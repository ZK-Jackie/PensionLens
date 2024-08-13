import request from '@/utils/request'

// 查询大屏空位与大屏数据对照表列表
export function listScreen_detail_data(query) {
  return request({
    url: '/system/screen_detail_data/list',
    method: 'get',
    params: query
  })
}

// 查询大屏空位与大屏数据对照表详细
export function getScreen_detail_data(detailId) {
  return request({
    url: '/system/screen_detail_data/' + detailId,
    method: 'get'
  })
}

// 新增大屏空位与大屏数据对照表
export function addScreen_detail_data(data) {
  return request({
    url: '/system/screen_detail_data',
    method: 'post',
    data: data
  })
}

// 修改大屏空位与大屏数据对照表
export function updateScreen_detail_data(data) {
  return request({
    url: '/system/screen_detail_data',
    method: 'put',
    data: data
  })
}

// 删除大屏空位与大屏数据对照表
export function delScreen_detail_data(detailId) {
  return request({
    url: '/system/screen_detail_data/' + detailId,
    method: 'delete'
  })
}
