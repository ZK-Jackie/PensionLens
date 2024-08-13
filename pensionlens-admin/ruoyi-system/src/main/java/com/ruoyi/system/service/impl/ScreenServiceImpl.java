package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ScreenMapper;
import com.ruoyi.system.domain.Screen;
import com.ruoyi.system.service.IScreenService;

/**
 * 大屏表Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
@Service
public class ScreenServiceImpl implements IScreenService 
{
    @Autowired
    private ScreenMapper screenMapper;

    /**
     * 查询大屏表
     * 
     * @param screenId 大屏表主键
     * @return 大屏表
     */
    @Override
    public Screen selectScreenByScreenId(Long screenId)
    {
        return screenMapper.selectScreenByScreenId(screenId);
    }

    /**
     * 查询大屏表列表
     * 
     * @param screen 大屏表
     * @return 大屏表
     */
    @Override
    public List<Screen> selectScreenList(Screen screen)
    {
        return screenMapper.selectScreenList(screen);
    }

    /**
     * 新增大屏表
     * 
     * @param screen 大屏表
     * @return 结果
     */
    @Override
    public int insertScreen(Screen screen)
    {
        screen.setCreateTime(DateUtils.getNowDate());
        return screenMapper.insertScreen(screen);
    }

    /**
     * 修改大屏表
     * 
     * @param screen 大屏表
     * @return 结果
     */
    @Override
    public int updateScreen(Screen screen)
    {
        return screenMapper.updateScreen(screen);
    }

    /**
     * 批量删除大屏表
     * 
     * @param screenIds 需要删除的大屏表主键
     * @return 结果
     */
    @Override
    public int deleteScreenByScreenIds(Long[] screenIds)
    {
        return screenMapper.deleteScreenByScreenIds(screenIds);
    }

    /**
     * 删除大屏表信息
     * 
     * @param screenId 大屏表主键
     * @return 结果
     */
    @Override
    public int deleteScreenByScreenId(Long screenId)
    {
        return screenMapper.deleteScreenByScreenId(screenId);
    }
}
