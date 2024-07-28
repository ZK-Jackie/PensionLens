<template>
  <div class="main-box">
    <ul class="clearfix" v-if="isLoadable">
      <li>
        <Block height="3.4rem" title="不同生育模式下不同年龄的人数预测情况">
          <ul class="select-ul2" v-if="buttonIndex1[0] !== undefined">
            <li v-for="(name, index) in buttonIndex1[0]"
                :key="index"
                :class="{ active: buttonActive1[0] === name }"
                class="button-list"
                style="font-size: 0.15rem"
                @click="handleButtonClick(0, name, 1)">{{ name }}</li>
          </ul>
          <ul class="select-ul" v-if="buttonIndex2[0] !== undefined">
            <li v-for="(name, index) in buttonIndex2[0]"
                :key="index" :class="{ active: buttonActive2[0] === name }"
                style="font-size: 0.15rem"
                @click="handleButtonClick(0, name, 2)">{{ name }}</li>
          </ul>
          <Chart type="ring" :data="nowData[0]" :key="nowData[0][0].dataId"/>
        </Block>
        <Block height="3.2rem" title="广东省城镇养老保险未来收入和支出">
          <Chart type="bar" :data="nowData[1]" :key="nowData[1][0].dataId"/>
        </Block>
        <Block height="3.4rem" title="广东省城镇职工的参保人数">
          <Chart type="linear" :data="nowData[2]" :key="nowData[2][0].dataId"/>
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
                    <img src="../../assets/screen/icondown.png" alt="icon-down" height="12">
                    4.7%
                  </div>
                </transition>
              </li>
              <li class="pulll_left counter" style="font-family: 'DS DIGHTAL'">{{ num2 }}
                <transition name="fade">
                  <div class="icon-color" v-if="showElement">环比
                    <img src="../../assets/screen/iconup.png" alt="icon-down" height="12">
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
        <Block title="人均基本养老金变化" height="3.4rem">
          <Chart type="climb" :data="nowData[3]" :key="nowData[3][0].dataId"/>
        </Block>
        <Block title="人均个人养老金情况" height="3.2rem">
          <ul class="select-ul">
            <ul class="select-ul">
              <li :class="{ active: activeItem === 1}" style="font-size: 12px" @click="handleItemClick(1)">老中人</li>
              <li :class="{ active: activeItem === 2}" style="font-size: 12px" @click="handleItemClick(2)">新中人</li>
              <li :class="{ active: activeItem === 3}" style="font-size: 12px" @click="handleItemClick(3)">新人</li>
            </ul>
          </ul>
<!--          <Chart v-if="activeItem===1" type="rose" :detail="pieData_pension01"/>-->
<!--          <Chart v-else-if="activeItem===2" type="rose" :detail="pieData_pension02"/>-->
<!--          <Chart v-else-if="activeItem===3" type="rose" :detail="pieData_pension03"/>-->
        </Block>
        <Block title="人均过渡养老金情况" height="3.4rem">
<!--          <Chart type="radar" :detail="RadarData"/>-->
        </Block>
      </li>
    </ul>
  </div>
</template>

<script>
import {UUID} from "@/utils/string";
import Block from "@/components/block.vue";
import Guangdong from "@/views/local/components/Guangdong.vue";
import Chart from '@/components/chart.vue';
import BasicPension from "@/views/local/components/BasicPension.vue";
import {getRegionData} from "@/api/charts";

