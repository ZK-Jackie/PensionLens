import request from '@/utils/request'

// 查询测算城镇化率默认参数表列表
export function listUrban_rate(query) {
  return request({
    url: '/system/urban_rate/list',
    method: 'get',
    params: query
  })
}

// 查询测算城镇化率默认参数表详细
export function getUrban_rate(planArea) {
  return request({
    url: '/system/urban_rate/' + planArea,
    method: 'get'
  })
}

// 新增测算城镇化率默认参数表
export function addUrban_rate(data) {
  return request({
    url: '/system/urban_rate',
    method: 'post',
    data: data
  })
}

// 修改测算城镇化率默认参数表
export function updateUrban_rate(data) {
  return request({
    url: '/system/urban_rate',
    method: 'put',
    data: data
  })
}

// 删除测算城镇化率默认参数表
export function delUrban_rate(planArea) {
  return request({
    url: '/system/urban_rate/' + planArea,
    method: 'delete'
  })
}
