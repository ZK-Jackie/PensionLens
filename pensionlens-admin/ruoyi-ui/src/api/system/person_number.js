import request from '@/utils/request'

// 查询测算默认年份分年龄性别人数列表
export function listPerson_number(query) {
  return request({
    url: '/system/person_number/list',
    method: 'get',
    params: query
  })
}

// 查询测算默认年份分年龄性别人数详细
export function getPerson_number(planArea) {
  return request({
    url: '/system/person_number/' + planArea,
    method: 'get'
  })
}

// 新增测算默认年份分年龄性别人数
export function addPerson_number(data) {
  return request({
    url: '/system/person_number',
    method: 'post',
    data: data
  })
}

// 修改测算默认年份分年龄性别人数
export function updatePerson_number(data) {
  return request({
    url: '/system/person_number',
    method: 'put',
    data: data
  })
}

// 删除测算默认年份分年龄性别人数
export function delPerson_number(planArea) {
  return request({
    url: '/system/person_number/' + planArea,
    method: 'delete'
  })
}
