import request from '@/utils/request'

// 查询测算方案参数表（按年）列表
export function listIndex_year(query) {
  return request({
    url: '/system/index_year/list',
    method: 'get',
    params: query
  })
}

// 查询测算方案参数表（按年）详细
export function getIndex_year(id) {
  return request({
    url: '/system/index_year/' + id,
    method: 'get'
  })
}

// 新增测算方案参数表（按年）
export function addIndex_year(data) {
  return request({
    url: '/system/index_year',
    method: 'post',
    data: data
  })
}

// 修改测算方案参数表（按年）
export function updateIndex_year(data) {
  return request({
    url: '/system/index_year',
    method: 'put',
    data: data
  })
}

// 删除测算方案参数表（按年）
export function delIndex_year(id) {
  return request({
    url: '/system/index_year/' + id,
    method: 'delete'
  })
}
