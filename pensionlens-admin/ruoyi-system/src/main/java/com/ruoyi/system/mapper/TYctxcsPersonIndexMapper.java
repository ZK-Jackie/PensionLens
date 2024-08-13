package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPersonIndex;

/**
 * 测算默认人口数量表Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface TYctxcsPersonIndexMapper 
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
     * 删除测算默认人口数量表
     * 
     * @param planArea 测算默认人口数量表主键
     * @return 结果
     */
    public int deleteTYctxcsPersonIndexByPlanArea(Long planArea);

    /**
     * 批量删除测算默认人口数量表
     * 
     * @param planAreas 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTYctxcsPersonIndexByPlanAreas(Long[] planAreas);
}
