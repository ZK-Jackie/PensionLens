<template>
  <div>
    <div class="modifier-top">
      <el-select v-model="selectorValue"
                 @change="selectorChange"
                 :disabled="selectorOptions.length <= 1"
                 placeholder="请选择">
        <el-option
            v-for="item in selectorOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value">
        </el-option>
      </el-select>
      <el-button type="primary"
                 plain
                 @click="reset"
                 style="margin-left: 0.1rem">
        重置
      </el-button>
      <el-button type="success" plain
                 @click="confirm">
        保存
      </el-button>
    </div>
    <Chart class="modifier-mid"
           :type="chartType"
           :detail="chartDetail"
           :key="refreshKey"
           style="height: 1.7rem"/>
  </div>
</template>
<script>
import Chart from "@/components/chart.vue";
import {toDetail} from "@/utils/chart";

export default {
  watch: {
    '$store.getters.tempOption': {
      handler(newVal, oldVal) {
        // deep copy
        let copy = JSON.parse(JSON.stringify(newVal));
        let temp = toDetail(copy);
        if (temp) {
          this.concatDetailById(temp);
        }
      },
      deep: true
    },
    '$store.getters.tempButton': {
      handler(newVal, oldVal) {
        this.activeButton = newVal;
      },
      deep: true
    },
    activeButton() {
      this.refreshKey ++;
      this.loadParam();
    }
  },
  data() {
    return {
      //bak
      paramDetailsBak: [],
      // outside-button
      activeButton: 0,
      // inside-selector
      selectorValue: '',
      selectorOptions: [],
      // chart
      chartDetail: [],
      chartType: '',
      //operation
      confirmDetails: [],
      //refresh
      refreshKey: 0
    };
  },
  methods: {
    async init(){
      try{
        await this.$store.dispatch('GetParamDetails');
        //copy a bak
        this.paramDetailsBak = this.$store.getters.paramDetails.slice();
        // 1. 默认起始选值
        this.selectorValue = 0;
        // 2. 加载数据
        this.loadParam();
      }catch (e) {
        console.log(e);
      }
    },
    loadParam(){
      // 1. 更新选项
      let tempArr = [];
      this.$store.getters.paramDetails[this.activeButton].forEach((item) => {
        tempArr.push({
          value: tempArr.length,
          label: item.chartOption.defaultIndex
        });
      });
      this.selectorOptions = [];
      this.selectorOptions = tempArr.slice();
      // 2. 更新起始图表
      this.chartType = this.$store.getters.paramDetails[this.activeButton][this.selectorValue].displayMode;
      // 3. 更新chart detail数据
      this.chartDetail[0] = this.$store.getters.paramDetails[this.activeButton][this.selectorValue];
    },
    selectorChange() {
      this.chartType = this.$store.getters.paramDetails[this.activeButton][this.selectorValue].displayMode;
      this.chartDetail = [];
      this.chartDetail[0] = this.$store.getters.paramDetails[this.activeButton][this.selectorValue];
    },
    concatDetailById(newDetail){
      // deep copy
      let temp = JSON.parse(JSON.stringify(this.$store.getters.paramDetails));
      temp.forEach((detail) => {
        detail.forEach((item) => {
          if(item.dataId === newDetail.dataId){
            item.chartOption = newDetail;
          }
        });
      });
      this.$store.commit('SET_PARAM_DETAILS', temp);
      console.log(this.$store.getters.paramDetails);
    },
    confirm() {

    },
    reset() {

    }
  },
  mounted() {
    this.init();
  },
  name: "Modifier",
  components: {
    Chart,
  },
}
</script>

<style scoped>
.modifier-top {
  align-items: center;
  margin-bottom: .1rem;
}
</style>
