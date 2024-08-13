<template>
  <el-slider
      class="modifier-slider"
      :id="'modifier-slider-' + id"
      style="width: 100%; margin: 0.1rem"
      v-model="sliderValue"
      v-bind="sliderProps"
      show-stops>
  </el-slider>
</template>

<script>
import {UUID} from "@/utils/string";
import {countTrailingZeros} from "@/utils/number";
import selector from "@/views/settings/selector.vue";

export default {
  name: 'MsliderChart',
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
  watch: {
    options: {
      handler: function (newVal) {
        if (newVal) {
          this.loadChart();
        }
      },
      deep: true
    },
  },
  mounted() {
    this.loadChart();
  },
  methods: {
    loadChart() {
      const that = this;
      let tempArr = [];
      tempArr.push(this.options[0].data[0][1] + 1);
      tempArr.push(this.options[0].data[1][1] - 1);
      this.sliderValue = tempArr;
      this.sliderProps.min = this.options[0].minValue;
      this.sliderProps.max = this.options[0].maxValue;
      this.sliderProps.step = Math.pow(1, countTrailingZeros(that.options[0].numPrecision));
    }
  },
  data() {
    return {
      sliderProps: {
        min: -1,
        max: -1,
        step: 1,
        disabled: false,
        // showInput: true,
        // showInputControls: true,
        // inputSize: 'small',
        showStops: true,
        showTooltip: true,
        // formatTooltip: null,
        range: true,
        // vertical: false,
        // height: '200',
        // label: '',
        // debounce: 300,
        // tooltipClass: '',
        // marks: {
        //   0: '0%',
        //   100: '100%'
        // }
      },
      sliderValue: [2024, 2030],
    }
  }
}
</script>

<style>
.modifier-slider {
  margin: 0.2rem;
}

.el-tooltip__popper.is-dark {
  background-color: whitesmoke;
}

.el-tooltip__popper.is-dark .el-tooltip__content {
  color: white;
}
</style>