export default {
  components: {Chart, Block, Guangdong, BasicPension},
  data() {
    return {
      // 当前是否可被显示
      isLoadable: false,
      // 当前屏本身参数
      nowScreenId: 2,
      // 当前屏的所有详情
      totalDetails: [],
      totalData: {},
      // 当前屏所有按键状况
      buttonActive1: [],
      buttonActive2: [],
      buttonDataMap: {},
      buttonIndex1: [],
      buttonIndex2: [],
      // 当前屏的显示数据
      nowData: [],


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
  watch:{
    buttonActive1:{
      deep: true,
      handler: function () {

      },
    }
  },
  created() {
    getRegionData().then(res => {
      // this.activeItem2 = 1;//默认激活的项是'1'
      // this.activeItem = 3;//默认激活的项是'3'
      // this.activeItem3 = 1;//默认激活的项是'1'
      // this.participants = res.data.participants01;
      // this.RadarData = res.data.RadarData1;
      // this.pieData = res.data.pieData;
      // this.barData = res.data.barData;
      // this.lineData = res.data.lineData;
      // this.pieData_pension01 = res.data.pieData_pension01;
      // this.pieData_pension02 = res.data.pieData_pension02;
      // this.pieData_pension03 = res.data.pieData_pension03;
      // this.population11.push(res.data.H_population101[0]);
      // this.population12.push(res.data.M_population102[0]);
      // this.population13.push(res.data.L_population103[0]);
      // this.population21.push(res.data.H_population101[1]);
      // this.population22.push(res.data.M_population102[2]);
      // this.population23.push(res.data.L_population103[3]);
      // this.income_and_expense = res.data.income_and_expense01;
      //
      // this.tempArr11.push(res.data.H_population101[0]);
      // this.tempArr12.push(res.data.M_population102[0]);
      // this.tempArr13.push(res.data.L_population103[0]);
      // this.tempArr21.push(res.data.H_population101[1]);
      // this.tempArr22.push(res.data.M_population102[2]);
      // this.tempArr23.push(res.data.L_population103[3]);
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
    },
    loadData(){
      this.$store.dispatch('GetScreenDetail', this.nowScreenId).then(res => {
        this.totalDetails = JSON.parse(JSON.stringify(res));
        this.preProcessDetail();
        this.isLoadable = true;
      }).catch(err => {
        console.error(err)
      });
    },
    getDataFromDetail(detailId, dataId){
      this.totalDetails.forEach(item => {
        if (item.detailId === detailId) {
          item.detailData.forEach(detail => {
            if (detail.dataId === dataId) {
              return detail;
            }
          });
        }
      });
    },
    handleButtonClick(blockSpot, name, indexId){
      // 若按键没有变化，不进行任何操作
      if (indexId === 1 && this.buttonActive1[blockSpot] === name) {
        return;
      }else if (indexId === 2 && this.buttonActive2[blockSpot] === name) {
        return;
      }
      // 按键点击事件
      if (indexId === 1) {
        this.$set(this.buttonActive1, blockSpot, name);
      } else {
        this.$set(this.buttonActive2, blockSpot, name);
      }
      this.$nextTick(() => {
        let button_x = this.buttonActive1[blockSpot];
        let button_y = this.buttonActive2[blockSpot];
        let pickDataId = this.buttonDataMap[blockSpot][button_x][button_y];
        for (let i = 0; i < this.totalDetails[blockSpot].minDataUnit; i++) {
          this.$set(this.nowData[blockSpot], i, this.totalData[pickDataId]);
        }
      });
    },
    preProcessDetail(){
      // 准备渲染面板。即将初始化的内容有：
      // this.buttonDataMap，this.buttonIndex1，this.buttonIndex2，
      // this.buttonActive1，this.buttonActive2，this.nowData，this.totalData
      console.log(this.totalDetails);
      // 1. 检查是否有按键面板
      this.totalDetails.forEach(item => {
        // 若有按键面板，构造按键、数据映射表，构造默认激活按键表
        if(item.isMultiOption){
          // 初始化按键索引——确定两个按键组每个按键叫什么名字；初始化按键、数据映射二维表——确定两个按键对应一个数据；
          this.buttonDataMap[item.detailId] = {};
          item.detailData.forEach(detail => {
            // 初始化当前 detail 按键索引1，值为dataName
            if (this.buttonIndex1[item.detailId] === undefined) {
              this.$set(this.buttonIndex1, item.detailId, []);
            }
            if (!this.buttonIndex1[item.detailId].includes(detail.dataName[0])) {
              this.buttonIndex1[item.detailId].push(detail.dataName[0]);
            }
            // 初始化当前 detail 按键索引2，值为dataName
            if (this.buttonIndex2[item.detailId] === undefined) {
              this.$set(this.buttonIndex2, item.detailId, []);
            }
            if (!this.buttonIndex2[item.detailId].includes(detail.dataName[1])) {
              this.buttonIndex2[item.detailId].push(detail.dataName[1]);
            }
            // 二位表的横纵坐标分别为dataName的第一个参数和第二个参数，值为dataId
            if (!(detail.dataName[0] in this.buttonDataMap[item.detailId])) {
              this.$set(this.buttonDataMap[item.detailId], detail.dataName[0], {});
            }
            this.buttonDataMap[item.detailId][detail.dataName[0]][detail.dataName[1]] = detail.dataId;
          });
          // 默认激活按键表，第一个值为buttonIndex1的第一个值，第二个值为buttonIndex2的第一个值，值为dataName
          this.buttonActive1[item.detailId] = this.buttonIndex1[item.detailId][0];
          this.buttonActive2[item.detailId] = this.buttonIndex2[item.detailId][0];
        }
        // 2. 将当前detail应当展示的数据加载到nowData中
        let tempArr = [];
        for (let i = 0; i < item.minDataUnit; i++) {
          tempArr.push(item.detailData[i]);
        }
        this.nowData[item.detailId] = JSON.parse(JSON.stringify(tempArr));
        // 3. 将当前detail的所有数据根据 dataId 加载到totalData中
        item.detailData.forEach(data => {
          this.totalData[data.dataId] = data;
        });
      });
    }
  },
  mounted() {
    this.loadData();
    this.load();
    this.startCounter();
    console.log(this.nowData);
  },
}
</script>

<style scoped>

.select-ul {
  position: absolute;
  width: 1rem;
  right: 0;
  bottom: 0.2rem;
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
  padding: .1rem .1rem 0 .1rem;
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
