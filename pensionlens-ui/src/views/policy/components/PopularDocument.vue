<template>
    <div >
      <VueSeamlessScroll :data="listData" :class-option="optionSingleHeight" class="policy-seamless-warp">
        <!--上述代码实现滚动效果，数据由listData提供,后面来设置每个列表的高度-->
        <div class="policy-list">
          <div class="policy-item" v-for="(item,index) in listData" :key="index" @click="click_item(item)">
            <div class="policy-info">
              <div v-if="item.importance==1" class="policy-mood policy-importance">重要</div>
              <div v-else-if="item.importance==2" class="policy-mood policy-normal">一般</div>
              <div v-else class="policy-mood policy-not_importance">不重要</div>
              <div class="policy-source">{{item.source_name}}</div>
              <div class="policy-date">{{item.publish_time}}</div>
              <div class="policy-login-title">{{item.title}}</div>
            </div>
          </div>
        </div>
      </VueSeamlessScroll>
    </div>
</template>

<script>

import VueSeamlessScroll from 'vue-seamless-scroll';

export default {
  components:{
    VueSeamlessScroll
  },
  data() {
    return{
      //先写死，直接用JSON格式提供对应的数据，后期再写活一点
      listData: [
        { importance: 1,
          source_name: "新华社",
          publish_time: "2024-02-12",
          title: "《中央财政加大对基本养老保险补助力度》",
          url: "https://www.gov.cn/zhengce/jiedu/tujie/202402/content_6931393.htm"},
        { importance: 2,
          source_name: "央视网",
          publish_time: "2024-6-18",
          title: "《利好1.4亿左右退休人员！2024年基本养老金再涨3%》",
          url: "https://news.cctv.com/2024/06/18/ARTIITovdOABKbCTInrM8e1P240618.shtml"},
        { importance: 1,
          source_name: "中国政府网",
          publish_time: "2022-2-25",
          title: "《企业职工基本养老保险全国统筹1月起启动实施 养老金及时足额发放有保障》",
          url: "https://www.gov.cn/xinwen/2022-02/25/content_5675550.htm"},
        { importance: 1,
          source_name: "新华网",
          publish_time: "2024-5-30",
          title: "《我国建成世界最大养老保险体系 覆盖10.7亿人》",
          url: "http://www.news.cn/politics/20240530/4ed6f22138aa457b967576ec938d7caf/c.html"
        },
        { importance: 1,
          source_name: "新华网",
          publish_time: "2024-07-09",
          title:"城心养老2.0发布 第三届中国保险养老融合与发展论坛举行",
          url:"http://www.news.cn/money/20240709/44d47b5a0c7b410ca1e1ba7a41e2df46/c.html"
        },
        { importance: 2,
          source_name: "新华网",
          publish_time: "2024-07-02",
          title:"新华养老保险全面开启2024年“7.8全国保险公众宣传日活动”",
          url:"http://www.news.cn/money/20240702/9cc95f9c231f4752b030bdc80dba4771/c.html"
        },
        { importance: 1,
          source_name: "国务院办公厅",
          publish_time: "2022-04-21",
          title:"国务院办公厅关于推动个人养老金发展的意见  国办发〔2022〕7号",
          url:"https://www.gov.cn/zhengce/content/2022-04/21/content_5686402.htm"
        }
      ],
    }
  },
  computed: {
    optionSingleHeight () {
      return {
        singleHeight: 40
      }
    }
  },
  methods:{
    click_item(item){
      if(item.url){
        window.open(item.url,'_blank')
      }
    },
  }
}
</script>

<style lang="scss" scoped>
.policy-seamless-warp {
  position: absolute;
  top:23%;
  height: 3.24rem;
  overflow: hidden;
}
.policy-list{
  padding: 0 .15rem;
}
.policy-item{
  width: 100%;
  height: .55rem;
  line-height: .5rem;
  position: relative;
  display: flex;
  align-items: center;
  .policy-info{
    display: flex;
    .policy-mood{
      font-size: 16px;
      margin-right: .32rem;
    }
    .policy-importance {
      color: #36bea6;
    }
    .policy-normal {
      color: #ffbc34;
    }
    .policy-not_importance {
      color: #f62d51;
    }
    .policy-source{
      color: #03b4f5;
      font-size: 16px;
      margin-right: .3rem;
    }
    .policy-date{
      color: #03b4f5;
      font-size: 15px;
      margin-right: .3rem;
    }
    .policy-login-title{
      flex: 1;
      color: #fff;
      font-size: 16px;
      overflow: hidden;
      text-overflow: ellipsis;
      white-space: nowrap;
    }
  }
}
.policy-item:hover{
  cursor: pointer;
}

</style>
