package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ScreenDataColorMapper;
import com.ruoyi.system.domain.ScreenDataColor;
import com.ruoyi.system.service.IScreenDataColorService;

/**
 * 大屏数据颜色设置Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
@Service
public class ScreenDataColorServiceImpl implements IScreenDataColorService 
{
    @Autowired
    private ScreenDataColorMapper screenDataColorMapper;

    /**
     * 查询大屏数据颜色设置
     * 
     * @param dataColorId 大屏数据颜色设置主键
     * @return 大屏数据颜色设置
     */
    @Override
    public ScreenDataColor selectScreenDataColorByDataColorId(Long dataColorId)
    {
        return screenDataColorMapper.selectScreenDataColorByDataColorId(dataColorId);
    }

    /**
     * 查询大屏数据颜色设置列表
     * 
     * @param screenDataColor 大屏数据颜色设置
     * @return 大屏数据颜色设置
     */
    @Override
    public List<ScreenDataColor> selectScreenDataColorList(ScreenDataColor screenDataColor)
    {
        return screenDataColorMapper.selectScreenDataColorList(screenDataColor);
    }

    /**
     * 新增大屏数据颜色设置
     * 
     * @param screenDataColor 大屏数据颜色设置
     * @return 结果
     */
    @Override
    public int insertScreenDataColor(ScreenDataColor screenDataColor)
    {
        return screenDataColorMapper.insertScreenDataColor(screenDataColor);
    }

    /**
     * 修改大屏数据颜色设置
     * 
     * @param screenDataColor 大屏数据颜色设置
     * @return 结果
     */
    @Override
    public int updateScreenDataColor(ScreenDataColor screenDataColor)
    {
        return screenDataColorMapper.updateScreenDataColor(screenDataColor);
    }

    /**
     * 批量删除大屏数据颜色设置
     * 
     * @param dataColorIds 需要删除的大屏数据颜色设置主键
     * @return 结果
     */
    @Override
    public int deleteScreenDataColorByDataColorIds(Long[] dataColorIds)
    {
        return screenDataColorMapper.deleteScreenDataColorByDataColorIds(dataColorIds);
    }

    /**
     * 删除大屏数据颜色设置信息
     * 
     * @param dataColorId 大屏数据颜色设置主键
     * @return 结果
     */
    @Override
    public int deleteScreenDataColorByDataColorId(Long dataColorId)
    {
        return screenDataColorMapper.deleteScreenDataColorByDataColorId(dataColorId);
    }
}
