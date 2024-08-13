import request from '@/utils/request'

// 查询大屏数据颜色设置列表
export function listScreen_data_color(query) {
  return request({
    url: '/system/screen_data_color/list',
    method: 'get',
    params: query
  })
}

// 查询大屏数据颜色设置详细
export function getScreen_data_color(dataColorId) {
  return request({
    url: '/system/screen_data_color/' + dataColorId,
    method: 'get'
  })
}

// 新增大屏数据颜色设置
export function addScreen_data_color(data) {
  return request({
    url: '/system/screen_data_color',
    method: 'post',
    data: data
  })
}

// 修改大屏数据颜色设置
export function updateScreen_data_color(data) {
  return request({
    url: '/system/screen_data_color',
    method: 'put',
    data: data
  })
}

// 删除大屏数据颜色设置
export function delScreen_data_color(dataColorId) {
  return request({
    url: '/system/screen_data_color/' + dataColorId,
    method: 'delete'
  })
}
