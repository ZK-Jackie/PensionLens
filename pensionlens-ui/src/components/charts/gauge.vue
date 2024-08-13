<script>
import {UUID} from "@/utils/string";
import {formatNumber} from "@/utils/number";

export default {
  name: 'GaugeChart',
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
      required: true,
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
      const chart = this.$echarts.init(document.getElementById('chart-item-gauge-' + that.id));
      const option = {
        tooltip: {
          formatter: '{a} <br/>{b} : {c}'
        },
        series: [
          {
            type: 'gauge',
            name:  '安全指数',
            startAngle: 180,
            endAngle: 0,
            center: ['50%', '70%'],
            radius: '90%',
            min: 0,
            max: 1,
            splitNumber: 8,
            axisLine: {
              lineStyle: {
                width: 7,
                color: [] // 设置项1：色系
                //对应轴线的色系
              }
            },
            pointer: {
              icon: 'path://M12.8,0.7l12,40.1H0.7L12.8,0.7z',
              length: '12%',
              width: 18,
              offsetCenter: [0, '-60%'],
              itemStyle: {
                color: 'auto'
              }
            },
            axisTick: {
              length: 12,
              lineStyle: {
                color: 'auto',
                width: 2.5
              }
            },
            splitLine: {
              length: 20,
              lineStyle: {
                color: 'auto',
                width: 5
              }
            },
            axisLabel: {
              color: 'rgba(255,255,255,.6)',
              fontSize: 22,
              distance: -55,
              rotate: 'tangential',
              formatter: ''  // 设置项2：刻度标签
            },
            progress: {
              show: true,
              overlap: true,
              roundCap: true
            },
            detail: {
              fontSize: 35,
              offsetCenter: [0, '-30%'],
              valueAnimation: true,
              formatter: function (value) {
                return Math.round(value * 100) + '';
              },
              color: 'inherit'
            },
            data: []
          }
        ]
      };
      // 填充数据
      /**********色系***********/
      option.series[0].axisLine.lineStyle.color = [
        [0.25, that.data[0].dataColor[0]],
        [0.5, that.data[0].dataColor[1]],
        [0.75, that.data[0].dataColor[2]],
        [1, that.data[0].dataColor[3]]
      ];
      /*********刻度标签*********/
      option.series[0].axisLabel.formatter = function (value) {
        if (value === 0.875) {
          return that.data[0].data[0][3];
        } else if (value === 0.625) {
          return that.data[0].data[0][2];
        } else if (value === 0.375) {
          return that.data[0].data[0][1];
        } else if (value === 0.125) {
          return that.data[0].data[0][0];
        }
        return '';
      }
      /*********数据*********/
      option.series[0].data = [
        {
          value: formatNumber(that.data[0].data[1][0], that.data[0].numPrecision),
          name: that.data[0].dataName[0]　
        }
      ];
      // 使用刚指定的配置项和数据显示图表
      chart.setOption(option);
      setInterval(() => {
        chart.clear(); // 清除当前图表
        // 并改变对应的安全系数的值
        option.series[0].data[0].value = formatNumber(Math.random(), that.data[0].numPrecision)
        chart.setOption(option);
      }, 5000); // 每5秒刷新一次图表
      window.addEventListener("resize", function () {
        chart.resize();
      });
    }
  },
}
</script>

<template>
  <div
      class="chart-item-gauge"
      :id="'chart-item-gauge-'+ id"
      style="width: 100%; height: 100%;">
  </div>
</template>