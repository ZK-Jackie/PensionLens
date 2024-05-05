package edu.gdou.pensionlens.service.impl;

import edu.gdou.pensionlens.mapper.ScreenMapper;
import edu.gdou.pensionlens.service.ScreenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScreenServiceImpl implements ScreenService {
    @Resource
    private ScreenMapper screenMapper;


    @Override
    public List<Integer> getScreenDetailIds(Integer screenId) {
        // 示例：处理数据库返回的数据
        List<Integer> screenDetailIds = screenMapper.getScreenDetailIds(screenId);
        screenDetailIds.sort(Integer::compareTo);
        // 示例：返回处理后的数据
        return screenDetailIds;
    }
}
