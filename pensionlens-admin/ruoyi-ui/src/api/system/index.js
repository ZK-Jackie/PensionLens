import request from '@/utils/request'

// 查询延迟退休测算方案默认参数表列表
export function listIndex(query) {
  return request({
    url: '/system/index/list',
    method: 'get',
    params: query
  })
}

// 查询延迟退休测算方案默认参数表详细
export function getIndex(planArea) {
  return request({
    url: '/system/index/' + planArea,
    method: 'get'
  })
}

// 新增延迟退休测算方案默认参数表
export function addIndex(data) {
  return request({
    url: '/system/index',
    method: 'post',
    data: data
  })
}

// 修改延迟退休测算方案默认参数表
export function updateIndex(data) {
  return request({
    url: '/system/index',
    method: 'put',
    data: data
  })
}

// 删除延迟退休测算方案默认参数表
export function delIndex(planArea) {
  return request({
    url: '/system/index/' + planArea,
    method: 'delete'
  })
}
