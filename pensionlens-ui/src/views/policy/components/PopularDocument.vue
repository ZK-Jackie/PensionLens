<template>
    <div >
      <VueSeamlessScroll :data="listData" :class-option="optionSingleHeight" class="seamless-warp">
        <!--上述代码实现滚动效果，数据由listData提供,后面来设置每个列表的高度-->
        <div class="list">
          <div class="item" v-for="(item,index) in listData" :key="index" @click="click_item(item)">
            <div class="info">
              <div v-if="item.importance==1" class="mood importance">重要</div>
              <div v-else-if="item.importance==2" class="mood normal">一般</div>
              <div v-else class="mood not_importance">不重要</div>
              <div class="source">{{item.source_name}}</div>
              <div class="date">{{item.publish_time}}</div>
              <div class="login-title">{{item.title}}</div>
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
        { importance:1,
          source_name:"中华人民共和国中央人民政府",
          publish_time:"2008-03-28",
          title:"国务院关于完善企业职工基本养老保险制度的决定(国发〔2005〕38号)",
          url:"https://www.gov.cn/zhengce/content/2008-03/28/content_7376.html"},
        { importance: 2,
          source_name: "中华人民共和国中央人民政府",
          publish_time: "2010-10-28",
          title: "中华人民共和国社会保险法",
          url:"https://www.gov.cn/guoqing/2021-10/29/content_5647616.html"},
        { importance: 1,
          source_name: "南昌市人民政府",
          publish_time:"1991-06-25",
          title: "国务院关于企业职工养老保险制度改革的决定（国发［1991]33号）",
          url:"https://www.nc.gov.cn/ncszf/rsjr/199106/1d3f99267afc4adca768099da7f03ffe.html"},
        { importance: 1,
          source_name: "人社通",
          publish_time: "1995-12-31",
          title:"国务院关于深化企业职工养老保险制度改革的通知(国发〔1995〕6号)",
          url:"https://m12333.cn/policy/sbfi.html"},
        { importance: 1,
          source_name: "中华人民共和国中央人民政府",
          publish_time: "2015-01-14",
          title:"国务院关于机关事业单位工作人员养老保险制度改革的决定(国发〔2015〕2号)",
          url:""
        },
        { importance: 2,
          source_name: "中华人民共和国人力资源和社会保障部",
          publish_time: "2019-04-04",
          title:"国务院办公厅印发《降低社会保险费率综合方案》",
          url:"http://epaper.legaldaily.com.cn/fzrb/content/20220301/Articel06003GN.html"
        },
        { importance: 1,
          source_name: "人社通",
          publish_time: "1998-08-06",
          title:"国务院关于实行企业职工基本养老保险省级统筹和行业统筹移交地方管理有关问题的通知(国发〔1998〕28号)",
          url:"https://m12333.cn/policy/piac.html"
        },
        { importance: 2,
          source_name: "中华人民共和国人力资源和社会保障部",
          publish_time: "2018-06-13",
          title:"国务院印发《关于建立企业职工基本养老保险基金中央调剂制度的通知》",
          url:"http://www.mohrss.gov.cn/SYrlzyhshbzb/dongtaixinwen/buneiyaowen/201806/t20180613_295758.html"
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
.seamless-warp {
  position: absolute;
  top:23%;
  height: 3.24rem;
  overflow: hidden;
}
.list{
  padding: 0 .15rem;
}
.item{
  width: 100%;
  height: .55rem;
  line-height: .5rem;
  position: relative;
  display: flex;
  align-items: center;
  .info{
    display: flex;
    .mood{
      font-size: 16px;
      margin-right: .32rem;
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
      font-size: 16px;
      margin-right: .3rem;
    }
    .date{
      color: #03b4f5;
      font-size: 15px;
      margin-right: .3rem;
    }
    .login-title{
      flex: 1;
      color: #fff;
      font-size: 16px;
      overflow: hidden;
      text-overflow: ellipsis;
      white-space: nowrap;
    }
  }
}
.item:hover{
  cursor: pointer;
}

</style>