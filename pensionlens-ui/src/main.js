import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// Global modules
import $ from 'jquery'  //jquery
import * as echarts from 'echarts'
import ElementUI from 'element-ui';
import '@/assets/style/global.css'
import 'element-ui/lib/theme-chalk/index.css';
// Global components
import Block from '@/components/block.vue'

import './guard'

Vue.prototype.$echarts = echarts
Vue.prototype.$ = $   //将$(jquery)挂在到vue.prototype身上，让所有的Vue共享这个方法

Vue.use(ElementUI);

Vue.component('Block', Block)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
