package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ScreenDetail;

/**
 * 大屏配置表Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
public interface ScreenDetailMapper 
{
    /**
     * 查询大屏配置表
     * 
     * @param detailId 大屏配置表主键
     * @return 大屏配置表
     */
    public ScreenDetail selectScreenDetailByDetailId(Long detailId);

    /**
     * 查询大屏配置表列表
     * 
     * @param screenDetail 大屏配置表
     * @return 大屏配置表集合
     */
    public List<ScreenDetail> selectScreenDetailList(ScreenDetail screenDetail);

    /**
     * 新增大屏配置表
     * 
     * @param screenDetail 大屏配置表
     * @return 结果
     */
    public int insertScreenDetail(ScreenDetail screenDetail);

    /**
     * 修改大屏配置表
     * 
     * @param screenDetail 大屏配置表
     * @return 结果
     */
    public int updateScreenDetail(ScreenDetail screenDetail);

    /**
     * 删除大屏配置表
     * 
     * @param detailId 大屏配置表主键
     * @return 结果
     */
    public int deleteScreenDetailByDetailId(Long detailId);

    /**
     * 批量删除大屏配置表
     * 
     * @param detailIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteScreenDetailByDetailIds(Long[] detailIds);
}
