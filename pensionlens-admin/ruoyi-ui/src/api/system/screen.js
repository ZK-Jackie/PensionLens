import request from '@/utils/request'

// 查询大屏表列表
export function listScreen(query) {
  return request({
    url: '/system/screen/list',
    method: 'get',
    params: query
  })
}

// 查询大屏表详细
export function getScreen(screenId) {
  return request({
    url: '/system/screen/' + screenId,
    method: 'get'
  })
}

// 新增大屏表
export function addScreen(data) {
  return request({
    url: '/system/screen',
    method: 'post',
    data: data
  })
}

// 修改大屏表
export function updateScreen(data) {
  return request({
    url: '/system/screen',
    method: 'put',
    data: data
  })
}

// 删除大屏表
export function delScreen(screenId) {
  return request({
    url: '/system/screen/' + screenId,
    method: 'delete'
  })
}
