<script>
import {Bar, Gauge, Linear, Ring, Rose, Error, Mlinear, Mslider, Mradio, Loading, Climb, Rader} from "./charts"
import Radar from "@/components/charts/radar.vue";
import {removeNonLetters, capitalizeFirstLetter, UUID} from "@/utils/string";
import {toOptions} from "@/utils/chart"

const supportedTypes =
    ['bar', 'gauge', 'linear', 'ring', 'rose',
      'mlinear', 'mslider', "mradio", "radar",
      'error', 'climb', "rader"
    ];

export default {
  name: "chart-component",
  props: {
    data: {
      type: Array,
      required: true,
      default: () => {
        return []  // 使用工厂函数返回默认值
      }
    },
    type: {
      type: String,
      required: true,
      default: () => {
        return "error";
      }
    },
    name: {
      type: String,
      required: false,
      default: () => {
        return "chart";
      }
    },
  },
  mounted() {
    this.componentUUID = UUID();
    this.$nextTick(() => {
      this.loadTick = true;
      this.componentData = this.data;
      this.init();
    });
  },
  errorCaptured(err, vm, info) {
    console.warn(err);
    console.error(vm);
    console.log(info);
    this.chartType = 'error';
  },
  methods: {
    init() {
      this.chartType = removeNonLetters(this.type.toLowerCase());
      this.startLoad = true;
    },
  },
  components: {
    Bar, Gauge, Linear, Ring, Rose, Error,
    Mlinear, Mslider, Mradio, Loading, Radar,
    Climb, Rader
  },
  data() {
    return {
      // 等待 Dom 加载完成
      loadTick: false,
      // 当前组件的 UUID
      componentUUID: '',
      // 当前组件的数据
      componentData: [],
      // 当前组件的类型
      chartType: '', /** 1. switching test type */
      // 当前组件可否加载
      startLoad: false,
    }
  },
}
</script>

<template>
  <div v-if="loadTick && startLoad" style="width: 100%; height: 100%;">
      <component :is="chartType" :data="componentData" :key="componentUUID"/>
  </div>
  <div v-else-if="loadTick">
    <component is="Loading" style="width: 100%; height: 100%;"/>
  </div>
</template>
