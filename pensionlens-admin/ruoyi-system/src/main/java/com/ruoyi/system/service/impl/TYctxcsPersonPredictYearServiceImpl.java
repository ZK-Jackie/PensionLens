package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsPersonPredictYearMapper;
import com.ruoyi.system.domain.TYctxcsPersonPredictYear;
import com.ruoyi.system.service.ITYctxcsPersonPredictYearService;

/**
 * 人口预测参数（按年份）Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsPersonPredictYearServiceImpl implements ITYctxcsPersonPredictYearService 
{
    @Autowired
    private TYctxcsPersonPredictYearMapper tYctxcsPersonPredictYearMapper;

    /**
     * 查询人口预测参数（按年份）
     * 
     * @param planArea 人口预测参数（按年份）主键
     * @return 人口预测参数（按年份）
     */
    @Override
    public TYctxcsPersonPredictYear selectTYctxcsPersonPredictYearByPlanArea(Long planArea)
    {
        return tYctxcsPersonPredictYearMapper.selectTYctxcsPersonPredictYearByPlanArea(planArea);
    }

    /**
     * 查询人口预测参数（按年份）列表
     * 
     * @param tYctxcsPersonPredictYear 人口预测参数（按年份）
     * @return 人口预测参数（按年份）
     */
    @Override
    public List<TYctxcsPersonPredictYear> selectTYctxcsPersonPredictYearList(TYctxcsPersonPredictYear tYctxcsPersonPredictYear)
    {
        return tYctxcsPersonPredictYearMapper.selectTYctxcsPersonPredictYearList(tYctxcsPersonPredictYear);
    }

    /**
     * 新增人口预测参数（按年份）
     * 
     * @param tYctxcsPersonPredictYear 人口预测参数（按年份）
     * @return 结果
     */
    @Override
    public int insertTYctxcsPersonPredictYear(TYctxcsPersonPredictYear tYctxcsPersonPredictYear)
    {
        return tYctxcsPersonPredictYearMapper.insertTYctxcsPersonPredictYear(tYctxcsPersonPredictYear);
    }

    /**
     * 修改人口预测参数（按年份）
     * 
     * @param tYctxcsPersonPredictYear 人口预测参数（按年份）
     * @return 结果
     */
    @Override
    public int updateTYctxcsPersonPredictYear(TYctxcsPersonPredictYear tYctxcsPersonPredictYear)
    {
        return tYctxcsPersonPredictYearMapper.updateTYctxcsPersonPredictYear(tYctxcsPersonPredictYear);
    }

    /**
     * 批量删除人口预测参数（按年份）
     * 
     * @param planAreas 需要删除的人口预测参数（按年份）主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPersonPredictYearByPlanAreas(Long[] planAreas)
    {
        return tYctxcsPersonPredictYearMapper.deleteTYctxcsPersonPredictYearByPlanAreas(planAreas);
    }

    /**
     * 删除人口预测参数（按年份）信息
     * 
     * @param planArea 人口预测参数（按年份）主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPersonPredictYearByPlanArea(Long planArea)
    {
        return tYctxcsPersonPredictYearMapper.deleteTYctxcsPersonPredictYearByPlanArea(planArea);
    }
}
