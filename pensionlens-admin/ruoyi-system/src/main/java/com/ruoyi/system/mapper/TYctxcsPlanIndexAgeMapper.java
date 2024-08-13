package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPlanIndexAge;

/**
 * 测算方案参数表（按年龄）Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface TYctxcsPlanIndexAgeMapper 
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
     * 删除测算方案参数表（按年龄）
     * 
     * @param id 测算方案参数表（按年龄）主键
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexAgeById(Long id);

    /**
     * 批量删除测算方案参数表（按年龄）
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexAgeByIds(Long[] ids);
}
