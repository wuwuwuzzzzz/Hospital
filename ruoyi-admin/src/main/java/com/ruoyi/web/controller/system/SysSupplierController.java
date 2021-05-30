package com.ruoyi.web.controller.system;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysSupplier;
import com.ruoyi.system.service.ISysSupplierService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 供应商Controller
 * @author wxz
 * @date 2021-05-27
 */
@RestController
@RequestMapping("/system/supplier")
public class SysSupplierController extends BaseController
{
    @Autowired
    private ISysSupplierService sysSupplierService;

    /**
     * @Title: list
     * @Description: 查询供应商列表
     * @Param: sysSupplier
     * @return: TableDataInfo返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:14
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysSupplier sysSupplier)
    {
        startPage();
        List<SysSupplier> list = sysSupplierService.selectSysSupplierList(sysSupplier);
        return getDataTable(list);
    }

    /**
     * @Title: export
     * @Description: 导出供应商列表
     * @Param: sysSupplier
     * @return: AjaxResult返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:15
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:export')")
    @Log(title = "供应商", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysSupplier sysSupplier)
    {
        List<SysSupplier> list = sysSupplierService.selectSysSupplierList(sysSupplier);
        ExcelUtil<SysSupplier> util = new ExcelUtil<SysSupplier>(SysSupplier.class);
        return util.exportExcel(list, "供应商数据");
    }

    /**
     * @Title: getInfo
     * @Description: 获取供应商详细信息
     * @Param: supplierId
     * @return: AjaxResult返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:15
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:query')")
    @GetMapping(value = "/{supplierId}")
    public AjaxResult getInfo(@PathVariable("supplierId") Long supplierId)
    {
        return AjaxResult.success(sysSupplierService.selectSysSupplierById(supplierId));
    }

    /**
     * @Title: add
     * @Description: 新增供应商
     * @Param: sysSupplier
     * @return: AjaxResult返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:15
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:add')")
    @Log(title = "供应商", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysSupplier sysSupplier)
    {
        return toAjax(sysSupplierService.insertSysSupplier(sysSupplier));
    }

    /**
     * @Title: edit
     * @Description: 修改供应商
     * @Param: sysSupplier
     * @return: AjaxResult返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:15
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:edit')")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysSupplier sysSupplier)
    {
        return toAjax(sysSupplierService.updateSysSupplier(sysSupplier));
    }

    /**
     * @Title: remove
     * @Description: 删除供应商
     * @Param: supplierIds
     * @return: AjaxResult返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:15
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:remove')")
    @Log(title = "供应商", businessType = BusinessType.DELETE)
	@DeleteMapping("/{supplierIds}")
    public AjaxResult remove(@PathVariable Long[] supplierIds)
    {
        return toAjax(sysSupplierService.deleteSysSupplierByIds(supplierIds));
    }

    /**
     * @Title: sysSupplierList
     * @Description: 查询所有的供应商
     * @return: AjaxResult返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午3:22
     */
    @GetMapping("/sysSupplierList")
    public AjaxResult sysSupplierList() {
        return AjaxResult.success(sysSupplierService.selectAllSysSupplier());
    }
}
