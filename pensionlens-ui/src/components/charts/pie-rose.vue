<script>
import {formatNumber} from "@/utils/number";
import {UUID} from "@/utils/string";

export default {
  name: 'RoseChart',
  props: {
    id: {
      type: String,
      required: false,
      default: UUID()
    },
    data: {
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
      const chart = this.$echarts.init(document.getElementById('chart-item-rose-' + that.id));
      const option = {
        tooltip: {
          trigger: 'item',
          formatter: '',           /**设置项1：数据提示悬浮框内容**/
          position: function (p) {   //其中p为当前鼠标的位置
            return [p[0] + 10, p[1] - 10];
          }
        },
        legend: {
          top: '0%',
          x: 'left', // 设置图例水平位置为居中
          // itemWidth: 10,
          // itemHeight: 10,
          inactiveColor: 'rgba(255,255,255,.2)',  // 未激活时的颜色
          textStyle: {
            color: "rgba(255,255,255,.6)",  // 激活时的颜色
          },
          fontSize: '12',
        },
        series: []
      };
      // 填充数据
      /************数据提示悬浮框************/
      option.tooltip.formatter = function (params){
        let res = params.seriesName + '<br/>';
        res += params.marker + params.data.name + ': <b>' + formatNumber(params.data.value, params.data.numPrecision) + params.data.valueUnit + ' (' + params.percent + '%)</b>';
        return res;
      };
      /**********数据提示悬浮框结束**********/

      /**************数据系列**************/
      let tempArr = [];
      for (let i = 0; i < that.data[0].data[0].length; i++) {
        tempArr.push({
          value: that.data[0].data[1][i],
          name: that.data[0].data[0][i],
          numPrecision: that.data[0].numPrecision,
          valueUnit: that.data[0].valueUnit
        });
      }
      for (let i = 0; i < that.data[0].predictData[0].length; i++) {
        tempArr.push({
          value: that.data[0].predictData[1][i],
          name: that.data[0].predictData[0][i] + "预测",
          numPrecision: that.data[0].numPrecision,
          valueUnit: that.data[0].valueUnit
        });
      }
      option.series.push({
        name: that.data[0].dataName.toString(),
        type: 'pie',
        center: ['50%', '53%'],
        radius: ['20%', '80%'],
        color: that.data[0].dataColor.dataColor,
        roseType: 'area',
        label: {
          show: false
        },
        labelLine: {
          show: false
        },
        itemStyle:{
          borderRadius: 10,
          borderWidth: 2
        },
        data: tempArr
      });
      /************数据系列结束************/

      /**************自动刷新**************/
      chart && chart.setOption(option);
      setInterval(() => {
        chart.clear(); // 清除当前图表
        chart.setOption(option);
      }, 10000); // 每10秒刷新一次图表
      window.addEventListener("resize", function () {
        chart.resize();
      });
    }
  },
}
</script>

<template>
  <div
      class="chart-item-rose"
      :id="'chart-item-rose-' + id"
      style="width: 100%; height: 100%;">
  </div>
</template>