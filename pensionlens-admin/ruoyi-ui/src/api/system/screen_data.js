import request from '@/utils/request'

// 查询大屏数据定位列表
export function listScreen_data(query) {
  return request({
    url: '/system/screen_data/list',
    method: 'get',
    params: query
  })
}

// 查询大屏数据定位详细
export function getScreen_data(dataId) {
  return request({
    url: '/system/screen_data/' + dataId,
    method: 'get'
  })
}

// 新增大屏数据定位
export function addScreen_data(data) {
  return request({
    url: '/system/screen_data',
    method: 'post',
    data: data
  })
}

// 修改大屏数据定位
export function updateScreen_data(data) {
  return request({
    url: '/system/screen_data',
    method: 'put',
    data: data
  })
}

// 删除大屏数据定位
export function delScreen_data(dataId) {
  return request({
    url: '/system/screen_data/' + dataId,
    method: 'delete'
  })
}
