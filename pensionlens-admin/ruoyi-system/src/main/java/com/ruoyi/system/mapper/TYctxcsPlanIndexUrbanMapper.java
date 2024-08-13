package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsPlanIndexUrban;

/**
 * 测算城镇化率参数表Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface TYctxcsPlanIndexUrbanMapper 
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
     * 删除测算城镇化率参数表
     * 
     * @param id 测算城镇化率参数表主键
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexUrbanById(Long id);

    /**
     * 批量删除测算城镇化率参数表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTYctxcsPlanIndexUrbanByIds(Long[] ids);
}
