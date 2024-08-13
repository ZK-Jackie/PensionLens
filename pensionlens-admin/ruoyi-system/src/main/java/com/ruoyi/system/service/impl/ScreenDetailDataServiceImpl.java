package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ScreenDetailDataMapper;
import com.ruoyi.system.domain.ScreenDetailData;
import com.ruoyi.system.service.IScreenDetailDataService;

/**
 * 大屏空位与大屏数据对照表Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
@Service
public class ScreenDetailDataServiceImpl implements IScreenDetailDataService 
{
    @Autowired
    private ScreenDetailDataMapper screenDetailDataMapper;

    /**
     * 查询大屏空位与大屏数据对照表
     * 
     * @param detailId 大屏空位与大屏数据对照表主键
     * @return 大屏空位与大屏数据对照表
     */
    @Override
    public ScreenDetailData selectScreenDetailDataByDetailId(Long detailId)
    {
        return screenDetailDataMapper.selectScreenDetailDataByDetailId(detailId);
    }

    /**
     * 查询大屏空位与大屏数据对照表列表
     * 
     * @param screenDetailData 大屏空位与大屏数据对照表
     * @return 大屏空位与大屏数据对照表
     */
    @Override
    public List<ScreenDetailData> selectScreenDetailDataList(ScreenDetailData screenDetailData)
    {
        return screenDetailDataMapper.selectScreenDetailDataList(screenDetailData);
    }

    /**
     * 新增大屏空位与大屏数据对照表
     * 
     * @param screenDetailData 大屏空位与大屏数据对照表
     * @return 结果
     */
    @Override
    public int insertScreenDetailData(ScreenDetailData screenDetailData)
    {
        return screenDetailDataMapper.insertScreenDetailData(screenDetailData);
    }

    /**
     * 修改大屏空位与大屏数据对照表
     * 
     * @param screenDetailData 大屏空位与大屏数据对照表
     * @return 结果
     */
    @Override
    public int updateScreenDetailData(ScreenDetailData screenDetailData)
    {
        return screenDetailDataMapper.updateScreenDetailData(screenDetailData);
    }

    /**
     * 批量删除大屏空位与大屏数据对照表
     * 
     * @param detailIds 需要删除的大屏空位与大屏数据对照表主键
     * @return 结果
     */
    @Override
    public int deleteScreenDetailDataByDetailIds(Long[] detailIds)
    {
        return screenDetailDataMapper.deleteScreenDetailDataByDetailIds(detailIds);
    }

    /**
     * 删除大屏空位与大屏数据对照表信息
     * 
     * @param detailId 大屏空位与大屏数据对照表主键
     * @return 结果
     */
    @Override
    public int deleteScreenDetailDataByDetailId(Long detailId)
    {
        return screenDetailDataMapper.deleteScreenDetailDataByDetailId(detailId);
    }
}
