package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsIndexMapper;
import com.ruoyi.system.domain.TYctxcsIndex;
import com.ruoyi.system.service.ITYctxcsIndexService;

/**
 * 延迟退休测算方案默认参数表Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsIndexServiceImpl implements ITYctxcsIndexService 
{
    @Autowired
    private TYctxcsIndexMapper tYctxcsIndexMapper;

    /**
     * 查询延迟退休测算方案默认参数表
     * 
     * @param planArea 延迟退休测算方案默认参数表主键
     * @return 延迟退休测算方案默认参数表
     */
    @Override
    public TYctxcsIndex selectTYctxcsIndexByPlanArea(Long planArea)
    {
        return tYctxcsIndexMapper.selectTYctxcsIndexByPlanArea(planArea);
    }

    /**
     * 查询延迟退休测算方案默认参数表列表
     * 
     * @param tYctxcsIndex 延迟退休测算方案默认参数表
     * @return 延迟退休测算方案默认参数表
     */
    @Override
    public List<TYctxcsIndex> selectTYctxcsIndexList(TYctxcsIndex tYctxcsIndex)
    {
        return tYctxcsIndexMapper.selectTYctxcsIndexList(tYctxcsIndex);
    }

    /**
     * 新增延迟退休测算方案默认参数表
     * 
     * @param tYctxcsIndex 延迟退休测算方案默认参数表
     * @return 结果
     */
    @Override
    public int insertTYctxcsIndex(TYctxcsIndex tYctxcsIndex)
    {
        return tYctxcsIndexMapper.insertTYctxcsIndex(tYctxcsIndex);
    }

    /**
     * 修改延迟退休测算方案默认参数表
     * 
     * @param tYctxcsIndex 延迟退休测算方案默认参数表
     * @return 结果
     */
    @Override
    public int updateTYctxcsIndex(TYctxcsIndex tYctxcsIndex)
    {
        return tYctxcsIndexMapper.updateTYctxcsIndex(tYctxcsIndex);
    }

    /**
     * 批量删除延迟退休测算方案默认参数表
     * 
     * @param planAreas 需要删除的延迟退休测算方案默认参数表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsIndexByPlanAreas(Long[] planAreas)
    {
        return tYctxcsIndexMapper.deleteTYctxcsIndexByPlanAreas(planAreas);
    }

    /**
     * 删除延迟退休测算方案默认参数表信息
     * 
     * @param planArea 延迟退休测算方案默认参数表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsIndexByPlanArea(Long planArea)
    {
        return tYctxcsIndexMapper.deleteTYctxcsIndexByPlanArea(planArea);
    }
}
