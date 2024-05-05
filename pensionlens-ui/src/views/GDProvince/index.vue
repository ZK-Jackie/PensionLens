<template>
  <div class="main-box">
    <ul class="clearfix">
      <li>
        <Block height="3.4rem" title="不同生育模式下不同年龄的人数预测情况">
          <ul class="select-ul2">
            <ul class="select-ul2">
              <li :class="{ active: activeItem3 === 1}" style="font-size: 12px" @click="activeItem3 = 1">男</li>
              <li :class="{ active: activeItem3 === 2}" style="font-size: 12px" @click="activeItem3 = 2">女</li>
            </ul>
          </ul>
          <ul class="select-ul">
            <ul class="select-ul">
              <li :class="{ active: activeItem2 === 1}" style="font-size: 12px" @click="handleItemClick2(1)">
                高生育模式
              </li>
              <li :class="{ active: activeItem2 === 2}" style="font-size: 12px" @click="handleItemClick2(2)">
                中生育模式
              </li>
              <li :class="{ active: activeItem2 === 3}" style="font-size: 12px" @click="handleItemClick2(3)">
                低生育模式
              </li>
            </ul>
          </ul>
          <Chart v-if="activeItem3===1 && activeItem2===1" type="ring" :detail="population11"/>
          <Chart v-else-if="activeItem3===1 && activeItem2===2" type="ring" :detail="population12"/>
          <Chart v-else-if="activeItem3===1 && activeItem2===3" type="ring" :detail="population13"/>
          <Chart v-else-if="activeItem3===2 && activeItem2===1" type="ring" :detail="population21"/>
          <Chart v-else-if="activeItem3===2 && activeItem2===2" type="ring" :detail="population22"/>
          <Chart v-else-if="activeItem3===2 && activeItem2===3" type="ring" :detail="population23"/>
        </Block>
        <Block height="3.2rem" title="广东省城镇养老保险未来收入和支出">
          <Chart type="bar" :detail="income_and_expense" />
        </Block>
        <Block height="3.4rem" title="广东省城镇职工的参保人数">
          <Chart type="linear" :detail="participants"/>
        </Block>
      </li>
      <li>
        <div class="bar">
          <div class="barbox">
            <!--下述区域属于显示对应收入的区域-->
            <ul class="clearfix">
              <li class="pulll_left counter" style="font-family: 'DS DIGHTAL'">{{ num1 }}
                <!--嵌套对应的环比的数据-->
                <transition name="fade">
                  <div class="icon-color" v-if="showElement">环比
                    <img src="@/assets/icondown.png" height="12">
                    4.7%
                  </div>
                </transition>
              </li>
              <li class="pulll_left counter" style="font-family: 'DS DIGHTAL'">{{ num2 }}
                <transition name="fade">
                  <div class="icon-color" v-if="showElement">环比
                    <img src="@/assets/iconup.png" height="12">
                    3.5%
                  </div>
                </transition>
              </li>
            </ul>
          </div>
          <div class="barbox2">
            <ul class="clearfix">
              <li class="pulll_left">2023年养老保险总收入情况</li>
              <li class="pulll_left">2023年养老保险总支出情况</li>
            </ul>
          </div>
        </div>
        <div class="map">
          <!--展示地图的地方-->
          <Guangdong/>
          <div class="map2"><img src="@/assets/jt.png"/></div>
        </div>
      </li>
      <li>
        <Block title="人均基本养老金情况" height="3.4rem">
          <BasicPension/>
        </Block>
        <Block title="人均个人养老金情况" height="3.2rem">
          <ul class="select-ul">
            <ul class="select-ul">
              <li :class="{ active: activeItem === 1}" style="font-size: 12px" @click="handleItemClick(1)">老中人</li>
              <li :class="{ active: activeItem === 2}" style="font-size: 12px" @click="handleItemClick(2)">新中人</li>
              <li :class="{ active: activeItem === 3}" style="font-size: 12px" @click="handleItemClick(3)">新人</li>
            </ul>
          </ul>
          <Chart v-if="activeItem===1" type="rose" :detail="pieData_pension01"/>
          <Chart v-else-if="activeItem===2" type="rose" :detail="pieData_pension02"/>
          <Chart v-else-if="activeItem===3" type="rose" :detail="pieData_pension03"/>
        </Block>
        <Block title="人均过渡养老金情况" height="3.4rem">
          <Chart type="radar" :detail="RadarData"/>
        </Block>
      </li>
    </ul>
  </div>
</template>

<script>
import * as echarts from "echarts";
import Block from "@/components/block.vue";
import Guangdong from "@/views/GDProvince/components/Guangdong.vue";
import Chart from '@/components/chart.vue';
import BasicPension from "@/views/GDProvince/components/BasicPension.vue";
import {getRegionData} from "@/api/charts";

