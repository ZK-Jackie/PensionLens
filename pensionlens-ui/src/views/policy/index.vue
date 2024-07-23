<template>
  <div class="main-box">
    <ul class="clearfix">
      <li>
        <Block title="养老政策知识图谱" >
<!--          <KnowledgeGraph />-->

          <div style="background-color: rgb(0,0,0,0); height: 8.7rem">
            <Graph />
<!--            <img src="@/assets/policyGraph.svg" alt="养老保险政策知识图谱"/>-->
          </div>
        </Block>
      </li>

      <li>
        <Block title="政策词云热点图" height="4.725rem">
          <div class="image-container">
            <WorldCloud />
          </div>
        </Block>

        <div class="all-box" style="height: 4.725rem">
          <div class="all-title">热门政策报告</div>
<!--          <div class="boxStyle">-->
<!--            <el-button icon="el-icon-search" circle size="small" @click="showSearchInput = !showSearchInput"></el-button>-->
<!--            <el-input v-if="showSearchInput" ref="searchInput" class="search-input" placeholder="请输入感兴趣的内容"-->
<!--                      prefix-icon="el-icon-search" v-model="input" ></el-input>-->
<!--          </div>-->
          <SearchBox class="SearchBoxStyle"/>
          <PopularDocument/>
          <div class="all-box-foot"></div>
        </div>
      </li>

    </ul>
  </div>
</template>

<script>
import PopularDocument from "@/views/PoliciesInfo/components/PopularDocument.vue";
import Block from "@/components/block.vue";
import WorldCloud  from "@/views/PoliciesInfo/components/WorldCloud.vue";
import SearchBox  from "@/views/PoliciesInfo/components/SearchBox.vue";
import KnowledgeGraph  from "@/views/PoliciesInfo/components/Knowledge Graph.vue";
import Graph from "@/components/charts/graph.vue";

export default {
  components:{
    PopularDocument,Block,WorldCloud,SearchBox,KnowledgeGraph,Graph
  },
  data(){
    return{
      showSearchInput:false,
      input:""
    }
  },
  methods: {
    // echarts_1() {
    //   var that = this;
    //   // 基于准备好的dom，初始化echarts实例
    //   var myChart = echarts.init(document.getElementById('echart1'));
    //
    //   var option = {
    //     //  backgroundColor: '#00265f',
    //     tooltip: {
    //       trigger: 'axis',
    //       axisPointer: {
    //         type: 'shadow'
    //       }
    //     },
    //     grid: {
    //       left: '0%',
    //       top: '10px',
    //       right: '0%',
    //       bottom: '4%',
    //       containLabel: true
    //     },
    //     xAxis: [{
    //       type: 'category',
    //       data: ['商超门店', '教育培训', '房地产', '生活服务', '汽车销售', '旅游酒店', '五金建材'],
    //       axisLine: {
    //         show: true,
    //         lineStyle: {
    //           color: "rgba(255,255,255,.1)",
    //           width: 1,
    //           type: "solid"
    //         },
    //       },
    //
    //       axisTick: {
    //         show: false,
    //       },
    //       axisLabel: {
    //         interval: 0,
    //         // rotate:50,
    //         show: true,
    //         splitNumber: 15,
    //         textStyle: {
    //           color: "rgba(255,255,255,.6)",
    //           fontSize: '12',
    //         },
    //       },
    //     }],
    //     yAxis: [{
    //       type: 'value',
    //       axisLabel: {
    //         //formatter: '{value} %'
    //         show: true,
    //         textStyle: {
    //           color: "rgba(255,255,255,.6)",
    //           fontSize: '12',
    //         },
    //       },
    //       axisTick: {
    //         show: false,
    //       },
    //       axisLine: {
    //         show: true,
    //         lineStyle: {
    //           color: "rgba(255,255,255,.1	)",
    //           width: 1,
    //           type: "solid"
    //         },
    //       },
    //       splitLine: {
    //         lineStyle: {
    //           color: "rgba(255,255,255,.1)",
    //         }
    //       }
    //     }],
    //     series: [
    //       {
    //         type: 'bar',
    //         data: [200, 300, 300, 900, 1500, 1200, 600],
    //         barWidth: '35%', //柱子宽度
    //         // barGap: 1, //柱子之间间距
    //         itemStyle: {
    //           normal: {
    //             color: '#2f89cf',
    //             opacity: 1,
    //             barBorderRadius: 5,
    //           }
    //         }
    //       }
    //
    //     ]
    //   };
    //
    //   // 使用刚指定的配置项和数据显示图表。
    //   myChart.setOption(option);
    //   window.addEventListener("resize", function () {
    //     myChart.resize();
    //   });
    // },
    // load(){
    //   // 延迟初始化图表，直到可以确定DOM元素已经有了正确的大小
    //   setTimeout(()=>{
    //     this.echarts_1()
    //   },2000)
    // },
  },
  mounted() {
    // this.load();
  }
}
</script>

<style scoped>

.SearchBoxStyle{
  position: absolute;
  z-index: 999;
  top: 11%;
  left:28%;
}

.boxStyle{
  height:0.3rem
}

.main-box > ul {
}

.main-box > ul > li {
  float: left;
  padding: 0 .1rem
}

.main-box > ul > li:first-child {
  width: 35%;
}

.main-box > ul > li:nth-child(2) {
  width: 65%;
}

 .image-container {
   width: 100%;
   height: 96%;
 }

.search-input {
  position: absolute;
  top: 0;
  left: 10%;
  transform: translate(-50%, -50%);
  z-index: 1000;
}

</style>