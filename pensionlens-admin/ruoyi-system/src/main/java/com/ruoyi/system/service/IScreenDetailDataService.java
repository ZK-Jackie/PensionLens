package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ScreenDetailData;

/**
 * 大屏空位与大屏数据对照表Service接口
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
public interface IScreenDetailDataService 
{
    /**
     * 查询大屏空位与大屏数据对照表
     * 
     * @param detailId 大屏空位与大屏数据对照表主键
     * @return 大屏空位与大屏数据对照表
     */
    public ScreenDetailData selectScreenDetailDataByDetailId(Long detailId);

    /**
     * 查询大屏空位与大屏数据对照表列表
     * 
     * @param screenDetailData 大屏空位与大屏数据对照表
     * @return 大屏空位与大屏数据对照表集合
     */
    public List<ScreenDetailData> selectScreenDetailDataList(ScreenDetailData screenDetailData);

    /**
     * 新增大屏空位与大屏数据对照表
     * 
     * @param screenDetailData 大屏空位与大屏数据对照表
     * @return 结果
     */
    public int insertScreenDetailData(ScreenDetailData screenDetailData);

    /**
     * 修改大屏空位与大屏数据对照表
     * 
     * @param screenDetailData 大屏空位与大屏数据对照表
     * @return 结果
     */
    public int updateScreenDetailData(ScreenDetailData screenDetailData);

    /**
     * 批量删除大屏空位与大屏数据对照表
     * 
     * @param detailIds 需要删除的大屏空位与大屏数据对照表主键集合
     * @return 结果
     */
    public int deleteScreenDetailDataByDetailIds(Long[] detailIds);

    /**
     * 删除大屏空位与大屏数据对照表信息
     * 
     * @param detailId 大屏空位与大屏数据对照表主键
     * @return 结果
     */
    public int deleteScreenDetailDataByDetailId(Long detailId);
}
