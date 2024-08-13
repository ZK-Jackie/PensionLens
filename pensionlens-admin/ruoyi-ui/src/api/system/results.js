import request from '@/utils/request'

// 查询结果预测表列表
export function listResults(query) {
  return request({
    url: '/system/results/list',
    method: 'get',
    params: query
  })
}

// 查询结果预测表详细
export function getResults(id) {
  return request({
    url: '/system/results/' + id,
    method: 'get'
  })
}

// 新增结果预测表
export function addResults(data) {
  return request({
    url: '/system/results',
    method: 'post',
    data: data
  })
}

// 修改结果预测表
export function updateResults(data) {
  return request({
    url: '/system/results',
    method: 'put',
    data: data
  })
}

// 删除结果预测表
export function delResults(id) {
  return request({
    url: '/system/results/' + id,
    method: 'delete'
  })
}
