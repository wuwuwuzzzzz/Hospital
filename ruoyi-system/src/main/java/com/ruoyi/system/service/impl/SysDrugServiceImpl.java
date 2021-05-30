package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysDrugMapper;
import com.ruoyi.system.domain.SysDrug;
import com.ruoyi.system.service.ISysDrugService;

/**
 * 药品信息Service业务层处理
 * @author wxz
 * @date 2021-05-27
 */
@Service
public class SysDrugServiceImpl implements ISysDrugService 
{
    @Autowired
    private SysDrugMapper sysDrugMapper;

    /**
     * @Title: selectSysDrugById
     * @Description: 查询药品信息
     * @Param: id
     * @return: SysDrug返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午12:01
     */
    @Override
    public SysDrug selectSysDrugById(Long id)
    {
        return sysDrugMapper.selectSysDrugById(id);
    }

    /**
     * @Title: selectSysDrugList
     * @Description: 查询药品信息列表
     * @Param: sysDrug
     * @return: SysDrug>返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午12:01
     */
    @Override
    public List<SysDrug> selectSysDrugList(SysDrug sysDrug)
    {
        return sysDrugMapper.selectSysDrugList(sysDrug);
    }

    /**
     * @Title: insertSysDrug
     * @Description: 新增药品信息
     * @Param: sysDrug
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午12:02
     */
    @Override
    public int insertSysDrug(SysDrug sysDrug)
    {
        sysDrug.preInsert();
        return sysDrugMapper.insertSysDrug(sysDrug);
    }

    /**
     * @Title: updateSysDrug
     * @Description: 修改药品信息
     * @Param: sysDrug
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午12:02
     */
    @Override
    public int updateSysDrug(SysDrug sysDrug)
    {
        sysDrug.preUpdate();
        return sysDrugMapper.updateSysDrug(sysDrug);
    }

    /**
     * @Title: deleteSysDrugByIds
     * @Description: 批量删除药品信息
     * @Param: ids
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午12:02
     */
    @Override
    public int deleteSysDrugByIds(Long[] ids)
    {
        return sysDrugMapper.deleteSysDrugByIds(ids);
    }

    /**
     * @Title: deleteSysDrugById
     * @Description: 删除药品信息信息
     * @Param: id
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2021/5/27 下午12:02
     */
    @Override
    public int deleteSysDrugById(Long id)
    {
        return sysDrugMapper.deleteSysDrugById(id);
    }
}
