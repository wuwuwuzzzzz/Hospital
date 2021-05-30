import request from '@/utils/request'

// 查询供应商列表
export function listSupplier(query) {
  return request({
    url: '/system/supplier/list',
    method: 'get',
    params: query
  })
}

// 查询供应商详细
export function getSupplier(supplierId) {
  return request({
    url: '/system/supplier/' + supplierId,
    method: 'get'
  })
}

// 新增供应商
export function addSupplier(data) {
  return request({
    url: '/system/supplier',
    method: 'post',
    data: data
  })
}

// 修改供应商
export function updateSupplier(data) {
  return request({
    url: '/system/supplier',
    method: 'put',
    data: data
  })
}

// 删除供应商
export function delSupplier(supplierId) {
  return request({
    url: '/system/supplier/' + supplierId,
    method: 'delete'
  })
}

// 导出供应商
export function exportSupplier(query) {
  return request({
    url: '/system/supplier/export',
    method: 'get',
    params: query
  })
}

// 查询所有供应商
export function sysSupplierList() {
  return request({
    url: '/system/supplier/sysSupplierList',
    method: 'get',
  })
}
