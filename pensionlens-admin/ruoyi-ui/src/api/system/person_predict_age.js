import request from '@/utils/request'

// 查询人口预测参数（按年龄）列表
export function listPerson_predict_age(query) {
  return request({
    url: '/system/person_predict_age/list',
    method: 'get',
    params: query
  })
}

// 查询人口预测参数（按年龄）详细
export function getPerson_predict_age(planArea) {
  return request({
    url: '/system/person_predict_age/' + planArea,
    method: 'get'
  })
}

// 新增人口预测参数（按年龄）
export function addPerson_predict_age(data) {
  return request({
    url: '/system/person_predict_age',
    method: 'post',
    data: data
  })
}

// 修改人口预测参数（按年龄）
export function updatePerson_predict_age(data) {
  return request({
    url: '/system/person_predict_age',
    method: 'put',
    data: data
  })
}

// 删除人口预测参数（按年龄）
export function delPerson_predict_age(planArea) {
  return request({
    url: '/system/person_predict_age/' + planArea,
    method: 'delete'
  })
}
