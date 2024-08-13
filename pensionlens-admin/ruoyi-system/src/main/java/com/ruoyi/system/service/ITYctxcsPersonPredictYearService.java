package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPersonPredictYear;

/**
 * 人口预测参数（按年份）Service接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface ITYctxcsPersonPredictYearService 
{
    /**
     * 查询人口预测参数（按年份）
     * 
     * @param planArea 人口预测参数（按年份）主键
     * @return 人口预测参数（按年份）
     */
    public TYctxcsPersonPredictYear selectTYctxcsPersonPredictYearByPlanArea(Long planArea);

    /**
     * 查询人口预测参数（按年份）列表
     * 
     * @param tYctxcsPersonPredictYear 人口预测参数（按年份）
     * @return 人口预测参数（按年份）集合
     */
    public List<TYctxcsPersonPredictYear> selectTYctxcsPersonPredictYearList(TYctxcsPersonPredictYear tYctxcsPersonPredictYear);

    /**
     * 新增人口预测参数（按年份）
     * 
     * @param tYctxcsPersonPredictYear 人口预测参数（按年份）
     * @return 结果
     */
    public int insertTYctxcsPersonPredictYear(TYctxcsPersonPredictYear tYctxcsPersonPredictYear);

    /**
     * 修改人口预测参数（按年份）
     * 
     * @param tYctxcsPersonPredictYear 人口预测参数（按年份）
     * @return 结果
     */
    public int updateTYctxcsPersonPredictYear(TYctxcsPersonPredictYear tYctxcsPersonPredictYear);

    /**
     * 批量删除人口预测参数（按年份）
     * 
     * @param planAreas 需要删除的人口预测参数（按年份）主键集合
     * @return 结果
     */
    public int deleteTYctxcsPersonPredictYearByPlanAreas(Long[] planAreas);

    /**
     * 删除人口预测参数（按年份）信息
     * 
     * @param planArea 人口预测参数（按年份）主键
     * @return 结果
     */
    public int deleteTYctxcsPersonPredictYearByPlanArea(Long planArea);
}
