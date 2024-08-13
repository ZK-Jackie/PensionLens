package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ScreenDetailMapper;
import com.ruoyi.system.domain.ScreenDetail;
import com.ruoyi.system.service.IScreenDetailService;

/**
 * 大屏配置表Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
@Service
public class ScreenDetailServiceImpl implements IScreenDetailService 
{
    @Autowired
    private ScreenDetailMapper screenDetailMapper;

    /**
     * 查询大屏配置表
     * 
     * @param detailId 大屏配置表主键
     * @return 大屏配置表
     */
    @Override
    public ScreenDetail selectScreenDetailByDetailId(Long detailId)
    {
        return screenDetailMapper.selectScreenDetailByDetailId(detailId);
    }

    /**
     * 查询大屏配置表列表
     * 
     * @param screenDetail 大屏配置表
     * @return 大屏配置表
     */
    @Override
    public List<ScreenDetail> selectScreenDetailList(ScreenDetail screenDetail)
    {
        return screenDetailMapper.selectScreenDetailList(screenDetail);
    }

    /**
     * 新增大屏配置表
     * 
     * @param screenDetail 大屏配置表
     * @return 结果
     */
    @Override
    public int insertScreenDetail(ScreenDetail screenDetail)
    {
        return screenDetailMapper.insertScreenDetail(screenDetail);
    }

    /**
     * 修改大屏配置表
     * 
     * @param screenDetail 大屏配置表
     * @return 结果
     */
    @Override
    public int updateScreenDetail(ScreenDetail screenDetail)
    {
        return screenDetailMapper.updateScreenDetail(screenDetail);
    }

    /**
     * 批量删除大屏配置表
     * 
     * @param detailIds 需要删除的大屏配置表主键
     * @return 结果
     */
    @Override
    public int deleteScreenDetailByDetailIds(Long[] detailIds)
    {
        return screenDetailMapper.deleteScreenDetailByDetailIds(detailIds);
    }

    /**
     * 删除大屏配置表信息
     * 
     * @param detailId 大屏配置表主键
     * @return 结果
     */
    @Override
    public int deleteScreenDetailByDetailId(Long detailId)
    {
        return screenDetailMapper.deleteScreenDetailByDetailId(detailId);
    }
}
