package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ScreenPlanMapper;
import com.ruoyi.system.domain.ScreenPlan;
import com.ruoyi.system.service.IScreenPlanService;

/**
 * 大屏绑定预测方案Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
@Service
public class ScreenPlanServiceImpl implements IScreenPlanService 
{
    @Autowired
    private ScreenPlanMapper screenPlanMapper;

    /**
     * 查询大屏绑定预测方案
     * 
     * @param screenId 大屏绑定预测方案主键
     * @return 大屏绑定预测方案
     */
    @Override
    public ScreenPlan selectScreenPlanByScreenId(Long screenId)
    {
        return screenPlanMapper.selectScreenPlanByScreenId(screenId);
    }

    /**
     * 查询大屏绑定预测方案列表
     * 
     * @param screenPlan 大屏绑定预测方案
     * @return 大屏绑定预测方案
     */
    @Override
    public List<ScreenPlan> selectScreenPlanList(ScreenPlan screenPlan)
    {
        return screenPlanMapper.selectScreenPlanList(screenPlan);
    }

    /**
     * 新增大屏绑定预测方案
     * 
     * @param screenPlan 大屏绑定预测方案
     * @return 结果
     */
    @Override
    public int insertScreenPlan(ScreenPlan screenPlan)
    {
        return screenPlanMapper.insertScreenPlan(screenPlan);
    }

    /**
     * 修改大屏绑定预测方案
     * 
     * @param screenPlan 大屏绑定预测方案
     * @return 结果
     */
    @Override
    public int updateScreenPlan(ScreenPlan screenPlan)
    {
        return screenPlanMapper.updateScreenPlan(screenPlan);
    }

    /**
     * 批量删除大屏绑定预测方案
     * 
     * @param screenIds 需要删除的大屏绑定预测方案主键
     * @return 结果
     */
    @Override
    public int deleteScreenPlanByScreenIds(Long[] screenIds)
    {
        return screenPlanMapper.deleteScreenPlanByScreenIds(screenIds);
    }

    /**
     * 删除大屏绑定预测方案信息
     * 
     * @param screenId 大屏绑定预测方案主键
     * @return 结果
     */
    @Override
    public int deleteScreenPlanByScreenId(Long screenId)
    {
        return screenPlanMapper.deleteScreenPlanByScreenId(screenId);
    }
}
