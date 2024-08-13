package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ScreenPlan;

/**
 * 大屏绑定预测方案Service接口
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
public interface IScreenPlanService 
{
    /**
     * 查询大屏绑定预测方案
     * 
     * @param screenId 大屏绑定预测方案主键
     * @return 大屏绑定预测方案
     */
    public ScreenPlan selectScreenPlanByScreenId(Long screenId);

    /**
     * 查询大屏绑定预测方案列表
     * 
     * @param screenPlan 大屏绑定预测方案
     * @return 大屏绑定预测方案集合
     */
    public List<ScreenPlan> selectScreenPlanList(ScreenPlan screenPlan);

    /**
     * 新增大屏绑定预测方案
     * 
     * @param screenPlan 大屏绑定预测方案
     * @return 结果
     */
    public int insertScreenPlan(ScreenPlan screenPlan);

    /**
     * 修改大屏绑定预测方案
     * 
     * @param screenPlan 大屏绑定预测方案
     * @return 结果
     */
    public int updateScreenPlan(ScreenPlan screenPlan);

    /**
     * 批量删除大屏绑定预测方案
     * 
     * @param screenIds 需要删除的大屏绑定预测方案主键集合
     * @return 结果
     */
    public int deleteScreenPlanByScreenIds(Long[] screenIds);

    /**
     * 删除大屏绑定预测方案信息
     * 
     * @param screenId 大屏绑定预测方案主键
     * @return 结果
     */
    public int deleteScreenPlanByScreenId(Long screenId);
}
