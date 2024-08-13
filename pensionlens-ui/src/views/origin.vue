<template>
  <div class="main-box">
    <ul class="clearfix">
      <li>
        <div class="all-box" style="height: 3.2rem">
          <div class="all-title">模块标题样式</div>
          <div class="allnav" id="echart1" style="width: 100%; height: 100%"></div>
          <div class="all-box-foot"></div>
        </div>
        <div class="all-box" style="height: 3.2rem">
          <div class="all-title">模块标题样式</div>
          <div class="allnav" id="echart2"  style="width: 100%; height: 100%"></div>
          <div class="all-box-foot"></div>
        </div>
        <div class="all-box" style="height: 3.2rem">
          <div style="height: 100%; width: 100%">
            <div class="sy" id="fb1"></div>
            <div class="sy" id="fb2"></div>
            <div class="sy" id="fb3"></div>
          </div>
          <div class="all-box-foot"></div>
        </div>
      </li>
      <li>
        <div class="bar">
          <div class="barbox">
            <ul class="clearfix">
              <li class="pulll_left counter" style="font-family: 'DS DIGHTAL'">12581189</li>
              <li class="pulll_left counter" style="font-family: 'DS DIGHTAL'">3912410</li>
            </ul>
          </div>
          <div class="barbox2">
            <ul class="clearfix">
              <li class="pulll_left">2018年总收入情况</li>
              <li class="pulll_left">2018年总支出情况</li>
            </ul>
          </div>
        </div>
        <div class="map">
          <div class="map1"><img src="../assets/screen/lbx.png"/></div>
          <div class="map2"><img src="../assets/screen/jt.png"/></div>
          <div class="map3"><img src="../assets/screen/map.png"/></div>
          <div class="map4" id="map_1"></div>
        </div>
      </li>
      <li>
        <div class="all-box" style="height: 3.4rem">
          <div class="all-title">模块标题样式</div>
          <div class="allnav" id="echart4"  style="width: 100%; height: 100%"></div>
          <div class="all-box-foot"></div>
        </div>
        <div class="all-box" style="height: 3.2rem">
          <div class="all-title">模块标题样式</div>
          <div class="allnav" id="echart5"  style="width: 100%; height: 100%"></div>
          <div class="all-box-foot"></div>
        </div>
        <div class="all-box" style="height: 3rem">
          <div class="all-title">模块标题样式</div>
          <div class="allnav" id="echart6"  style="width: 100%; height: 100%"></div>
          <div class="all-box-foot"></div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import * as echarts from "echarts";

