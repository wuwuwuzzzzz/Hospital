package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysSupplierMapper;
import com.ruoyi.system.domain.SysSupplier;
import com.ruoyi.system.service.ISysSupplierService;

/**
 * 供应商Service业务层处理
 * @author wxz
 * @date 2021-05-27
 */
@Service
public class SysSupplierServiceImpl implements ISysSupplierService 
{
    @Autowired
    private SysSupplierMapper sysSupplierMapper;

    /**
     * @Title: selectSysSupplierById
     * @Description: 查询供应商
     * @Param: supplierId
     * @return: SysSupplier返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:13
     */
    @Override
    public SysSupplier selectSysSupplierById(Long supplierId)
    {
        return sysSupplierMapper.selectSysSupplierById(supplierId);
    }

    /**
     * @Title: selectSysSupplierList
     * @Description: 查询供应商列表
     * @Param: sysSupplier
     * @return: SysSupplier>返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:13
     */
    @Override
    public List<SysSupplier> selectSysSupplierList(SysSupplier sysSupplier)
    {
        return sysSupplierMapper.selectSysSupplierList(sysSupplier);
    }

    /**
     * @Title: insertSysSupplier
     * @Description: 新增供应商
     * @Param: sysSupplier
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:14
     */
    @Override
    public int insertSysSupplier(SysSupplier sysSupplier)
    {
        return sysSupplierMapper.insertSysSupplier(sysSupplier);
    }

    /**
     * @Title: updateSysSupplier
     * @Description: 修改供应商
     * @Param: sysSupplier
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:14
     */
    @Override
    public int updateSysSupplier(SysSupplier sysSupplier)
    {
        return sysSupplierMapper.updateSysSupplier(sysSupplier);
    }

    /**
     * @Title: deleteSysSupplierByIds
     * @Description: 批量删除供应商
     * @Param: supplierIds
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:14
     */
    @Override
    public int deleteSysSupplierByIds(Long[] supplierIds)
    {
        return sysSupplierMapper.deleteSysSupplierByIds(supplierIds);
    }

    /**
     * @Title: deleteSysSupplierById
     * @Description: 删除供应商信息
     * @Param: supplierId
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:14
     */
    @Override
    public int deleteSysSupplierById(Long supplierId)
    {
        return sysSupplierMapper.deleteSysSupplierById(supplierId);
    }

    /**
     * @Title: selectAllSysSupplier
     * @Description: 查询所有的供应商
     * @return: SysSupplier>返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:21
     */
    @Override
    public List<SysSupplier> selectAllSysSupplier() {
        return sysSupplierMapper.selectAllSysSupplier();
    }
}
