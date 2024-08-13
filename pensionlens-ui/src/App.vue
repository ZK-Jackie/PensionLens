<template>
  <div id="app">
    <Head v-if="showHeadAndBackground"/>
    <Background class="background" v-show="showHeadAndBackground"/>
    <transition name="fade-transform" mode="out-in">
      <router-view class="main-box" :key="$route.fullPath"/>
    </transition>
  </div>
</template>

<script>
import {Background, Head} from "@/layout";


export default {
  name: 'App',
  components: {
    Background,
    Head,
  },
  data() {
    return {
      showHeadAndBackground: false,
    }
  },
  watch: {
    '$route': function(to, from) {
      this.showHeadAndBackground = to.meta.showNav;
    }
  },
  created() {
    this.showHeadAndBackground = this.$route.meta.showNav;
  },
  methods: {
    resizeFont() {
      let width = window.innerWidth;
      document.documentElement.style.fontSize = `${width / 20}px`;
    }
  },
  mounted() {
    this.resizeFont();
    window.addEventListener('resize', this.resizeFont);
  },
  beforeDestroy() {
    window.removeEventListener('resize', this.resizeFont);
  },
}
</script>

<style>
.main-box {
  padding: .1rem .1rem 0 .1rem;
}

.background {
  opacity: 0.2;
  position: absolute;
  width: 100%;
  left: 0;
  top: 0;
  height: 99%;
  z-index: 1;
}

.fade-transform-enter-active, .fade-transform-leave-active {
  transition: opacity .5s;
}
.fade-transform-enter, .fade-transform-leave-to {
  opacity: 0;
}

/*chrome滚动条样式*/
::-webkit-scrollbar {
  width: 5px;
  height: 5px;
  position: absolute
}

::-webkit-scrollbar-thumb {
  background-color: #5bc0de
}

::-webkit-scrollbar-track {
  background-color: #ddd
}
</style>
