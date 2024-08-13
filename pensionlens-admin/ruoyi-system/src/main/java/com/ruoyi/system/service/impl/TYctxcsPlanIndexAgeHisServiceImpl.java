package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsPlanIndexAgeHisMapper;
import com.ruoyi.system.domain.TYctxcsPlanIndexAgeHis;
import com.ruoyi.system.service.ITYctxcsPlanIndexAgeHisService;

/**
 * 测算方案参数历史表（按年龄）Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsPlanIndexAgeHisServiceImpl implements ITYctxcsPlanIndexAgeHisService 
{
    @Autowired
    private TYctxcsPlanIndexAgeHisMapper tYctxcsPlanIndexAgeHisMapper;

    /**
     * 查询测算方案参数历史表（按年龄）
     * 
     * @param id 测算方案参数历史表（按年龄）主键
     * @return 测算方案参数历史表（按年龄）
     */
    @Override
    public TYctxcsPlanIndexAgeHis selectTYctxcsPlanIndexAgeHisById(Long id)
    {
        return tYctxcsPlanIndexAgeHisMapper.selectTYctxcsPlanIndexAgeHisById(id);
    }

    /**
     * 查询测算方案参数历史表（按年龄）列表
     * 
     * @param tYctxcsPlanIndexAgeHis 测算方案参数历史表（按年龄）
     * @return 测算方案参数历史表（按年龄）
     */
    @Override
    public List<TYctxcsPlanIndexAgeHis> selectTYctxcsPlanIndexAgeHisList(TYctxcsPlanIndexAgeHis tYctxcsPlanIndexAgeHis)
    {
        return tYctxcsPlanIndexAgeHisMapper.selectTYctxcsPlanIndexAgeHisList(tYctxcsPlanIndexAgeHis);
    }

    /**
     * 新增测算方案参数历史表（按年龄）
     * 
     * @param tYctxcsPlanIndexAgeHis 测算方案参数历史表（按年龄）
     * @return 结果
     */
    @Override
    public int insertTYctxcsPlanIndexAgeHis(TYctxcsPlanIndexAgeHis tYctxcsPlanIndexAgeHis)
    {
        return tYctxcsPlanIndexAgeHisMapper.insertTYctxcsPlanIndexAgeHis(tYctxcsPlanIndexAgeHis);
    }

    /**
     * 修改测算方案参数历史表（按年龄）
     * 
     * @param tYctxcsPlanIndexAgeHis 测算方案参数历史表（按年龄）
     * @return 结果
     */
    @Override
    public int updateTYctxcsPlanIndexAgeHis(TYctxcsPlanIndexAgeHis tYctxcsPlanIndexAgeHis)
    {
        return tYctxcsPlanIndexAgeHisMapper.updateTYctxcsPlanIndexAgeHis(tYctxcsPlanIndexAgeHis);
    }

    /**
     * 批量删除测算方案参数历史表（按年龄）
     * 
     * @param ids 需要删除的测算方案参数历史表（按年龄）主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanIndexAgeHisByIds(Long[] ids)
    {
        return tYctxcsPlanIndexAgeHisMapper.deleteTYctxcsPlanIndexAgeHisByIds(ids);
    }

    /**
     * 删除测算方案参数历史表（按年龄）信息
     * 
     * @param id 测算方案参数历史表（按年龄）主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanIndexAgeHisById(Long id)
    {
        return tYctxcsPlanIndexAgeHisMapper.deleteTYctxcsPlanIndexAgeHisById(id);
    }
}
