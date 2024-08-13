package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsPlanMapper;
import com.ruoyi.system.domain.TYctxcsPlan;
import com.ruoyi.system.service.ITYctxcsPlanService;

/**
 * 延迟退休测算计划表Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsPlanServiceImpl implements ITYctxcsPlanService 
{
    @Autowired
    private TYctxcsPlanMapper tYctxcsPlanMapper;

    /**
     * 查询延迟退休测算计划表
     * 
     * @param id 延迟退休测算计划表主键
     * @return 延迟退休测算计划表
     */
    @Override
    public TYctxcsPlan selectTYctxcsPlanById(Long id)
    {
        return tYctxcsPlanMapper.selectTYctxcsPlanById(id);
    }

    /**
     * 查询延迟退休测算计划表列表
     * 
     * @param tYctxcsPlan 延迟退休测算计划表
     * @return 延迟退休测算计划表
     */
    @Override
    public List<TYctxcsPlan> selectTYctxcsPlanList(TYctxcsPlan tYctxcsPlan)
    {
        return tYctxcsPlanMapper.selectTYctxcsPlanList(tYctxcsPlan);
    }

    /**
     * 新增延迟退休测算计划表
     * 
     * @param tYctxcsPlan 延迟退休测算计划表
     * @return 结果
     */
    @Override
    public int insertTYctxcsPlan(TYctxcsPlan tYctxcsPlan)
    {
        return tYctxcsPlanMapper.insertTYctxcsPlan(tYctxcsPlan);
    }

    /**
     * 修改延迟退休测算计划表
     * 
     * @param tYctxcsPlan 延迟退休测算计划表
     * @return 结果
     */
    @Override
    public int updateTYctxcsPlan(TYctxcsPlan tYctxcsPlan)
    {
        return tYctxcsPlanMapper.updateTYctxcsPlan(tYctxcsPlan);
    }

    /**
     * 批量删除延迟退休测算计划表
     * 
     * @param ids 需要删除的延迟退休测算计划表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanByIds(Long[] ids)
    {
        return tYctxcsPlanMapper.deleteTYctxcsPlanByIds(ids);
    }

    /**
     * 删除延迟退休测算计划表信息
     * 
     * @param id 延迟退休测算计划表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanById(Long id)
    {
        return tYctxcsPlanMapper.deleteTYctxcsPlanById(id);
    }
}
