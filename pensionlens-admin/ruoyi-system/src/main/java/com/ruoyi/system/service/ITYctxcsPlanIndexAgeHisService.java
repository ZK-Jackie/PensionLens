package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPlanIndexAgeHis;

/**
 * 测算方案参数历史表（按年龄）Service接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface ITYctxcsPlanIndexAgeHisService 
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
     * 批量删除测算方案参数历史表（按年龄）
     * 
     * @param ids 需要删除的测算方案参数历史表（按年龄）主键集合
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexAgeHisByIds(Long[] ids);

    /**
     * 删除测算方案参数历史表（按年龄）信息
     * 
     * @param id 测算方案参数历史表（按年龄）主键
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexAgeHisById(Long id);
}
