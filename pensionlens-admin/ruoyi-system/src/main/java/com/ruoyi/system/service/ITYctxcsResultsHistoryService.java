package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsResultsHistory;

/**
 * 结果预测历史表Service接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface ITYctxcsResultsHistoryService 
{
    /**
     * 查询结果预测历史表
     * 
     * @param id 结果预测历史表主键
     * @return 结果预测历史表
     */
    public TYctxcsResultsHistory selectTYctxcsResultsHistoryById(Long id);

    /**
     * 查询结果预测历史表列表
     * 
     * @param tYctxcsResultsHistory 结果预测历史表
     * @return 结果预测历史表集合
     */
    public List<TYctxcsResultsHistory> selectTYctxcsResultsHistoryList(TYctxcsResultsHistory tYctxcsResultsHistory);

    /**
     * 新增结果预测历史表
     * 
     * @param tYctxcsResultsHistory 结果预测历史表
     * @return 结果
     */
    public int insertTYctxcsResultsHistory(TYctxcsResultsHistory tYctxcsResultsHistory);

    /**
     * 修改结果预测历史表
     * 
     * @param tYctxcsResultsHistory 结果预测历史表
     * @return 结果
     */
    public int updateTYctxcsResultsHistory(TYctxcsResultsHistory tYctxcsResultsHistory);

    /**
     * 批量删除结果预测历史表
     * 
     * @param ids 需要删除的结果预测历史表主键集合
     * @return 结果
     */
    public int deleteTYctxcsResultsHistoryByIds(Long[] ids);

    /**
     * 删除结果预测历史表信息
     * 
     * @param id 结果预测历史表主键
     * @return 结果
     */
    public int deleteTYctxcsResultsHistoryById(Long id);
}
