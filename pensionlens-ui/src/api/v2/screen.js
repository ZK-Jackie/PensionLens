import request from '@/utils/request'
import {parseBoolean} from "@/utils/string";
import { Message } from 'element-ui';

const isOffline = parseBoolean(process.env.VUE_APP_IS_OFFLINE);

export function getScreenInfo() {
  if (!isOffline) {
    return request({
      url: '/screen',
      method: 'get',
    })
  } else {
    Message({
      showClose: true,
      message: '当前系统处于离线模式下！',
      type: 'error'
    });
    return Promise.reject('当前系统处于离线模式下！');
  }
}

export function getScreenDetails(screenIds) {
  if (!isOffline) {
    return request({
      url: '/screen/' + screenIds,
      method: 'get',
    })
  } else {
    Message({
      showClose: true,
      message: '当前系统处于离线模式下！',
      type: 'error'
    });
  }
}