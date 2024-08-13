<template>
  <div class="head">
    <!--面包屑对应的位置-->
    <div class="breadStyle">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item v-for="(item, index) in $router.options.routes" :key="index" v-if="!item.meta.hidden">
          <span
              style="color: #fff;font-size: 14px;cursor: pointer"
              :class="{ 'active-breadcrumb': $route.path === item.path }"
              @click="$router.push(item.path)"
          >
            {{ item.meta.miniTitle }}
          </span>
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <h1 class="login-title">{{ title }}</h1>
    <div class="right">
      <span class="time" v-html="formattedTime"></span>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: '智算古稀－养老保险测算大数据平台',
      currentTime: new Date(),
      blink: false
    }
  },
  created() {
    this.getTitle();
  },
  computed: {
    formattedTime() {
      const dt = this.currentTime;
      const y = dt.getFullYear();
      const mt = (dt.getMonth() + 1).toString().padStart(2, '0'); //获取月份
      const day = dt.getDate().toString().padStart(2, '0'); //获取日期
      const h = dt.getHours().toString().padStart(2, '0'); //获取时
      const m = dt.getMinutes().toString().padStart(2, '0'); //获取分
      const s = dt.getSeconds().toString().padStart(2, '0'); //获取秒
      const w = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'][dt.getDay()]; //获取星期
      return y + "年" + mt + "月" + day + "日" + " " + w + " " + h + ":" + m + (this.blink ? ":" : "<span style='opacity: 0;'>:</span>") + s;
    }
  },
  watch: {
    '$route': function (to, from) {
      this.getTitle();
    }
  },
  methods: {
    getTitle() {
      this.title = this.$route.meta.title;
    },
    getBreadcrumb() {
      const pathSegments = this.$route.path.split('/');
      let path = '';
      this.breadcrumbList = pathSegments.map(segment => {
        path += '/' + segment;
        const route = this.$router.options.routes.find(r => r.path === path);
        return route && route.meta && route.meta.miniTitle ? route : null;
      }).filter(item => item !== null);
    },
    refreshClock() {
      setInterval(() => {
        this.currentTime = new Date();
      }, 1000);
      setInterval(() => {
        this.blink = !this.blink;
      }, 700);
    }
  },
  mounted() {
    this.refreshClock();
    this.getTitle();
  }
}
</script>

<style scoped>

.active-breadcrumb {
  font-weight: bold !important;
  color: #d71d1d !important;
}

.breadStyle {
  position: absolute;
  top: 35%;
  left: 3%;
}

.head {
  height: 1.05rem;
  background: url(@/assets/screen/head_bg.png) no-repeat center center;
  background-size: 100% 100%;
  position: relative;
  z-index: 100;
}

.head .login-title {
  color: #fff;
  text-align: center;
  font-size: .4rem;
  line-height: .8rem;
}

.head .right {
  position: absolute;
  right: .3rem;
  top: 0;
  line-height: .75rem;
}

.head .right .time {
  color: rgba(255, 255, 255, .7);
  font-size: .18rem;
  padding-right: .1rem;
}

</style>
