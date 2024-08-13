import request from '@/utils/request'

// 查询测算城镇化率参数表列表
export function listIndex_urban(query) {
  return request({
    url: '/system/index_urban/list',
    method: 'get',
    params: query
  })
}

// 查询测算城镇化率参数表详细
export function getIndex_urban(id) {
  return request({
    url: '/system/index_urban/' + id,
    method: 'get'
  })
}

// 新增测算城镇化率参数表
export function addIndex_urban(data) {
  return request({
    url: '/system/index_urban',
    method: 'post',
    data: data
  })
}

// 修改测算城镇化率参数表
export function updateIndex_urban(data) {
  return request({
    url: '/system/index_urban',
    method: 'put',
    data: data
  })
}

// 删除测算城镇化率参数表
export function delIndex_urban(id) {
  return request({
    url: '/system/index_urban/' + id,
    method: 'delete'
  })
}
