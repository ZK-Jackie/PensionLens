package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ScreenColorMapper;
import com.ruoyi.system.domain.ScreenColor;
import com.ruoyi.system.service.IScreenColorService;

/**
 * 大屏颜色设置Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
@Service
public class ScreenColorServiceImpl implements IScreenColorService 
{
    @Autowired
    private ScreenColorMapper screenColorMapper;

    /**
     * 查询大屏颜色设置
     * 
     * @param dataColorId 大屏颜色设置主键
     * @return 大屏颜色设置
     */
    @Override
    public ScreenColor selectScreenColorByDataColorId(Long dataColorId)
    {
        return screenColorMapper.selectScreenColorByDataColorId(dataColorId);
    }

    /**
     * 查询大屏颜色设置列表
     * 
     * @param screenColor 大屏颜色设置
     * @return 大屏颜色设置
     */
    @Override
    public List<ScreenColor> selectScreenColorList(ScreenColor screenColor)
    {
        return screenColorMapper.selectScreenColorList(screenColor);
    }

    /**
     * 新增大屏颜色设置
     * 
     * @param screenColor 大屏颜色设置
     * @return 结果
     */
    @Override
    public int insertScreenColor(ScreenColor screenColor)
    {
        return screenColorMapper.insertScreenColor(screenColor);
    }

    /**
     * 修改大屏颜色设置
     * 
     * @param screenColor 大屏颜色设置
     * @return 结果
     */
    @Override
    public int updateScreenColor(ScreenColor screenColor)
    {
        return screenColorMapper.updateScreenColor(screenColor);
    }

    /**
     * 批量删除大屏颜色设置
     * 
     * @param dataColorIds 需要删除的大屏颜色设置主键
     * @return 结果
     */
    @Override
    public int deleteScreenColorByDataColorIds(Long[] dataColorIds)
    {
        return screenColorMapper.deleteScreenColorByDataColorIds(dataColorIds);
    }

    /**
     * 删除大屏颜色设置信息
     * 
     * @param dataColorId 大屏颜色设置主键
     * @return 结果
     */
    @Override
    public int deleteScreenColorByDataColorId(Long dataColorId)
    {
        return screenColorMapper.deleteScreenColorByDataColorId(dataColorId);
    }
}
