<script>
import {UUID} from '@/utils/string'
import {formatNumber} from "@/utils/number";

export default {
  name: 'BarChart',
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
  // 在JavaScript中，console.log()函数会阻塞事件循环，直到控制台完成日志的打印。
  // 这意味着，如果你的options数据是通过异步操作（例如Ajax请求或Promise）获取的，
  // 那么console.log(that.options)可能会给异步操作提供足够的时间来完成并更新options数据。
  // 当你移除console.log(that.options)时，由于没有了阻塞事件循环的操作，异步操作可能还没有完成，
  // options数据还没有更新，所以that.options[0]可能是undefined。
  // 为了解决这个问题，你应该确保在使用that.options[0]之前，options数据已经准备好了。
  // 你可以使用watch或者computed属性来观察options的变化，当options更新时，再执行相关的操作。例如：
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
          fontSize: '12',
        },
        xAxis: [{
          type: 'category',
          data: [],           /**设置项3：横坐标轴标签**/
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
      // option.yAxis[0].axisLabel.formatter += that.options[0].valueUnit
      // 最值
      option.yAxis[0].min = that.options[0].minValue
      option.yAxis[0].max = that.options[0].maxValue
      /*************纵坐标轴结束*************/

      /***************横坐标轴***************/
      // 标签
      option.xAxis[0].data = that.options[0].xAxisTags
      /*************横坐标轴结束*************/

      /************数据提示悬浮框************/
      option.tooltip.formatter =  function (params) {
        let res = params[0].name + that.options[0].keyUnit + '<br/>';
        for (let i = 0, l = params.length; i < l; i++) {
          let seriesName = params[i].seriesName.split('预测')[0];
          let isPredict = params[i].seriesName.includes('预测');
          // 1. 有该系列且当前还要新增该系列的预测，不允许，跳过；
          if(res.includes(seriesName) && isPredict) continue;
          // 2. 从第2,3个参数中获取精度和单位
          res += params[i].marker + params[i].seriesName + ' : <b>' + formatNumber(params[i].value[1], params[i].value[2]) + params[i].value[3] + '</b><br/>';
        }
        return res;
      }
      /**********数据提示悬浮框结束**********/

      option.legend.data = [];
      option.series = [];
      /**************数据系列1**************/
      // 1. 系列名字
      option.legend.data.push(that.options[0].dataName);
      // 2. 系列样式及数据
      option.series.push({
        type: 'bar',
        name: that.options[0].dataName,
        data: that.options[0].data.slice(), // copy list instead of reference
        barWidth: '35%', //柱子宽度
        barGap: '0%',
        // barCategoryGap: '35%',
        itemStyle: {
          color: that.options[0].dataColor[0],
          opacity: 1,
          borderRadius: 5,
        },
      });
      // 3. 若为预测数据
      if (that.options[0].isPredict) {
        // 3.1 系列名字
        option.legend.data.push(that.options[0].dataName + "预测");
        // 3.2 系列样式及数据（与折线图不同之处不用把最后一个数据塞入temp中）
        let tempArr = [];
        for (let i = 0; i < that.options[0].data.length; i++) {
          option.series[0].data.push(NaN);
          tempArr.push(NaN);
        }
        tempArr = tempArr.concat(that.options[0].predictData);
        option.series.push({
          type: 'bar',
          name: that.options[0].dataName + "预测",
          data: tempArr,
          barGap: '0%',
          barWidth: '35%', //柱子宽度
          // barCategoryGap: '35%',
          itemStyle: {
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
        });
      }
      /************数据系列1结束************/

      /*************数据系列2*************/
      if (that.options[1] !== undefined || that.options[1] !== null) {
        // 1. 系列名字
        option.legend.data.push(that.options[1].dataName);
        // 2. 系列样式及数据
        option.series.push({
          type: 'bar',
          name: that.options[1].dataName,
          data: that.options[1].data.slice(), // copy list instead of reference
          barWidth: '35%', //柱子宽度
          barGap: '0%',
          // barCategoryGap: '35%',
          itemStyle: {
            color: that.options[1].dataColor[0],
            opacity: 1,
            borderRadius: 5,
          }
        });
        // 3. 若为预测数据
        if (that.options[1].isPredict) {
          // 3.1 系列名字
          option.legend.data.push(that.options[1].dataName + "预测");
          // 3.2 系列样式及数据
          let tempArr = [];
          for (let i = 0; i < that.options[1].data.length - 1; i++) {
            tempArr.push(NaN);
          }
          tempArr = tempArr.concat(that.options[1].predictData);
          option.series.push({
            type: 'bar',
            name: that.options[1].dataName + "预测",
            data: tempArr,
            barWidth: '35%', //柱子宽度
            barGap: '0%',
            // barCategoryGap: '35%',
            itemStyle: {
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
          });
        }
      }
      /***********数据系列2结束***********/

      chart && chart.setOption(option);
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