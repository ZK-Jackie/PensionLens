import request from '@/utils/request'

// 查询测算城镇化率历史表列表
export function listIndex_urban_his(query) {
  return request({
    url: '/system/index_urban_his/list',
    method: 'get',
    params: query
  })
}

// 查询测算城镇化率历史表详细
export function getIndex_urban_his(id) {
  return request({
    url: '/system/index_urban_his/' + id,
    method: 'get'
  })
}

// 新增测算城镇化率历史表
export function addIndex_urban_his(data) {
  return request({
    url: '/system/index_urban_his',
    method: 'post',
    data: data
  })
}

// 修改测算城镇化率历史表
export function updateIndex_urban_his(data) {
  return request({
    url: '/system/index_urban_his',
    method: 'put',
    data: data
  })
}

// 删除测算城镇化率历史表
export function delIndex_urban_his(id) {
  return request({
    url: '/system/index_urban_his/' + id,
    method: 'delete'
  })
}
