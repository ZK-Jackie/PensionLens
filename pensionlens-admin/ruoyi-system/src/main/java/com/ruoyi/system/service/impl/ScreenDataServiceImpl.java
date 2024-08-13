package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ScreenDataMapper;
import com.ruoyi.system.domain.ScreenData;
import com.ruoyi.system.service.IScreenDataService;

/**
 * 大屏数据定位Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
@Service
public class ScreenDataServiceImpl implements IScreenDataService 
{
    @Autowired
    private ScreenDataMapper screenDataMapper;

    /**
     * 查询大屏数据定位
     * 
     * @param dataId 大屏数据定位主键
     * @return 大屏数据定位
     */
    @Override
    public ScreenData selectScreenDataByDataId(Long dataId)
    {
        return screenDataMapper.selectScreenDataByDataId(dataId);
    }

    /**
     * 查询大屏数据定位列表
     * 
     * @param screenData 大屏数据定位
     * @return 大屏数据定位
     */
    @Override
    public List<ScreenData> selectScreenDataList(ScreenData screenData)
    {
        return screenDataMapper.selectScreenDataList(screenData);
    }

    /**
     * 新增大屏数据定位
     * 
     * @param screenData 大屏数据定位
     * @return 结果
     */
    @Override
    public int insertScreenData(ScreenData screenData)
    {
        return screenDataMapper.insertScreenData(screenData);
    }

    /**
     * 修改大屏数据定位
     * 
     * @param screenData 大屏数据定位
     * @return 结果
     */
    @Override
    public int updateScreenData(ScreenData screenData)
    {
        return screenDataMapper.updateScreenData(screenData);
    }

    /**
     * 批量删除大屏数据定位
     * 
     * @param dataIds 需要删除的大屏数据定位主键
     * @return 结果
     */
    @Override
    public int deleteScreenDataByDataIds(Long[] dataIds)
    {
        return screenDataMapper.deleteScreenDataByDataIds(dataIds);
    }

    /**
     * 删除大屏数据定位信息
     * 
     * @param dataId 大屏数据定位主键
     * @return 结果
     */
    @Override
    public int deleteScreenDataByDataId(Long dataId)
    {
        return screenDataMapper.deleteScreenDataByDataId(dataId);
    }
}
