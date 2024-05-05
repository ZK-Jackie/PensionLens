<script>
import {Bar, Gauge, Linear, Ring, Rose, Error, Mlinear, Mslider, Mradio, Loading} from "./charts"
import Radar from "@/components/charts/radar.vue";
import {removeNonLetters, capitalizeFirstLetter} from "@/utils/string";
import {toOptions} from "@/utils/chart"

export default {
  name: "chart-component",
  props: {
    /**
     * The data of the chart, need an array with JSON element.
     * In dev mode, detail is not required.
     */
    detail: {
      type: Array,
      required: true,
      default: function() {
        return []  // 使用工厂函数返回默认值
      }
    },
    /**
     * the type of the chart,
     * chosen from ['bar', 'gauge', 'line', 'ring', 'rose', 'mlinear', 'mslider']
     */
    type: {
      type: String,
      required: true,
      default: "error"
    },
    /**
     * the name of the chart,
     * will be the class name and vue name of the chart,
     * default is uuid
     */
    name: {
      type: String,
      required: false,
      default: ''
    },
  },
  computed: {
    isPropsLoaded() {
      if (typeof this.detail === 'undefined' || this.detail.length === 0 && this.checkRefresh === false) {
        return false;
      } else {
        this.init();
        return true;
      }
    },
  },
  mounted() {

  },
  errorCaptured(err, vm, info) {
    console.log(err);
    console.log(vm);
    console.log(info);
    this.chartType = 'Error';
  },
  methods: {
    init() {
      this.init1();
      this.init2();
    },
    init1() {
      // step1: get and formatter the type of the chart
      const chosenType = removeNonLetters(this.type.toLowerCase());
      if (['bar', 'gauge', 'linear', 'ring', 'rose', 'mlinear', 'mslider', "mradio","radar"].includes(chosenType)) {
        this.chartType = capitalizeFirstLetter(chosenType);
      } else {
        this.chartType = 'Error';
      }
    },
    init2() {
      // step2: transform the data to the option of the chart
      this.chartOption = toOptions(this.detail);
    }
  },
  components: {
    Bar, Gauge, Linear, Ring, Rose, Error, Mlinear, Mslider, Mradio, Loading, Radar
  },
  data() {
    return {
      checkRefresh: false,
      chartData: '',
      chartOption: [],
      chartType: '',     /** 1. switching test type */
      countdown: 0,
      intervalId: 0,
    }
  },
}
</script>

<template>
  <div v-if="isPropsLoaded" style="width: 100%; height: 100%;">
    <div style="width: 100%; height: 100%;">
      <component :is="chartType" :options="chartOption" />
    </div>
  </div>
<!--  <div v-else-if="chartType === 'Error'">-->
<!--    <component :is="'Error'" :options="chartOption" style="width: 100%; height: 100%;"/>-->
<!--  </div>-->
    <div v-else>
      <component :is="'Loading'" style="width: 100%; height: 100%;"/>
    </div>
</template>
