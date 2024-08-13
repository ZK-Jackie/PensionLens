<script>
import {Message} from "element-ui";
import {UUID} from "@/utils/string";
import {formatNumber} from "@/utils/number";

export default {
  name: "MlinearChart",
  props: {
    id: {
      type: String,
      default: () => {
        return UUID();
      }
    },
    data: {
      type: Array,
      required: true
    },
  },
  data(){
    return{
      bakData: [],
    }
  },
  mounted() {
    this.warningCheck();
    this.load();
  },
  watch:{
    bakData:{
      handler: function () {
        this.syncData();
      },
      deep: true
    }
  },
  methods: {
    warningCheck(){
      if (this.data[0].minValue > this.data[0].maxValue){
        Message.warning('错误码：01 数据取值范围为空集！');
      }
    },
    syncData(){
      try{
        this.data[0].data = this.toLensData(this.bakData);
      }catch (e) {
        Message.error('错误码：01 数据同步失败！');
      }
    },
    load(){
      // 数据格式转换
      this.bakData = this.toEchartsData(this.data[0].data)
      this.loadChart();
    },
    toEchartsData(lensArr){
      let temp = [];
      for (let i = 0; i < lensArr[0].length; i++){
        temp.push([lensArr[0][i], lensArr[1][i]]);
      }
      return JSON.parse(JSON.stringify(temp));
    },
    toLensData(echartsArr){
      let temp = [[], []];
      for (let i = 0; i < echartsArr.length; i++){
        temp[0].push(echartsArr[i][0]);
        if (this.data[0].valueUnit !== '%')
          temp[1].push(formatNumber(echartsArr[i][1], this.data[0].numPrecision, true));
        else
          temp[1].push(formatNumber(echartsArr[i][1], '1.0000', true));
      }
      return JSON.parse(JSON.stringify(temp));
    },
    loadChart() {
      const that = this;
      const chart = this.$echarts.init(document.getElementById('modifier-linear-' + this.id));
      //数据
      const option = {
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
              formatter: '{value}'    /**设置项1：y轴数据单位**/,
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
            data: [],         /**设置项2：数据**/
            label: {
              show: true,
              position: 'insideBottom',
              color: 'rgba(255,255,255,.6)',
              formatter: ''
            },
          }
        ]
      };

      /*************交互动作参数*************/
      //zoom
      if (this.data[0].data[0].length >= 6) {
        option.dataZoom[0].minSpan = Math.floor(6 / that.data[0].data[0].length * 100);
        option.dataZoom[0].maxSpan = Math.floor(6 / that.data[0].data[0].length * 100);
      } else {
        option.dataZoom[0].minSpan = 100;
        option.dataZoom[0].maxSpan = 100;
      }
      //点大小
      let symbolSize = 10;
      option.series[0].symbolSize = symbolSize;
      // tooltip显示精度
      option.series[0].label.formatter = function (params) {
        return formatNumber(params.value[1], that.data[0].numPrecision) + that.data[0].valueUnit;
      }
      /***********交互动作参数结束***********/

      /***************横坐标轴***************/
      // 标签
      option.xAxis[0].data = that.data[0].data[0];
      // 最值
      option.xAxis[0].min = that.data[0].data[0][0] - 1;
      option.xAxis[0].max = that.data[0].data[0][that.data[0].data[0].length - 1] + 1;
      /*************横坐标轴结束*************/
      //x标签
      // chartOption.xAxis[0].axisLabel.formatter = function (value) {
      //   return that.options[0].xAxisTags[value] + that.options[0].keyUnit;
      // }
      //y标签
      // chartOption.yAxis[0].axisLabel.formatter = function (value) {
      //   return formatNumber(value, that.options[0].numPrecision);
      // }
      /***************纵坐标轴***************/
      // 最值
      option.yAxis[0].min = that.data[0].minValue;
      option.yAxis[0].max = that.data[0].maxValue;
      /*************纵坐标轴结束*************/

      /****************点数据***************/
      option.series[0].data = that.bakData;
      /**************点数据结束*************/

      // 先设置option
      chart.setOption(option);
      /**************交互动作函数*************/
      setTimeout(function () {
        chart.setOption({
          graphic: that.bakData.map(function (item, dataIndex) {
            return {
              type: 'circle',
              position: chart.convertToPixel('grid', item),
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
      chart.on('dataZoom', updatePosition);
      function updatePosition() {
        chart.setOption({
          graphic: that.bakData.map(function (item, dataIndex) {
            return {
              position: chart.convertToPixel('grid', item)
            };
          })
        });
        chart.resize()
      }
      function showTooltip(dataIndex) {
        chart.dispatchAction({
          type: 'showTip',
          seriesIndex: 0,
          dataIndex: dataIndex
        });
      }
      function hideTooltip(dataIndex) {
        chart.dispatchAction({
          type: 'hideTip'
        });
      }
      function onPointDragging(dataIndex, pos) {
        // 获取新的坐标
        let newY = chart.convertFromPixel('grid', pos)[1];
        // 检查新的坐标是否在图表的范围内，超出极值就直接变成极值
        if (newY < that.data[0].minValue) {
          newY = that.data[0].minValue;
        }else if (newY > that.data[0].maxValue){
          newY = that.data[0].maxValue;
        }
        // 保持x坐标不变
        const oldX = that.bakData[dataIndex][0];
        that.$set(that.bakData, dataIndex, [oldX, newY]);
        // 更新同步数据
        chart.setOption({
          series: [{
            data: that.bakData
          }]
        });
        // 更新显示位置
        chart.setOption({
          graphic: that.bakData.map(function (item, itemIndex) {
            return {
              position: itemIndex === dataIndex ? chart.convertToPixel('grid', [oldX, newY]) : chart.convertToPixel('grid', item)
            };
          })
        });
      }
      function onPointDragEnd(dataIndex, pos) {
        // 获取新的坐标
        let newY = chart.convertFromPixel('grid', pos)[1];
        // 检查新的坐标是否在图表的范围内
        if (newY < that.data[0].minValue || newY > that.data[0].maxValue) {
          // 如果不在范围内，就将数据点的位置重置为边界上的位置
          newY = newY < that.data[0].minValue ? that.data[0].minValue : that.data[0].maxValue;
          const oldX = that.bakData[dataIndex][0];
          that.$set(that.bakData, dataIndex, [oldX, newY]);
          chart.setOption({
            series: [{
              data: that.bakData
            }]
          });
        }
      }
      window.addEventListener("resize", function () {
        chart.resize();
        chart.setOption(option);
      });
      /************交互动作函数结束***********/
    }
  },
}
</script>

<template>
  <div :id="'modifier-linear-' + id" style="width: 100%; height: 100%">
  </div>
</template>