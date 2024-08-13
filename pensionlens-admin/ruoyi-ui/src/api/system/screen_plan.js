import request from '@/utils/request'

// 查询大屏绑定预测方案列表
export function listScreen_plan(query) {
  return request({
    url: '/system/screen_plan/list',
    method: 'get',
    params: query
  })
}

// 查询大屏绑定预测方案详细
export function getScreen_plan(screenId) {
  return request({
    url: '/system/screen_plan/' + screenId,
    method: 'get'
  })
}

// 新增大屏绑定预测方案
export function addScreen_plan(data) {
  return request({
    url: '/system/screen_plan',
    method: 'post',
    data: data
  })
}

// 修改大屏绑定预测方案
export function updateScreen_plan(data) {
  return request({
    url: '/system/screen_plan',
    method: 'put',
    data: data
  })
}

// 删除大屏绑定预测方案
export function delScreen_plan(screenId) {
  return request({
    url: '/system/screen_plan/' + screenId,
    method: 'delete'
  })
}
