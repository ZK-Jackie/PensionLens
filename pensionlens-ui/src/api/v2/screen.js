import request from '@/utils/request'
import {parseBoolean} from "@/utils/string";
import { Message } from 'element-ui';
import axios from "axios";

const isOffline = parseBoolean(process.env.VUE_APP_IS_OFFLINE);
const baseApi = process.env.VUE_APP_BASE_API;

export function getScreenInfo(id) {
  if (!isOffline) {
    return request({
      url: `/screen/${id}`,
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