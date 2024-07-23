<template>
  <div class="main-box">
    <ul class="clearfix">
      <li>
        <Block title="养老政策知识图谱" >
          <div style="background-color: rgb(0,0,0,0); height: 8.7rem">
            <Graph />
          </div>
        </Block>
      </li>

      <li>
        <Block title="政策词云热点图" height="4.725rem">
          <div class="image-container">
            <WordCloud />
          </div>
        </Block>
        <div class="all-box" style="height: 4.725rem">
          <div class="all-title">热门政策报告</div>
          <SearchBox class="search-box"/>
          <PopularDocument/>
          <div class="all-box-foot"></div>
        </div>
      </li>

    </ul>
  </div>
</template>

<script>
import Block from "@/components/block.vue";
import PopularDocument from "@/views/policy/components/PopularDocument.vue";
import WordCloud  from "@/views/policy/components/WordCloud.vue";
import SearchBox  from "@/views/policy/components/SearchBox.vue";
import KnowledgeGraph  from "@/views/policy/components/KnowledgeGraph.vue";
import Graph from "@/components/charts/graph.vue";

export default {
  components:{
    PopularDocument,Block,WordCloud,SearchBox,KnowledgeGraph,Graph
  },
  data(){
    return{
      showSearchInput:false,
      input:""
    }
  },
  methods: {},
  mounted() {}
}
</script>

<style scoped lang="scss">

.search-box{
  position: absolute;
  z-index: 999;
  top: 11%;
  left:28%;
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

</style>