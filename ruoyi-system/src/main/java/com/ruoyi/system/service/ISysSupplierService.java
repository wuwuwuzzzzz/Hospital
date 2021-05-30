package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysSupplier;

/**
 * 供应商Service接口
 * @author wxz
 * @date 2021-05-27
 */
public interface ISysSupplierService 
{
    /**
     * @Title: selectSysSupplierById
     * @Description: 查询供应商
     * @Param: supplierId
     * @return: SysSupplier返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:12
     */
    public SysSupplier selectSysSupplierById(Long supplierId);

    /**
     * @Title: selectSysSupplierList
     * @Description: 查询供应商列表
     * @Param: sysSupplier
     * @return: SysSupplier>返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:12
     */
    public List<SysSupplier> selectSysSupplierList(SysSupplier sysSupplier);

    /**
     * @Title: insertSysSupplier
     * @Description: 新增供应商
     * @Param: sysSupplier
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:13
     */
    public int insertSysSupplier(SysSupplier sysSupplier);

    /**
     * @Title: updateSysSupplier
     * @Description: 修改供应商
     * @Param: sysSupplier
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:13
     */
    public int updateSysSupplier(SysSupplier sysSupplier);

    /**
     * @Title: deleteSysSupplierByIds
     * @Description: 批量删除供应商
     * @Param: supplierIds
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:13
     */
    public int deleteSysSupplierByIds(Long[] supplierIds);

    /**
     * @Title: deleteSysSupplierById
     * @Description: 删除供应商信息
     * @Param: supplierId
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:13
     */
    public int deleteSysSupplierById(Long supplierId);

    /**
     * @Title: selectAllSysSupplier
     * @Description: 查询所有的供应商
     * @return: SysSupplier>返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:20
     */
    public List<SysSupplier> selectAllSysSupplier();
}
