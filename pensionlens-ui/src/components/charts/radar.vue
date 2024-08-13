<template>
  <div
      class="chart-item-radar"
      :id="'chart-item-radar-'+ id"
      style="width: 100%; height: 100%;">
  </div>
</template>

<script>
import {UUID} from "@/utils/string";

export default {
  name: 'RadarChart',
  props: {
    id: {
      type: String,
      required: false,
      default: UUID()
    },
    /**
     * the specific data and style of the chart
     * @type {Array} Need an array consists of max to two JSON elements
     */
    options: {
      type: Array,
      required: true
    }
  },
  watch: {
    options: {
      handler: function (newVal) {
        if (newVal) {
          this.loadChartData();
        }
      },
      deep: true
    }
  },
  mounted() {
    this.loadChartData();
  },
  methods: {
    loadChartData() {
      this.loadChart();
    },
    loadChart() {
      const that = this;
      const chart = this.$echarts.init(document.getElementById('chart-item-radar-' + that.id));
      let option = {
        legend: {
          data: ['新中人','老中人'],//设置图例
          x: 'left', // 设置图例水平位置为居中
          y: 'top' ,// 设置图例垂直位置为底部
          textStyle: {
            color: function (params) {
              var colorList = ['#26c6da', '#909fe6'];
              return colorList[params.dataIndex];
            }
          }
        },
        tooltip: {
          trigger: 'item',
        },
        radar: {
          name: {
            textStyle: {
              color: '#fff',
              fontSize: 15,
              padding: [0, 0, 0, 0]  // 上、右、下、左的内边距
            }
          },
          radius: '70%',//雷达图的半径
          center: ['50%', '51%'],//雷达图的位置
          splitNumber: 5,//雷达图的分割段数
          indicator: [ //雷达图的指示器，这里指定雷达图有几个维度　　　填充项目1
          ]
        },
        series: [{
          type: 'radar',
          lineStyle: {
            // 设置雷达图线条的样式
            width: 3  // 设置线条的宽度为3像素
          },
          data: [　　//填充项目2 有关雷达图的数据
            {
              value: [15935.85, 16699.88, 17259.10, 17562.81, 17795.41, 18455.97],//不知道为什么用that.options[0].data[1]会报错
              name: '新中人'
            },{
              value: [11593.98, 12646.32, 13445.69, 14473.18, 14069.35, 13567.43],
              name: '老中人'
            }
          ]
        }]
      };
      /******************设置项1：雷达图的指示器******************/
      option.radar.indicator=that.options[0].indicator;
      chart.setOption(option);
      setInterval(() => {
        chart.clear(); // 清除当前图表
        chart.setOption(option);
      }, 10000); // 每10秒刷新一次图表
      window.addEventListener("resize", function () {
        chart.resize();
      });
    }
  }
}


</script>