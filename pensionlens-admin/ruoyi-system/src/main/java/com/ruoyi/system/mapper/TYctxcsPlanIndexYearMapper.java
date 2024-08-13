package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPlanIndexYear;

/**
 * 测算方案参数表（按年）Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface TYctxcsPlanIndexYearMapper 
{
    /**
     * 查询测算方案参数表（按年）
     * 
     * @param id 测算方案参数表（按年）主键
     * @return 测算方案参数表（按年）
     */
    public TYctxcsPlanIndexYear selectTYctxcsPlanIndexYearById(Long id);

    /**
     * 查询测算方案参数表（按年）列表
     * 
     * @param tYctxcsPlanIndexYear 测算方案参数表（按年）
     * @return 测算方案参数表（按年）集合
     */
    public List<TYctxcsPlanIndexYear> selectTYctxcsPlanIndexYearList(TYctxcsPlanIndexYear tYctxcsPlanIndexYear);

    /**
     * 新增测算方案参数表（按年）
     * 
     * @param tYctxcsPlanIndexYear 测算方案参数表（按年）
     * @return 结果
     */
    public int insertTYctxcsPlanIndexYear(TYctxcsPlanIndexYear tYctxcsPlanIndexYear);

    /**
     * 修改测算方案参数表（按年）
     * 
     * @param tYctxcsPlanIndexYear 测算方案参数表（按年）
     * @return 结果
     */
    public int updateTYctxcsPlanIndexYear(TYctxcsPlanIndexYear tYctxcsPlanIndexYear);

    /**
     * 删除测算方案参数表（按年）
     * 
     * @param id 测算方案参数表（按年）主键
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexYearById(Long id);

    /**
     * 批量删除测算方案参数表（按年）
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexYearByIds(Long[] ids);
}
