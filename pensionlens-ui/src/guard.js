import router from './router'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import {getToken} from "@/utils/auth";
import {parseBoolean} from "@/utils/string";

const isLoginSystemOpen = parseBoolean(process.env.LOGIN_SYSTEM_OPEN);

NProgress.configure({showSpinner: false})
const whiteList = ['/login', '/register', '/home']

// 动画效果
let isAnimationOpen = true; // 动画效果开关
const animationList = ['/nation', '/regin', '/policy', '/modify'];


router.beforeEach((to, from, next) => {
    NProgress.start();
    if (!isLoginSystemOpen || getToken()) {
      if ((from.fullPath === '/home' && isAnimationOpen && animationList.includes(to.path))) {
        // 去看动画
        next('/animation');
        // 设置定时器，2.5秒后跳转
        setTimeout(() => {
          // 转移，消除编译器警告
          router.push(to.fullPath).then(_ => {
          });
        }, 2500);
      } else {
        next();
      }
    } else {
      // 没有token
      if (whiteList.indexOf(to.path) !== -1) {
        // 在免登录白名单，直接进入
        next()
      } else {
        next(`/login?redirect=${encodeURIComponent(to.fullPath)}`)
      }
    }
    NProgress.done()
  }
);


router.afterEach(() => {
  NProgress.done()
})

