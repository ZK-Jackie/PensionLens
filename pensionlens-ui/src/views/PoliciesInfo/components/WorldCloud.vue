<template>
  <div id="container"></div>
</template>

<script>
import anychart from 'anychart';
import {getPensionWordFreq} from "@/api/charts";

export default{
  data(){
    return {
      tagwords: [],
    };
  },
  created() {
    getPensionWordFreq().then(response => {
      this.tagwords = response.data;
    });
  },
  methods:{
    drawChart(){
      var chart = anychart.tagCloud(this.tagwords);
      chart.container("container");
      chart.normal().fontWeight(600);
      chart.background().fill("rgb(0,0,0,0)");
      chart.draw();
      setTimeout(function () {
        $('.anychart-credits').remove();
      }, 100);
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.drawChart();
    });
  }
}
</script>

<style scoped>
#container{
  padding-top: 0rem;
  width: 100%;
  height: 4.1rem;
}
</style>