export default {
  methods: {
    echarts_1() {
      var that = this;
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById('echart1'));

      var option = {
        //  backgroundColor: '#00265f',
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        grid: {
          left: '0%',
          top: '10px',
          right: '0%',
          bottom: '4%',
          containLabel: true
        },
        xAxis: [{
          type: 'category',
          data: ['商超门店', '教育培训', '房地产', '生活服务', '汽车销售', '旅游酒店', '五金建材'],
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
            // rotate:50,
            show: true,
            splitNumber: 15,
            textStyle: {
              color: "rgba(255,255,255,.6)",
              fontSize: '12',
            },
          },
        }],
        yAxis: [{
          type: 'value',
          axisLabel: {
            //formatter: '{value} %'
            show: true,
            textStyle: {
              color: "rgba(255,255,255,.6)",
              fontSize: '12',
            },
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
        series: [
          {
            type: 'bar',
            data: [200, 300, 300, 900, 1500, 1200, 600],
            barWidth: '35%', //柱子宽度
            // barGap: 1, //柱子之间间距
            itemStyle: {
              normal: {
                color: '#2f89cf',
                opacity: 1,
                barBorderRadius: 5,
              }
            }
          }

        ]
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
      window.addEventListener("resize", function () {
        myChart.resize();
      });
    },
    echarts_2() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById('echart2'));

      var option = {
        //  backgroundColor: '#00265f',
        tooltip: {
          trigger: 'axis',
          axisPointer: {type: 'shadow'}
        },
        grid: {
          left: '0%',
          top: '10px',
          right: '0%',
          bottom: '4%',
          containLabel: true
        },
        xAxis: [{
          type: 'category',
          data: ['浙江', '上海', '江苏', '广东', '北京', '深圳', '安徽'],
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
            // rotate:50,
            show: true,
            splitNumber: 15,
            textStyle: {
              color: "rgba(255,255,255,.6)",
              fontSize: '12',
            },
          },
        }],
        yAxis: [{
          type: 'value',
          axisLabel: {
            //formatter: '{value} %'
            show: true,
            textStyle: {
              color: "rgba(255,255,255,.6)",
              fontSize: '12',
            },
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
        series: [
          {

            type: 'bar',
            data: [1500, 1200, 600, 200, 300, 300, 900],
            barWidth: '35%', //柱子宽度
            // barGap: 1, //柱子之间间距
            itemStyle: {
              normal: {
                color: '#27d08a',
                opacity: 1,
                barBorderRadius: 5,
              }
            }
          }

        ]
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
      window.addEventListener("resize", function () {
        myChart.resize();
      });
    },
    echarts_5() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById('echart5'));

      var option = {
        //  backgroundColor: '#00265f',
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },

        grid: {
          left: '0%',
          top: '10px',
          right: '0%',
          bottom: '2%',
          containLabel: true
        },
        xAxis: [{
          type: 'category',
          data: ['浙江', '上海', '江苏', '广东', '北京', '深圳', '安徽', '四川'],
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
            // rotate:50,
            show: true,
            splitNumber: 15,
            textStyle: {
              color: "rgba(255,255,255,.6)",
              fontSize: '12',
            },
          },
        }],
        yAxis: [{
          type: 'value',
          axisLabel: {
            //formatter: '{value} %'
            show: true,
            textStyle: {
              color: "rgba(255,255,255,.6)",
              fontSize: '12',
            },
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
        series: [{
          type: 'bar',
          data: [2, 3, 3, 9, 15, 12, 6, 4, 6, 7, 4, 10],
          barWidth: '35%', //柱子宽度
          // barGap: 1, //柱子之间间距
          itemStyle: {
            normal: {
              color: '#2f89cf',
              opacity: 1,
              barBorderRadius: 5,
            }
          }
        }
        ]
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
      window.addEventListener("resize", function () {
        myChart.resize();
      });
    },
    echarts_4() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById('echart4'));
      var option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            lineStyle: {
              color: '#dddc6b'
            }
          }
        },
        legend: {
          top: '0%',
          data: ['安卓', 'IOS'],
          textStyle: {
            color: 'rgba(255,255,255,.5)',
            fontSize: '12',
          }
        },
        grid: {
          left: '10',
          top: '30',
          right: '10',
          bottom: '10',
          containLabel: true
        },

        xAxis: [{
          type: 'category',
          boundaryGap: false,
          axisLabel: {
            textStyle: {
              color: "rgba(255,255,255,.6)",
              fontSize: 12,
            },
          },
          axisLine: {
            lineStyle: {
              color: 'rgba(255,255,255,.2)'
            }

          },

          data: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24']

        }, {

          axisPointer: {show: false},
          axisLine: {show: false},
          position: 'bottom',
          offset: 20,


        }],

        yAxis: [{
          type: 'value',
          axisTick: {show: false},
          axisLine: {
            lineStyle: {
              color: 'rgba(255,255,255,.1)'
            }
          },
          axisLabel: {
            textStyle: {
              color: "rgba(255,255,255,.6)",
              fontSize: 12,
            },
          },

          splitLine: {
            lineStyle: {
              color: 'rgba(255,255,255,.1)'
            }
          }
        }],
        series: [
          {
            name: '安卓',
            type: 'line',
            smooth: true,
            symbol: 'circle',
            symbolSize: 5,
            showSymbol: false,
            lineStyle: {

              normal: {
                color: '#0184d5',
                width: 2
              }
            },
            areaStyle: {
              normal: {
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                  offset: 0,
                  color: 'rgba(1, 132, 213, 0.4)'
                }, {
                  offset: 0.8,
                  color: 'rgba(1, 132, 213, 0.1)'
                }], false),
                shadowColor: 'rgba(0, 0, 0, 0.1)',
              }
            },
            itemStyle: {
              normal: {
                color: '#0184d5',
                borderColor: 'rgba(221, 220, 107, .1)',
                borderWidth: 12
              }
            },
            data: [3, 4, 3, 4, 3, 4, 3, 6, 2, 4, 2, 4, 3, 4, 3, 4, 3, 4, 3, 6, 2, 4, 2, 4]

          },
          {
            name: 'IOS',
            type: 'line',
            smooth: true,
            symbol: 'circle',
            symbolSize: 5,
            showSymbol: false,
            lineStyle: {

              normal: {
                color: '#00d887',
                width: 2
              }
            },
            areaStyle: {
              normal: {
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                  offset: 0,
                  color: 'rgba(0, 216, 135, 0.4)'
                }, {
                  offset: 0.8,
                  color: 'rgba(0, 216, 135, 0.1)'
                }], false),
                shadowColor: 'rgba(0, 0, 0, 0.1)',
              }
            },
            itemStyle: {
              normal: {
                color: '#00d887',
                borderColor: 'rgba(221, 220, 107, .1)',
                borderWidth: 12
              }
            },
            data: [5, 3, 5, 6, 1, 5, 3, 5, 6, 4, 6, 4, 8, 3, 5, 6, 1, 5, 3, 7, 2, 5, 1, 4]

          },

        ]

      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
      window.addEventListener("resize", function () {
        myChart.resize();
      });
    },
    echarts_6() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById('echart6'));

      var dataStyle = {
        normal: {
          label: {
            show: false
          },
          labelLine: {
            show: false
          },
          //shadowBlur: 40,
          //shadowColor: 'rgba(40, 40, 40, 1)',
        }
      };
      var placeHolderStyle = {
        normal: {
          color: 'rgba(255,255,255,.05)',
          label: {show: false,},
          labelLine: {show: false}
        },
        emphasis: {
          color: 'rgba(0,0,0,0)'
        }
      };
      var option = {
        color: ['#0f63d6', '#0f78d6', '#0f8cd6', '#0fa0d6', '#0fb4d6'],
        tooltip: {
          show: true,
          formatter: "{a} : {c} "
        },
        legend: {
          itemWidth: 10,
          itemHeight: 10,
          itemGap: 12,
          bottom: '3%',

          data: ['浙江', '上海', '广东', '北京', '深圳'],
          textStyle: {
            color: 'rgba(255,255,255,.6)',
          }
        },

        series: [
          {
            name: '浙江',
            type: 'pie',
            clockWise: false,
            center: ['50%', '42%'],
            radius: ['59%', '70%'],
            itemStyle: dataStyle,
            hoverAnimation: false,
            data: [{
              value: 80,
              name: '01'
            }, {
              value: 20,
              name: 'invisible',
              tooltip: {show: false},
              itemStyle: placeHolderStyle
            }]
          },
          {
            name: '上海',
            type: 'pie',
            clockWise: false,
            center: ['50%', '42%'],
            radius: ['49%', '60%'],
            itemStyle: dataStyle,
            hoverAnimation: false,
            data: [{
              value: 70,
              name: '02'
            }, {
              value: 30,
              name: 'invisible',
              tooltip: {show: false},
              itemStyle: placeHolderStyle
            }]
          },
          {
            name: '广东',
            type: 'pie',
            clockWise: false,
            hoverAnimation: false,
            center: ['50%', '42%'],
            radius: ['39%', '50%'],
            itemStyle: dataStyle,
            data: [{
              value: 65,
              name: '03'
            }, {
              value: 35,
              name: 'invisible',
              tooltip: {show: false},
              itemStyle: placeHolderStyle
            }]
          },
          {
            name: '北京',
            type: 'pie',
            clockWise: false,
            hoverAnimation: false,
            center: ['50%', '42%'],
            radius: ['29%', '40%'],
            itemStyle: dataStyle,
            data: [{
              value: 60,
              name: '04'
            }, {
              value: 40,
              name: 'invisible',
              tooltip: {show: false},
              itemStyle: placeHolderStyle
            }]
          },
          {
            name: '深圳',
            type: 'pie',
            clockWise: false,
            hoverAnimation: false,
            center: ['50%', '42%'],
            radius: ['20%', '30%'],
            itemStyle: dataStyle,
            data: [{
              value: 50,
              name: '05'
            }, {
              value: 50,
              name: 'invisible',
              tooltip: {show: false},
              itemStyle: placeHolderStyle
            }]
          },]
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
      window.addEventListener("resize", function () {
        myChart.resize();
      });
    },
    echarts_31() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById('fb1'));
      var option = {
        title: [{
          text: '年龄分布',
          left: 'center',
          textStyle: {
            color: '#fff',
            fontSize: '16'
          }
        }],
        tooltip: {
          trigger: 'item',
          formatter: "{a} <br/>{b}: {c} ({d}%)",
          position: function (p) {   //其中p为当前鼠标的位置
            return [p[0] + 10, p[1] - 10];
          }
        },
        legend: {
          top: '70%',
          itemWidth: 10,
          itemHeight: 10,
          data: ['0岁以下', '20-29岁', '30-39岁', '40-49岁', '50岁以上'],
          textStyle: {
            color: 'rgba(255,255,255,.5)',
            fontSize: '12',
          }
        },
        series: [
          {
            name: '年龄分布',
            type: 'pie',
            center: ['50%', '42%'],
            radius: ['40%', '60%'],
            color: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
            label: {show: false},
            labelLine: {show: false},
            data: [
              {value: 1, name: '0岁以下'},
              {value: 4, name: '20-29岁'},
              {value: 2, name: '30-39岁'},
              {value: 2, name: '40-49岁'},
              {value: 1, name: '50岁以上'},
            ]
          }
        ]
      };
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
      window.addEventListener("resize", function () {
        myChart.resize();
      });
    },
    echarts_32() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById('fb2'));
      var option = {
        title: [{
          text: '职业分布',
          left: 'center',
          textStyle: {
            color: '#fff',
            fontSize: '16'
          }
        }],
        tooltip: {
          trigger: 'item',
          formatter: "{a} <br/>{b}: {c} ({d}%)",
          position: function (p) {   //其中p为当前鼠标的位置
            return [p[0] + 10, p[1] - 10];
          }
        },
        legend: {
          top: '70%',
          itemWidth: 10,
          itemHeight: 10,
          data: ['电子商务', '教育', 'IT/互联网', '金融', '学生', '其他'],
          textStyle: {
            color: 'rgba(255,255,255,.5)',
            fontSize: '12',
          }
        },
        series: [
          {
            name: '年龄分布',
            type: 'pie',
            center: ['50%', '42%'],
            radius: ['40%', '60%'],
            color: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
            label: {show: false},
            labelLine: {show: false},
            data: [
              {value: 5, name: '电子商务'},
              {value: 1, name: '教育'},
              {value: 6, name: 'IT/互联网'},
              {value: 2, name: '金融'},
              {value: 1, name: '学生'},
              {value: 1, name: '其他'},
            ]
          }
        ]
      };
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
      window.addEventListener("resize", function () {
        myChart.resize();
      });
    },
    echarts_33() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById('fb3'));
      var option = {
        title: [{
          text: '兴趣分布',
          left: 'center',
          textStyle: {
            color: '#fff',
            fontSize: '16'
          }
        }],
        tooltip: {
          trigger: 'item',
          formatter: "{a} <br/>{b}: {c} ({d}%)",
          position: function (p) {   //其中p为当前鼠标的位置
            return [p[0] + 10, p[1] - 10];
          }
        },
        legend: {
          top: '70%',
          itemWidth: 10,
          itemHeight: 10,
          data: ['汽车', '旅游', '财经', '教育', '软件', '其他'],
          textStyle: {
            color: 'rgba(255,255,255,.5)',
            fontSize: '12',
          }
        },
        series: [
          {
            name: '兴趣分布',
            type: 'pie',
            center: ['50%', '42%'],
            radius: ['40%', '60%'],
            color: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
            label: {show: false},
            labelLine: {show: false},
            data: [
              {value: 2, name: '汽车'},
              {value: 3, name: '旅游'},
              {value: 1, name: '财经'},
              {value: 4, name: '教育'},
              {value: 8, name: '软件'},
              {value: 1, name: '其他'},
            ]
          }
        ]
      };
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
      window.addEventListener("resize", function () {
        myChart.resize();
      });
    },
    load(){
      // 延迟初始化图表，直到可以确定DOM元素已经有了正确的大小
      setTimeout(()=>{
        this.echarts_1();
        this.echarts_2();
        this.echarts_4();
        this.echarts_31();
        this.echarts_32();
        this.echarts_33();
        this.echarts_5();
        this.echarts_6();
      },2000)
    }
  },
  mounted() {
    this.load();
  }
}
</script>

