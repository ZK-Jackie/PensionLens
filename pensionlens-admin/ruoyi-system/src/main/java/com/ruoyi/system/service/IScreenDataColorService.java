package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ScreenDataColor;

/**
 * 大屏数据颜色设置Service接口
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
public interface IScreenDataColorService 
{
    /**
     * 查询大屏数据颜色设置
     * 
     * @param dataColorId 大屏数据颜色设置主键
     * @return 大屏数据颜色设置
     */
    public ScreenDataColor selectScreenDataColorByDataColorId(Long dataColorId);

    /**
     * 查询大屏数据颜色设置列表
     * 
     * @param screenDataColor 大屏数据颜色设置
     * @return 大屏数据颜色设置集合
     */
    public List<ScreenDataColor> selectScreenDataColorList(ScreenDataColor screenDataColor);

    /**
     * 新增大屏数据颜色设置
     * 
     * @param screenDataColor 大屏数据颜色设置
     * @return 结果
     */
    public int insertScreenDataColor(ScreenDataColor screenDataColor);

    /**
     * 修改大屏数据颜色设置
     * 
     * @param screenDataColor 大屏数据颜色设置
     * @return 结果
     */
    public int updateScreenDataColor(ScreenDataColor screenDataColor);

    /**
     * 批量删除大屏数据颜色设置
     * 
     * @param dataColorIds 需要删除的大屏数据颜色设置主键集合
     * @return 结果
     */
    public int deleteScreenDataColorByDataColorIds(Long[] dataColorIds);

    /**
     * 删除大屏数据颜色设置信息
     * 
     * @param dataColorId 大屏数据颜色设置主键
     * @return 结果
     */
    public int deleteScreenDataColorByDataColorId(Long dataColorId);
}
