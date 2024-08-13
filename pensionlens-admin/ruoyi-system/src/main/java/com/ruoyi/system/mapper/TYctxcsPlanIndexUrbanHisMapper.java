package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPlanIndexUrbanHis;

/**
 * 测算城镇化率历史表Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface TYctxcsPlanIndexUrbanHisMapper 
{
    /**
     * 查询测算城镇化率历史表
     * 
     * @param id 测算城镇化率历史表主键
     * @return 测算城镇化率历史表
     */
    public TYctxcsPlanIndexUrbanHis selectTYctxcsPlanIndexUrbanHisById(Long id);

    /**
     * 查询测算城镇化率历史表列表
     * 
     * @param tYctxcsPlanIndexUrbanHis 测算城镇化率历史表
     * @return 测算城镇化率历史表集合
     */
    public List<TYctxcsPlanIndexUrbanHis> selectTYctxcsPlanIndexUrbanHisList(TYctxcsPlanIndexUrbanHis tYctxcsPlanIndexUrbanHis);

    /**
     * 新增测算城镇化率历史表
     * 
     * @param tYctxcsPlanIndexUrbanHis 测算城镇化率历史表
     * @return 结果
     */
    public int insertTYctxcsPlanIndexUrbanHis(TYctxcsPlanIndexUrbanHis tYctxcsPlanIndexUrbanHis);

    /**
     * 修改测算城镇化率历史表
     * 
     * @param tYctxcsPlanIndexUrbanHis 测算城镇化率历史表
     * @return 结果
     */
    public int updateTYctxcsPlanIndexUrbanHis(TYctxcsPlanIndexUrbanHis tYctxcsPlanIndexUrbanHis);

    /**
     * 删除测算城镇化率历史表
     * 
     * @param id 测算城镇化率历史表主键
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexUrbanHisById(Long id);

    /**
     * 批量删除测算城镇化率历史表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexUrbanHisByIds(Long[] ids);
}
