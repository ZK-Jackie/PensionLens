package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPlanIndexAgeHis;

/**
 * 测算方案参数历史表（按年龄）Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface TYctxcsPlanIndexAgeHisMapper 
{
    /**
     * 查询测算方案参数历史表（按年龄）
     * 
     * @param id 测算方案参数历史表（按年龄）主键
     * @return 测算方案参数历史表（按年龄）
     */
    public TYctxcsPlanIndexAgeHis selectTYctxcsPlanIndexAgeHisById(Long id);

    /**
     * 查询测算方案参数历史表（按年龄）列表
     * 
     * @param tYctxcsPlanIndexAgeHis 测算方案参数历史表（按年龄）
     * @return 测算方案参数历史表（按年龄）集合
     */
    public List<TYctxcsPlanIndexAgeHis> selectTYctxcsPlanIndexAgeHisList(TYctxcsPlanIndexAgeHis tYctxcsPlanIndexAgeHis);

    /**
     * 新增测算方案参数历史表（按年龄）
     * 
     * @param tYctxcsPlanIndexAgeHis 测算方案参数历史表（按年龄）
     * @return 结果
     */
    public int insertTYctxcsPlanIndexAgeHis(TYctxcsPlanIndexAgeHis tYctxcsPlanIndexAgeHis);

    /**
     * 修改测算方案参数历史表（按年龄）
     * 
     * @param tYctxcsPlanIndexAgeHis 测算方案参数历史表（按年龄）
     * @return 结果
     */
    public int updateTYctxcsPlanIndexAgeHis(TYctxcsPlanIndexAgeHis tYctxcsPlanIndexAgeHis);

    /**
     * 删除测算方案参数历史表（按年龄）
     * 
     * @param id 测算方案参数历史表（按年龄）主键
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexAgeHisById(Long id);

    /**
     * 批量删除测算方案参数历史表（按年龄）
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexAgeHisByIds(Long[] ids);
}
