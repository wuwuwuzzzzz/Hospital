import request from '@/utils/request'

// 查询药品信息列表
export function listDrug(query) {
  return request({
    url: '/system/drug/list',
    method: 'get',
    params: query
  })
}

// 查询药品信息详细
export function getDrug(id) {
  return request({
    url: '/system/drug/' + id,
    method: 'get'
  })
}

// 新增药品信息
export function addDrug(data) {
  return request({
    url: '/system/drug',
    method: 'post',
    data: data
  })
}

// 修改药品信息
export function updateDrug(data) {
  return request({
    url: '/system/drug',
    method: 'put',
    data: data
  })
}

// 删除药品信息
export function delDrug(id) {
  return request({
    url: '/system/drug/' + id,
    method: 'delete'
  })
}

// 导出药品信息
export function exportDrug(query) {
  return request({
    url: '/system/drug/export',
    method: 'get',
    params: query
  })
}