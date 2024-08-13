package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsPlanIndexYearHisMapper;
import com.ruoyi.system.domain.TYctxcsPlanIndexYearHis;
import com.ruoyi.system.service.ITYctxcsPlanIndexYearHisService;

/**
 * 测算方案参数历史表（按年）Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsPlanIndexYearHisServiceImpl implements ITYctxcsPlanIndexYearHisService 
{
    @Autowired
    private TYctxcsPlanIndexYearHisMapper tYctxcsPlanIndexYearHisMapper;

    /**
     * 查询测算方案参数历史表（按年）
     * 
     * @param id 测算方案参数历史表（按年）主键
     * @return 测算方案参数历史表（按年）
     */
    @Override
    public TYctxcsPlanIndexYearHis selectTYctxcsPlanIndexYearHisById(Long id)
    {
        return tYctxcsPlanIndexYearHisMapper.selectTYctxcsPlanIndexYearHisById(id);
    }

    /**
     * 查询测算方案参数历史表（按年）列表
     * 
     * @param tYctxcsPlanIndexYearHis 测算方案参数历史表（按年）
     * @return 测算方案参数历史表（按年）
     */
    @Override
    public List<TYctxcsPlanIndexYearHis> selectTYctxcsPlanIndexYearHisList(TYctxcsPlanIndexYearHis tYctxcsPlanIndexYearHis)
    {
        return tYctxcsPlanIndexYearHisMapper.selectTYctxcsPlanIndexYearHisList(tYctxcsPlanIndexYearHis);
    }

    /**
     * 新增测算方案参数历史表（按年）
     * 
     * @param tYctxcsPlanIndexYearHis 测算方案参数历史表（按年）
     * @return 结果
     */
    @Override
    public int insertTYctxcsPlanIndexYearHis(TYctxcsPlanIndexYearHis tYctxcsPlanIndexYearHis)
    {
        return tYctxcsPlanIndexYearHisMapper.insertTYctxcsPlanIndexYearHis(tYctxcsPlanIndexYearHis);
    }

    /**
     * 修改测算方案参数历史表（按年）
     * 
     * @param tYctxcsPlanIndexYearHis 测算方案参数历史表（按年）
     * @return 结果
     */
    @Override
    public int updateTYctxcsPlanIndexYearHis(TYctxcsPlanIndexYearHis tYctxcsPlanIndexYearHis)
    {
        return tYctxcsPlanIndexYearHisMapper.updateTYctxcsPlanIndexYearHis(tYctxcsPlanIndexYearHis);
    }

    /**
     * 批量删除测算方案参数历史表（按年）
     * 
     * @param ids 需要删除的测算方案参数历史表（按年）主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanIndexYearHisByIds(Long[] ids)
    {
        return tYctxcsPlanIndexYearHisMapper.deleteTYctxcsPlanIndexYearHisByIds(ids);
    }

    /**
     * 删除测算方案参数历史表（按年）信息
     * 
     * @param id 测算方案参数历史表（按年）主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanIndexYearHisById(Long id)
    {
        return tYctxcsPlanIndexYearHisMapper.deleteTYctxcsPlanIndexYearHisById(id);
    }
}
