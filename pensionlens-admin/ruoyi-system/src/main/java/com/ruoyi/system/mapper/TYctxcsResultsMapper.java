package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsResults;

/**
 * 结果预测表Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface TYctxcsResultsMapper 
{
    /**
     * 查询结果预测表
     * 
     * @param id 结果预测表主键
     * @return 结果预测表
     */
    public TYctxcsResults selectTYctxcsResultsById(Long id);

    /**
     * 查询结果预测表列表
     * 
     * @param tYctxcsResults 结果预测表
     * @return 结果预测表集合
     */
    public List<TYctxcsResults> selectTYctxcsResultsList(TYctxcsResults tYctxcsResults);

    /**
     * 新增结果预测表
     * 
     * @param tYctxcsResults 结果预测表
     * @return 结果
     */
    public int insertTYctxcsResults(TYctxcsResults tYctxcsResults);

    /**
     * 修改结果预测表
     * 
     * @param tYctxcsResults 结果预测表
     * @return 结果
     */
    public int updateTYctxcsResults(TYctxcsResults tYctxcsResults);

    /**
     * 删除结果预测表
     * 
     * @param id 结果预测表主键
     * @return 结果
     */
    public int deleteTYctxcsResultsById(Long id);

    /**
     * 批量删除结果预测表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTYctxcsResultsByIds(Long[] ids);
}
