package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPersonPredictAge;

/**
 * 人口预测参数（按年龄）Service接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface ITYctxcsPersonPredictAgeService 
{
    /**
     * 查询人口预测参数（按年龄）
     * 
     * @param planArea 人口预测参数（按年龄）主键
     * @return 人口预测参数（按年龄）
     */
    public TYctxcsPersonPredictAge selectTYctxcsPersonPredictAgeByPlanArea(Long planArea);

    /**
     * 查询人口预测参数（按年龄）列表
     * 
     * @param tYctxcsPersonPredictAge 人口预测参数（按年龄）
     * @return 人口预测参数（按年龄）集合
     */
    public List<TYctxcsPersonPredictAge> selectTYctxcsPersonPredictAgeList(TYctxcsPersonPredictAge tYctxcsPersonPredictAge);

    /**
     * 新增人口预测参数（按年龄）
     * 
     * @param tYctxcsPersonPredictAge 人口预测参数（按年龄）
     * @return 结果
     */
    public int insertTYctxcsPersonPredictAge(TYctxcsPersonPredictAge tYctxcsPersonPredictAge);

    /**
     * 修改人口预测参数（按年龄）
     * 
     * @param tYctxcsPersonPredictAge 人口预测参数（按年龄）
     * @return 结果
     */
    public int updateTYctxcsPersonPredictAge(TYctxcsPersonPredictAge tYctxcsPersonPredictAge);

    /**
     * 批量删除人口预测参数（按年龄）
     * 
     * @param planAreas 需要删除的人口预测参数（按年龄）主键集合
     * @return 结果
     */
    public int deleteTYctxcsPersonPredictAgeByPlanAreas(Long[] planAreas);

    /**
     * 删除人口预测参数（按年龄）信息
     * 
     * @param planArea 人口预测参数（按年龄）主键
     * @return 结果
     */
    public int deleteTYctxcsPersonPredictAgeByPlanArea(Long planArea);
}
