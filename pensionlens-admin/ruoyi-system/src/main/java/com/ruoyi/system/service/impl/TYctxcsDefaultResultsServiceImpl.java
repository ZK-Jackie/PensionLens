package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsDefaultResultsMapper;
import com.ruoyi.system.domain.TYctxcsDefaultResults;
import com.ruoyi.system.service.ITYctxcsDefaultResultsService;

/**
 * 测算结果默认表Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsDefaultResultsServiceImpl implements ITYctxcsDefaultResultsService 
{
    @Autowired
    private TYctxcsDefaultResultsMapper tYctxcsDefaultResultsMapper;

    /**
     * 查询测算结果默认表
     * 
     * @param planArea 测算结果默认表主键
     * @return 测算结果默认表
     */
    @Override
    public TYctxcsDefaultResults selectTYctxcsDefaultResultsByPlanArea(Long planArea)
    {
        return tYctxcsDefaultResultsMapper.selectTYctxcsDefaultResultsByPlanArea(planArea);
    }

    /**
     * 查询测算结果默认表列表
     * 
     * @param tYctxcsDefaultResults 测算结果默认表
     * @return 测算结果默认表
     */
    @Override
    public List<TYctxcsDefaultResults> selectTYctxcsDefaultResultsList(TYctxcsDefaultResults tYctxcsDefaultResults)
    {
        return tYctxcsDefaultResultsMapper.selectTYctxcsDefaultResultsList(tYctxcsDefaultResults);
    }

    /**
     * 新增测算结果默认表
     * 
     * @param tYctxcsDefaultResults 测算结果默认表
     * @return 结果
     */
    @Override
    public int insertTYctxcsDefaultResults(TYctxcsDefaultResults tYctxcsDefaultResults)
    {
        return tYctxcsDefaultResultsMapper.insertTYctxcsDefaultResults(tYctxcsDefaultResults);
    }

    /**
     * 修改测算结果默认表
     * 
     * @param tYctxcsDefaultResults 测算结果默认表
     * @return 结果
     */
    @Override
    public int updateTYctxcsDefaultResults(TYctxcsDefaultResults tYctxcsDefaultResults)
    {
        return tYctxcsDefaultResultsMapper.updateTYctxcsDefaultResults(tYctxcsDefaultResults);
    }

    /**
     * 批量删除测算结果默认表
     * 
     * @param planAreas 需要删除的测算结果默认表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsDefaultResultsByPlanAreas(Long[] planAreas)
    {
        return tYctxcsDefaultResultsMapper.deleteTYctxcsDefaultResultsByPlanAreas(planAreas);
    }

    /**
     * 删除测算结果默认表信息
     * 
     * @param planArea 测算结果默认表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsDefaultResultsByPlanArea(Long planArea)
    {
        return tYctxcsDefaultResultsMapper.deleteTYctxcsDefaultResultsByPlanArea(planArea);
    }
}
