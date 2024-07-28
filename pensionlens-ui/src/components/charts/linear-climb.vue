<script>
import {UUID} from '@/utils/string'
import {formatNumber} from "@/utils/number";

export default {
  name: 'LinearChart',
  props: {
    data: {
      type: Array,
      required: true
    },
    id: {
      type: String,
      required: false,
      default: () => {
        return UUID();
      }
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
      const chart = this.$echarts.init(document.getElementById('chart-item-linear-' + that.id));
      let option = {
        animationDuration: 2000,
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
          top: '-2%',
          data: [], /**设置项2：图例**/
          inactiveColor: 'rgba(255,255,255,.2)',  // 未激活时的颜色
          textStyle: {
            color: "rgba(255,255,255,.6)"  // 激活时的颜色
          },
          fontSize: '12',
        },
        grid: {
          left: '1%',
          top: '6%',
          right: '10%',
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
          min: -1, /**设置项4：y轴最值*/
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
            formatter: '{value}', /**设置项5：y轴数据单位**/
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
      option.yAxis[0].axisLabel.formatter += that.data[0].valueUnit
      // 最值
      option.yAxis[0].min = that.data[0].minValue;
      option.yAxis[0].max = that.data[0].maxValue;
      /*************纵坐标轴结束*************/

      /***************横坐标轴***************/
      // 标签
      option.xAxis[0].data = that.data[0].data[0];
      /*************横坐标轴结束*************/

      /************数据提示悬浮框************/
      option.tooltip.formatter = function (params) {
        let res = params[0].name + that.data[0].keyUnit + '<br/>';
        for (let i = 0, l = params.length; i < l; i++) {
          let seriesName = params[i].seriesName.split('预测')[0];
          let isPredict = params[i].seriesName.includes('预测');
          // 1. 有该系列且当前还要新增该系列的预测，不允许，跳过；
          if (res.includes(seriesName) && isPredict) continue;
          // 2. 从第2,3个参数中获取精度和单位
          res += params[i].marker + params[i].seriesName + ' : <b>' + formatNumber(params[i].value, that.data[0].numPrecision) + that.data[0].valueUnit + '</b><br/>';
        }
        return res;
      }
      /**********数据提示悬浮框结束**********/

      option.legend.data = [];
      option.series = [];
      /**************数据系列1**************/
      // 1. 系列名字
      option.legend.data[0] = that.data[0].dataName[0];
      // 2. 系列样式及数据
      option.series.push({
        name: that.data[0].dataName[0],
        data: that.data[0].data[1],
        type: 'line',
        smooth: true,
        symbol: 'circle',
        symbolSize: 5,
        showSymbol: false,
        lineStyle: {
          color: that.data[0].dataColor[0],
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
          color: that.data[0].dataColor[0],
          borderColor: 'rgba(221,220,107,.1)',
          borderWidth: 12
        },
        labelLayout: {
          moveOverlap: 'shiftY',
        },
        emphasis: {
          focus: 'series'
        },
        endLabel: {
          show: true,
          formatter: function (params) {
            if (params.value === that.data[0].data[1][that.data[0].data[1].length - 1])
              return ""
            return that.data[0].dataName.toString()
          }
        },
      });
      // 3. 若为预测数据，则设置虚线样式
      if (that.data[0].isPredict) {
        // 3.1 横坐标标签
        option.xAxis[0].data = option.xAxis[0].data.concat(that.data[0].predictData[0]);
        // 3.1 系列名字
        option.legend.data.push(that.data[0].dataName[0] + "预测");
        // 3.2 系列样式及数据
        let tempArr = [];
        for (let i = 0; i < that.data[0].data[0].length - 1; i++) {
          tempArr.push(null);
        }
        tempArr.push(that.data[0].data[1][that.data[0].data[1].length - 1]);  // 拼接最后一个真实数据
        tempArr = tempArr.concat(that.data[0].predictData[1]); // 拼接预测数据
        option.series.push({
          name: that.data[0].dataName + '预测',
          data: tempArr,
          type: 'line',
          smooth: true,
          symbol: 'circle',
          symbolSize: 5,
          showSymbol: false,
          lineStyle: {
            color: that.data[0].dataColor[0],
            width: 2,
            type: 'dotted'
          },
          itemStyle: {
            color: that.data[0].dataColor[0],
            width: 2
          },
          labelLayout: {
            moveOverlap: 'shiftY',
          },
          emphasis: {
            focus: 'series'
          },
          endLabel: {
            show: true,
            formatter: function (params) {
              if (params.data !== that.data[0].predictData[1][that.data[0].predictData[1].length - 1])
                return ""
              return that.data[0].dataName.toString()
            }
          },
        })
      }
      /************数据系列1结束************/

      /*************数据系列2*************/
      if (that.data.length > 1) {
        // 1. 系列名字
        option.legend.data.push(that.data[1].dataName[0]);
        // 2. 系列样式及数据
        option.series.push({
          name: that.data[1].dataName[0],
          data: that.data[1].data[1],
          type: 'line',
          smooth: true,
          symbol: 'circle',
          symbolSize: 5,
          showSymbol: false,
          lineStyle: {
            color: that.data[1].dataColor[0],
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
            color: that.data[1].dataColor[0],
            borderColor: 'rgba(221,220,107,.1)',
            borderWidth: 12
          },
          labelLayout: {
            moveOverlap: 'shiftY',
          },
          emphasis: {
            focus: 'series'
          },
          endLabel: {
            show: true,
            formatter: function (params) {
              if (params.value === that.data[1].data[1][that.data[1].data[1].length - 1])
                return ""
              return that.data[1].dataName.toString()
            }
          },
        });
        // 3. 若为预测数据，则设置虚线样式
        if (that.data[1].isPredict) {
          // 3.1 系列名字
          option.legend.data.push(that.data[1].dataName[0] + "预测");
          // 3.2 系列样式及数据
          let tempArr = [];
          for (let i = 0; i < that.data[1].data[0].length - 1; i++) {
            tempArr.push(null);
          }
          tempArr.push(that.data[1].data[1][that.data[1].data[0].length - 1]);  // 拼接最后一个真实数据
          tempArr = tempArr.concat(that.data[1].predictData[1]); // 拼接预测数据
          option.series.push({
            name: that.data[1].dataName + '预测',
            data: tempArr,
            type: 'line',
            smooth: true,
            symbol: 'circle',
            symbolSize: 5,
            showSymbol: false,
            lineStyle: {
              color: that.data[1].dataColor[0],
              width: 2,
              type: 'dotted'
            },
            itemStyle: {
              color: that.data[1].dataColor[0],
              width: 2
            },
            labelLayout: {
              moveOverlap: 'shiftY',
            },
            emphasis: {
              focus: 'series'
            },
            endLabel: {
              show: true,
              formatter: function (params) {
                if (params.data !== that.data[1].predictData[1][that.data[1].predictData[1].length - 1])
                  return ""
                return that.data[1].dataName.toString()
              }
            },
          })
        }
      }
      /************数据系列2结束************/

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