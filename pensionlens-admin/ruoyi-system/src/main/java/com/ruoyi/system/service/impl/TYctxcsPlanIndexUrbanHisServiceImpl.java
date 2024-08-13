package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsPlanIndexUrbanHisMapper;
import com.ruoyi.system.domain.TYctxcsPlanIndexUrbanHis;
import com.ruoyi.system.service.ITYctxcsPlanIndexUrbanHisService;

/**
 * 测算城镇化率历史表Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsPlanIndexUrbanHisServiceImpl implements ITYctxcsPlanIndexUrbanHisService 
{
    @Autowired
    private TYctxcsPlanIndexUrbanHisMapper tYctxcsPlanIndexUrbanHisMapper;

    /**
     * 查询测算城镇化率历史表
     * 
     * @param id 测算城镇化率历史表主键
     * @return 测算城镇化率历史表
     */
    @Override
    public TYctxcsPlanIndexUrbanHis selectTYctxcsPlanIndexUrbanHisById(Long id)
    {
        return tYctxcsPlanIndexUrbanHisMapper.selectTYctxcsPlanIndexUrbanHisById(id);
    }

    /**
     * 查询测算城镇化率历史表列表
     * 
     * @param tYctxcsPlanIndexUrbanHis 测算城镇化率历史表
     * @return 测算城镇化率历史表
     */
    @Override
    public List<TYctxcsPlanIndexUrbanHis> selectTYctxcsPlanIndexUrbanHisList(TYctxcsPlanIndexUrbanHis tYctxcsPlanIndexUrbanHis)
    {
        return tYctxcsPlanIndexUrbanHisMapper.selectTYctxcsPlanIndexUrbanHisList(tYctxcsPlanIndexUrbanHis);
    }

    /**
     * 新增测算城镇化率历史表
     * 
     * @param tYctxcsPlanIndexUrbanHis 测算城镇化率历史表
     * @return 结果
     */
    @Override
    public int insertTYctxcsPlanIndexUrbanHis(TYctxcsPlanIndexUrbanHis tYctxcsPlanIndexUrbanHis)
    {
        return tYctxcsPlanIndexUrbanHisMapper.insertTYctxcsPlanIndexUrbanHis(tYctxcsPlanIndexUrbanHis);
    }

    /**
     * 修改测算城镇化率历史表
     * 
     * @param tYctxcsPlanIndexUrbanHis 测算城镇化率历史表
     * @return 结果
     */
    @Override
    public int updateTYctxcsPlanIndexUrbanHis(TYctxcsPlanIndexUrbanHis tYctxcsPlanIndexUrbanHis)
    {
        return tYctxcsPlanIndexUrbanHisMapper.updateTYctxcsPlanIndexUrbanHis(tYctxcsPlanIndexUrbanHis);
    }

    /**
     * 批量删除测算城镇化率历史表
     * 
     * @param ids 需要删除的测算城镇化率历史表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanIndexUrbanHisByIds(Long[] ids)
    {
        return tYctxcsPlanIndexUrbanHisMapper.deleteTYctxcsPlanIndexUrbanHisByIds(ids);
    }

    /**
     * 删除测算城镇化率历史表信息
     * 
     * @param id 测算城镇化率历史表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanIndexUrbanHisById(Long id)
    {
        return tYctxcsPlanIndexUrbanHisMapper.deleteTYctxcsPlanIndexUrbanHisById(id);
    }
}
