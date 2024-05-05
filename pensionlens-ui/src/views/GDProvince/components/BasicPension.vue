<script >
import {getBasicPension} from "@/api/charts";
export default {
  data() {
    return {
      myChart: null
    };
  },
  mounted() {
    getBasicPension().then((res) => {
      this.myChart = this.$echarts.init(document.getElementById('basicPension'));
      this.run(res.data);
    });
  },
  methods: {
    run(_rawData) {
      const types = ['Old', 'Young'];
      const datasetWithFilters = [];
      const seriesList = [];
      this.$echarts.util.each(types, function (type){
        var datasetId = 'dataset_' + type;
        datasetWithFilters.push({
          id: datasetId,
          fromDatasetId: 'dataset_raw',
          transform: {
            type: 'filter',
            config: {
              and: [
                { dimension: 'Year', gte: 1980},
                { dimension: 'type', '=': type }
              ]
            }
          }
        });
        seriesList.push({
          type: 'line',
          lineStyle: {
            width: 3  // 设置折线的粗细
          },
          datasetId: datasetId,
          showSymbol: false,
          name: type,
          endLabel: {
            show: true,
            formatter: (params) => {
              return params.seriesName
            }

          },
          // labelLayout: {
          //   moveOverlap: 'shiftY'
          // },
          emphasis: {
            focus: 'series'
          },
          encode: {
            x: 'Year',
            y: 'Pension',
            label: ['type', 'Pension'],
            itemName: 'Year',
            tooltip: ['Pension']
          }
        });
      });
      const option = {
        animationDuration: 3000,
        dataset: [
          {
            id: 'dataset_raw',
            source: _rawData
          },
          ...datasetWithFilters
        ],
        tooltip: {
          order: 'valueDesc',
          trigger: 'axis'
        },
        xAxis: {
          type: 'category',
          nameLocation: 'middle',
          interval:10,
          axisLabel: {
            fontSize: 14,  // 设置字体大小
            color: '#b3d8ff',  // 设置字体颜色
            fontWeight: 'bold'  // 设置字体粗细
          }
        },
        yAxis: {
          name: 'Pension',
          splitNumber:4,
          nameTextStyle: {
            fontSize: 15,  // 设置字体大小
            color: '#b3d8ff'  // 设置字体颜色
          },
          fontWeight: 'bold',// 设置字体粗细
          axisLabel: {
            fontSize: 14,  // 设置字体大小
            color: '#b3d8ff',  // 设置字体颜色
          }
        },
        grid: {
          right: 48,
          left:50,
          top:15,
          bottom:40,
        },
        series: seriesList
      };
      this.myChart.setOption(option);
      setInterval(() => {
        this.myChart.clear(); // 清除当前图表
        this.myChart.setOption(option);
      }, 10000); // 每10秒刷新一次图表
    }
  }
};
</script>

<template>
  <div id="size">
    <div id="basicPension" style="width: 100%; height: 100%"></div>
  </div>
</template>

<style scoped>
#size {
  width: 100%;
  height: 3rem;
}
#basicPension {
  margin-top: -5px;
}

</style>
