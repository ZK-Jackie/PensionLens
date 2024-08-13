package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsDefaultResults;

/**
 * 测算结果默认表Service接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface ITYctxcsDefaultResultsService 
{
    /**
     * 查询测算结果默认表
     * 
     * @param planArea 测算结果默认表主键
     * @return 测算结果默认表
     */
    public TYctxcsDefaultResults selectTYctxcsDefaultResultsByPlanArea(Long planArea);

    /**
     * 查询测算结果默认表列表
     * 
     * @param tYctxcsDefaultResults 测算结果默认表
     * @return 测算结果默认表集合
     */
    public List<TYctxcsDefaultResults> selectTYctxcsDefaultResultsList(TYctxcsDefaultResults tYctxcsDefaultResults);

    /**
     * 新增测算结果默认表
     * 
     * @param tYctxcsDefaultResults 测算结果默认表
     * @return 结果
     */
    public int insertTYctxcsDefaultResults(TYctxcsDefaultResults tYctxcsDefaultResults);

    /**
     * 修改测算结果默认表
     * 
     * @param tYctxcsDefaultResults 测算结果默认表
     * @return 结果
     */
    public int updateTYctxcsDefaultResults(TYctxcsDefaultResults tYctxcsDefaultResults);

    /**
     * 批量删除测算结果默认表
     * 
     * @param planAreas 需要删除的测算结果默认表主键集合
     * @return 结果
     */
    public int deleteTYctxcsDefaultResultsByPlanAreas(Long[] planAreas);

    /**
     * 删除测算结果默认表信息
     * 
     * @param planArea 测算结果默认表主键
     * @return 结果
     */
    public int deleteTYctxcsDefaultResultsByPlanArea(Long planArea);
}
