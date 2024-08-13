import request from '@/utils/request'

// 查询延迟退休测算方案历史表列表
export function listPlan_history(query) {
  return request({
    url: '/system/plan_history/list',
    method: 'get',
    params: query
  })
}

// 查询延迟退休测算方案历史表详细
export function getPlan_history(id) {
  return request({
    url: '/system/plan_history/' + id,
    method: 'get'
  })
}

// 新增延迟退休测算方案历史表
export function addPlan_history(data) {
  return request({
    url: '/system/plan_history',
    method: 'post',
    data: data
  })
}

// 修改延迟退休测算方案历史表
export function updatePlan_history(data) {
  return request({
    url: '/system/plan_history',
    method: 'put',
    data: data
  })
}

// 删除延迟退休测算方案历史表
export function delPlan_history(id) {
  return request({
    url: '/system/plan_history/' + id,
    method: 'delete'
  })
}
