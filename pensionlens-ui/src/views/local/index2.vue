<template>
  <div class="main-box">
    <ul class="clearfix">
      <li>
        <Block height="3.4rem" title="不同生育模式下不同年龄的人数预测情况">
          <ul class="select-ul-1st">
            <ul class="select-ul-1st">
              <li :class="{ active: activeItem3 === 1}" style="font-size: 12px" @click="activeItem3 = 1">男</li>
              <li :class="{ active: activeItem3 === 2}" style="font-size: 12px" @click="activeItem3 = 2">女</li>
            </ul>
          </ul>
          <ul class="select-ul-2nd">
            <ul class="select-ul-2nd">
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
          <Chart v-if="activeItem3===1 && activeItem2===1" type="ring" :detail="population31"/>
          <Chart v-else-if="activeItem3===1 && activeItem2===2" type="ring" :detail="population32"/>
          <Chart v-else-if="activeItem3===1 && activeItem2===3" type="ring" :detail="population33"/>
          <Chart v-else-if="activeItem3===2 && activeItem2===1" type="ring" :detail="population41"/>
          <Chart v-else-if="activeItem3===2 && activeItem2===2" type="ring" :detail="population42"/>
          <Chart v-else-if="activeItem3===2 && activeItem2===3" type="ring" :detail="population43"/>
        </Block>
        <Block height="3.2rem" title="广东省城镇养老保险未来收入和支出">
          <Chart type="bar" :detail="income_and_expense2"/>
        </Block>
        <Block height="3.4rem" title="广东省城镇职工的参保人数">
          <Chart type="linear" :detail="participants2"/>
        </Block>
      </li>
      <li>
        <div class="bar">
          <div class="barbox">
            <!--下述区域属于显示对应收入的区域-->
            <ul class="clearfix">
              <li class="pulll_left counter" style="font-family: 'DS DIGHTAL'">{{ digitNum1 }}
                <!--嵌套对应的环比的数据-->
                <transition name="fade">
                  <div class="icon-color" v-if="showElement">环比
                    <img src="../../assets/screen/icondown.png" height="12">
                    4.7%
                  </div>
                </transition>
              </li>
              <li class="pulll_left counter" style="font-family: 'DS DIGHTAL'">{{ digitNum2 }}
                <transition name="fade">
                  <div class="icon-color" v-if="showElement">环比
                    <img src="../../assets/screen/iconup.png" height="12">
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
          <div class="map2"><img src="../../assets/screen/jt.png"/></div>
        </div>
      </li>
      <li>
        <Block class="preview-charts" title="人均基本养老金情况" height="3.4rem">
          <Chart type="linear" :detail="lineData_basic01" :key="2"/>
        </Block>
        <Block title="人均个人养老金情况" height="3.2rem">
          <ul class="select-ul-2nd">
            <li :class="{ active: activeItem === 1}" style="font-size: 12px" @click="handleItemClick(1)">老中人</li>
            <li :class="{ active: activeItem === 2}" style="font-size: 12px" @click="handleItemClick(2)">新中人</li>
            <li :class="{ active: activeItem === 3}" style="font-size: 12px" @click="handleItemClick(3)">新人</li>
          </ul>
          <Chart v-if="activeItem===1" type="rose" :detail="pieData_pension04"/>
          <Chart v-else-if="activeItem===2" type="rose" :detail="pieData_pension05"/>
          <Chart v-else-if="activeItem===3" type="rose" :detail="pieData_pension06"/>
        </Block>
        <Block title="人均过渡养老金情况" height="3.4rem">
          <Chart type="radar" :detail="RadarData2"/>
        </Block>
      </li>
    </ul>
  </div>
</template>

<script>
import Guangdong from "@/views/local/components/Guangdong.vue";
import Chart from '@/components/chart.vue';
import {getRegionData} from "@/api/charts";

export default {
  components: {Chart, Guangdong},
  data() {
    return {
      activeItem2: [],
      activeItem: [],
      activeItem3: [],
      population31: [],
      population32: [],
      population33: [],
      population41: [],
      population42: [],
      population43: [],
      income_and_expense2: [],
      participants2: [],
      pieData_pension04: [],
      pieData_pension05: [],
      pieData_pension06: [],
      RadarData2: [],
      lineData_basic01: [],
      num1: 0,
      num2: 0,
      maxNum1: 38581413,//有关最终养老金收入和支出的情况
      maxNum2: 33136439,//有关最终养老金收入和支出的情况
      showElement: false,


      tempArr31: [],
      tempArr32: [],
      tempArr33: [],
      tempArr41: [],
      tempArr42: [],
      tempArr43: [],
    }
  },
  created() {
    getRegionData().then(res => {
      this.activeItem2 = 1;//默认激活的项是'1'
      this.activeItem = 3;//默认激活的项是'3'
      this.activeItem3 = 1;//默认激活的项是'1'
      this.population31.push(res.data.H_population201[0]);
      this.population32.push(res.data.M_population202[0]);
      this.population33.push(res.data.L_population203[0]);
      this.population41.push(res.data.H_population201[1]);
      this.population42.push(res.data.M_population202[2]);
      this.population43.push(res.data.L_population203[3]);

      this.income_and_expense2 = res.data.income_and_expense02;
      this.participants2 = res.data.participants02;
      this.pieData_pension04 = res.data.pieData_pension201;
      this.pieData_pension05 = res.data.pieData_pension202;
      this.pieData_pension06 = res.data.pieData_pension203;
      this.RadarData2 = res.data.RadarData2;
      this.lineData_basic01 = res.data.lineData_basic01;
      this.num1 = 0;
      this.num2 = 0;
      this.maxNum1 = 38581413;//有关最终养老金收入和支出的情况
      this.maxNum2 = 33136439;//有关最终养老金收入和支出的情况
      this.showElement = false;

      this.tempArr31.push(res.data.H_population101[0]);
      this.tempArr32.push(res.data.M_population102[0]);
      this.tempArr33.push(res.data.L_population103[0]);
      this.tempArr41.push(res.data.H_population101[1]);
      this.tempArr42.push(res.data.M_population102[2]);
      this.tempArr43.push(res.data.L_population103[3]);
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
      if (!sessionStorage.getItem('gd2-reloaded')) {
        sessionStorage.setItem('gd2-reloaded', true);
        //location.reload();
      } else {
        sessionStorage.removeItem('gd2-reloaded');
      }
    });
    this.load();
    this.startCounter();
  },
}
</script>

<style scoped>

.select-ul-2nd {
  position: absolute;
  width: 1rem;
  top: 1rem;
  right: 0;
  z-index: 999;
}

.select-ul-2nd > li {
  height: 0.4rem;
  line-height: 0.4rem;
  padding-left: 10px;
  box-sizing: border-box;
  background-color: rgba(14, 148, 234, 0.2);
  cursor: default;
  color: #cdddf7;
}

.select-ul-2nd > li.active {
  color: white;
  background: #0e94eb;
}

.select-ul-1st {
  position: absolute;
  width: 1rem;
  bottom: 0.2rem;
  left: 0;
  z-index: 999;
}

.select-ul-1st > li {
  height: 0.4rem;
  line-height: 0.4rem;
  padding-left: 10px;
  box-sizing: border-box;
  background-color: rgba(14, 148, 234, 0.2);
  cursor: default;
  color: #cdddf7;
}

.select-ul-1st > li.active {
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
