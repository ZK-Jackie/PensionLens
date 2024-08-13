import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/home',// 设置默认重定向到/home
    meta:{
      hidden: true,
      reload: false,
      showNav: true,
    }
  },
  {
    path: '/nation',
    name: 'nation',
    component: () => import('@/views/nation/index.vue'),
    meta: {
      title: '智算古稀——养老保险测算可视化平台',
      miniTitle: '全国概况',
      hidden: false,
      reload: false,
      showNav: true,
    }
  },
  {
    path: '/policy',
    name: 'policy',
    component: () => import('@/views/policy/index.vue'),
    meta: {
      title: '养老政策信息',
      miniTitle: '政策资讯',
      hidden: false,
      reload: false,
      showNav: true,
    }
  },
  {
    path: '/regin',
    name: 'regin',
    component: () => import('@/views/local/index.vue'),
    meta: {
      title: '广东省区域大屏信息',
      miniTitle: '区域信息',
      hidden: false,
      reload: false,
      showNav: true,
    }
  },
  {
    path: '/modify',
    name: 'modify',
    component: () => import('@/views/settings/index.vue'),
    meta: {
      title: '养老测算',
      miniTitle: '参数调配',
      hidden: false,
      reload: false,
      showNav: true,
    }
  },
  {
    path: '/gd',
    name: 'gd',
    component: () => import('@/views/local/index2.vue'),
    meta: {
      title: '广东省区域大屏信息',
      miniTitle: '区域信息',
      hidden: true,
      reload: false,
      showNav: true,
    }
  },
  {
    path: '/test',
    name: 'test',
    component: () => import('@/components/charts/graph.vue'),
    meta: {
      title: '测试专用',
      miniTitle: '测试',
      hidden: true,
      reload: false,
      showNav: true,
    }
  },
  {
    path: '/home',
    name: 'home',
    component: () => import('@/views/index.vue'),
    meta: {
      hidden: true,
      reload: false,
      showNav: false,
    }
  },

  {
    path: '/animation',
    name: 'animation',
    component: () => import('@/views/animation/index.vue'),
    meta: {
      hidden: true,
      reload: false,
      showNav: false,
    }
  },

  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/auth/login/index.vue'),
    meta: {
      hidden: true,
      reload: false,
      showNav: false,
    }
  },

  {
    path: '/register',
    name: 'register',
    component: () => import('@/views/auth/register/index.vue'),
    meta: {
      hidden: true,
      reload: false,
      showNav: false,
    }
  },
]

const router = new VueRouter({
  routes,
  mode: 'history',
  base: process.env.VUE_APP_BASE_URL,
})

export default router
