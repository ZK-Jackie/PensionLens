package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPersonNumber;

/**
 * 测算默认年份分年龄性别人数Service接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface ITYctxcsPersonNumberService 
{
    /**
     * 查询测算默认年份分年龄性别人数
     * 
     * @param planArea 测算默认年份分年龄性别人数主键
     * @return 测算默认年份分年龄性别人数
     */
    public TYctxcsPersonNumber selectTYctxcsPersonNumberByPlanArea(Long planArea);

    /**
     * 查询测算默认年份分年龄性别人数列表
     * 
     * @param tYctxcsPersonNumber 测算默认年份分年龄性别人数
     * @return 测算默认年份分年龄性别人数集合
     */
    public List<TYctxcsPersonNumber> selectTYctxcsPersonNumberList(TYctxcsPersonNumber tYctxcsPersonNumber);

    /**
     * 新增测算默认年份分年龄性别人数
     * 
     * @param tYctxcsPersonNumber 测算默认年份分年龄性别人数
     * @return 结果
     */
    public int insertTYctxcsPersonNumber(TYctxcsPersonNumber tYctxcsPersonNumber);

    /**
     * 修改测算默认年份分年龄性别人数
     * 
     * @param tYctxcsPersonNumber 测算默认年份分年龄性别人数
     * @return 结果
     */
    public int updateTYctxcsPersonNumber(TYctxcsPersonNumber tYctxcsPersonNumber);

    /**
     * 批量删除测算默认年份分年龄性别人数
     * 
     * @param planAreas 需要删除的测算默认年份分年龄性别人数主键集合
     * @return 结果
     */
    public int deleteTYctxcsPersonNumberByPlanAreas(Long[] planAreas);

    /**
     * 删除测算默认年份分年龄性别人数信息
     * 
     * @param planArea 测算默认年份分年龄性别人数主键
     * @return 结果
     */
    public int deleteTYctxcsPersonNumberByPlanArea(Long planArea);
}
