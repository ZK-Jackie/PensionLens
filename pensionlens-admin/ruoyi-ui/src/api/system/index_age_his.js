import request from '@/utils/request'

// 查询测算方案参数历史表（按年龄）列表
export function listIndex_age_his(query) {
  return request({
    url: '/system/index_age_his/list',
    method: 'get',
    params: query
  })
}

// 查询测算方案参数历史表（按年龄）详细
export function getIndex_age_his(id) {
  return request({
    url: '/system/index_age_his/' + id,
    method: 'get'
  })
}

// 新增测算方案参数历史表（按年龄）
export function addIndex_age_his(data) {
  return request({
    url: '/system/index_age_his',
    method: 'post',
    data: data
  })
}

// 修改测算方案参数历史表（按年龄）
export function updateIndex_age_his(data) {
  return request({
    url: '/system/index_age_his',
    method: 'put',
    data: data
  })
}

// 删除测算方案参数历史表（按年龄）
export function delIndex_age_his(id) {
  return request({
    url: '/system/index_age_his/' + id,
    method: 'delete'
  })
}
