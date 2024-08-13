package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsPlanIndexAgeMapper;
import com.ruoyi.system.domain.TYctxcsPlanIndexAge;
import com.ruoyi.system.service.ITYctxcsPlanIndexAgeService;

/**
 * 测算方案参数表（按年龄）Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsPlanIndexAgeServiceImpl implements ITYctxcsPlanIndexAgeService 
{
    @Autowired
    private TYctxcsPlanIndexAgeMapper tYctxcsPlanIndexAgeMapper;

    /**
     * 查询测算方案参数表（按年龄）
     * 
     * @param id 测算方案参数表（按年龄）主键
     * @return 测算方案参数表（按年龄）
     */
    @Override
    public TYctxcsPlanIndexAge selectTYctxcsPlanIndexAgeById(Long id)
    {
        return tYctxcsPlanIndexAgeMapper.selectTYctxcsPlanIndexAgeById(id);
    }

    /**
     * 查询测算方案参数表（按年龄）列表
     * 
     * @param tYctxcsPlanIndexAge 测算方案参数表（按年龄）
     * @return 测算方案参数表（按年龄）
     */
    @Override
    public List<TYctxcsPlanIndexAge> selectTYctxcsPlanIndexAgeList(TYctxcsPlanIndexAge tYctxcsPlanIndexAge)
    {
        return tYctxcsPlanIndexAgeMapper.selectTYctxcsPlanIndexAgeList(tYctxcsPlanIndexAge);
    }

    /**
     * 新增测算方案参数表（按年龄）
     * 
     * @param tYctxcsPlanIndexAge 测算方案参数表（按年龄）
     * @return 结果
     */
    @Override
    public int insertTYctxcsPlanIndexAge(TYctxcsPlanIndexAge tYctxcsPlanIndexAge)
    {
        return tYctxcsPlanIndexAgeMapper.insertTYctxcsPlanIndexAge(tYctxcsPlanIndexAge);
    }

    /**
     * 修改测算方案参数表（按年龄）
     * 
     * @param tYctxcsPlanIndexAge 测算方案参数表（按年龄）
     * @return 结果
     */
    @Override
    public int updateTYctxcsPlanIndexAge(TYctxcsPlanIndexAge tYctxcsPlanIndexAge)
    {
        return tYctxcsPlanIndexAgeMapper.updateTYctxcsPlanIndexAge(tYctxcsPlanIndexAge);
    }

    /**
     * 批量删除测算方案参数表（按年龄）
     * 
     * @param ids 需要删除的测算方案参数表（按年龄）主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanIndexAgeByIds(Long[] ids)
    {
        return tYctxcsPlanIndexAgeMapper.deleteTYctxcsPlanIndexAgeByIds(ids);
    }

    /**
     * 删除测算方案参数表（按年龄）信息
     * 
     * @param id 测算方案参数表（按年龄）主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanIndexAgeById(Long id)
    {
        return tYctxcsPlanIndexAgeMapper.deleteTYctxcsPlanIndexAgeById(id);
    }
}
