<script>
import {getPolicyGraph} from "@/api/charts";
export default{
  data(){
    getPolicyGraph().then(res=>{
      return{
        PoliciesRelation: res.data,
      }
    })
  },
  methods:{
     echarts(){
       var that=this;
       // 基于准备好的dom，初始化echarts实例
       var myChart = this.$echarts.init(document.getElementById('container'));
       var option;
       myChart.showLoading();
       var graph = this.PoliciesRelation;//获取js文件中对应的数据信息
       myChart.hideLoading();
         option = {
           tooltip: {},
           legend: [
             {
               data: graph.categories.map(function (a) {
                 return a.name;
               })
             }
           ],
           series: [
             {
               name: 'Les Miserables',
               type: 'graph',
               layout: 'none',
               data: graph.nodes,
               links: graph.links,
               categories: graph.categories,
               roam: true,
               label: {
                 show: true,
                 position: 'right',
                 formatter: '{b}'
               },
               labelLayout: {
                 hideOverlap: true
               },
               scaleLimit: {
                 min: 0.4,
                 max: 2
               },
               lineStyle: {
                 color: 'source',
                 curveness: 0.3
               }
             }
           ]
         };
         myChart.setOption(option);
     }

  },
  mounted() {
    this.$nextTick(() => {
      this.echarts();
    });
  }
}

</script>

<template>
<div id="container" class="size-Policies">

</div>
</template>

<style lang="scss">
#size-Policies{
  width: 100%;
  height: 100%;
}

</style>
