<template>
  <div>
    <el-radio-group v-model="pick" class="chart-radio-group">
      <el-radio v-for="(item, index) in radioOption"
                :label="index"
                :key="index"
                border>{{item}}</el-radio>
    </el-radio-group>
  </div>


</template>

<script>

import selector from "@/views/settings/selector.vue";
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
    data: {
      type: Array,
      required: true
    },
  },
  methods:{
    loadChart(){
      this.radioOption = this.data[0].data[0];
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
.chart-radio-group{
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: .5rem;
}
</style>