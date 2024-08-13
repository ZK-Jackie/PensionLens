import request from '@/utils/request'

// 查询大屏颜色设置列表
export function listScreen_color(query) {
  return request({
    url: '/system/screen_color/list',
    method: 'get',
    params: query
  })
}

// 查询大屏颜色设置详细
export function getScreen_color(dataColorId) {
  return request({
    url: '/system/screen_color/' + dataColorId,
    method: 'get'
  })
}

// 新增大屏颜色设置
export function addScreen_color(data) {
  return request({
    url: '/system/screen_color',
    method: 'post',
    data: data
  })
}

// 修改大屏颜色设置
export function updateScreen_color(data) {
  return request({
    url: '/system/screen_color',
    method: 'put',
    data: data
  })
}

// 删除大屏颜色设置
export function delScreen_color(dataColorId) {
  return request({
    url: '/system/screen_color/' + dataColorId,
    method: 'delete'
  })
}
