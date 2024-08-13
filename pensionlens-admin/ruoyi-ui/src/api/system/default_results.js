import request from '@/utils/request'

// 查询测算结果默认表列表
export function listDefault_results(query) {
  return request({
    url: '/system/default_results/list',
    method: 'get',
    params: query
  })
}

// 查询测算结果默认表详细
export function getDefault_results(planArea) {
  return request({
    url: '/system/default_results/' + planArea,
    method: 'get'
  })
}

// 新增测算结果默认表
export function addDefault_results(data) {
  return request({
    url: '/system/default_results',
    method: 'post',
    data: data
  })
}

// 修改测算结果默认表
export function updateDefault_results(data) {
  return request({
    url: '/system/default_results',
    method: 'put',
    data: data
  })
}

// 删除测算结果默认表
export function delDefault_results(planArea) {
  return request({
    url: '/system/default_results/' + planArea,
    method: 'delete'
  })
}
