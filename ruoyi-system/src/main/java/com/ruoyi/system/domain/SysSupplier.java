package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商对象 sys_supplier
 * @author wxz
 * @date 2021-05-27
 */
public class SysSupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long supplierId;

    /** 名称 */
    @Excel(name = "名称")
    private String supplierName;

    /** 地址 */
    @Excel(name = "地址")
    private String supplierAddress;

    /** 电话 */
    @Excel(name = "电话")
    private String supplierPhonenumber;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierPhonenumber() {
        return supplierPhonenumber;
    }

    public void setSupplierPhonenumber(String supplierPhonenumber) {
        this.supplierPhonenumber = supplierPhonenumber;
    }
}
