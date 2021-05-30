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
import com.ruoyi.system.domain.SysDrug;
import com.ruoyi.system.service.ISysDrugService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药品信息Controller
 * @author wxz
 * @date 2021-05-27
 */
@RestController
@RequestMapping("/system/drug")
public class SysDrugController extends BaseController
{
    @Autowired
    private ISysDrugService sysDrugService;

    /**
     * @Title: list
     * @Description: 查询药品信息列表
     * @Param: sysDrug
     * @return: TableDataInfo返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午12:02
     */
    @PreAuthorize("@ss.hasPermi('system:drug:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDrug sysDrug)
    {
        startPage();
        List<SysDrug> list = sysDrugService.selectSysDrugList(sysDrug);
        return getDataTable(list);
    }

    /**
     * @Title: export
     * @Description: 导出药品信息列表
     * @Param: sysDrug
     * @return: AjaxResult返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午12:03
     */
    @PreAuthorize("@ss.hasPermi('system:drug:export')")
    @Log(title = "药品信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysDrug sysDrug)
    {
        List<SysDrug> list = sysDrugService.selectSysDrugList(sysDrug);
        ExcelUtil<SysDrug> util = new ExcelUtil<SysDrug>(SysDrug.class);
        return util.exportExcel(list, "药品信息数据");
    }

    /**
     * @Title: getInfo
     * @Description: 获取药品信息详细信息
     * @Param: id
     * @return: AjaxResult返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午12:03
     */
    @PreAuthorize("@ss.hasPermi('system:drug:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysDrugService.selectSysDrugById(id));
    }

    /**
     * @Title: add
     * @Description: 新增药品信息
     * @Param: sysDrug
     * @return: AjaxResult返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午12:03
     */
    @PreAuthorize("@ss.hasPermi('system:drug:add')")
    @Log(title = "药品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDrug sysDrug)
    {
        return toAjax(sysDrugService.insertSysDrug(sysDrug));
    }

    /**
     * @Title: edit
     * @Description: 修改药品信息
     * @Param: sysDrug
     * @return: AjaxResult返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午12:03
     */
    @PreAuthorize("@ss.hasPermi('system:drug:edit')")
    @Log(title = "药品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDrug sysDrug)
    {
        return toAjax(sysDrugService.updateSysDrug(sysDrug));
    }

    /**
     * @Title: remove
     * @Description: 删除药品信息
     * @Param: ids
     * @return: AjaxResult返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午12:03
     */
    @PreAuthorize("@ss.hasPermi('system:drug:remove')")
    @Log(title = "药品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysDrugService.deleteSysDrugByIds(ids));
    }
}
