<script>
import {UUID} from '@/utils/string'
import {formatNumber} from "@/utils/number";

export default {
  name: 'LinearChart',
  data(){
    return {
      id: UUID()
    }
  },
  props: {
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
    this.id = UUID();
  },
  methods: {
    loadChartData() {
      this.loadChart();
    },
    loadChart() {
      const that = this;
      const chart = this.$echarts.init(document.getElementById('chart-item-linear-' + that.id));
      let option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            lineStyle: {
              color: '#dddc6b'
            }
          },
          formatter: ''           /**设置项1：数据提示悬浮框内容**/
        },
        legend: {
          top: '0%',
          data: [],               /**设置项2：图例**/
          inactiveColor: 'rgba(255,255,255,.2)',  // 未激活时的颜色
          textStyle: {
            color: "rgba(255,255,255,.6)"  // 激活时的颜色
          },
          fontSize: '12',
        },
        grid: {
          left: '1%',
          top: '4%',
          right: '1%',
          bottom: '5%',
          containLabel: true
        },
        xAxis: [{
          type: 'category',
          boundaryGap: false,
          axisLabel: {
            color: "rgba(255,255,255,.6)",
            fontSize: 12,
          },
          axisLine: {
            lineStyle: {
              color: 'rgba(255,255,255,.2)'
            }
          },
          data: []            /**设置项3：x轴标签**/
        },
        {
          axisPointer: {show: false},
          axisLine: {show: false},
          position: 'bottom',
          offset: 20,
        }],
        yAxis: [{
          type: 'value',
          min: -1,             /**设置项4：y轴最值*/
          max: -1,
          axisTick: {
            show: false
          },
          axisLine: {
            lineStyle: {
              color: 'rgba(255,255,255,.1)'
            }
          },
          axisLabel: {
            formatter: '{value}',    /**设置项5：y轴数据单位**/
            color: "rgba(255,255,255,.6)",
            fontSize: 12,
          },
          splitLine: {
            lineStyle: {
              color: 'rgba(255,255,255,.1)'
            }
          }
        }],
        series: []                /**设置项6：图标数据**/
      };
      // 填充数据
      /***************纵坐标轴***************/
      // 单位
      option.yAxis[0].axisLabel.formatter += that.options[0].valueUnit
      // 最值
      option.yAxis[0].min = that.options[0].minValue;
      option.yAxis[0].max = that.options[0].maxValue;
      /*************纵坐标轴结束*************/

      /***************横坐标轴***************/
      // 标签
      option.xAxis[0].data = that.options[0].xAxisTags;
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
        name: that.options[0].dataName,
        type: 'line',
        smooth: true,
        symbol: 'circle',
        symbolSize: 5,
        showSymbol: false,
        lineStyle: {
          color: that.options[0].dataColor[0],
          width: 2
        },
        areaStyle: {
          color: new that.$echarts.graphic.LinearGradient(0, 0, 0, 1, [{
            offset: 0,
            color: 'rgba(1, 132, 213, 0.4)'
          },
            {
              offset: 0.8,
              color: 'rgba(1, 132, 213, 0.1)'
            }], false),
          shadowColor: 'rgba(0, 0, 0, 0.1)',
        },
        itemStyle: {
          color: that.options[0].dataColor[0],
          borderColor: 'rgba(221,220,107,.1)',
          borderWidth: 12
        },
        data: that.options[0].data.slice()  // copy list instead of reference
      });
      // 3. 若为预测数据，则设置虚线样式
      if (that.options[0].isPredict) {
        // 3.1 系列名字
        option.legend.data.push(that.options[0].dataName + "预测");
        // 3.2 系列样式及数据
        let tempArr = [];
        for (let i = 0; i < that.options[0].data.length - 1; i++) {
          tempArr.push(null);
        }
        tempArr.push(that.options[0].data[that.options[0].data.length - 1]);
        tempArr = tempArr.concat(that.options[0].predictData);
        option.series.push({
          name: that.options[0].dataName + '预测',
          type: 'line',
          smooth: true,
          symbol: 'circle',
          symbolSize: 5,
          showSymbol: false,
          lineStyle: {
            color: that.options[0].dataColor[0],
            width: 2,
            type: 'dotted'
          },
          data: tempArr,
          itemStyle: {
            color: that.options[0].dataColor[0],
            width: 2
          }
        })
      }
      /************数据系列1结束************/

      /*************数据系列2*************/
      if (that.options.length > 1) {
        // 1. 系列名字
        option.legend.data.push(that.options[1].dataName);
        // 2. 系列样式及数据
        option.series.push({
          name: that.options[1].dataName,
          type: 'line',
          smooth: true,
          symbol: 'circle',
          symbolSize: 5,
          showSymbol: false,
          lineStyle: {
            color: that.options[1].dataColor[0],
            width: 2
          },
          areaStyle: {
            color: new that.$echarts.graphic.LinearGradient(0, 0, 0, 1, [{
              offset: 0,
              color: 'rgba(1, 132, 213, 0.4)'
            },
            {
              offset: 0.8,
              color: 'rgba(1, 132, 213, 0.1)'
            }], false),
            shadowColor: 'rgba(0, 0, 0, 0.1)',
          },
          itemStyle: {
            color: that.options[1].dataColor[0],
            borderColor: 'rgba(221,220,107,.1)',
            borderWidth: 12
          },
          data: that.options[1].data.slice()  // copy list instead of reference
        });
        // 3. 若为预测数据，则设置虚线样式
        if (that.options[1].isPredict) {
          // 3.1 系列名字
          option.legend.data.push(that.options[1].dataName + "预测");
          // 3.2 系列样式及数据
          let tempArr = [];
          for (let i = 0; i < that.options[1].data.length - 1; i++) {
            tempArr.push(null);
          }
          tempArr.push(that.options[1].data[that.options[1].data.length - 1]);
          tempArr = tempArr.concat(that.options[1].predictData);
          option.series.push({
            name: that.options[1].dataName + '预测',
            type: 'line',
            smooth: true,
            symbol: 'circle',
            symbolSize: 5,
            showSymbol: false,
            lineStyle: {
              color: that.options[1].dataColor[0],
              width: 2,
              type: 'dotted'
            },
            data: tempArr,
            itemStyle: {
              color: that.options[1].dataColor[0],
              width: 2
            }
          })
        }
      }
      /************数据系列2结束************/

      console.log(option)
      chart && chart.setOption(option);
      setInterval(() => {
        chart.clear(); // 清除当前图表
        chart.setOption(option);
      }, 10000); // 每10秒刷新一次图表
      window.addEventListener("resize", function () {
        chart.resize();
      });
    },
  },
}
</script>

<template>
  <div class="chart-item-linear"
       :id="'chart-item-linear-' + id"
       style="width: 100%; height: 100%;">
  </div>
</template>