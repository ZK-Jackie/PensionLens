package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsIndex;

/**
 * 延迟退休测算方案默认参数表Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface TYctxcsIndexMapper 
{
    /**
     * 查询延迟退休测算方案默认参数表
     * 
     * @param planArea 延迟退休测算方案默认参数表主键
     * @return 延迟退休测算方案默认参数表
     */
    public TYctxcsIndex selectTYctxcsIndexByPlanArea(Long planArea);

    /**
     * 查询延迟退休测算方案默认参数表列表
     * 
     * @param tYctxcsIndex 延迟退休测算方案默认参数表
     * @return 延迟退休测算方案默认参数表集合
     */
    public List<TYctxcsIndex> selectTYctxcsIndexList(TYctxcsIndex tYctxcsIndex);

    /**
     * 新增延迟退休测算方案默认参数表
     * 
     * @param tYctxcsIndex 延迟退休测算方案默认参数表
     * @return 结果
     */
    public int insertTYctxcsIndex(TYctxcsIndex tYctxcsIndex);

    /**
     * 修改延迟退休测算方案默认参数表
     * 
     * @param tYctxcsIndex 延迟退休测算方案默认参数表
     * @return 结果
     */
    public int updateTYctxcsIndex(TYctxcsIndex tYctxcsIndex);

    /**
     * 删除延迟退休测算方案默认参数表
     * 
     * @param planArea 延迟退休测算方案默认参数表主键
     * @return 结果
     */
    public int deleteTYctxcsIndexByPlanArea(Long planArea);

    /**
     * 批量删除延迟退休测算方案默认参数表
     * 
     * @param planAreas 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTYctxcsIndexByPlanAreas(Long[] planAreas);
}
