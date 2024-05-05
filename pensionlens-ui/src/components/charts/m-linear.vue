<script>
import {UUID} from "@/utils/string";
import {formatNumber} from "@/utils/number";

var isChartInit = false;
var chartDOM = null;
var chartOption = null;

export default {
  name: "MlinearChart",
  props: {
    id: {
      type: String,
      default: () => UUID()
    },
    options: {
      type: Array,
      required: true
    },
  },
  watch: {
    options: {
      handler: function (newVal, oldVal) {
        if (newVal) {
          oldVal[0].data = this.changedData.slice();
          this.$store.commit('SET_TEMP_OPTION', oldVal[0]);
          // chartDOM.dispose();
          // chartDOM = null;
          isChartInit = false;
          if(!isChartInit){
            isChartInit = true;
            this.loadChart();
          }else{
            this.reloadChart(newVal);
          }
        }
      },
      deep: true
    },
    '$store.getters.tempButton': {
      handler() {
        chartDOM.dispose();
        chartDOM = null;
      },
      deep: true
    },
  },
  data(){
    return {
      changedData: []
    }

  },
  mounted() {
    // if(!isChartInit){
    //   isChartInit = true;
      this.loadChart();
    // }
  },
  beforeDestroy() {
    if (chartDOM) {
      chartDOM.dispose();
      chartDOM = null;
    }
  },
  methods: {
    reloadChart(newVal){
      const that = this;
      //点大小
      const symbolSize = 10;

      if(typeof newVal === 'undefined')
        this.changedData = this.options[0].data.slice();
      else {
        this.changedData = newVal[0].data.slice();
      }
      /**************控制函数*************/
      setTimeout(function () {
        // Add shadow circles (which is not visible) to enable drag.
        chartDOM.setOption({
          graphic: that.changedData.map(function (item, dataIndex) {
            return {
              type: 'circle',
              position: chartDOM.convertToPixel('grid', item),
              shape: {
                cx: 0,
                cy: 0,
                r: symbolSize / 2
              },
              invisible: true,
              draggable: true,
              ondrag: function (dx, dy) {
                onPointDragging(dataIndex, [this.x, this.y]);
              },
              ondragend: function (dx, dy) {
                onPointDragEnd(dataIndex, [this.x, this.y]);
              },
              onmousemove: function () {
                showTooltip(dataIndex);
              },
              onmouseout: function () {
                hideTooltip(dataIndex);
              },
              z: 100
            };
          })
        });
      }, 0);
      window.addEventListener('resize', updatePosition);
      chartDOM.on('dataZoom', updatePosition);
      function updatePosition() {
        chartDOM.setOption({
          graphic: that.changedData.map(function (item, dataIndex) {
            return {
              position: chartDOM.convertToPixel('grid', item)
            };
          })
        });
        chartDOM.resize()
      }
      function showTooltip(dataIndex) {
        chartDOM.dispatchAction({
          type: 'showTip',
          seriesIndex: 0,
          dataIndex: dataIndex
        });
      }
      function hideTooltip(dataIndex) {
        chartDOM.dispatchAction({
          type: 'hideTip'
        });
      }
      function onPointDragging(dataIndex, pos) {
        // 获取新的坐标
        let newY = chartDOM.convertFromPixel('grid', pos)[1];
        // 检查新的坐标是否在图表的范围内
        if (newY < chartOption.yAxis[0].min || newY > chartOption.yAxis[0].max) {
          // 如果不在范围内，就不更新数据点的位置
          return;
        }
        // 保持x坐标不变
        const oldX = that.changedData[dataIndex][0];
        that.changedData[dataIndex] = [oldX, newY, that.options[0].numPrecision, that.options[0].valueUnit];
        // 更新同步数据
        chartDOM.setOption({
          series: [{
            data: that.changedData
          }]
        });
        // 更新显示位置
        chartDOM.setOption({
          graphic: that.changedData.map(function (item, itemIndex) {
            return {
              position: itemIndex === dataIndex ? chartDOM.convertToPixel('grid', [oldX, newY]) : chartDOM.convertToPixel('grid', item)
            };
          })
        });
      }
      function onPointDragEnd(dataIndex, pos) {
        // 获取新的坐标
        let newY = chartDOM.convertFromPixel('grid', pos)[1];
        // 检查新的坐标是否在图表的范围内
        if (newY < chartOption.yAxis[0].min || newY > chartOption.yAxis[0].max) {
          // 如果不在范围内，就将数据点的位置重置为边界上的位置
          newY = newY < chartOption.yAxis[0].min ? chartOption.yAxis[0].min : chartOption.yAxis[0].max;
          const oldX = that.changedData[dataIndex][0];
          that.changedData[dataIndex] = [oldX, newY, that.options[0].numPrecision, that.options[0].valueUnit];
          chartDOM.setOption({
            series: [{
              data: that.changedData
            }]
          });
        }
      }
      window.addEventListener("resize", function () {
        chartDOM.resize();
      });
      /************控制函数结束***********/
      /**************数据填充*************/
      //点大小
      chartOption.series[0].symbolSize = symbolSize
      //tooltip显示精度
      chartOption.series[0].label.formatter = function (params) {
        return formatNumber(params.value[1], params.value[2]) + params.value[3];
      }
      //x最值
      chartOption.xAxis[0].min = this.changedData[0][0] - 1;
      chartOption.xAxis[0].max = this.changedData[this.changedData.length - 1][0] + 1;
      //x标签
      chartOption.xAxis[0].axisLabel.formatter = function (value) {
        return that.options[0].xAxisTags[value] + that.options[0].keyUnit;
      }
      //y最值
      chartOption.yAxis[0].min = this.options[0].minValue;
      chartOption.yAxis[0].max = this.options[0].maxValue;
      //y标签
      chartOption.yAxis[0].axisLabel.formatter = function (value) {
        return formatNumber(value, that.options[0].numPrecision);
      }
      //zoom
      if (this.changedData.length >= 6) {
        chartOption.dataZoom[0].minSpan = Math.floor(6 / that.changedData.length * 100);
        chartOption.dataZoom[0].maxSpan = Math.floor(6 / that.changedData.length * 100);
      } else {
        chartOption.dataZoom[0].minSpan = 100;
        chartOption.dataZoom[0].maxSpan = 100;
      }
      /************数据填充结束************/
      chartDOM.setOption(chartOption);
    },
    loadChart() {
      const chart = this.$echarts.init(document.getElementById('modifier-linear-' + this.id));
      chartDOM = chart;

      //数据
      this.changedData = this.options[0].data.slice();

      let option = {
        grid: {
          left: '1%',
          top: '7%',
          right: '1%',
          bottom: '10%',
          containLabel: true
        },
        xAxis: [
          {
            min: -1,
            max: 4,
            type: 'value',
            axisLine: {
              onZero: false,
              lineStyle: {
                color: 'rgba(255,255,255,.1)',
                width: 1,
                type: 'solid'
              }
            },
            axisLabel: {
              color: 'rgba(255,255,255,.6)',
              fontSize: '12',
              showMaxLabel: false,
              showMinLabel: false
            },
            splitLine: {
              lineStyle: {
                color: 'rgba(255,255,255,.2)'
              }
            }
          }
        ],
        yAxis: [
          {
            min: 100,
            max: 400,
            type: 'value',
            axisLine: {
              onZero: false,
              lineStyle: {
                color: 'rgba(255,255,255,.1	)',
                width: 1,
                type: 'solid'
              }
            },
            axisLabel: {
              formatter: '{value}' /**设置项5：y轴数据单位**/,
              show: true,
              color: 'rgba(255,255,255,.6)',
              fontSize: 12
            },
            splitLine: {
              lineStyle: {
                color: 'rgba(255,255,255,.2)'
              }
            }
          }
        ],
        dataZoom: [
          {
            type: 'slider',
            xAxisIndex: 0,
            bottom: '6%',
            filterMode: 'none',
            minSpan: 50,     /*单位是百分比*/
            maxSpan: 50,     /*单位是百分比*/
            zoomLock: true
          },
        ],
        series: [
          {
            type: 'line',
            smooth: true,
            symbolSize: 0,
            data: this.changedData,
            label: {
              show: true,
              position: 'insideBottom',
              color: 'rgba(255,255,255,.6)',
              formatter: ''
            },
          }
        ]
      };


      chartOption = option;
      this.reloadChart();
    }
  },
}
</script>

<template>
  <div :id="'modifier-linear-' + id" style="width: 100%; height: 100%">
  </div>
</template>