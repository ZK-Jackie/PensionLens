import request from '@/utils/request'

// 查询测算方案参数描述表列表
export function listIndex_description(query) {
  return request({
    url: '/system/index_description/list',
    method: 'get',
    params: query
  })
}

// 查询测算方案参数描述表详细
export function getIndex_description(id) {
  return request({
    url: '/system/index_description/' + id,
    method: 'get'
  })
}

// 新增测算方案参数描述表
export function addIndex_description(data) {
  return request({
    url: '/system/index_description',
    method: 'post',
    data: data
  })
}

// 修改测算方案参数描述表
export function updateIndex_description(data) {
  return request({
    url: '/system/index_description',
    method: 'put',
    data: data
  })
}

// 删除测算方案参数描述表
export function delIndex_description(id) {
  return request({
    url: '/system/index_description/' + id,
    method: 'delete'
  })
}
