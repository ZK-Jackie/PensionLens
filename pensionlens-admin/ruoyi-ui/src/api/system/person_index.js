import request from '@/utils/request'

// 查询测算默认人口数量表列表
export function listPerson_index(query) {
  return request({
    url: '/system/person_index/list',
    method: 'get',
    params: query
  })
}

// 查询测算默认人口数量表详细
export function getPerson_index(planArea) {
  return request({
    url: '/system/person_index/' + planArea,
    method: 'get'
  })
}

// 新增测算默认人口数量表
export function addPerson_index(data) {
  return request({
    url: '/system/person_index',
    method: 'post',
    data: data
  })
}

// 修改测算默认人口数量表
export function updatePerson_index(data) {
  return request({
    url: '/system/person_index',
    method: 'put',
    data: data
  })
}

// 删除测算默认人口数量表
export function delPerson_index(planArea) {
  return request({
    url: '/system/person_index/' + planArea,
    method: 'delete'
  })
}
