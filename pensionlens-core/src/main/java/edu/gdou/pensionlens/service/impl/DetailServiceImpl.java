package edu.gdou.pensionlens.service.impl;

import edu.gdou.pensionlens.mapper.DetailMapper;
import edu.gdou.pensionlens.pojo.Detail;
import edu.gdou.pensionlens.pojo.DetailData;
import edu.gdou.pensionlens.service.DetailDataService;
import edu.gdou.pensionlens.service.DetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {
    @Resource
    private DetailMapper detailMapper;
    @Resource
    private DetailDataService detailDataService;

    @Override
    public List<Detail> getScreenDetails(Integer screenId){
        // 1. 取出当前 screen 的所有 detail，但 detailData 信息空缺
        List<Detail> pre_details = detailMapper.getScreenDetails(screenId);
        // 2. 让 detailData 查询、按要求处理、补好发回来
        for (Detail detail : pre_details) {
            List<DetailData> detailData = detailDataService.getDetailData(detail.getDetailId());
            detail.setDetailData(detailData);
        }
        // 3. 补完，返回
        return pre_details;
    }
}
