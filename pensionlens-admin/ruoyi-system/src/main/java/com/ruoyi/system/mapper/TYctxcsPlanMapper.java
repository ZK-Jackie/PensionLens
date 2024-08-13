package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPlan;

/**
 * 延迟退休测算计划表Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface TYctxcsPlanMapper 
{
    /**
     * 查询延迟退休测算计划表
     * 
     * @param id 延迟退休测算计划表主键
     * @return 延迟退休测算计划表
     */
    public TYctxcsPlan selectTYctxcsPlanById(Long id);

    /**
     * 查询延迟退休测算计划表列表
     * 
     * @param tYctxcsPlan 延迟退休测算计划表
     * @return 延迟退休测算计划表集合
     */
    public List<TYctxcsPlan> selectTYctxcsPlanList(TYctxcsPlan tYctxcsPlan);

    /**
     * 新增延迟退休测算计划表
     * 
     * @param tYctxcsPlan 延迟退休测算计划表
     * @return 结果
     */
    public int insertTYctxcsPlan(TYctxcsPlan tYctxcsPlan);

    /**
     * 修改延迟退休测算计划表
     * 
     * @param tYctxcsPlan 延迟退休测算计划表
     * @return 结果
     */
    public int updateTYctxcsPlan(TYctxcsPlan tYctxcsPlan);

    /**
     * 删除延迟退休测算计划表
     * 
     * @param id 延迟退休测算计划表主键
     * @return 结果
     */
    public int deleteTYctxcsPlanById(Long id);

    /**
     * 批量删除延迟退休测算计划表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTYctxcsPlanByIds(Long[] ids);
}
