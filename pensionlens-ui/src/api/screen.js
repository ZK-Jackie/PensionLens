import request from '@/utils/request'
import { Message } from 'element-ui';
import {parseBoolean} from "@/utils/string";

const isOffline = parseBoolean(process.env.VUE_APP_IS_OFFLINE);
// 登录方法
export function getScreenList() {
  if (!isOffline) {
    return request({
      url: '/screen',
      method: 'get',
      data: data
    })
  } else {
    Message({
      showClose: true,
      message: '网络连接错误，请检查网络',
      type: 'error'
    });
  }
}