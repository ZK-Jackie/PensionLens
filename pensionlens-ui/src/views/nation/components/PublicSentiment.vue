<template>
  <div >
      <vue-seamless-scroll :data="listData" :class-option="optionSingleHeight" class="seamless-warp">
        <div class="list">
          <div class="item" v-for="(item,index) in listData" :key="index" @click="click_item(item)">
            <div class="info">
              <div class="content-title">
                <div class="login-title">{{item.title}}</div>
                <span v-if="item.importance===1" class="mood importance">重要</span>
                <span v-else-if="item.importance===2" class="mood normal">一般</span>
                <span v-else class="mood not_importance">不重要</span>
              </div>
              <div class="details">
                <span class="date">{{item.publish_time}}</span>
                <span class="source">{{item.source_name}}</span>
              </div>
            </div>
          </div>
        </div>
      </vue-seamless-scroll>
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
      listData: [
        { importance:3,
          source_name:"微博",
          publish_time:"2023-03-01 10:04:25",
          title:"基本养老保险和医疗保险在缴费模式上的差异性",
          url:"https://weibo.com/2812380383/Mve3GsY6A?refer_flag=1001030103_"},
        { importance: 2,
          source_name: "中华人民共和国",
          publish_time: "2010-10-28 18:03:40",
          title: "中华人民共和国社会保险法",
          url:"https://www.gov.cn/guoqing/2021-10/29/content_5647616.html"},
        { importance: 2,
          source_name: "知乎",
          publish_time: "2022-05-19 12:03:30",
          title: "人口老龄化背景下我国养老保险问题及对策",
          url:"https://www.zhihu.com/market/paid_magazine/1510729911703126016/section/1510730080293011456?origin_label=search"},
        { importance: 1,
          source_name: "微博",
          publish_time:"2024-03-25 10:27:35",
          title: "养老金并轨倒计时意味着什么？",
          url:"https://weibo.com/1642088277/O6BYh0TLT?refer_flag=1001030103_"},
        { importance: 1,
          source_name: "人社通",
          publish_time: "2006-06-29 09:05:40",
          title:"国务院关于深化企业职工养老保险制度改革的通知",
          url:"https://m12333.cn/policy/sbfi.html"
        },
        { importance: 2,
          source_name: "知乎",
          publish_time: "2022-10-21 13:37:30",
          title:"企业职工基本养老保险是什么意思？90%的打工人还不清楚",
          url:"https://zhuanlan.zhihu.com/p/575843975"
        },
      ],
    }
  },
  computed: {
    optionSingleHeight () {
      return {
        singleHeight: 43.8
      }
    }
  },
  methods: {
      click_item(item){
        if(item.url){
          window.open(item.url,'_blank')
        }
      }
  }
}
</script>

<style lang="scss" scoped>
.seamless-warp {
  height: 4.25rem;
  overflow: hidden;
}
.item{
  width: 100%;
  height: .73rem;
  display: flex;
  margin-top: .08rem;
  .info{
    flex-direction: column;
    width: 100%;
    display: flex;
    padding: .05rem 0 .08rem 0;
    border: .05rem solid transparent;
    .content-title{
      width: 100%;
      display: flex;
      align-items: center;
      justify-content: space-between; /* 让子元素左右对齐 */
    }
    .mood{
      margin-right: .05rem;
      color: #43c0ab;
      padding: .05rem .13rem;
      border-radius: .6rem;
      font-size: 12px !important;
      white-space: nowrap;
      background-color: rgba(245, 249, 255, 0.2);
    }
    .importance {
      color: #36bea6;
    }
    .normal {
      color: #ffbc34;
    }
    .not_importance {
      color: #f62d51;
    }
    .source{
      color: #03b4f5;
      font-size: 15px;
      margin-top: .06rem;
    }
    .date{
      color: #03b4f5;
      font-size: 15px;
      margin-top: .06rem;
      margin-right: .3rem;
    }
    .login-title{
      width: calc(100% - .3rem);
      color: #ffffff;
      font-size: 15px;
      overflow: hidden;
      text-overflow: ellipsis;
      white-space: nowrap;
    }
    .details {
      display: flex;
    }
  }
}
.item:hover{
  cursor: pointer;
}
</style>