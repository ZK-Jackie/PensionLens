import router from './router'
import store from './store'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'

NProgress.configure({showSpinner: false})

let timer;//定时器变量
let list = ['/nation', '/regin', '/policy', '/modify'];
let n = 0;

router.beforeEach((to, from, next) => {
  NProgress.start();
  if(from.fullPath.includes("modify") && to.fullPath.includes("regin")){
    next('gd');
    return;
    NProgress.done()
  }else if(from.fullPath === '/home' && list.includes(to.path) && n === 0) {

    next('/animation');

    // 设置定时器，2.5秒后跳转
    timer = setTimeout(() => {
      router.push(to.fullPath);
    }, 2500);
    return;
  } else {
    next();
    return;
    NProgress.done()
  }
});


router.afterEach(() => {
  NProgress.done()
})

