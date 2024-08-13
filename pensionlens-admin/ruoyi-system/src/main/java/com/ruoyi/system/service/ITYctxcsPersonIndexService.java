package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPersonIndex;

/**
 * 测算默认人口数量表Service接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface ITYctxcsPersonIndexService 
{
    /**
     * 查询测算默认人口数量表
     * 
     * @param planArea 测算默认人口数量表主键
     * @return 测算默认人口数量表
     */
    public TYctxcsPersonIndex selectTYctxcsPersonIndexByPlanArea(Long planArea);

    /**
     * 查询测算默认人口数量表列表
     * 
     * @param tYctxcsPersonIndex 测算默认人口数量表
     * @return 测算默认人口数量表集合
     */
    public List<TYctxcsPersonIndex> selectTYctxcsPersonIndexList(TYctxcsPersonIndex tYctxcsPersonIndex);

    /**
     * 新增测算默认人口数量表
     * 
     * @param tYctxcsPersonIndex 测算默认人口数量表
     * @return 结果
     */
    public int insertTYctxcsPersonIndex(TYctxcsPersonIndex tYctxcsPersonIndex);

    /**
     * 修改测算默认人口数量表
     * 
     * @param tYctxcsPersonIndex 测算默认人口数量表
     * @return 结果
     */
    public int updateTYctxcsPersonIndex(TYctxcsPersonIndex tYctxcsPersonIndex);

    /**
     * 批量删除测算默认人口数量表
     * 
     * @param planAreas 需要删除的测算默认人口数量表主键集合
     * @return 结果
     */
    public int deleteTYctxcsPersonIndexByPlanAreas(Long[] planAreas);

    /**
     * 删除测算默认人口数量表信息
     * 
     * @param planArea 测算默认人口数量表主键
     * @return 结果
     */
    public int deleteTYctxcsPersonIndexByPlanArea(Long planArea);
}
