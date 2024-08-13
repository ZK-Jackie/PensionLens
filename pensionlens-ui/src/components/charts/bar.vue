<script>
import {UUID} from '@/utils/string'
import {formatNumber} from "@/utils/number";

export default {
  name: 'BarChart',
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
      const chart = this.$echarts.init(document.getElementById('chart-item-bar-' + that.id));
      let option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          },
          formatter: ''         /**设置项1：数据提示悬浮框内容**/
        },
        grid: {
          left: '1%',
          top: '4%',
          right: '1%',
          bottom: '5%',
          containLabel: true
        },
        legend: {
          data: [],             /**设置项2：图例**/
          inactiveColor: 'rgba(255,255,255,.2)',  // 未激活时的颜色
          textStyle: {
            color: "rgba(255,255,255,.6)"  // 激活时的颜色
          },
          fontSize: 12,
        },
        xAxis: [{
          type: 'category',
          data: [],             /**设置项3：横坐标轴标签**/
          axisLine: {
            show: true,
            lineStyle: {
              color: "rgba(255,255,255,.1)",
              width: 1,
              type: "solid"
            },
          },
          axisTick: {
            show: false,
          },
          axisLabel: {
            interval: 0,
            show: true,
            splitNumber: 15,
            color: "rgba(255,255,255,.6)",
            fontSize: '12',
          },
        }],
        yAxis: [{
          type: 'value',
          min: -1,                /**设置项4：y轴最值*/
          max: -1,
          axisLabel: {
            formatter: '{value}', /**设置项5：y轴数据单位**/
            show: true,
            color: "rgba(255,255,255,.6)",
            fontSize: '12',
          },
          axisTick: {
            show: false,
          },
          axisLine: {
            show: true,
            lineStyle: {
              color: "rgba(255,255,255,.1	)",
              width: 1,
              type: "solid"
            },
          },
          splitLine: {
            show: false,
            lineStyle: {
              color: "rgba(255,255,255,.1)",
            }
          }
        }],
        series: []           /**设置项6：图标数据**/
      };
      // 填充数据
      /***************纵坐标轴***************/
      // 单位
      option.yAxis[0].axisLabel.formatter += that.data[0].valueUnit
      // 最值
      option.yAxis[0].min = that.data[0].minValue
      option.yAxis[0].max = that.data[0].maxValue
      /*************纵坐标轴结束*************/

      /***************横坐标轴***************/
      // 标签
      option.xAxis[0].data = that.data[0].data[0]
      /*************横坐标轴结束*************/

      /************数据提示悬浮框************/
      option.tooltip.formatter = function (params) {
        let res = params[0].name + that.data[0].keyUnit + '<br/>';
        for (let i = 0, l = params.length; i < l; i++) {
          // TODO 1. 判定预测
          if (that.data[0].isPredict) {
            for (let j = 0; j < that.data[0].predictData[0].length; j++) {
              if (params[i].axisValue === that.data[0].predictData[0][j]) {
                res = params[0].name + that.data[0].keyUnit + '预测 <br/>';
                break;
              }
            }
          }
          // 2. 从 data 中获取精度和单位
          res += params[i].marker + params[i].seriesName + ' : <b>' + formatNumber(params[i].value, that.data[0].numPrecision) + that.data[0].valueUnit + '</b><br/>';
        }
        return res;
      }
      /**********数据提示悬浮框结束**********/

      option.legend.data = [];
      option.series = [];
      /**************数据系列1**************/
      // 1. 系列名字
      option.legend.data[0] = that.data[0].dataName[0]
      // 2. 系列样式及数据
      option.series[0] = {
        type: 'bar',
        name: that.data[0].dataName[0],
        data: that.data[0].data[1],
        barWidth: '35%', //柱子宽度
        barCategoryGap: '35%',
        itemStyle: {
          color: that.data[0].dataColor[0],
          opacity: 1,
          borderRadius: 5,
        },
      };
      // 3. 若为预测数据，则设置渐变样式
      if (that.data[0].isPredict) {
        let predictStyle = {
          color: new this.$echarts.graphic.LinearGradient(
              0, 1, 0, 0,
              [
                {offset: 0, color: '#83bff6'},
                {offset: 0.5, color: '#188df0'},
                {offset: 1, color: '#188df0'}
              ]
          ),
          opacity: 1,
          borderRadius: 5
        }
        for (let i = 0; i < that.data[0].predictData[0].length; i++) {
          option.xAxis[0].data.push(that.data[0].predictData[0][i]);
          option.series[0].data.push({
            value: that.data[0].predictData[1][i],
            itemStyle: predictStyle
          })
        }
      }
      /************数据系列1结束************/

      /*************数据系列2*************/
      if (that.data[1] !== undefined || that.data[1] !== null) {
        // 1. 系列名字
        option.legend.data[1] = that.data[1].dataName[0]
        // 2. 系列样式及数据
        option.series[1] = {
          type: 'bar',
          name: that.data[1].dataName[0],
          data: that.data[1].data[1],
          barWidth: '35%', //柱子宽度
          barCategoryGap: '35%',
          itemStyle: {
            color: that.data[1].dataColor[0],
            opacity: 1,
            borderRadius: 5,
          },
        };
        if (that.data[1].isPredict) {
          let predictStyle = {
            color: new this.$echarts.graphic.LinearGradient(
                0, 1, 0, 0,
                [
                  {offset: 0, color: '#97fad1'},
                  {offset: 0.5, color: '#53ecac'},
                  {offset: 1, color: '#04b76e'}
                ]
            ),
            opacity: 1,
            borderRadius: 5
          }
          for (let i = 0; i < that.data[1].predictData[1].length; i++) {
            option.series[1].data.push({
              value: that.data[1].predictData[1][i],
              itemStyle: predictStyle
            })
          }
        }
      }
      /***********数据系列2结束***********/

      // 使用刚指定的配置项和数据显示图表。
      chart.setOption(option);
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
  <div class="chart-item-bar"
       :id="'chart-item-bar-' + id"
       style="width: 100%; height: 100%;">
  </div>
</template>