import request from '@/utils/request'

// 查询人口预测参数（按年份）列表
export function listPerson_predict_year(query) {
  return request({
    url: '/system/person_predict_year/list',
    method: 'get',
    params: query
  })
}

// 查询人口预测参数（按年份）详细
export function getPerson_predict_year(planArea) {
  return request({
    url: '/system/person_predict_year/' + planArea,
    method: 'get'
  })
}

// 新增人口预测参数（按年份）
export function addPerson_predict_year(data) {
  return request({
    url: '/system/person_predict_year',
    method: 'post',
    data: data
  })
}

// 修改人口预测参数（按年份）
export function updatePerson_predict_year(data) {
  return request({
    url: '/system/person_predict_year',
    method: 'put',
    data: data
  })
}

// 删除人口预测参数（按年份）
export function delPerson_predict_year(planArea) {
  return request({
    url: '/system/person_predict_year/' + planArea,
    method: 'delete'
  })
}
