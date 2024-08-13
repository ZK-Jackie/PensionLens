package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsResultsHistoryMapper;
import com.ruoyi.system.domain.TYctxcsResultsHistory;
import com.ruoyi.system.service.ITYctxcsResultsHistoryService;

/**
 * 结果预测历史表Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsResultsHistoryServiceImpl implements ITYctxcsResultsHistoryService 
{
    @Autowired
    private TYctxcsResultsHistoryMapper tYctxcsResultsHistoryMapper;

    /**
     * 查询结果预测历史表
     * 
     * @param id 结果预测历史表主键
     * @return 结果预测历史表
     */
    @Override
    public TYctxcsResultsHistory selectTYctxcsResultsHistoryById(Long id)
    {
        return tYctxcsResultsHistoryMapper.selectTYctxcsResultsHistoryById(id);
    }

    /**
     * 查询结果预测历史表列表
     * 
     * @param tYctxcsResultsHistory 结果预测历史表
     * @return 结果预测历史表
     */
    @Override
    public List<TYctxcsResultsHistory> selectTYctxcsResultsHistoryList(TYctxcsResultsHistory tYctxcsResultsHistory)
    {
        return tYctxcsResultsHistoryMapper.selectTYctxcsResultsHistoryList(tYctxcsResultsHistory);
    }

    /**
     * 新增结果预测历史表
     * 
     * @param tYctxcsResultsHistory 结果预测历史表
     * @return 结果
     */
    @Override
    public int insertTYctxcsResultsHistory(TYctxcsResultsHistory tYctxcsResultsHistory)
    {
        return tYctxcsResultsHistoryMapper.insertTYctxcsResultsHistory(tYctxcsResultsHistory);
    }

    /**
     * 修改结果预测历史表
     * 
     * @param tYctxcsResultsHistory 结果预测历史表
     * @return 结果
     */
    @Override
    public int updateTYctxcsResultsHistory(TYctxcsResultsHistory tYctxcsResultsHistory)
    {
        return tYctxcsResultsHistoryMapper.updateTYctxcsResultsHistory(tYctxcsResultsHistory);
    }

    /**
     * 批量删除结果预测历史表
     * 
     * @param ids 需要删除的结果预测历史表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsResultsHistoryByIds(Long[] ids)
    {
        return tYctxcsResultsHistoryMapper.deleteTYctxcsResultsHistoryByIds(ids);
    }

    /**
     * 删除结果预测历史表信息
     * 
     * @param id 结果预测历史表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsResultsHistoryById(Long id)
    {
        return tYctxcsResultsHistoryMapper.deleteTYctxcsResultsHistoryById(id);
    }
}
