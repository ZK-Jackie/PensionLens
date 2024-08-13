package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPlanIndexUrban;

/**
 * 测算城镇化率参数表Service接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface ITYctxcsPlanIndexUrbanService 
{
    /**
     * 查询测算城镇化率参数表
     * 
     * @param id 测算城镇化率参数表主键
     * @return 测算城镇化率参数表
     */
    public TYctxcsPlanIndexUrban selectTYctxcsPlanIndexUrbanById(Long id);

    /**
     * 查询测算城镇化率参数表列表
     * 
     * @param tYctxcsPlanIndexUrban 测算城镇化率参数表
     * @return 测算城镇化率参数表集合
     */
    public List<TYctxcsPlanIndexUrban> selectTYctxcsPlanIndexUrbanList(TYctxcsPlanIndexUrban tYctxcsPlanIndexUrban);

    /**
     * 新增测算城镇化率参数表
     * 
     * @param tYctxcsPlanIndexUrban 测算城镇化率参数表
     * @return 结果
     */
    public int insertTYctxcsPlanIndexUrban(TYctxcsPlanIndexUrban tYctxcsPlanIndexUrban);

    /**
     * 修改测算城镇化率参数表
     * 
     * @param tYctxcsPlanIndexUrban 测算城镇化率参数表
     * @return 结果
     */
    public int updateTYctxcsPlanIndexUrban(TYctxcsPlanIndexUrban tYctxcsPlanIndexUrban);

    /**
     * 批量删除测算城镇化率参数表
     * 
     * @param ids 需要删除的测算城镇化率参数表主键集合
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexUrbanByIds(Long[] ids);

    /**
     * 删除测算城镇化率参数表信息
     * 
     * @param id 测算城镇化率参数表主键
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexUrbanById(Long id);
}
