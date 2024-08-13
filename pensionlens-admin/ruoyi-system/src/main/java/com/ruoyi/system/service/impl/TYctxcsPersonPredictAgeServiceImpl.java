package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsPersonPredictAgeMapper;
import com.ruoyi.system.domain.TYctxcsPersonPredictAge;
import com.ruoyi.system.service.ITYctxcsPersonPredictAgeService;

/**
 * 人口预测参数（按年龄）Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsPersonPredictAgeServiceImpl implements ITYctxcsPersonPredictAgeService 
{
    @Autowired
    private TYctxcsPersonPredictAgeMapper tYctxcsPersonPredictAgeMapper;

    /**
     * 查询人口预测参数（按年龄）
     * 
     * @param planArea 人口预测参数（按年龄）主键
     * @return 人口预测参数（按年龄）
     */
    @Override
    public TYctxcsPersonPredictAge selectTYctxcsPersonPredictAgeByPlanArea(Long planArea)
    {
        return tYctxcsPersonPredictAgeMapper.selectTYctxcsPersonPredictAgeByPlanArea(planArea);
    }

    /**
     * 查询人口预测参数（按年龄）列表
     * 
     * @param tYctxcsPersonPredictAge 人口预测参数（按年龄）
     * @return 人口预测参数（按年龄）
     */
    @Override
    public List<TYctxcsPersonPredictAge> selectTYctxcsPersonPredictAgeList(TYctxcsPersonPredictAge tYctxcsPersonPredictAge)
    {
        return tYctxcsPersonPredictAgeMapper.selectTYctxcsPersonPredictAgeList(tYctxcsPersonPredictAge);
    }

    /**
     * 新增人口预测参数（按年龄）
     * 
     * @param tYctxcsPersonPredictAge 人口预测参数（按年龄）
     * @return 结果
     */
    @Override
    public int insertTYctxcsPersonPredictAge(TYctxcsPersonPredictAge tYctxcsPersonPredictAge)
    {
        return tYctxcsPersonPredictAgeMapper.insertTYctxcsPersonPredictAge(tYctxcsPersonPredictAge);
    }

    /**
     * 修改人口预测参数（按年龄）
     * 
     * @param tYctxcsPersonPredictAge 人口预测参数（按年龄）
     * @return 结果
     */
    @Override
    public int updateTYctxcsPersonPredictAge(TYctxcsPersonPredictAge tYctxcsPersonPredictAge)
    {
        return tYctxcsPersonPredictAgeMapper.updateTYctxcsPersonPredictAge(tYctxcsPersonPredictAge);
    }

    /**
     * 批量删除人口预测参数（按年龄）
     * 
     * @param planAreas 需要删除的人口预测参数（按年龄）主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPersonPredictAgeByPlanAreas(Long[] planAreas)
    {
        return tYctxcsPersonPredictAgeMapper.deleteTYctxcsPersonPredictAgeByPlanAreas(planAreas);
    }

    /**
     * 删除人口预测参数（按年龄）信息
     * 
     * @param planArea 人口预测参数（按年龄）主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPersonPredictAgeByPlanArea(Long planArea)
    {
        return tYctxcsPersonPredictAgeMapper.deleteTYctxcsPersonPredictAgeByPlanArea(planArea);
    }
}
