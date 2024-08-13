package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsPlanHistoryMapper;
import com.ruoyi.system.domain.TYctxcsPlanHistory;
import com.ruoyi.system.service.ITYctxcsPlanHistoryService;

/**
 * 延迟退休测算方案历史表Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsPlanHistoryServiceImpl implements ITYctxcsPlanHistoryService 
{
    @Autowired
    private TYctxcsPlanHistoryMapper tYctxcsPlanHistoryMapper;

    /**
     * 查询延迟退休测算方案历史表
     * 
     * @param id 延迟退休测算方案历史表主键
     * @return 延迟退休测算方案历史表
     */
    @Override
    public TYctxcsPlanHistory selectTYctxcsPlanHistoryById(Long id)
    {
        return tYctxcsPlanHistoryMapper.selectTYctxcsPlanHistoryById(id);
    }

    /**
     * 查询延迟退休测算方案历史表列表
     * 
     * @param tYctxcsPlanHistory 延迟退休测算方案历史表
     * @return 延迟退休测算方案历史表
     */
    @Override
    public List<TYctxcsPlanHistory> selectTYctxcsPlanHistoryList(TYctxcsPlanHistory tYctxcsPlanHistory)
    {
        return tYctxcsPlanHistoryMapper.selectTYctxcsPlanHistoryList(tYctxcsPlanHistory);
    }

    /**
     * 新增延迟退休测算方案历史表
     * 
     * @param tYctxcsPlanHistory 延迟退休测算方案历史表
     * @return 结果
     */
    @Override
    public int insertTYctxcsPlanHistory(TYctxcsPlanHistory tYctxcsPlanHistory)
    {
        return tYctxcsPlanHistoryMapper.insertTYctxcsPlanHistory(tYctxcsPlanHistory);
    }

    /**
     * 修改延迟退休测算方案历史表
     * 
     * @param tYctxcsPlanHistory 延迟退休测算方案历史表
     * @return 结果
     */
    @Override
    public int updateTYctxcsPlanHistory(TYctxcsPlanHistory tYctxcsPlanHistory)
    {
        return tYctxcsPlanHistoryMapper.updateTYctxcsPlanHistory(tYctxcsPlanHistory);
    }

    /**
     * 批量删除延迟退休测算方案历史表
     * 
     * @param ids 需要删除的延迟退休测算方案历史表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanHistoryByIds(Long[] ids)
    {
        return tYctxcsPlanHistoryMapper.deleteTYctxcsPlanHistoryByIds(ids);
    }

    /**
     * 删除延迟退休测算方案历史表信息
     * 
     * @param id 延迟退休测算方案历史表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanHistoryById(Long id)
    {
        return tYctxcsPlanHistoryMapper.deleteTYctxcsPlanHistoryById(id);
    }
}
