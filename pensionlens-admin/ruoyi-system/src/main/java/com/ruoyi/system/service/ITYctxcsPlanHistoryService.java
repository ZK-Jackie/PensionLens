package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPlanHistory;

/**
 * 延迟退休测算方案历史表Service接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface ITYctxcsPlanHistoryService 
{
    /**
     * 查询延迟退休测算方案历史表
     * 
     * @param id 延迟退休测算方案历史表主键
     * @return 延迟退休测算方案历史表
     */
    public TYctxcsPlanHistory selectTYctxcsPlanHistoryById(Long id);

    /**
     * 查询延迟退休测算方案历史表列表
     * 
     * @param tYctxcsPlanHistory 延迟退休测算方案历史表
     * @return 延迟退休测算方案历史表集合
     */
    public List<TYctxcsPlanHistory> selectTYctxcsPlanHistoryList(TYctxcsPlanHistory tYctxcsPlanHistory);

    /**
     * 新增延迟退休测算方案历史表
     * 
     * @param tYctxcsPlanHistory 延迟退休测算方案历史表
     * @return 结果
     */
    public int insertTYctxcsPlanHistory(TYctxcsPlanHistory tYctxcsPlanHistory);

    /**
     * 修改延迟退休测算方案历史表
     * 
     * @param tYctxcsPlanHistory 延迟退休测算方案历史表
     * @return 结果
     */
    public int updateTYctxcsPlanHistory(TYctxcsPlanHistory tYctxcsPlanHistory);

    /**
     * 批量删除延迟退休测算方案历史表
     * 
     * @param ids 需要删除的延迟退休测算方案历史表主键集合
     * @return 结果
     */
    public int deleteTYctxcsPlanHistoryByIds(Long[] ids);

    /**
     * 删除延迟退休测算方案历史表信息
     * 
     * @param id 延迟退休测算方案历史表主键
     * @return 结果
     */
    public int deleteTYctxcsPlanHistoryById(Long id);
}
