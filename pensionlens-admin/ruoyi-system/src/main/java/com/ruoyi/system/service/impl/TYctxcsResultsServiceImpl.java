package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsResultsMapper;
import com.ruoyi.system.domain.TYctxcsResults;
import com.ruoyi.system.service.ITYctxcsResultsService;

/**
 * 结果预测表Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsResultsServiceImpl implements ITYctxcsResultsService 
{
    @Autowired
    private TYctxcsResultsMapper tYctxcsResultsMapper;

    /**
     * 查询结果预测表
     * 
     * @param id 结果预测表主键
     * @return 结果预测表
     */
    @Override
    public TYctxcsResults selectTYctxcsResultsById(Long id)
    {
        return tYctxcsResultsMapper.selectTYctxcsResultsById(id);
    }

    /**
     * 查询结果预测表列表
     * 
     * @param tYctxcsResults 结果预测表
     * @return 结果预测表
     */
    @Override
    public List<TYctxcsResults> selectTYctxcsResultsList(TYctxcsResults tYctxcsResults)
    {
        return tYctxcsResultsMapper.selectTYctxcsResultsList(tYctxcsResults);
    }

    /**
     * 新增结果预测表
     * 
     * @param tYctxcsResults 结果预测表
     * @return 结果
     */
    @Override
    public int insertTYctxcsResults(TYctxcsResults tYctxcsResults)
    {
        return tYctxcsResultsMapper.insertTYctxcsResults(tYctxcsResults);
    }

    /**
     * 修改结果预测表
     * 
     * @param tYctxcsResults 结果预测表
     * @return 结果
     */
    @Override
    public int updateTYctxcsResults(TYctxcsResults tYctxcsResults)
    {
        return tYctxcsResultsMapper.updateTYctxcsResults(tYctxcsResults);
    }

    /**
     * 批量删除结果预测表
     * 
     * @param ids 需要删除的结果预测表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsResultsByIds(Long[] ids)
    {
        return tYctxcsResultsMapper.deleteTYctxcsResultsByIds(ids);
    }

    /**
     * 删除结果预测表信息
     * 
     * @param id 结果预测表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsResultsById(Long id)
    {
        return tYctxcsResultsMapper.deleteTYctxcsResultsById(id);
    }
}
