<template>
  <div>
    <el-radio-group v-model="pick">
      <el-radio v-for="(item, index) in radioOption"
                :label="index"
                :key="index"
                border>{{item}}</el-radio>
    </el-radio-group>
  </div>


</template>

<script>

import selector from "@/views/ParamSetting/selector.vue";
import {UUID} from "@/utils/string";

export default {
  name: 'MradioChart',
  computed: {
    selector() {
      return selector
    }
  },
  props: {
    id: {
      type: String,
      default: () => UUID()
    },
    options: {
      type: Array,
      required: true
    },
  },
  methods:{
    loadChart(){
      this.radioOption = this.options[0].xAxisTags.slice();
      this.radioOption.forEach((index) => {
        this.radioPick.push(index)
      })
    }
  },
  data(){
    return{
      radioOption:[],
      radioPick: [],
      pick: -1,
    }
  },
  mounted() {
    this.loadChart();
  }
}
</script>

<style>
.el-radio__label {
  color: #dcdbdb; /* 你想要的颜色 */
}
</style>