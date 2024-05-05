<template>
  <div class="plan-view">
    <div class="scroll-selector">
      <ul class="scroll-box"
          ref="scrollBox"
          @mouseenter="addScrollListener"
          @mouseleave="removeScrollListener"
      >
        <li v-for="(planItem, index) in plans"
            :key="index"
        >
          {{ planItem }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
let lastChosenPlan = null;
export default {
  props: {
    chosenPlan: {
      type: Number,
      default: 0
    }
  },
  watch: {
    chosen(newVal, oldVal) {
      if (newVal !== oldVal) {
        this.chosenPlan = newVal;
        // alert('选中第' + this.chosenPlan + '个元素');
      }
    }
  },
  data() {
    return {
      chosen: 0,
      plans: ["方案1", "方案2", "方案3", "方案4", "方案5", "方案6", "方案7", "方案8", "方案9", "方案10", "方案11", "方案12"],
    }
  },
  methods: {
    initPlan() {
      // 初始化方案
      this.plans.splice(0, 0, 'New Plan');
    },
    handleMouseScroll() {
      const that = this;
      let newScrollTop = this.$refs.scrollBox.scrollTop;
      let itemHeight = window.getComputedStyle(this.$refs.scrollBox.querySelector('li')).height;
      itemHeight = parseFloat(itemHeight);

      let tempChosenPlan = Math.floor(newScrollTop / itemHeight) + 1;
      if (tempChosenPlan !== that.chosen) {
        that.chosen = tempChosenPlan;
        console.log('选中第' + that.chosen + '个元素');
      }
    },
    addScrollListener() {
      this.$refs.scrollBox.addEventListener('scroll', this.handleMouseScroll);
      this.$refs.scrollBox.addEventListener('touchmove', this.handleMouseScroll, {passive: false})
    },
    removeScrollListener() {
      this.$refs.scrollBox.removeEventListener('scroll', this.handleMouseScroll);
      this.$refs.scrollBox.removeEventListener('touchmove', this.handleMouseScroll)
    }
  },
  mounted() {
    this.initPlan();
  }
}
</script>

<style scoped lang="scss">
.plan-view {
  display: flex;
  justify-content: center;
  align-items: center;
}

.scroll-box {
  list-style: none;
  width: 1.4rem; /* 25rem * 0.25 */
  height: 0.75rem; /* 18.75rem * 0.25 */
  overflow: scroll;
  scroll-snap-type: y mandatory;
}

.scroll-box li {
  width: 100%;
  height: 0.75rem; /* 3.75rem * 0.25 */
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: bold;
  font-size: 0.2rem; /* 0.075rem * 0.25 */
  color: #fff;
  scroll-snap-align: start;
}

.scroll-box li:last-child {
  margin-bottom: 1.5rem; /* 7.5rem * 0.25 */
}

.scroll-selector {
  width: 1.4rem; /* 25rem * 0.25 */
  height: 0.75rem; /* 18.75rem * 0.25 */
  position: relative;
  background: linear-gradient(to bottom, rgba(117, 107, 128, 0.3) 0%, rgba(117, 107, 128, 0) 25%, rgba(117, 107, 128, 0) 75%, rgba(117, 107, 128, .3) 100%);
  box-shadow: inset 0px 0px 0.15rem rgba(0, 0, 0, .2); /* 0.75rem * 0.25 */
  border-radius: 0.15rem; /* 0.75rem * 0.25 */
}

.scroll-selector::after {
  // content: '';
  position: absolute;
  top: 0.375rem; /* 7.5rem * 0.25 / 2 */
  width: 100%;
  height: 0.75rem; /* 3.75rem * 0.25 */
  background: linear-gradient(to bottom, rgba(117, 107, 128, 0.1) 0%, rgba(117, 107, 128, .2) 50%, rgba(117, 107, 128, .25) 50%, rgba(117, 107, 128, .1) 100%);
  pointer-events: none;
  box-shadow: 0 0.05rem 0.15rem rgba(0, 0, 0, .12); /* 0.25rem * 0.25, 0.75rem * 0.25 */
  border-top: 0.0125rem solid rgba(0, 0, 0, .12); /* 0.0625rem * 0.25 */
  border-bottom: 0.0125rem solid rgba(0, 0, 0, .12); /* 0.0625rem * 0.25 */
}

::-webkit-scrollbar {
  display: none;
}
</style>