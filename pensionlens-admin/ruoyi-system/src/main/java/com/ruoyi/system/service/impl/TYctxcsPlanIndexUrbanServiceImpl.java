package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsPlanIndexUrbanMapper;
import com.ruoyi.system.domain.TYctxcsPlanIndexUrban;
import com.ruoyi.system.service.ITYctxcsPlanIndexUrbanService;

/**
 * 测算城镇化率参数表Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsPlanIndexUrbanServiceImpl implements ITYctxcsPlanIndexUrbanService 
{
    @Autowired
    private TYctxcsPlanIndexUrbanMapper tYctxcsPlanIndexUrbanMapper;

    /**
     * 查询测算城镇化率参数表
     * 
     * @param id 测算城镇化率参数表主键
     * @return 测算城镇化率参数表
     */
    @Override
    public TYctxcsPlanIndexUrban selectTYctxcsPlanIndexUrbanById(Long id)
    {
        return tYctxcsPlanIndexUrbanMapper.selectTYctxcsPlanIndexUrbanById(id);
    }

    /**
     * 查询测算城镇化率参数表列表
     * 
     * @param tYctxcsPlanIndexUrban 测算城镇化率参数表
     * @return 测算城镇化率参数表
     */
    @Override
    public List<TYctxcsPlanIndexUrban> selectTYctxcsPlanIndexUrbanList(TYctxcsPlanIndexUrban tYctxcsPlanIndexUrban)
    {
        return tYctxcsPlanIndexUrbanMapper.selectTYctxcsPlanIndexUrbanList(tYctxcsPlanIndexUrban);
    }

    /**
     * 新增测算城镇化率参数表
     * 
     * @param tYctxcsPlanIndexUrban 测算城镇化率参数表
     * @return 结果
     */
    @Override
    public int insertTYctxcsPlanIndexUrban(TYctxcsPlanIndexUrban tYctxcsPlanIndexUrban)
    {
        return tYctxcsPlanIndexUrbanMapper.insertTYctxcsPlanIndexUrban(tYctxcsPlanIndexUrban);
    }

    /**
     * 修改测算城镇化率参数表
     * 
     * @param tYctxcsPlanIndexUrban 测算城镇化率参数表
     * @return 结果
     */
    @Override
    public int updateTYctxcsPlanIndexUrban(TYctxcsPlanIndexUrban tYctxcsPlanIndexUrban)
    {
        return tYctxcsPlanIndexUrbanMapper.updateTYctxcsPlanIndexUrban(tYctxcsPlanIndexUrban);
    }

    /**
     * 批量删除测算城镇化率参数表
     * 
     * @param ids 需要删除的测算城镇化率参数表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanIndexUrbanByIds(Long[] ids)
    {
        return tYctxcsPlanIndexUrbanMapper.deleteTYctxcsPlanIndexUrbanByIds(ids);
    }

    /**
     * 删除测算城镇化率参数表信息
     * 
     * @param id 测算城镇化率参数表主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanIndexUrbanById(Long id)
    {
        return tYctxcsPlanIndexUrbanMapper.deleteTYctxcsPlanIndexUrbanById(id);
    }
}
