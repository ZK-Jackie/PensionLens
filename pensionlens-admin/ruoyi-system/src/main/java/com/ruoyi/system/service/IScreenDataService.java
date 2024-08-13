package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ScreenData;

/**
 * 大屏数据定位Service接口
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
public interface IScreenDataService 
{
    /**
     * 查询大屏数据定位
     * 
     * @param dataId 大屏数据定位主键
     * @return 大屏数据定位
     */
    public ScreenData selectScreenDataByDataId(Long dataId);

    /**
     * 查询大屏数据定位列表
     * 
     * @param screenData 大屏数据定位
     * @return 大屏数据定位集合
     */
    public List<ScreenData> selectScreenDataList(ScreenData screenData);

    /**
     * 新增大屏数据定位
     * 
     * @param screenData 大屏数据定位
     * @return 结果
     */
    public int insertScreenData(ScreenData screenData);

    /**
     * 修改大屏数据定位
     * 
     * @param screenData 大屏数据定位
     * @return 结果
     */
    public int updateScreenData(ScreenData screenData);

    /**
     * 批量删除大屏数据定位
     * 
     * @param dataIds 需要删除的大屏数据定位主键集合
     * @return 结果
     */
    public int deleteScreenDataByDataIds(Long[] dataIds);

    /**
     * 删除大屏数据定位信息
     * 
     * @param dataId 大屏数据定位主键
     * @return 结果
     */
    public int deleteScreenDataByDataId(Long dataId);
}
