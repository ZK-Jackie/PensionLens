package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPlanIndexYearHis;

/**
 * 测算方案参数历史表（按年）Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface TYctxcsPlanIndexYearHisMapper 
{
    /**
     * 查询测算方案参数历史表（按年）
     * 
     * @param id 测算方案参数历史表（按年）主键
     * @return 测算方案参数历史表（按年）
     */
    public TYctxcsPlanIndexYearHis selectTYctxcsPlanIndexYearHisById(Long id);

    /**
     * 查询测算方案参数历史表（按年）列表
     * 
     * @param tYctxcsPlanIndexYearHis 测算方案参数历史表（按年）
     * @return 测算方案参数历史表（按年）集合
     */
    public List<TYctxcsPlanIndexYearHis> selectTYctxcsPlanIndexYearHisList(TYctxcsPlanIndexYearHis tYctxcsPlanIndexYearHis);

    /**
     * 新增测算方案参数历史表（按年）
     * 
     * @param tYctxcsPlanIndexYearHis 测算方案参数历史表（按年）
     * @return 结果
     */
    public int insertTYctxcsPlanIndexYearHis(TYctxcsPlanIndexYearHis tYctxcsPlanIndexYearHis);

    /**
     * 修改测算方案参数历史表（按年）
     * 
     * @param tYctxcsPlanIndexYearHis 测算方案参数历史表（按年）
     * @return 结果
     */
    public int updateTYctxcsPlanIndexYearHis(TYctxcsPlanIndexYearHis tYctxcsPlanIndexYearHis);

    /**
     * 删除测算方案参数历史表（按年）
     * 
     * @param id 测算方案参数历史表（按年）主键
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexYearHisById(Long id);

    /**
     * 批量删除测算方案参数历史表（按年）
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexYearHisByIds(Long[] ids);
}
