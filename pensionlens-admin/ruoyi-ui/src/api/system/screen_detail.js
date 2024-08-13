import request from '@/utils/request'

// 查询大屏配置表列表
export function listScreen_detail(query) {
  return request({
    url: '/system/screen_detail/list',
    method: 'get',
    params: query
  })
}

// 查询大屏配置表详细
export function getScreen_detail(detailId) {
  return request({
    url: '/system/screen_detail/' + detailId,
    method: 'get'
  })
}

// 新增大屏配置表
export function addScreen_detail(data) {
  return request({
    url: '/system/screen_detail',
    method: 'post',
    data: data
  })
}

// 修改大屏配置表
export function updateScreen_detail(data) {
  return request({
    url: '/system/screen_detail',
    method: 'put',
    data: data
  })
}

// 删除大屏配置表
export function delScreen_detail(detailId) {
  return request({
    url: '/system/screen_detail/' + detailId,
    method: 'delete'
  })
}
