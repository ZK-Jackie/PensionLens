import request from '@/utils/request'

// 查询测算方案访问表列表
export function listPlan_visit(query) {
  return request({
    url: '/system/plan_visit/list',
    method: 'get',
    params: query
  })
}

// 查询测算方案访问表详细
export function getPlan_visit(id) {
  return request({
    url: '/system/plan_visit/' + id,
    method: 'get'
  })
}

// 新增测算方案访问表
export function addPlan_visit(data) {
  return request({
    url: '/system/plan_visit',
    method: 'post',
    data: data
  })
}

// 修改测算方案访问表
export function updatePlan_visit(data) {
  return request({
    url: '/system/plan_visit',
    method: 'put',
    data: data
  })
}

// 删除测算方案访问表
export function delPlan_visit(id) {
  return request({
    url: '/system/plan_visit/' + id,
    method: 'delete'
  })
}
