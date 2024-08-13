package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPlanHistory;

/**
 * 延迟退休测算方案历史表Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface TYctxcsPlanHistoryMapper 
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
     * 删除延迟退休测算方案历史表
     * 
     * @param id 延迟退休测算方案历史表主键
     * @return 结果
     */
    public int deleteTYctxcsPlanHistoryById(Long id);

    /**
     * 批量删除延迟退休测算方案历史表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTYctxcsPlanHistoryByIds(Long[] ids);
}