<style scoped>
.main-box {
  padding: .1rem .1rem 0rem .1rem;
}

.main-box > ul {
}

.main-box > ul > li {
  float: left;
  padding: 0 .1rem
}

.main-box > ul > li {
  width: 30%
}

.main-box > ul > li:nth-child(2) {
  width: 40%;
  padding: 0
}




.bar {
  background: rgba(101, 132, 226, .1);
  padding: .15rem;
}

.barbox li, .barbox2 li {
  width: 50%;
  text-align: center;
  position: relative;
  z-index: 100;
}

.barbox:before,
.barbox:after {
  position: absolute;
  width: .3rem;
  height: .1rem;
  content: "";
}

.barbox:before {
  border-left: 2px solid #02a6b5;
  left: 0;
  border-top: 2px solid #02a6b5;
}

.barbox:after {
  border-right: 2px solid #02a6b5;
  right: 0;
  bottom: 0;
  border-bottom: 2px solid #02a6b5;
}

.barbox li:first-child:before {
  position: absolute;
  content: "";
  height: 50%;
  width: 1px;
  background: rgba(255, 255, 255, .2);
  right: 0;
  top: 25%;
}

.barbox {
  border: 1px solid rgba(25, 186, 139, .17);
  position: relative;
}

.barbox li {
  font-size: .7rem;
  color: #ffeb7b;
  padding: .05rem 0;
  font-family: electronicFont;
  font-weight: bold;
}

.barbox2 li {
  font-size: .19rem;
  color: rgba(255, 255, 255, .7);
  padding-top: .1rem;
}

.map {
  position: relative;
  height: 7.2rem;
  z-index: 9;
}

.map4 {
  width: 200%;
  height: 7rem;
  position: relative;
  left: -50%;
  top: 4%;
  margin-top: .2rem;
  z-index: 5;
}

.map1, .map2, .map3 {
  position: absolute;
  opacity: .5
}

.map1 {
  width: 6.43rem;
  z-index: 2;
  top: .45rem;
  left: .7rem;
  animation: myfirst2 15s infinite linear;
}

.map2 {
  width: 5.66rem;
  top: .85rem;
  left: 1.2rem;
  z-index: 3;
  opacity: 0.2;
  animation: myfirst 10s infinite linear;
}

.map3 {
  width: 5.18rem;
  top: 1.07rem;
  left: 1.4rem;
  z-index: 1;
}
</style>