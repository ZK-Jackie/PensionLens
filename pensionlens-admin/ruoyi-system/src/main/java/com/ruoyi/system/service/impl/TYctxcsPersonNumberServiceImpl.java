package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsPersonNumberMapper;
import com.ruoyi.system.domain.TYctxcsPersonNumber;
import com.ruoyi.system.service.ITYctxcsPersonNumberService;

/**
 * 测算默认年份分年龄性别人数Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsPersonNumberServiceImpl implements ITYctxcsPersonNumberService 
{
    @Autowired
    private TYctxcsPersonNumberMapper tYctxcsPersonNumberMapper;

    /**
     * 查询测算默认年份分年龄性别人数
     * 
     * @param planArea 测算默认年份分年龄性别人数主键
     * @return 测算默认年份分年龄性别人数
     */
    @Override
    public TYctxcsPersonNumber selectTYctxcsPersonNumberByPlanArea(Long planArea)
    {
        return tYctxcsPersonNumberMapper.selectTYctxcsPersonNumberByPlanArea(planArea);
    }

    /**
     * 查询测算默认年份分年龄性别人数列表
     * 
     * @param tYctxcsPersonNumber 测算默认年份分年龄性别人数
     * @return 测算默认年份分年龄性别人数
     */
    @Override
    public List<TYctxcsPersonNumber> selectTYctxcsPersonNumberList(TYctxcsPersonNumber tYctxcsPersonNumber)
    {
        return tYctxcsPersonNumberMapper.selectTYctxcsPersonNumberList(tYctxcsPersonNumber);
    }

    /**
     * 新增测算默认年份分年龄性别人数
     * 
     * @param tYctxcsPersonNumber 测算默认年份分年龄性别人数
     * @return 结果
     */
    @Override
    public int insertTYctxcsPersonNumber(TYctxcsPersonNumber tYctxcsPersonNumber)
    {
        return tYctxcsPersonNumberMapper.insertTYctxcsPersonNumber(tYctxcsPersonNumber);
    }

    /**
     * 修改测算默认年份分年龄性别人数
     * 
     * @param tYctxcsPersonNumber 测算默认年份分年龄性别人数
     * @return 结果
     */
    @Override
    public int updateTYctxcsPersonNumber(TYctxcsPersonNumber tYctxcsPersonNumber)
    {
        return tYctxcsPersonNumberMapper.updateTYctxcsPersonNumber(tYctxcsPersonNumber);
    }

    /**
     * 批量删除测算默认年份分年龄性别人数
     * 
     * @param planAreas 需要删除的测算默认年份分年龄性别人数主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPersonNumberByPlanAreas(Long[] planAreas)
    {
        return tYctxcsPersonNumberMapper.deleteTYctxcsPersonNumberByPlanAreas(planAreas);
    }

    /**
     * 删除测算默认年份分年龄性别人数信息
     * 
     * @param planArea 测算默认年份分年龄性别人数主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPersonNumberByPlanArea(Long planArea)
    {
        return tYctxcsPersonNumberMapper.deleteTYctxcsPersonNumberByPlanArea(planArea);
    }
}
