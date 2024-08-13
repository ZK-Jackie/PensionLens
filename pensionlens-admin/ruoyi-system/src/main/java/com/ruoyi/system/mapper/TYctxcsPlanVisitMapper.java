package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPlanVisit;

/**
 * 测算方案访问表Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface TYctxcsPlanVisitMapper 
{
    /**
     * 查询测算方案访问表
     * 
     * @param id 测算方案访问表主键
     * @return 测算方案访问表
     */
    public TYctxcsPlanVisit selectTYctxcsPlanVisitById(Long id);

    /**
     * 查询测算方案访问表列表
     * 
     * @param tYctxcsPlanVisit 测算方案访问表
     * @return 测算方案访问表集合
     */
    public List<TYctxcsPlanVisit> selectTYctxcsPlanVisitList(TYctxcsPlanVisit tYctxcsPlanVisit);

    /**
     * 新增测算方案访问表
     * 
     * @param tYctxcsPlanVisit 测算方案访问表
     * @return 结果
     */
    public int insertTYctxcsPlanVisit(TYctxcsPlanVisit tYctxcsPlanVisit);

    /**
     * 修改测算方案访问表
     * 
     * @param tYctxcsPlanVisit 测算方案访问表
     * @return 结果
     */
    public int updateTYctxcsPlanVisit(TYctxcsPlanVisit tYctxcsPlanVisit);

    /**
     * 删除测算方案访问表
     * 
     * @param id 测算方案访问表主键
     * @return 结果
     */
    public int deleteTYctxcsPlanVisitById(Long id);

    /**
     * 批量删除测算方案访问表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTYctxcsPlanVisitByIds(Long[] ids);
}
