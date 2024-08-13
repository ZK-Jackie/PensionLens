package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsUrbanRateMapper;
import com.ruoyi.system.domain.TYctxcsUrbanRate;
import com.ruoyi.system.service.ITYctxcsUrbanRateService;

/**
 * 测算城镇化率默认参数表Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsUrbanRateServiceImpl implements ITYctxcsUrbanRateService 
{
    @Autowired
    private TYctxcsUrbanRateMapper tYctxcsUrbanRateMapper;

    /**
     * 查询测算城镇化率默认参数表
     * 
     * @param planArea 测算城镇化率默认参数表主键
     * @return 测算城镇化率默认参数表
     */
    @Override
    public TYctxcsUrbanRate selectTYctxcsUrbanRateByPlanArea(Long planArea)
    {
        return tYctxcsUrbanRateMapper.selectTYctxcsUrbanRateByPlanArea(planArea);
    }

    /**
     * 查询测算城镇化率默认参数表列表
     * 
     * @param tYctxcsUrbanRate 测算城镇化率默认参数表
     * @return 测算城镇化率默认参数表
     */
    @Override
    public List<TYctxcsUrbanRate> selectTYctxcsUrbanRateList(TYctxcsUrbanRate tYctxcsUrbanRate)
    {
        return tYctxcsUrbanRateMapper.selectTYctxcsUrbanRateList(tYctxcsUrbanRate);
    }

    /**
     * 新增测算城镇化率默认参数表
     * 
     * @param tYctxcsUrbanRate 测算城镇化率默认参数表
     * @return 结果
     */
    @Override
    public int insertTYctxcsUrbanRate(TYctxcsUrbanRate tYctxcsUrbanRate)
    {
        return tYctxcsUrbanRateMapper.insertTYctxcsUrbanRate(tYctxcsUrbanRate);
    }

    /**
     * 修改测算城镇化率默认参数表
     * 
     * @param tYctxcsUrbanRate 测算城镇化率默认参数表
     * @return 结果
     */
    @Override
    public int updateTYctxcsUrbanRate(TYctxcsUrbanRate tYctxcsUrbanRate)
    {
        return tYctxcsUrbanRateMapper.updateTYctxcsUrbanRate(tYctxcsUrbanRate);
    }

    /**
     * 批量删除测算城镇化率默认参数表
     * 
     * @param planAreas 需要删除的测算城镇化率默认参数表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsUrbanRateByPlanAreas(Long[] planAreas)
    {
        return tYctxcsUrbanRateMapper.deleteTYctxcsUrbanRateByPlanAreas(planAreas);
    }

    /**
     * 删除测算城镇化率默认参数表信息
     * 
     * @param planArea 测算城镇化率默认参数表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsUrbanRateByPlanArea(Long planArea)
    {
        return tYctxcsUrbanRateMapper.deleteTYctxcsUrbanRateByPlanArea(planArea);
    }
}
