<script>
import {UUID} from "@/utils/string";
import {formatNumber} from "@/utils/number";

export default {
  name: 'RadarV',
  props: {
    id: {
      type: String,
      required: false,
      default: () => {
        return UUID();
      }
    },
    data: {
      type: Array,
      required: true
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
          x: 'center',  // 设置图例水平位置为居中
          y: 'top' ,  // 设置图例垂直位置为底部
          top: '0%',
          inactiveColor: 'rgba(255,255,255,.2)',  // 未激活时的颜色
          textStyle: {
            color: "rgba(255,255,255,.6)",  // 激活时的颜色
          },
          fontSize: '12',
          data: []      /**设置项1：图例**/
        },
        tooltip: {
          trigger: 'item',
          formatter: '' /**设置项2：数据提示悬浮框内容**/
        },
        radar: {
          axisName: {
            color: 'rgba(255,255,255,.6)',
            fontSize: '12',
            padding: [-10, -10, -15, -10]  // 上、右、下、左的内边距
          },
          radius: '70%',          //雷达图的半径
          center: ['50%', '51%'], //雷达图的位置
          splitNumber: 5,         //雷达图的分割段数
          indicator: []  /**设置项3：雷达图维度（即x轴）**/
        },
        series: [
          {
            type: 'radar',
            lineStyle: {
              width: 3  // 设置雷塔图线条宽度为 3px
            },
            data: []
          }
        ]      /**设置项4：数据**/
      };
      // 填充数据
      /************数据提示悬浮框************/

      /**********数据提示悬浮框结束**********/

      option.legend.data = [];
      option.radar.indicator = [];
      option.series[0].data = [];
      /**************数据系列1**************/
      // 图例
      option.legend.data.push(that.data[0].dataName.toString());
      let tempDataArr1 = [];
      for (let i = 0; i < that.data[0].data[0].length; i++) {
        // 雷达维度
        option.radar.indicator.push({
          name: that.data[0].data[0][i],
        });
        tempDataArr1.push(that.data[0].data[1][i]);
      }
      // 若预测
      if (that.data[0].isPredict){
        for (let i = 0; i < that.data[0].predictData[0].length; i++) {
          option.radar.indicator.push({
            name: that.data[0].predictData[0][i] + "预测",
          });
          tempDataArr1.push(that.data[0].predictData[1][i]);
        }
      }
      option.series[0].data.push({
        itemStyle: {
          color: that.data[0].dataColor[0]
        },
        value: tempDataArr1,
        name: that.data[0].dataName.toString()
      })
      /************数据系列1结束************/

      /**************数据系列2**************/
      if (that.data.length > 1){
        // 图例
        option.legend.data.push(that.data[1].dataName.toString());
        let tempDataArr2 = [];
        for (let i = 0; i < that.data[1].data[0].length; i++) {
          tempDataArr2.push(that.data[1].data[1][i]);
        }
        // 若预测
        if (that.data[1].isPredict){
          for (let i = 0; i < that.data[1].predictData[0].length; i++) {
            tempDataArr2.push(that.data[1].predictData[1][i]);
          }
        }
        option.series[0].data.push({
          itemStyle: {
            color: that.data[1].dataColor[0]
          },
          value: tempDataArr2,
          name: that.data[1].dataName.toString()
        })
      }
      /************数据系列2结束************/

      /**************自动刷新**************/
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

<template>
  <div
      class="chart-item-radar"
      :id="'chart-item-radar-'+ id"
      style="width: 100%; height: 100%;">
  </div>
</template>