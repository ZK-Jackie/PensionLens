<template>
  <div id="scope">
    <div class="allnav" id="echart"  style="width: 100%; height: 100%"></div>
  </div>
</template>

<script>
export default {
  data(){
    return{
      index:0,
      seriesData: [
        [
          { name: '2020', data: [100, 1020, 1588, 1899, 4288, 6091.16] },
          { name: '2021', data: [210, 1678, 2389, 2388, 5199, 6991.18] }
        ],
        [
          { name: '2022', data: [300, 1820, 2388, 2899, 5288, 7091.16] },
          { name: '2023', data: [410, 2678, 3389, 3388, 6199, 7991.18] }
        ]
      ],
    }
  },
  methods: {
    echarts() {
      var that = this;
      // 基于准备好的dom，初始化echarts实例
      var myChart = this.$echarts.init(document.getElementById('echart'));
      var option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        legend: {
          textStyle: {
            color: function (params) {
              var colorList = ['#26c6da', '#909fe6'];
              return colorList[params.dataIndex];
            }
          },
        },
        grid: {
          left: '0%',
          right: '2%',
          bottom: '1%',
          top: '7.8%',
          containLabel: true
        },
        xAxis: {
          type: 'value',
          boundaryGap: [0, 0.01]
        },
        yAxis: {
          type: 'category',
          data: [
            '人保养老',
            '长江养老',
            '太平养老',
            '泰康养老',
            '平安养老',
            '国泰养老'
          ]
        },
        series: [
          {
            name: this.seriesData[this.index][0].name,
            type: 'bar',
            data: this.seriesData[this.index][0].data,
            itemStyle: {
              color: '#26c6da'
            },
          },
          {
            name:  this.seriesData[this.index][1].name,
            type: 'bar',
            data: this.seriesData[this.index][1].data,
            itemStyle: {
              color: '#909fe6'
            },
          }
        ]
      }
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
      setInterval(() => {
          this.index = (this.index + 1) % this.seriesData.length;
          option.series[0].name = this.seriesData[this.index][0].name;
          option.series[0].data = this.seriesData[this.index][0].data;
          option.series[1].name = this.seriesData[this.index][1].name;
          option.series[1].data = this.seriesData[this.index][1].data;
          myChart.clear(); // 清除当前图表
          myChart.setOption(option);
      }, 3000); // 每3秒刷新一次图表
      window.addEventListener("resize", function () {
        myChart.resize();
      });
    },
  },
    mounted() {
      this.echarts();
    }
}
</script>

<style scoped>
#scope{
  width: 100%;
  height: 98%;
}
</style>

