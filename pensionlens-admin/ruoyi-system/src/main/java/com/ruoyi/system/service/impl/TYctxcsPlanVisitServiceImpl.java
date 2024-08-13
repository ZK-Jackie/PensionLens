package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsPlanVisitMapper;
import com.ruoyi.system.domain.TYctxcsPlanVisit;
import com.ruoyi.system.service.ITYctxcsPlanVisitService;

/**
 * 测算方案访问表Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsPlanVisitServiceImpl implements ITYctxcsPlanVisitService 
{
    @Autowired
    private TYctxcsPlanVisitMapper tYctxcsPlanVisitMapper;

    /**
     * 查询测算方案访问表
     * 
     * @param id 测算方案访问表主键
     * @return 测算方案访问表
     */
    @Override
    public TYctxcsPlanVisit selectTYctxcsPlanVisitById(Long id)
    {
        return tYctxcsPlanVisitMapper.selectTYctxcsPlanVisitById(id);
    }

    /**
     * 查询测算方案访问表列表
     * 
     * @param tYctxcsPlanVisit 测算方案访问表
     * @return 测算方案访问表
     */
    @Override
    public List<TYctxcsPlanVisit> selectTYctxcsPlanVisitList(TYctxcsPlanVisit tYctxcsPlanVisit)
    {
        return tYctxcsPlanVisitMapper.selectTYctxcsPlanVisitList(tYctxcsPlanVisit);
    }

    /**
     * 新增测算方案访问表
     * 
     * @param tYctxcsPlanVisit 测算方案访问表
     * @return 结果
     */
    @Override
    public int insertTYctxcsPlanVisit(TYctxcsPlanVisit tYctxcsPlanVisit)
    {
        return tYctxcsPlanVisitMapper.insertTYctxcsPlanVisit(tYctxcsPlanVisit);
    }

    /**
     * 修改测算方案访问表
     * 
     * @param tYctxcsPlanVisit 测算方案访问表
     * @return 结果
     */
    @Override
    public int updateTYctxcsPlanVisit(TYctxcsPlanVisit tYctxcsPlanVisit)
    {
        return tYctxcsPlanVisitMapper.updateTYctxcsPlanVisit(tYctxcsPlanVisit);
    }

    /**
     * 批量删除测算方案访问表
     * 
     * @param ids 需要删除的测算方案访问表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanVisitByIds(Long[] ids)
    {
        return tYctxcsPlanVisitMapper.deleteTYctxcsPlanVisitByIds(ids);
    }

    /**
     * 删除测算方案访问表信息
     * 
     * @param id 测算方案访问表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanVisitById(Long id)
    {
        return tYctxcsPlanVisitMapper.deleteTYctxcsPlanVisitById(id);
    }
}
