<template>
  <div id="gd-map">
<!--    <li id="symbol">-->
<!--      审图号：GS（2024）0568号-->
<!--    </li>-->
  </div>
</template>

<script>
import gdMap from '../../../assets/map/Guangdong.json';

//展示有关广东养老保险相关的数据
export default {
  data() {//把对应的数据导出来
    return {
      myChart: null
    }
  },
  methods: {
    map() {
      var that = this;
      // 基于准备好的dom，初始化echarts实例
      var myChart = this.$echarts.init(document.getElementById('gd-map'));
      this.$echarts.registerMap('guangdong', gdMap);
      this.myChart = myChart
      var option = {
        baseOption: {
          timeline: {
            axisType: 'category',
            autoPlay: true,
            playInterval: 3000,
            left:'13%',
            animationDurationUpdate: 1000, // 动画的持续时间，单位为毫秒
            animationEasingUpdate: 'cubicInOut', // 动画的缓动效果
            data: [
              {value: '2018-01-01', symbol: 'diamond', symbolSize: 18},
              '2019-01-01',
              '2020-01-01',
              '2021-01-01',
              {value: '2022-01-01', symbol: 'diamond', symbolSize: 18}
            ],
            label: {
              formatter: function (s) {
                return new Date(s).getFullYear();
              }
            },
            controlStyle:{
              showNextBtn: false,
              showPrevBtn: false,//是否展示时间轴左右的箭头
              itemSize:25,//设置暂停键的大小
              itemGap: 35,//设置暂停键与时间轴之间的间距
            }
          },
          tooltip: {
            trigger: 'item',
            showDelay: 0,
            transitionDuration: 2,
          },
          visualMap: {
            right: '2%',
            bottom: '15%',
            min: 1000,
            max: 100000,
            inRange: {
              color: [
                '#b3d8ff', // 浅蓝色
                '#66b3ff',
                '#3399ff',
                '#0066cc',
                '#003366'  // 深蓝色
              ]
              // color: [
              //   '#e0f7fa',
              //   '#b2ebf2',
              //   '#80deea',
              //   '#4dd0e1',
              //   '#26c6da'
              // ]
            },
            text: ['High', 'Low'],
            textStyle: {
              color: 'lightblue',
              fontSize: 12,
            },
            calculable: true,
          },
        },
        options:[
          {
            title: {
              text: '审图号：GS京(2022)1061号',
              top:13,
            },
            series: [
              {
                name: '广东省各市养老保险收入情况',
                type: 'map',
                map: 'guangdong',
                selectedMode: 'multiple',//表示可以同时选中多个区域
                emphasis: {
                  label: {
                    show: true
                  }
                },
                tooltip: {
                  trigger: 'item',
                  formatter: '{b}<br/>{c} (亿元)',
                  showDelay: 0,
                  transitionDuration: 2,
                  right:20,
                  backgroundColor: 'rgba(0,0,0,0)', // 设置背景颜色为透明
                  textStyle: {
                    fontSize: 12,
                    color:'#fff',
                    fontWeight: 'bold'
                  }
                },
                animationDurationUpdate: 2000, // 动画的持续时间，单位为毫秒
                animationEasingUpdate: 'cubicInOut', // 动画的缓动效果
                data: [
                  {
                    name: '广州市',
                    value: 120057.34
                  },
                  {
                    name: '韶关市',
                    value: 15477.48
                  },
                  {
                    name: '深圳市',
                    value: 131686.1
                  },
                  {
                    name: '珠海市',
                    value: 6992.6
                  },
                  {
                    name: '汕头市',
                    value: 44045.49
                  },
                  {
                    name: '佛山市',
                    value: 40689.64
                  },
                  {
                    name: '江门市',
                    value: 37659.78
                  },
                  {
                    name: '湛江市',
                    value: 45180.97
                  },
                  {
                    name: '茂名市',
                    value: 5204.26
                  },
                  {
                    name: '肇庆市',
                    value: 21900.9
                  },
                  {
                    name: '惠州市',
                    value: 4918.26
                  },
                  {
                    name: '梅州市',
                    value: 5881.84
                  },
                  {
                    name: '汕尾市',
                    value: 4178.01
                  },
                  {
                    name: '河源市',
                    value: 2227.92
                  },
                  {
                    name: '阳江市',
                    value: 2180.98
                  },
                  {
                    name: '清远市',
                    value: 9172.94
                  },
                  {
                    name: '东莞市',
                    value: 3368
                  },
                  {
                    name: '中山市',
                    value: 306.98
                  },
                  {
                    name: '潮州市',
                    value: 810.66
                  },
                  {
                    name: '揭阳市',
                    value: 542.2
                  },
                  {
                    name: '云浮市',
                    value: 256.38
                  }
                ]
              }
            ]
          },
          {
            series: [
              {
                name: '广东省各市养老保险收入情况',
                type: 'map',
                map: 'guangdong',
                selectedMode: 'multiple',//表示可以同时选中多个区域
                emphasis: {
                  label: {
                    show: true
                  }
                },
                tooltip: {
                  trigger: 'item',
                  formatter: '{b}<br/>{c} (亿元)',
                  showDelay: 0,
                  transitionDuration: 2,
                  right:20,
                  backgroundColor: 'rgba(0,0,0,0)', // 设置背景颜色为透明
                  textStyle: {
                    fontSize: 12,
                    color:'#fff',
                    fontWeight: 'bold'
                  }
                },
                animationDurationUpdate: 2000, // 动画的持续时间，单位为毫秒
                animationEasingUpdate: 'cubicInOut', // 动画的缓动效果
                data: [
                  {
                    name: '广州市',
                    value: 130000.34
                  },
                  {
                    name: '韶关市',
                    value: 16000.48
                  },
                  {
                    name: '深圳市',
                    value: 140000.1
                  },
                  {
                    name: '珠海市',
                    value: 8000.6
                  },
                  {
                    name: '汕头市',
                    value: 45000.49
                  },
                  {
                    name: '佛山市',
                    value: 41000.64
                  },
                  {
                    name: '江门市',
                    value: 38000.78
                  },
                  {
                    name: '湛江市',
                    value: 46000.97
                  },
                  {
                    name: '茂名市',
                    value: 5300.26
                  },
                  {
                    name: '肇庆市',
                    value: 22000.9
                  },
                  {
                    name: '惠州市',
                    value: 5000.26
                  },
                  {
                    name: '梅州市',
                    value: 6000.84
                  },
                  {
                    name: '汕尾市',
                    value: 4200.01
                  },
                  {
                    name: '河源市',
                    value: 2300.92
                  },
                  {
                    name: '阳江市',
                    value: 2200.98
                  },
                  {
                    name: '清远市',
                    value: 9200.94
                  },
                  {
                    name: '东莞市',
                    value: 3400
                  },
                  {
                    name: '中山市',
                    value: 310.98
                  },
                  {
                    name: '潮州市',
                    value: 820.66
                  },
                  {
                    name: '揭阳市',
                    value: 550.2
                  },
                  {
                    name: '云浮市',
                    value: 260.38
                  }
                ]
              }
            ]
          },
          {
            series: [
              {
                name: '广东省各市养老保险收入情况',
                type: 'map',
                map: 'guangdong',
                selectedMode: 'multiple',//表示可以同时选中多个区域
                emphasis: {
                  label: {
                    show: true
                  }
                },
                tooltip: {
                  trigger: 'item',
                  formatter: '{b}<br/>{c} (亿元)',
                  showDelay: 0,
                  transitionDuration: 2,
                  right:20,
                  backgroundColor: 'rgba(0,0,0,0)', // 设置背景颜色为透明
                  textStyle: {
                    fontSize: 12,
                    color:'#fff',
                    fontWeight: 'bold'
                  }
                },
                animationDurationUpdate: 2000, // 动画的持续时间，单位为毫秒
                animationEasingUpdate: 'cubicInOut', // 动画的缓动效果
                data: [
                  {
                    name: '广州市',
                    value: 130000.34
                  },
                  {
                    name: '韶关市',
                    value: 16000.48
                  },
                  {
                    name: '深圳市',
                    value: 140000.1
                  },
                  {
                    name: '珠海市',
                    value: 8000.6
                  },
                  {
                    name: '汕头市',
                    value: 45000.49
                  },
                  {
                    name: '佛山市',
                    value: 41000.64
                  },
                  {
                    name: '江门市',
                    value: 38000.78
                  },
                  {
                    name: '湛江市',
                    value: 46000.97
                  },
                  {
                    name: '茂名市',
                    value: 5300.26
                  },
                  {
                    name: '肇庆市',
                    value: 22000.9
                  },
                  {
                    name: '惠州市',
                    value: 5000.26
                  },
                  {
                    name: '梅州市',
                    value: 6000.84
                  },
                  {
                    name: '汕尾市',
                    value: 4200.01
                  },
                  {
                    name: '河源市',
                    value: 2300.92
                  },
                  {
                    name: '阳江市',
                    value: 2200.98
                  },
                  {
                    name: '清远市',
                    value: 9200.94
                  },
                  {
                    name: '东莞市',
                    value: 3400
                  },
                  {
                    name: '中山市',
                    value: 310.98
                  },
                  {
                    name: '潮州市',
                    value: 820.66
                  },
                  {
                    name: '揭阳市',
                    value: 550.2
                  },
                  {
                    name: '云浮市',
                    value: 260.38
                  }
                ]
              }
            ]
          },
          {
            series: [
              {
                name: '广东省各市养老保险收入情况',
                type: 'map',
                map: 'guangdong',
                selectedMode: 'multiple',//表示可以同时选中多个区域
                emphasis: {
                  label: {
                    show: true
                  }
                },
                tooltip: {
                  trigger: 'item',
                  formatter: '{b}<br/>{c} (亿元)',
                  showDelay: 0,
                  transitionDuration: 2,
                  right:20,
                  backgroundColor: 'rgba(0,0,0,0)', // 设置背景颜色为透明
                  textStyle: {
                    fontSize: 12,
                    color:'#fff',
                    fontWeight: 'bold'
                  }
                },
                animationDurationUpdate: 2000, // 动画的持续时间，单位为毫秒
                animationEasingUpdate: 'cubicInOut', // 动画的缓动效果
                data: [
                  {
                    name: '广州市',
                    value: 150000.34
                  },
                  {
                    name: '韶关市',
                    value: 20000.48
                  },
                  {
                    name: '深圳市',
                    value: 160000.1
                  },
                  {
                    name: '珠海市',
                    value: 10000.6
                  },
                  {
                    name: '汕头市',
                    value: 55000.49
                  },
                  {
                    name: '佛山市',
                    value: 51000.64
                  },
                  {
                    name: '江门市',
                    value: 48000.78
                  },
                  {
                    name: '湛江市',
                    value: 56000.97
                  },
                  {
                    name: '茂名市',
                    value: 6300.26
                  },
                  {
                    name: '肇庆市',
                    value: 32000.9
                  },
                  {
                    name: '惠州市',
                    value: 7000.26
                  },
                  {
                    name: '梅州市',
                    value: 8000.84
                  },
                  {
                    name: '汕尾市',
                    value: 6200.01
                  },
                  {
                    name: '河源市',
                    value: 4300.92
                  },
                  {
                    name: '阳江市',
                    value: 4200.98
                  },
                  {
                    name: '清远市',
                    value: 11200.94
                  },
                  {
                    name: '东莞市',
                    value: 5400
                  },
                  {
                    name: '中山市',
                    value: 610.98
                  },
                  {
                    name: '潮州市',
                    value: 1220.66
                  },
                  {
                    name: '揭阳市',
                    value: 950.2
                  },
                  {
                    name: '云浮市',
                    value: 660.38
                  }
                ]
              }
            ]
          },
          {
            series: [
              {
                name: '广东省各市养老保险收入情况',
                type: 'map',
                map: 'guangdong',
                selectedMode: 'multiple',//表示可以同时选中多个区域
                emphasis: {
                  label: {
                    show: true
                  }
                },
                tooltip: {
                  trigger: 'item',
                  formatter: '{b}<br/>{c} (亿元)',
                  showDelay: 0,
                  transitionDuration: 2,
                  right:20,
                  backgroundColor: 'rgba(0,0,0,0)', // 设置背景颜色为透明
                  textStyle: {
                    fontSize: 12,
                    color:'#fff',
                    fontWeight: 'bold'
                  }
                },
                animationDurationUpdate: 2000, // 动画的持续时间，单位为毫秒
                animationEasingUpdate: 'cubicInOut', // 动画的缓动效果
                data: [
                  {
                    name: '广州市',
                    value: 170000.34
                  },
                  {
                    name: '韶关市',
                    value: 24000.48
                  },
                  {
                    name: '深圳市',
                    value: 180000.1
                  },
                  {
                    name: '珠海市',
                    value: 12000.6
                  },
                  {
                    name: '汕头市',
                    value: 65000.49
                  },
                  {
                    name: '佛山市',
                    value: 61000.64
                  },
                  {
                    name: '江门市',
                    value: 58000.78
                  },
                  {
                    name: '湛江市',
                    value: 66000.97
                  },
                  {
                    name: '茂名市',
                    value: 7300.26
                  },
                  {
                    name: '肇庆市',
                    value: 42000.9
                  },
                  {
                    name: '惠州市',
                    value: 9000.26
                  },
                  {
                    name: '梅州市',
                    value: 10000.84
                  },
                  {
                    name: '汕尾市',
                    value: 8200.01
                  },
                  {
                    name: '河源市',
                    value: 6300.92
                  },
                  {
                    name: '阳江市',
                    value: 6200.98
                  },
                  {
                    name: '清远市',
                    value: 13200.94
                  },
                  {
                    name: '东莞市',
                    value: 7400
                  },
                  {
                    name: '中山市',
                    value: 910.98
                  },
                  {
                    name: '潮州市',
                    value: 1620.66
                  },
                  {
                    name: '揭阳市',
                    value: 1350.2
                  },
                  {
                    name: '云浮市',
                    value: 1060.38
                  }
                ]
              }
            ]
          },
          {
            series: [
              {
                name: '广东省各市养老保险收入情况',
                type: 'map',
                map: 'guangdong',
                selectedMode: 'multiple',//表示可以同时选中多个区域
                emphasis: {
                  label: {
                    show: true
                  }
                },
                tooltip: {
                  trigger: 'item',
                  formatter: '{b}<br/>{c} (亿元)',
                  showDelay: 0,
                  transitionDuration: 2,
                  backgroundColor: 'rgba(0,0,0,0)', // 设置背景颜色为透明
                  right:20,
                  textStyle: {
                    fontSize: 12,
                    color:'#fff',
                    fontWeight: 'bold'
                  }
                },
                animationDurationUpdate: 2000, // 动画的持续时间，单位为毫秒
                animationEasingUpdate: 'cubicInOut', // 动画的缓动效果
                data: [
                  {
                    name: '广州市',
                    value: 170500.34
                  },
                  {
                    name: '韶关市',
                    value: 24500.48
                  },
                  {
                    name: '深圳市',
                    value: 180500.1
                  },
                  {
                    name: '珠海市',
                    value: 12500.6
                  },
                  {
                    name: '汕头市',
                    value: 65500.49
                  },
                  {
                    name: '佛山市',
                    value: 61500.64
                  },
                  {
                    name: '江门市',
                    value: 58500.78
                  },
                  {
                    name: '湛江市',
                    value: 66500.97
                  },
                  {
                    name: '茂名市',
                    value: 7800.26
                  },
                  {
                    name: '肇庆市',
                    value: 42500.9
                  },
                  {
                    name: '惠州市',
                    value: 9500.26
                  },
                  {
                    name: '梅州市',
                    value: 10500.84
                  },
                  {
                    name: '汕尾市',
                    value: 8700.01
                  },
                  {
                    name: '河源市',
                    value: 6800.92
                  },
                  {
                    name: '阳江市',
                    value: 6700.98
                  },
                  {
                    name: '清远市',
                    value: 13700.94
                  },
                  {
                    name: '东莞市',
                    value: 7900
                  },
                  {
                    name: '中山市',
                    value: 960.98
                  },
                  {
                    name: '潮州市',
                    value: 1670.66
                  },
                  {
                    name: '揭阳市',
                    value: 1400.2
                  },
                  {
                    name: '云浮市',
                    value: 1110.38
                  }
                ]
              }
            ]
          }
        ]
      };
      myChart.setOption(option);
      window.addEventListener("resize", function () {
        myChart.resize();
      })
    },
    // handleChartClick(params) {
    //   // params.data 包含了用户点击的数据
    //   var data = params.data;
    //   console.log(data);
    // }
    handleMouseOver() {
      this.myChart.dispatchAction({
        type: 'timelinePlayChange',
        playState: false
      });
    },
    handleMouseOut() {
      this.myChart.dispatchAction({
        type: 'timelinePlayChange',
        playState: true
      });
    },
    handleTimelineChange() {
      // 获取所有的省份
      const provinces = this.myChart.getOption().series[0].data.map(item => item.name);
      // 随机选择一个省份
      const randomProvince = provinces[Math.floor(Math.random() * provinces.length)];
      // 显示这个省份的提示框
      this.myChart.dispatchAction({
        type: 'showTip',
        seriesIndex: 0,
        dataIndex: provinces.indexOf(randomProvince)
      });
      // 触发 'click' 事件
      this.myChart.dispatchAction({
        type: 'click',
        seriesIndex: 0,
        dataIndex: provinces.indexOf(randomProvince)
      });
    },
  },
  mounted() {
    this.$nextTick(() => {
      this.map();
      this.myChart.on('mouseover',this.handleMouseOver);
      this.myChart.on('mouseout',this.handleMouseOut);
      setInterval(() => {
        this.handleTimelineChange();
      }, 3000); // 每隔3秒执行一次
    });
  }
}

</script>

<style lang="scss" scoped>
#gd-map {
  width: 100%;
  height: 7.1rem;
  z-index: 100;
  position: absolute;
  top:2%;
  left:0.5%;
}

#symbol{
  font-size: .5rem;
  z-index: 999;
  color: black;
  position: absolute;
  top: 2%;
  left:1%;
  font-family: 'DS DIGHTAL';
}
</style>
