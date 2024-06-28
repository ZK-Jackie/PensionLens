import router from './router'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import {getToken} from "@/utils/auth";

NProgress.configure({showSpinner: false})
const whiteList = ['/login', '/register','/home']

let timer;//定时器变量
let list = ['/nation', '/regin', '/policy', '/modify'];
let n = 0;

router.beforeEach((to, from, next) => {
      NProgress.start();
      /*if (getToken()) {
        if(from.fullPath.includes("modify") && to.fullPath.includes("regin")){
          next('gd');
          return;
          NProgress.done()
        }else if((from.fullPath === '/home' && list.includes(to.path) && n === 0)) {

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
      }
      else {
          // 没有token
          if (whiteList.indexOf(to.path) !== -1) {
              // 在免登录白名单，直接进入
              next()
          } else {
              next(`/login?redirect=${encodeURIComponent(to.fullPath)}`)
              NProgress.done()
          }
      }*/
    if(from.fullPath.includes("modify") && to.fullPath.includes("regin")){
        next('gd');
        return;
        NProgress.done()
    }else if((from.fullPath === '/home' && list.includes(to.path) && n === 0)) {

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
    }
);


router.afterEach(() => {
  NProgress.done()
})

