<script>
import {UUID} from "@/utils/string";

export default {
  name: 'LoadingChart',
  props: {
    id: {
      type: String,
      required: false,
      default: () => {
        return UUID();
      }
    }
  },
  methods:{
    init() {
      const chart = this.$echarts.init(document.querySelector('.loading-' + this.id));
      const option = {
        graphic: {
          elements: [
            {
              type: 'text',
              left: 'center',
              top: 'center',
              style: {
                text: 'Intelligent Calculation',
                fontSize: 80,
                fontWeight: 'bold',
                lineDash: [0, 200],
                lineDashOffset: 0,
                fill: 'transparent',
                stroke: '#cdcdcd',
                lineWidth: 1
              },
              keyframeAnimation: {
                duration: 2500,
                loop: true,
                keyframes: [
                  {
                    percent: 0.7,
                    style: {
                      fill: 'transparent',
                      lineDashOffset: 200,
                      lineDash: [200, 0]
                    }
                  },
                  {
                    // Stop for a while.
                    percent: 0.8,
                    style: {
                      fill: 'transparent'
                    }
                  },
                  {
                    percent: 1,
                    style: {
                      fill: 'black'
                    }
                  }
                ]
              }
            }
          ]
        }
      };
      chart && chart.setOption(option);
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.init();
    });
  },
}
</script>

<template>
  <div style="height: 100%; width: 100%">
    <div :class="'loading-'+ id" style="height: 100%; width: 100%"></div>
  </div>
</template>