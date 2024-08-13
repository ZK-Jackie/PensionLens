package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsUrbanRate;

/**
 * 测算城镇化率默认参数表Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface TYctxcsUrbanRateMapper 
{
    /**
     * 查询测算城镇化率默认参数表
     * 
     * @param planArea 测算城镇化率默认参数表主键
     * @return 测算城镇化率默认参数表
     */
    public TYctxcsUrbanRate selectTYctxcsUrbanRateByPlanArea(Long planArea);

    /**
     * 查询测算城镇化率默认参数表列表
     * 
     * @param tYctxcsUrbanRate 测算城镇化率默认参数表
     * @return 测算城镇化率默认参数表集合
     */
    public List<TYctxcsUrbanRate> selectTYctxcsUrbanRateList(TYctxcsUrbanRate tYctxcsUrbanRate);

    /**
     * 新增测算城镇化率默认参数表
     * 
     * @param tYctxcsUrbanRate 测算城镇化率默认参数表
     * @return 结果
     */
    public int insertTYctxcsUrbanRate(TYctxcsUrbanRate tYctxcsUrbanRate);

    /**
     * 修改测算城镇化率默认参数表
     * 
     * @param tYctxcsUrbanRate 测算城镇化率默认参数表
     * @return 结果
     */
    public int updateTYctxcsUrbanRate(TYctxcsUrbanRate tYctxcsUrbanRate);

    /**
     * 删除测算城镇化率默认参数表
     * 
     * @param planArea 测算城镇化率默认参数表主键
     * @return 结果
     */
    public int deleteTYctxcsUrbanRateByPlanArea(Long planArea);

    /**
     * 批量删除测算城镇化率默认参数表
     * 
     * @param planAreas 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTYctxcsUrbanRateByPlanAreas(Long[] planAreas);
}
