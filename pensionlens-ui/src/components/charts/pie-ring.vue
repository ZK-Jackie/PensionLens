<script>
import {UUID} from "@/utils/string";
import {formatNumber} from "@/utils/number";

export default {
  name: 'RingChart',
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
      const chart = this.$echarts.init(document.getElementById('chart-item-ring-' + that.id));
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
          // itemWidth: 10,
          // itemHeight: 10,
          data: [],               /**设置项2：图例**/
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
      for (let i = 0; i < that.options[0].data.length; i++) {
        option.legend.data.push(that.options[0].xAxisTags[that.options[0].data[i][0]]+"");
        tempArr.push({
          value: that.options[0].data[i][1],
          name: that.options[0].xAxisTags[that.options[0].data[i][0]],
          numPrecision: that.options[0].numPrecision,
          valueUnit: that.options[0].valueUnit
        });
      }
      option.series.push({
        name: that.options[0].dataName,
        type: 'pie',
        center: ['50%', '55%'],
        radius: ['40%', '65%'],
        color: that.options[0].dataColor,
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
      /**************数据系列**************/

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
      class="chart-item-ring"
      :id="'chart-item-ring-'+ id"
      style="width: 100%; height: 100%;">
  </div>
</template>