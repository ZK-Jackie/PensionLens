package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Screen;

/**
 * 大屏表Service接口
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
public interface IScreenService 
{
    /**
     * 查询大屏表
     * 
     * @param screenId 大屏表主键
     * @return 大屏表
     */
    public Screen selectScreenByScreenId(Long screenId);

    /**
     * 查询大屏表列表
     * 
     * @param screen 大屏表
     * @return 大屏表集合
     */
    public List<Screen> selectScreenList(Screen screen);

    /**
     * 新增大屏表
     * 
     * @param screen 大屏表
     * @return 结果
     */
    public int insertScreen(Screen screen);

    /**
     * 修改大屏表
     * 
     * @param screen 大屏表
     * @return 结果
     */
    public int updateScreen(Screen screen);

    /**
     * 批量删除大屏表
     * 
     * @param screenIds 需要删除的大屏表主键集合
     * @return 结果
     */
    public int deleteScreenByScreenIds(Long[] screenIds);

    /**
     * 删除大屏表信息
     * 
     * @param screenId 大屏表主键
     * @return 结果
     */
    public int deleteScreenByScreenId(Long screenId);
}
