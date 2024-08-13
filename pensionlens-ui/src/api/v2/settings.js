import {parseBoolean} from "@/utils/string";
import {Message} from "element-ui";
import request from "@/utils/request";

const isOffline = parseBoolean(process.env.VUE_APP_IS_OFFLINE);

export function getNewPreview(newSettings){
  if (!isOffline) {
    return request({
      url: '/settings/preview',
      method: 'post',
      data: newSettings
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