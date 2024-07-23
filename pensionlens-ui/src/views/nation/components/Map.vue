<template>
  <div id="china-map">
  </div>
</template>

<script>
import china from '../../../assets/map/中华人民共和国.json';

//展示有关广东养老保险相关的数据
export default {
  data() {//把对应的数据导出来
    return {
      myChart: null
    }
  },
  methods: {
    map() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById('china-map'));
      this.$echarts.registerMap('china', china);
      this.myChart = myChart;
      let option = {
        baseOption: {
          timeline: {
            axisType: 'category',
            autoPlay: true,
            playInterval: 3000,
            bottom: '23%',
            left: '15%',
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
            controlStyle: {
              showNextBtn: false,
              showPrevBtn: false,//是否展示时间轴左右的箭头
              itemSize: 30,//设置暂停键的大小
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
            bottom: '30%',
            min: 200,
            max: 5000,
            inRange: {
              color: [
                '#b3d8ff', // 浅蓝色
                '#66b3ff',
                '#3399ff',
                '#0066cc',
                '#003366'  // 深蓝色
              ]
            },
            text: ['High', 'Low'],
            textStyle: {
              color: 'lightblue',
              fontSize: 12,
            },
            calculable: true,
          },
        },
        options: [
          {
            title: {
              text: '审图号：GS京(2022)1061号',
              top: 25,
            },
            series: [
              {
                name: '中国各省养老保险收入情况',
                type: 'map',
                map: 'china',
                selectedMode: 'multiple',//表示可以同时选中多个区域
                emphasis: {
                  label: {
                    show: true
                  }
                },
                tooltip: {
                  trigger: 'item',
                  alwaysShowContent: true,
                  triggerOn: 'mousemove',
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
                    name: '北京市', value: 2553.9
                  }, {
                    name: '天津市', value: 1120.3
                  }, {
                    name: '河北省', value: 2125.7
                  }, {
                    name: '山西省', value: 1223.4
                  }, {
                    name: '内蒙古自治区', value: 1094.6
                  }, {
                    name: '辽宁省', value: 2343.6
                  }, {
                    name: '吉林省', value: 1055.4
                  }, {
                    name: '黑龙江省', value: 1630.2
                  }, {
                    name: '上海市', value: 2808.9
                  }, {
                    name: '江苏省', value: 3923.2
                  }, {
                    name: '浙江省', value: 3011.8
                  }, {
                    name: '安徽省', value: 2005.6
                  }, {
                    name: '福建省', value: 886.4
                  }, {
                    name: '江西省', value: 1169.8
                  }, {
                    name: '山东省', value: 2728.1
                  }, {
                    name: '河南省', value: 1901.8
                  }, {
                    name: '湖北省', value: 1941.7
                  }, {
                    name: '湖南省', value: 2129.2
                  }, {
                    name: '广东省', value: 4571.3
                  }, {
                    name: '广西壮族自治区', value: 1248.9
                  }, {
                    name: '海南省', value: 326.1
                  }, {
                    name: '重庆市', value: 1202.3
                  }, {
                    name: '四川省', value: 2884.2
                  }, {
                    name: '贵州省', value: 799.3
                  }, {
                    name: '云南省', value: 878.0
                  }, {
                    name: '西藏自治区', value: 110.5
                  }, {
                    name: '陕西省', value: 1173.3
                  }, {
                    name: '甘肃省', value: 552.6
                  }, {
                    name: '青海省', value: 217.7
                  }, {
                    name: '宁夏回族自治区', value: 268.8
                  }, {
                    name: '新疆维吾尔自治区', value: 1041.7
                  }, {
                    name: '台湾省', value: 169.78
                  }, {
                    name: '香港特别行政区', value: 427.68
                  }, {
                    name: '澳门特别行政区', value: 450.3
                  }, {
                    name: '南海诸岛', value: 128.8
                  }
                ]
              }
            ],
          },
          {
            series: [
              {
                name: '中国各省养老保险收入情况',
                type: 'map',
                map: 'china',
                selectedMode: 'multiple',//表示可以同时选中多个区域
                emphasis: {
                  label: {
                    show: true
                  }
                },
                tooltip: {
                  alwaysShowContent: true,
                  triggerOn: 'mousemove',
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
                    name: '北京市', value: 2760.6
                  }, {
                    name: '天津市', value: 1021.2
                  }, {
                    name: '河北省', value: 2437.4
                  }, {
                    name: '山西省', value: 1232.5
                  }, {
                    name: '内蒙古自治区', value: 1060.9
                  }, {
                    name: '辽宁省', value: 2486.4
                  }, {
                    name: '吉林省', value: 1142.8
                  }, {
                    name: '黑龙江省', value: 1785.4
                  }, {
                    name: '上海市', value: 2933.7
                  }, {
                    name: '江苏省', value: 3759.2
                  }, {
                    name: '浙江省', value: 3040.0
                  }, {
                    name: '安徽省', value: 1514.6
                  }, {
                    name: '福建省', value: 931.8
                  }, {
                    name: '江西省', value: 1047.2
                  }, {
                    name: '山东省', value: 2784.7
                  }, {
                    name: '河南省', value: 2053.0
                  }, {
                    name: '湖北省', value: 2418.0
                  }, {
                    name: '湖南省', value: 1767.5
                  }, {
                    name: '广东省', value: 5593.2
                  }, {
                    name: '广西壮族自治区', value: 1128.7
                  }, {
                    name: '海南省', value: 324.5
                  }, {
                    name: '重庆市', value: 1238.3
                  }, {
                    name: '四川省', value: 2754.9
                  }, {
                    name: '贵州省', value: 725.6
                  }, {
                    name: '云南省', value: 951.3
                  }, {
                    name: '西藏自治区', value: 139.1
                  }, {
                    name: '陕西省', value: 1254.1
                  }, {
                    name: '甘肃省', value: 598.5
                  }, {
                    name: '青海省', value: 300.5
                  }, {
                    name: '宁夏回族自治区', value: 269.1
                  }, {
                    name: '新疆维吾尔自治区', value: 1137.1
                  }, {
                    name: '台湾省', value: 339.38
                  }, {
                    name: '香港特别行政区', value: 578.96
                  }, {
                    name: '澳门特别行政区', value: 500.68
                  }, {
                    name: '南海诸岛', value: 298.7
                  }
                ]
              }
            ],
          },
          {
            series: [
              {
                name: '中国各省养老保险收入情况',
                type: 'map',
                map: 'china',
                selectedMode: 'multiple',//表示可以同时选中多个区域
                emphasis: {
                  label: {
                    show: true
                  }
                },
                tooltip: {
                  alwaysShowContent: true,
                  triggerOn: 'mousemove',
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
                    name: '北京市', value: 2160.6
                  }, {
                    name: '天津市', value: 854.5
                  }, {
                    name: '河北省', value: 1683.6
                  }, {
                    name: '山西省', value: 1111.9
                  }, {
                    name: '内蒙古自治区', value: 997.4
                  }, {
                    name: '辽宁省', value: 2149.9
                  }, {
                    name: '吉林省', value: 957.3
                  }, {
                    name: '黑龙江省', value: 1629.3
                  }, {
                    name: '上海市', value: 2036.7
                  }, {
                    name: '江苏省', value: 3018.2
                  }, {
                    name: '浙江省', value: 2397.4
                  }, {
                    name: '安徽省', value: 1313.6
                  }, {
                    name: '福建省', value: 790.8
                  }, {
                    name: '江西省', value: 1032.5
                  }, {
                    name: '山东省', value: 2491.2
                  }, {
                    name: '河南省', value: 1689.5
                  }, {
                    name: '湖北省', value: 2024.7
                  }, {
                    name: '湖南省', value: 1733.8
                  }, {
                    name: '广东省', value: 3558.1
                  }, {
                    name: '广西壮族自治区', value: 982.5
                  }, {
                    name: '海南省', value: 266.3
                  }, {
                    name: '重庆市', value: 1212.5
                  }, {
                    name: '四川省', value: 2662.3
                  }, {
                    name: '贵州省', value: 668
                  }, {
                    name: '云南省', value: 819.9
                  }, {
                    name: '西藏自治区', value: 132.1
                  }, {
                    name: '陕西省', value: 1221.5
                  }, {
                    name: '甘肃省', value: 558.6
                  }, {
                    name: '青海省', value: 237.6
                  }, {
                    name: '宁夏回族自治区', value: 264.7
                  }, {
                    name: '新疆维吾尔自治区', value: 1087.9
                  }, {
                    name: '台湾省', value: 254.9
                  }, {
                    name: '香港特别行政区', value: 439.68
                  }, {
                    name: '澳门特别行政区', value: 480.3
                  }, {
                    name: '南海诸岛', value: 108.8
                  }
                ]
              }
            ],
          },
          {
            series: [
              {
                name: '中国各省养老保险收入情况',
                type: 'map',
                map: 'china',
                selectedMode: 'multiple',//表示可以同时选中多个区域
                emphasis: {
                  label: {
                    show: true
                  }
                },
                tooltip: {
                  alwaysShowContent: true,
                  triggerOn: 'mousemove',
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
                    name: '北京市', value: 3265.9
                  }, {
                    name: '天津市', value: 1159.9
                  }, {
                    name: '河北省', value: 2076.3
                  }, {
                    name: '山西省', value: 1429.2
                  }, {
                    name: '内蒙古自治区', value: 1195.2
                  }, {
                    name: '辽宁省', value: 2593.9
                  }, {
                    name: '吉林省', value: 1316.8
                  }, {
                    name: '黑龙江省', value: 1824.5
                  }, {
                    name: '上海市', value: 3379.5
                  }, {
                    name: '江苏省', value: 4391.1
                  }, {
                    name: '浙江省', value: 3488.7
                  }, {
                    name: '安徽省', value: 1731.6
                  }, {
                    name: '福建省', value: 1065.1
                  }, {
                    name: '江西省', value: 1334.2
                  }, {
                    name: '山东省', value: 3454.3
                  }, {
                    name: '河南省', value: 2136.7
                  }, {
                    name: '湖北省', value: 2441.9
                  }, {
                    name: '湖南省', value: 1859.6
                  }, {
                    name: '广东省', value: 6112.5
                  }, {
                    name: '广西壮族自治区', value: 1278.0
                  }, {
                    name: '海南省', value: 387.9
                  }, {
                    name: '重庆市', value: 1737.8
                  }, {
                    name: '四川省', value: 3596.7
                  }, {
                    name: '贵州省', value: 864.4
                  }, {
                    name: '云南省', value: 1076.5
                  }, {
                    name: '西藏自治区', value: 159.7
                  }, {
                    name: '陕西省', value: 1604.6
                  }, {
                    name: '甘肃省', value: 694.1
                  }, {
                    name: '青海省', value: 272.4
                  }, {
                    name: '宁夏回族自治区', value: 302.3
                  }, {
                    name: '新疆维吾尔自治区', value: 1336.5
                  }, {
                    name: '台湾省', value: 390.6
                  }, {
                    name: '香港特别行政区', value: 478.96
                  }, {
                    name: '澳门特别行政区', value: 405.68
                  }, {
                    name: '南海诸岛', value: 238.7
                  }
                ]
              }
            ],
          },
          {
            series: [
              {
                name: '中国各省养老保险收入情况',
                type: 'map',
                map: 'china',
                selectedMode: 'multiple',//表示可以同时选中多个区域
                emphasis: {
                  label: {
                    show: true
                  }
                },
                tooltip: {
                  alwaysShowContent: true,
                  triggerOn: 'mousemove',
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
                    name: '北京市', value: 3435.8
                  }, {
                    name: '天津市', value: 1225
                  }, {
                    name: '河北省', value: 2293.8
                  }, {
                    name: '山西省', value: 1413
                  }, {
                    name: '内蒙古自治区', value: 1248.3
                  }, {
                    name: '辽宁省', value: 2761
                  }, {
                    name: '吉林省', value: 1216.2
                  }, {
                    name: '黑龙江省', value: 1851.8
                  }, {
                    name: '上海市', value: 3705.5
                  }, {
                    name: '江苏省', value: 4846.9
                  }, {
                    name: '浙江省', value: 3796.8
                  }, {
                    name: '安徽省', value: 1883.8
                  }, {
                    name: '福建省', value: 1220.7
                  }, {
                    name: '江西省', value: 1389.9
                  }, {
                    name: '山东省', value: 3558.8
                  }, {
                    name: '河南省', value: 2292
                  }, {
                    name: '湖北省', value: 2549.7
                  }, {
                    name: '湖南省', value: 2019.5
                  }, {
                    name: '广东省', value: 6419.7
                  }, {
                    name: '广西壮族自治区', value: 1313.1
                  }, {
                    name: '海南省', value: 428.7
                  }, {
                    name: '重庆市', value: 1688.2
                  }, {
                    name: '四川省', value: 3701.9
                  }, {
                    name: '贵州省', value: 928.6
                  }, {
                    name: '云南省', value: 1153.9
                  }, {
                    name: '西藏自治区', value: 171.5
                  }, {
                    name: '陕西省', value: 1696.2
                  }, {
                    name: '甘肃省', value: 718.2
                  }, {
                    name: '青海省', value: 291
                  }, {
                    name: '宁夏回族自治区', value: 347.7
                  }, {
                    name: '新疆维吾尔自治区', value: 1407.8
                  }, {
                    name: '台湾省', value: 350.6
                  }, {
                    name: '香港特别行政区', value: 278.96
                  }, {
                    name: '澳门特别行政区', value: 300.68
                  }, {
                    name: '南海诸岛', value: 198.7
                  }
                ]
              }
            ],
          }
        ]
      };
      myChart.setOption(option);
      window.addEventListener("resize", function () {
        myChart.resize();
      })
    },
    handleChartClick(params) {
      let data = params.data;//获取用户点击的对象信息
      if (data.name ==='广东省') {
        this.$router.push('/regin')
      }
    },
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
        this.myChart.on('click', this.handleChartClick);
        this.myChart.on('mouseover', this.handleMouseOver);
        this.myChart.on('mouseout', this.handleMouseOut);
        setInterval(() => {
          this.handleTimelineChange();
        }, 3000); // 每隔5秒执行一次
      });
    }
}

</script>

<style scoped>
#china-map {
  height: 9rem;
  width: 100%;
  z-index: 10;
}

</style>