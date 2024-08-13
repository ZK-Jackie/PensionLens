package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsPlanIndexYearMapper;
import com.ruoyi.system.domain.TYctxcsPlanIndexYear;
import com.ruoyi.system.service.ITYctxcsPlanIndexYearService;

/**
 * 测算方案参数表（按年）Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsPlanIndexYearServiceImpl implements ITYctxcsPlanIndexYearService 
{
    @Autowired
    private TYctxcsPlanIndexYearMapper tYctxcsPlanIndexYearMapper;

    /**
     * 查询测算方案参数表（按年）
     * 
     * @param id 测算方案参数表（按年）主键
     * @return 测算方案参数表（按年）
     */
    @Override
    public TYctxcsPlanIndexYear selectTYctxcsPlanIndexYearById(Long id)
    {
        return tYctxcsPlanIndexYearMapper.selectTYctxcsPlanIndexYearById(id);
    }

    /**
     * 查询测算方案参数表（按年）列表
     * 
     * @param tYctxcsPlanIndexYear 测算方案参数表（按年）
     * @return 测算方案参数表（按年）
     */
    @Override
    public List<TYctxcsPlanIndexYear> selectTYctxcsPlanIndexYearList(TYctxcsPlanIndexYear tYctxcsPlanIndexYear)
    {
        return tYctxcsPlanIndexYearMapper.selectTYctxcsPlanIndexYearList(tYctxcsPlanIndexYear);
    }

    /**
     * 新增测算方案参数表（按年）
     * 
     * @param tYctxcsPlanIndexYear 测算方案参数表（按年）
     * @return 结果
     */
    @Override
    public int insertTYctxcsPlanIndexYear(TYctxcsPlanIndexYear tYctxcsPlanIndexYear)
    {
        return tYctxcsPlanIndexYearMapper.insertTYctxcsPlanIndexYear(tYctxcsPlanIndexYear);
    }

    /**
     * 修改测算方案参数表（按年）
     * 
     * @param tYctxcsPlanIndexYear 测算方案参数表（按年）
     * @return 结果
     */
    @Override
    public int updateTYctxcsPlanIndexYear(TYctxcsPlanIndexYear tYctxcsPlanIndexYear)
    {
        return tYctxcsPlanIndexYearMapper.updateTYctxcsPlanIndexYear(tYctxcsPlanIndexYear);
    }

    /**
     * 批量删除测算方案参数表（按年）
     * 
     * @param ids 需要删除的测算方案参数表（按年）主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanIndexYearByIds(Long[] ids)
    {
        return tYctxcsPlanIndexYearMapper.deleteTYctxcsPlanIndexYearByIds(ids);
    }

    /**
     * 删除测算方案参数表（按年）信息
     * 
     * @param id 测算方案参数表（按年）主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsPlanIndexYearById(Long id)
    {
        return tYctxcsPlanIndexYearMapper.deleteTYctxcsPlanIndexYearById(id);
    }
}
