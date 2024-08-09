<template>
  <div class="main-box" v-if="isLoadable">
    <ul class="clearfix">
      <li>
          <Block height="5.1rem" title="政策关键词词频统计图">
            <div @click="handleClick">
              <PictorialBar/>
            </div>
          </Block>
        <Block height="4.3rem" title="养老基金安全指数">
          <Chart type="gauge" :data="nowData.detailData" :key="'gaugegauge'"/>
        </Block>
      </li>
      <li>
        <div class="bar">
          <div class="barbox">
             <!--下述区域属于显示对应收入的区域-->
            <ul class="clearfix">
              <li class="pulll_left counter" style="font-family: 'DS-DIGIT',serif">{{counter1}}
                <!--嵌套对应的环比的数据-->
                <transition name="fade">
                <div class="icon-color" v-if="showElement">环比
                  <img src="../../assets/screen/icondown.png" alt="icon down" height="12">
                  4.7%
                </div>
                </transition>
              </li>
              <li class="pulll_left counter" style="font-family: 'DS-DIGIT',serif">{{counter2}}
                <transition name="fade">
                  <div class="icon-color" v-if="showElement">环比
                    <img src="../../assets/screen/iconup.png" alt="icon up" height="12">
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
          <Map/>
          <div class="map2"><img src="../../assets/screen/jt.png" alt="icon map"/></div>
        </div>
      </li>

      <li>
        <Block height="4.8 rem" title="舆情资讯动态展示">
          <PublicSentiment/>
        </Block>
        <Block height="4.2rem" title="专业养老保险公司年金业务情况">
          <Annuity_bar @click="handleClick"/>
        </Block>
      </li>
    </ul>
  </div>
</template>

<script>
import PublicSentiment from "@/views/nation/components/PublicSentiment.vue";
import Annuity_bar from "@/views/nation/components/HorizontalBar.vue";
import Guangdong from "@/views/local/components/Guangdong.vue";
import Block from "@/components/block.vue";
import Map from '@/views/nation/components/Map.vue';
import Chart from '@/components/chart.vue';
import PictorialBar  from "@/views/nation/components/PictorialBar.vue";


export default {
  components: {Chart,Map,Block,Guangdong, Annuity_bar, PublicSentiment,PictorialBar},
  data()　{
    return {
      // 当前屏幕是否可以开始加载
      isLoadable: false,
      // 当前屏幕 Id
      nowScreenId: 0,
      // 当前屏幕数据
      totalDetails: [],
      nowData: [],
      counter1: 0,
      counter2: 0,
      maxCounter1: 125811899,//有关最终养老金收入和支出的情况
      maxCounter2: 39124108,//有关最终养老金收入和支出的情况
      showElement: false,
    }
  },
  methods: {
    startCounter() {
      let time = 0;
      setInterval(() => {
        time += 19;
        if (this.counter1 < this.maxCounter1) {
          const increment = time * time; // 使用二次函数来计算增量
          if (this.maxCounter1 - this.counter1 < increment) { // 如果接近最大值
            this.counter1 = this.maxCounter1; // 直接设置为最大值
          } else {
            this.counter1 += increment;
          }
        }
        if(this.counter2 < this.maxCounter2) {
          const increment = time * time; // 使用二次函数来计算增量
          if (this.maxCounter2 - this.counter2 < increment) { // 如果接近最大值
            this.counter2 = this.maxCounter2; // 直接设置为最大值
          } else {
            this.counter2 += increment;
          }
        }
      }, 100) // 注意这里的时间间隔已经改为100毫秒，因为我们现在是以0.1秒为单位增加时间
    },
    handleClick() {
      this.$router.push('/policy')
    },
    load(){
      // 延迟初始化图表，直到可以确定DOM元素已经有了正确的大小
        setTimeout(() => {
          this.showElement = true;
        }, 500);
    },
    reqData(){
      this.$store.dispatch('GetScreenDetail', this.nowScreenId).then(res => {
        this.totalDetails = JSON.parse(JSON.stringify(res));
        this.nowData = this.totalDetails[0]
        this.isLoadable = true;
      }).catch(err => {
        console.error(err)
      });
    },
  },
  mounted() {
    this.reqData();
    this.load();
    this.startCounter();
  }
}
</script>

<style scoped lang="scss">

//.numberStyle{
//  color: #ffeb7b;
//  width: 100%;
//  height:0.5rem;
//  position: absolute;
//  top:0;
//}

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

.icon-color{
  color:#2f89cf;
  font-size: 11px;
  position: absolute;
  top:0;
  right:0;
}

.main-box > ul > li {
  float: left;
  padding: 0 .1rem
}

.main-box > ul > li {
  width: 27%
}

.main-box > ul > li:nth-child(2) {
  width: 46%;
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
  font-family: electronicFont,serif;
  font-weight: bold;
}

.barbox2 li {
  font-size: .19rem;
  color: rgba(255, 255, 255, .7);
  padding-top: .1rem;
}

.map {
  position: relative;
  height: 7.3rem;
  z-index: 9;
}

.map4 {
  width: 200%;
  height: 8rem;
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
  width: 6.93rem;
  z-index: 2;
  top: .35rem;
  left: 1.1rem;
  animation: myfirst2 15s infinite linear;
}

.map2 {
  width: 6.06rem;
  top: .85rem;
  left: 1.60rem;
  z-index: 3;
  opacity: 0.2;
  animation: myfirst 10s infinite linear;
}

.map3 {
  width: 5.70rem;
  top: 1.0rem;
  left: 1.75rem;
  z-index: 1;
}

</style>