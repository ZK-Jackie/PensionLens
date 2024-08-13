import request from '@/utils/request'

// 查询测算方案参数历史表（按年）列表
export function listIndex_year_his(query) {
  return request({
    url: '/system/index_year_his/list',
    method: 'get',
    params: query
  })
}

// 查询测算方案参数历史表（按年）详细
export function getIndex_year_his(id) {
  return request({
    url: '/system/index_year_his/' + id,
    method: 'get'
  })
}

// 新增测算方案参数历史表（按年）
export function addIndex_year_his(data) {
  return request({
    url: '/system/index_year_his',
    method: 'post',
    data: data
  })
}

// 修改测算方案参数历史表（按年）
export function updateIndex_year_his(data) {
  return request({
    url: '/system/index_year_his',
    method: 'put',
    data: data
  })
}

// 删除测算方案参数历史表（按年）
export function delIndex_year_his(id) {
  return request({
    url: '/system/index_year_his/' + id,
    method: 'delete'
  })
}
