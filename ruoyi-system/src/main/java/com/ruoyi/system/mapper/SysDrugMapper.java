package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysDrug;

/**
 * 药品信息Mapper接口
 * @author wxz
 * @date 2021-05-27
 */
public interface SysDrugMapper 
{
    /**
     * @Title: selectSysDrugById
     * @Description: 查询药品信息
     * @Param: id
     * @return: SysDrug返回类型
     * @Author: wxz
     * @Date: 2021/5/27 上午11:58
     */
    public SysDrug selectSysDrugById(Long id);

    /**
     * @Title: selectSysDrugList
     * @Description: 查询药品信息列表
     * @Param: sysDrug
     * @return: SysDrug>返回类型
     * @Author: wxz
     * @Date: 2021/5/27 上午11:58
     */
    public List<SysDrug> selectSysDrugList(SysDrug sysDrug);

    /**
     * @Title: insertSysDrug
     * @Description: 新增药品信息
     * @Param: sysDrug
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 上午11:58
     */
    public int insertSysDrug(SysDrug sysDrug);

    /**
     * @Title: updateSysDrug
     * @Description: 修改药品信息
     * @Param: sysDrug
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 上午11:59
     */
    public int updateSysDrug(SysDrug sysDrug);

    /**
     * @Title: deleteSysDrugById
     * @Description: 删除药品信息
     * @Param: id
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 上午11:59
     */
    public int deleteSysDrugById(Long id);

    /**
     * @Title: deleteSysDrugByIds
     * @Description: 批量删除药品信息
     * @Param: ids
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 上午11:59
     */
    public int deleteSysDrugByIds(Long[] ids);

}
