package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPlanIndexAge;

/**
 * 测算方案参数表（按年龄）Service接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface ITYctxcsPlanIndexAgeService 
{
    /**
     * 查询测算方案参数表（按年龄）
     * 
     * @param id 测算方案参数表（按年龄）主键
     * @return 测算方案参数表（按年龄）
     */
    public TYctxcsPlanIndexAge selectTYctxcsPlanIndexAgeById(Long id);

    /**
     * 查询测算方案参数表（按年龄）列表
     * 
     * @param tYctxcsPlanIndexAge 测算方案参数表（按年龄）
     * @return 测算方案参数表（按年龄）集合
     */
    public List<TYctxcsPlanIndexAge> selectTYctxcsPlanIndexAgeList(TYctxcsPlanIndexAge tYctxcsPlanIndexAge);

    /**
     * 新增测算方案参数表（按年龄）
     * 
     * @param tYctxcsPlanIndexAge 测算方案参数表（按年龄）
     * @return 结果
     */
    public int insertTYctxcsPlanIndexAge(TYctxcsPlanIndexAge tYctxcsPlanIndexAge);

    /**
     * 修改测算方案参数表（按年龄）
     * 
     * @param tYctxcsPlanIndexAge 测算方案参数表（按年龄）
     * @return 结果
     */
    public int updateTYctxcsPlanIndexAge(TYctxcsPlanIndexAge tYctxcsPlanIndexAge);

    /**
     * 批量删除测算方案参数表（按年龄）
     * 
     * @param ids 需要删除的测算方案参数表（按年龄）主键集合
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexAgeByIds(Long[] ids);

    /**
     * 删除测算方案参数表（按年龄）信息
     * 
     * @param id 测算方案参数表（按年龄）主键
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexAgeById(Long id);
}
