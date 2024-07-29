<template>
  <div class="button-table">
    <ul v-if="isLoadable">
      <li v-for="(buttonItem, index) in buttonList"
          :key="index"
          :class="activeButtonIndex === index ? 'button-active' : 'button-non-active'"
          @click="handleButtonClick(index)"
          ref="buttons"
      >
        <span class="button-word">{{ buttonItem }}</span>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "settings-param-select",
  props: {
    buttonList: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      // 当前页面是否可被加载
      isLoadable: false,
      activeButtonIndex: -1,
    }
  },
  methods: {
   load(){
     // 等待页面完全渲染完成
     setTimeout(() => {
       this.$set(this, 'activeButtonIndex', 0);
       this.isLoadable = true;
     }, 100)
   },
    handleButtonClick(index){
      this.activeButtonIndex = index;
      this.$emit('select', index);
    }
  },
  mounted() {
    this.load();
  }
}
</script>

<style scoped lang="scss">
.button-table {
  display: flex;
  justify-content: center;
  align-items: center;
}

.button-table > ul {
  position: relative;
}

.button-table > ul > li {
  position: relative;

  display: inline-block;
  width: 1.4rem;
  text-align: center;
  height: 0.9rem;
  line-height: 0.9rem;
  margin-top: 0.18rem;
  box-sizing: border-box;

  border-radius: 0.06rem;
}

.button-active {
  margin: .2rem .16rem;
  border-bottom: .08rem solid #4b8df8;
  box-shadow: -0.1rem 0rem 0.15rem #034c6a inset,
  0rem -0.1rem 0.15rem #034c6a inset,
  0.1rem 0rem 0.15rem #034c6a inset,
  0rem 0.1rem 0.15rem #034c6a inset;

  box-sizing: border-box;
}

//.underline {
//  position: absolute;
//
//  height: 0.06rem;
//  width: 1.4rem;
//  background-color: #4b8df8;
//  transition: transform 0.3s ease;
//}

.button-non-active {
  margin: .2rem .16rem;

  box-shadow: -0.2rem 0rem 0.3rem #034c6a inset,
  0rem -0.2rem 0.3rem #034c6a inset,
  0.2rem 0rem 0.3rem #034c6a inset,
  0rem 0.2rem 0.3rem #034c6a inset;

  box-sizing: border-box;
}

//.button-active, .button-non-active {
//  /* 其他样式保持不变 */
//  transition: transform 0.3s cubic-bezier(0.68, -0.55, 0.27, 1.55), background-color 0.3s ease, color 0.3s ease;
//}

.button-word {
  font-size: .18rem;
  color: #fff;
  text-align: center;
  line-height: .5rem;
}

</style>