import request from '@/utils/request'

// 查询测算方案参数表（按年龄）列表
export function listIndex_age(query) {
  return request({
    url: '/system/index_age/list',
    method: 'get',
    params: query
  })
}

// 查询测算方案参数表（按年龄）详细
export function getIndex_age(id) {
  return request({
    url: '/system/index_age/' + id,
    method: 'get'
  })
}

// 新增测算方案参数表（按年龄）
export function addIndex_age(data) {
  return request({
    url: '/system/index_age',
    method: 'post',
    data: data
  })
}

// 修改测算方案参数表（按年龄）
export function updateIndex_age(data) {
  return request({
    url: '/system/index_age',
    method: 'put',
    data: data
  })
}

// 删除测算方案参数表（按年龄）
export function delIndex_age(id) {
  return request({
    url: '/system/index_age/' + id,
    method: 'delete'
  })
}
