package edu.gdou.pensionlens.service.impl;

import edu.gdou.pensionlens.mapper.ScreenMapper;
import edu.gdou.pensionlens.pojo.Detail;
import edu.gdou.pensionlens.pojo.Screen;
import edu.gdou.pensionlens.service.DetailService;
import edu.gdou.pensionlens.service.ScreenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScreenServiceImpl implements ScreenService {
    @Resource
    private ScreenMapper screenMapper;
    @Resource
    private DetailService detailService;


    @Override
    public Screen getScreenInfo(Integer screenId) {
        // 1. 取 screen 信息
        Screen screen = screenMapper.getScreenInfo(screenId);
        // 2. 用 screenId 先取出 detailIds
        List<Detail> details = detailService.getScreenDetails(screenId);
        // 3. 拼接
        screen.setScreenDetails(details);
        return screen;
    }

    @Override
    public void updateScreenInfo(Screen calcScreen) {
//        screenMapper.insertScreenInfo(calcScreen);
    }
}
