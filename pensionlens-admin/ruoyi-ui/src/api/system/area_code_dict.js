import request from '@/utils/request'

// 查询测算统筹区域列表
export function listArea_code_dict(query) {
  return request({
    url: '/system/area_code_dict/list',
    method: 'get',
    params: query
  })
}

// 查询测算统筹区域详细
export function getArea_code_dict(code) {
  return request({
    url: '/system/area_code_dict/' + code,
    method: 'get'
  })
}

// 新增测算统筹区域
export function addArea_code_dict(data) {
  return request({
    url: '/system/area_code_dict',
    method: 'post',
    data: data
  })
}

// 修改测算统筹区域
export function updateArea_code_dict(data) {
  return request({
    url: '/system/area_code_dict',
    method: 'put',
    data: data
  })
}

// 删除测算统筹区域
export function delArea_code_dict(code) {
  return request({
    url: '/system/area_code_dict/' + code,
    method: 'delete'
  })
}
