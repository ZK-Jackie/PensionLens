<template>
  <div class="main-box">
    <ul class="clearfix" v-if="isLoadable">
      <li>
        <Block height="3.4rem" title="不同生育模式下不同年龄的人数预测情况">
          <ul class="select-ul-1st" v-if="buttonIndex1[spotDetailMap[0]] !== undefined">
            <li v-for="(name, index) in buttonIndex1[spotDetailMap[0]]"
                :key="index"
                :class="{ active: buttonActive1[spotDetailMap[0]] === name }"
                class="button-list"
                style="font-size: 0.15rem"
                @click="handleButtonClick(spotDetailMap[0], name, 1)">{{ name }}</li>
          </ul>
          <ul class="select-ul-2nd" v-if="buttonIndex2[spotDetailMap[0]] !== undefined">
            <li v-for="(name, index) in buttonIndex2[spotDetailMap[0]]"
                :key="index" :class="{ active: buttonActive2[spotDetailMap[0]] === name }"
                style="font-size: 0.15rem"
                @click="handleButtonClick(0, name, 2)">{{ name }}</li>
          </ul>
          <Chart type="ring" :data="nowData[spotDetailMap[0]]" :key="nowData[spotDetailMap[0]][0].dataId"/>
        </Block>
        <Block height="3.2rem" title="广东省城镇养老保险未来收入和支出">
          <Chart type="bar" :data="nowData[spotDetailMap[1]]" :key="nowData[spotDetailMap[1]][0].dataId"/>
        </Block>
        <Block height="3.4rem" title="广东省城镇职工的参保人数">
          <Chart type="linear" :data="nowData[spotDetailMap[2]]" :key="nowData[spotDetailMap[2]][0].dataId"/>
        </Block>
      </li>
      <li>
        <div class="bar">
          <div class="barbox">
            <!--下述区域属于显示对应收入的区域-->
            <ul class="clearfix">
              <li class="pulll_left counter" style="font-family: 'DS-DIGIT', serif">{{ digitNum1 }}
                <!--嵌套对应的环比的数据-->
                <transition name="fade">
                  <div class="icon-color" v-if="showDigit">环比
                    <img src="../../assets/screen/icondown.png" alt="icon-down" height="12">
                    {{ '4.7 %' }}
                  </div>
                </transition>
              </li>
              <li class="pulll_left counter" style="font-family: 'DS-DIGIT', serif">{{ digitNum2 }}
                <transition name="fade">
                  <div class="icon-color" v-if="showDigit">环比
                    <img src="../../assets/screen/iconup.png" alt="icon-down" height="12">
                    {{ '3.5 %' }}
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
          <Guangdong/>
          <div class="map2"><img alt="map background" src="../../assets/screen/jt.png"/></div>
        </div>
      </li>
      <li>
        <Block title="人均基本养老金变化" height="3.4rem">
          <Chart type="climb" :data="nowData[spotDetailMap[3]]" :key="nowData[spotDetailMap[3]][0].dataId"/>
        </Block>
        <Block title="人均个人养老金情况" height="3.2rem">
          <ul class="select-ul-1st" v-if="buttonIndex1[spotDetailMap[4]] !== undefined">
            <li v-for="(name, index) in buttonIndex1[spotDetailMap[4]]"
                :key="index"
                :class="{ active: buttonActive1[spotDetailMap[4]] === name }"
                class="button-list"
                style="font-size: 0.15rem"
                @click="handleButtonClick(spotDetailMap[4], name, 1)">{{ name }}</li>
          </ul>
          <Chart type="rose" :data="nowData[spotDetailMap[4]]" :key="nowData[spotDetailMap[4]][0].dataId"/>
        </Block>
        <Block title="人均过渡养老金情况" height="3.4rem">
          <Chart type="rader" :data="nowData[spotDetailMap[5]]" :key="nowData[spotDetailMap[5]][0].dataId"/>
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
      spotDetailMap: [],  // detail和spot的映射
      // 当前屏所有按键状况
      buttonActive1: [],
      buttonActive2: [],
      buttonDataMap: {},
      buttonIndex1: [],
      buttonIndex2: [],
      // 当前屏的显示数据
      nowData: [],
      // 当前屏幕中央大数字
      digitNum1: 0,
      digitNum2: 0,
      digitMaxNum1: 38581413,//有关最终养老金收入和支出的情况
      digitMaxNum2: 33136439,//有关最终养老金收入和支出的情况
      showDigit: false,
    }
  },
  methods: {
    startCounter() {
      let time = 0;
      setInterval(() => {
        time += 13;
        if (this.digitNum1 < this.digitMaxNum1) {
          const increment = time * time; // 使用二次函数来计算增量
          if (this.digitMaxNum1 - this.digitNum1 < increment) { // 如果接近最大值
            this.digitNum1 = this.digitMaxNum1; // 直接设置为最大值
          } else {
            this.digitNum1 += increment;
          }
        }
        if (this.digitNum2 < this.digitMaxNum2) {
          const increment = time * time; // 使用二次函数来计算增量
          if (this.digitMaxNum2 - this.digitNum2 < increment) { // 如果接近最大值
            this.digitNum2 = this.digitMaxNum2; // 直接设置为最大值
          } else {
            this.digitNum2 += increment;
          }
        }
      }, 100) // 注意这里的时间间隔已经改为100毫秒，因为我们现在是以0.1秒为单位增加时间
    },
    loadDigitAnimation() {
      // 延迟初始化图表，直到可以确定DOM元素已经有了正确的大小
      setTimeout(() => {
        this.showDigit = true;
      }, 500);
    },
    reqData(){
      this.$store.dispatch('GetScreenDetail', this.nowScreenId).then(res => {
        this.totalDetails = JSON.parse(JSON.stringify(res.data.screenDetails));
        this.preProcessDetail();
        this.isLoadable = true;
      }).catch(err => {
        console.error(err)
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
        // 如果有第二个按钮才是两级寻 id，一级的话使用一个 x 即可
        let pickDataId
        if (button_y !== undefined){
          pickDataId = this.buttonDataMap[blockSpot][button_x][button_y];
        } else {
          pickDataId = this.buttonDataMap[blockSpot][button_x];
        }
        // 根据需求取数据
        for (let i = 0; i < this.totalDetails[blockSpot].minDataUnit; i++) {
          this.$set(this.nowData[blockSpot], i, this.totalData[pickDataId]);
        }
      });
    },
    preProcessDetail(){
      // 准备渲染面板。即将初始化的内容有：
      // this.buttonDataMap，this.buttonIndex1，this.buttonIndex2，this.spotDetailMap
      // this.buttonActive1，this.buttonActive2，this.nowData，this.totalData
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
            // 如果有第二个 dataName 就两层 button
            if (detail.dataName[1] !== undefined){
              this.buttonDataMap[item.detailId][detail.dataName[0]][detail.dataName[1]] = detail.dataId;
            }else{
              this.buttonDataMap[item.detailId][detail.dataName[0]] = detail.dataId;
            }
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
        // 4. 将当前detail的所有数据根据 spotId 加载到spotDetailMap中
        this.spotDetailMap.push(item.detailId);
      });
    }
  },
  mounted() {
    this.reqData();
    this.loadDigitAnimation();
    this.startCounter();
  },
}
</script>

<style scoped lang="scss">
.select-ul-2nd {
  position: absolute;
  width: 1rem;
  right: 0;
  bottom: 0.2rem;
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
  font-family: electronicFont, serif;
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

.map2 {
  position: absolute;
  width: 5.66rem;
  top: .85rem;
  left: 1.2rem;
  z-index: 3;
  opacity: 0.2;
  animation: myfirst 10s infinite linear;
}
</style>
