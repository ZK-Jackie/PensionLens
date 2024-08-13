package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ScreenColor;

/**
 * 大屏颜色设置Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
public interface ScreenColorMapper 
{
    /**
     * 查询大屏颜色设置
     * 
     * @param dataColorId 大屏颜色设置主键
     * @return 大屏颜色设置
     */
    public ScreenColor selectScreenColorByDataColorId(Long dataColorId);

    /**
     * 查询大屏颜色设置列表
     * 
     * @param screenColor 大屏颜色设置
     * @return 大屏颜色设置集合
     */
    public List<ScreenColor> selectScreenColorList(ScreenColor screenColor);

    /**
     * 新增大屏颜色设置
     * 
     * @param screenColor 大屏颜色设置
     * @return 结果
     */
    public int insertScreenColor(ScreenColor screenColor);

    /**
     * 修改大屏颜色设置
     * 
     * @param screenColor 大屏颜色设置
     * @return 结果
     */
    public int updateScreenColor(ScreenColor screenColor);

    /**
     * 删除大屏颜色设置
     * 
     * @param dataColorId 大屏颜色设置主键
     * @return 结果
     */
    public int deleteScreenColorByDataColorId(Long dataColorId);

    /**
     * 批量删除大屏颜色设置
     * 
     * @param dataColorIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteScreenColorByDataColorIds(Long[] dataColorIds);
}