export default {
  components: {Chart, Block, Guangdong, BasicPension},
  data() {
    return {
      activeItem2: [],
      activeItem: [],
      activeItem3: [],
      participants: [],
      RadarData: [],
      pieData: [],
      barData: [],
      lineData: [],
      pieData_pension01: [],
      pieData_pension02: [],
      pieData_pension03: [],
      population11: [],
      population12: [],
      population13: [],
      population21: [],
      population22: [],
      population23: [],
      num1: 0,
      num2: 0,
      maxNum1: 38581413,//有关最终养老金收入和支出的情况
      maxNum2: 33136439,//有关最终养老金收入和支出的情况
      showElement: false,
      income_and_expense: [],

      tempArr11: [],
      tempArr12: [],
      tempArr13: [],
      tempArr21: [],
      tempArr22: [],
      tempArr23: [],
    }
  },
  created() {
    getRegionData().then(res => {
      this.activeItem2 = 1;//默认激活的项是'1'
      this.activeItem = 3;//默认激活的项是'3'
      this.activeItem3 = 1;//默认激活的项是'1'
      this.participants = res.data.participants01;
      this.RadarData = res.data.RadarData1;
      this.pieData = res.data.pieData;
      this.barData = res.data.barData;
      this.lineData = res.data.lineData;
      this.pieData_pension01 = res.data.pieData_pension01;
      this.pieData_pension02 = res.data.pieData_pension02;
      this.pieData_pension03 = res.data.pieData_pension03;
      this.population11.push(res.data.H_population101[0]);
      this.population12.push(res.data.M_population102[0]);
      this.population13.push(res.data.L_population103[0]);
      this.population21.push(res.data.H_population101[1]);
      this.population22.push(res.data.M_population102[2]);
      this.population23.push(res.data.L_population103[3]);
      this.income_and_expense = res.data.income_and_expense01;

      this.tempArr11.push(res.data.H_population101[0]);
      this.tempArr12.push(res.data.M_population102[0]);
      this.tempArr13.push(res.data.L_population103[0]);
      this.tempArr21.push(res.data.H_population101[1]);
      this.tempArr22.push(res.data.M_population102[2]);
      this.tempArr23.push(res.data.L_population103[3]);
    })
  },
  methods: {
    handleItemClick(index) {
      this.activeItem = index; // 将 activeItem 设置为被点击的项目的索引
    },
    handleItemClick2(index) {
      this.activeItem2 = index; // 将 activeItem 设置为被点击的项目的索引
    },
    startCounter() {
      let time = 0;
      setInterval(() => {
        time += 13;
        if (this.num1 < this.maxNum1) {
          const increment = time * time; // 使用二次函数来计算增量
          if (this.maxNum1 - this.num1 < increment) { // 如果接近最大值
            this.num1 = this.maxNum1; // 直接设置为最大值
          } else {
            this.num1 += increment;
          }
        }
        if (this.num2 < this.maxNum2) {
          const increment = time * time; // 使用二次函数来计算增量
          if (this.maxNum2 - this.num2 < increment) { // 如果接近最大值
            this.num2 = this.maxNum2; // 直接设置为最大值
          } else {
            this.num2 += increment;
          }
        }
      }, 100) // 注意这里的时间间隔已经改为100毫秒，因为我们现在是以0.1秒为单位增加时间
    },
    load() {
      // 延迟初始化图表，直到可以确定DOM元素已经有了正确的大小
      setTimeout(() => {
        this.showElement = true;
      }, 500);
    }
  },
  mounted() {
    this.$nextTick(() => {
      if (!sessionStorage.getItem('gd1-reloaded')) {
        sessionStorage.setItem('gd1-reloaded', true);
        location.reload();
      } else {
        sessionStorage.removeItem('gd1-reloaded');
      }
    });
    this.load();
    this.startCounter();
  },
}
</script>

<style scoped>

.select-ul {
  position: absolute;
  width: 1rem;
  top: 1rem;
  right: 0;
  z-index: 999;
}

.select-ul > li {
  height: 0.4rem;
  line-height: 0.4rem;
  padding-left: 10px;
  box-sizing: border-box;
  background-color: rgba(14, 148, 234, 0.2);
  cursor: default;
  color: #cdddf7;
}

.select-ul > li.active {
  color: white;
  background: #0e94eb;
}

.select-ul2 {
  position: absolute;
  width: 1rem;
  bottom: 0.2rem;
  left: 0;
  z-index: 999;
}

.select-ul2 > li {
  height: 0.4rem;
  line-height: 0.4rem;
  padding-left: 10px;
  box-sizing: border-box;
  background-color: rgba(14, 148, 234, 0.2);
  cursor: default;
  color: #cdddf7;
}

.select-ul2 > li.active {
  color: white;
  background: #0e94eb;
}

.fade-enter-active {
  animation: zoomInOut .5s;
}

.fade-enter {
  opacity: 0;
}

@keyframes zoomInOut {
  0% {
    transform: scale(1);
    opacity: 0;
  }
  70% {
    transform: scale(2);
    opacity: 1;
  }
  100% {
    transform: scale(1);
    opacity: 1;
  }
}

.icon-color {
  color: #2f89cf;
  font-size: 11px;
  position: absolute;
  top: 0;
  right: 0;
}

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
  height: 8.8rem;
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
