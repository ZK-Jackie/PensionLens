package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsPersonIndexMapper;
import com.ruoyi.system.domain.TYctxcsPersonIndex;
import com.ruoyi.system.service.ITYctxcsPersonIndexService;

/**
 * 测算默认人口数量表Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsPersonIndexServiceImpl implements ITYctxcsPersonIndexService 
{
    @Autowired
    private TYctxcsPersonIndexMapper tYctxcsPersonIndexMapper;

    /**
     * 查询测算默认人口数量表
     * 
     * @param planArea 测算默认人口数量表主键
     * @return 测算默认人口数量表
     */
    @Override
    public TYctxcsPersonIndex selectTYctxcsPersonIndexByPlanArea(Long planArea)
    {
        return tYctxcsPersonIndexMapper.selectTYctxcsPersonIndexByPlanArea(planArea);
    }

    /**
     * 查询测算默认人口数量表列表
     * 
     * @param tYctxcsPersonIndex 测算默认人口数量表
     * @return 测算默认人口数量表
     */
    @Override
    public List<TYctxcsPersonIndex> selectTYctxcsPersonIndexList(TYctxcsPersonIndex tYctxcsPersonIndex)
    {
        return tYctxcsPersonIndexMapper.selectTYctxcsPersonIndexList(tYctxcsPersonIndex);
    }

    /**
     * 新增测算默认人口数量表
     * 
     * @param tYctxcsPersonIndex 测算默认人口数量表
     * @return 结果
     */
    @Override
    public int insertTYctxcsPersonIndex(TYctxcsPersonIndex tYctxcsPersonIndex)
    {
        return tYctxcsPersonIndexMapper.insertTYctxcsPersonIndex(tYctxcsPersonIndex);
    }

    /**
     * 修改测算默认人口数量表
     * 
     * @param tYctxcsPersonIndex 测算默认人口数量表
     * @return 结果
     */
    @Override
    public int updateTYctxcsPersonIndex(TYctxcsPersonIndex tYctxcsPersonIndex)
    {
        return tYctxcsPersonIndexMapper.updateTYctxcsPersonIndex(tYctxcsPersonIndex);
    }

    /**
     * 批量删除测算默认人口数量表
     * 
     * @param planAreas 需要删除的测算默认人口数量表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPersonIndexByPlanAreas(Long[] planAreas)
    {
        return tYctxcsPersonIndexMapper.deleteTYctxcsPersonIndexByPlanAreas(planAreas);
    }

    /**
     * 删除测算默认人口数量表信息
     * 
     * @param planArea 测算默认人口数量表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPersonIndexByPlanArea(Long planArea)
    {
        return tYctxcsPersonIndexMapper.deleteTYctxcsPersonIndexByPlanArea(planArea);
    }
}
