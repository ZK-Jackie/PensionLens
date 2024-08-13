import request from '@/utils/request'

// 查询延迟退休测算计划表列表
export function listPlan(query) {
  return request({
    url: '/system/plan/list',
    method: 'get',
    params: query
  })
}

// 查询延迟退休测算计划表详细
export function getPlan(id) {
  return request({
    url: '/system/plan/' + id,
    method: 'get'
  })
}

// 新增延迟退休测算计划表
export function addPlan(data) {
  return request({
    url: '/system/plan',
    method: 'post',
    data: data
  })
}

// 修改延迟退休测算计划表
export function updatePlan(data) {
  return request({
    url: '/system/plan',
    method: 'put',
    data: data
  })
}

// 删除延迟退休测算计划表
export function delPlan(id) {
  return request({
    url: '/system/plan/' + id,
    method: 'delete'
  })
}
