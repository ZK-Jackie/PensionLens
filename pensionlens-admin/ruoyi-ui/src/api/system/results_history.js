import request from '@/utils/request'

// 查询结果预测历史表列表
export function listResults_history(query) {
  return request({
    url: '/system/results_history/list',
    method: 'get',
    params: query
  })
}

// 查询结果预测历史表详细
export function getResults_history(id) {
  return request({
    url: '/system/results_history/' + id,
    method: 'get'
  })
}

// 新增结果预测历史表
export function addResults_history(data) {
  return request({
    url: '/system/results_history',
    method: 'post',
    data: data
  })
}

// 修改结果预测历史表
export function updateResults_history(data) {
  return request({
    url: '/system/results_history',
    method: 'put',
    data: data
  })
}

// 删除结果预测历史表
export function delResults_history(id) {
  return request({
    url: '/system/results_history/' + id,
    method: 'delete'
  })
}
