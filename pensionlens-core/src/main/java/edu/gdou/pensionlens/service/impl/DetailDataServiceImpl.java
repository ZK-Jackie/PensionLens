package edu.gdou.pensionlens.service.impl;

import cn.hutool.core.date.DateTime;
import edu.gdou.pensionlens.config.MapResultHandler;
import edu.gdou.pensionlens.mapper.DetailDataMapper;
import edu.gdou.pensionlens.pojo.DetailData;
import edu.gdou.pensionlens.service.DetailDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DetailDataServiceImpl implements DetailDataService {
    @Resource
    private DetailDataMapper detailDataMapper;

    @Override
    public List<DetailData> getDetailData(Integer detailId) {
        // 1. 取出所有不带具体数据参数的 detailData
        List<DetailData> detailDataList = detailDataMapper.getDetailData(detailId);
        // 2. 根据 dataLocation、start/endTime 去特定的表拿特定年份的数据
        for (DetailData detailData : detailDataList) {
            if(detailData.getDataName().get(0).equals("总和生育率")){
                List<String> buttonNames = List.of("高生育模式", "中生育模式", "低生育模式");
                List<Integer> buttonVals = List.of(3, 2, 1);
                List<Object> combines = List.of(buttonNames, buttonVals);
                detailData.setData(combines);
                continue;
            }
            if(detailData.getDataName().get(0).equals("参保人数")){
                MapResultHandler<Integer, BigDecimal> resultHandler = new MapResultHandler<>();
                detailDataMapper.insuredNumber(resultHandler);
                Map<Integer, BigDecimal> data = resultHandler.getMappedResults();
                List<Integer> keys = data.keySet().stream().sorted().toList();
                List<BigDecimal> values = keys.stream().map(data::get).toList();
                // 提取出 predictData 数据
                List<Integer> predictKeys = keys.stream().filter(key -> key >= DateTime.now().year()).toList();
                List<BigDecimal> predictValues = predictKeys.stream().map(data::get).toList();
                // 原 kv 去掉 predictKV
                keys = keys.stream().filter(key -> !predictKeys.contains(key)).toList();
                values = values.stream().filter(value -> !predictValues.contains(value)).toList();
                // 装填
                detailData.setData(List.of(keys, values));
                detailData.setPredictData(List.of(predictKeys, predictValues));
                continue;
            }
            // 3. 去拿数据，执行 query 语句
            // 把数据装成 Map，拿一个 resultHandler 去装
            MapResultHandler<Integer, BigDecimal> resultHandler = new MapResultHandler<>();
            detailDataMapper.customDataQuery(detailData.getDataQuerySql(), resultHandler);
            Map<Integer, BigDecimal> data = resultHandler.getMappedResults();
            // 4. 拿到的数据转成二维数组
            List<Integer> keys = data.keySet().stream().sorted().toList();
            List<BigDecimal> values = keys.stream().map(data::get).toList();
            // 提取出 predictData 数据
            List<Integer> predictKeys = keys.stream().filter(key -> key >= DateTime.now().year()).toList();
            List<BigDecimal> predictValues = predictKeys.stream().map(data::get).toList();
            // 原 kv 去掉 predictKV
            keys = keys.stream().filter(key -> !predictKeys.contains(key)).toList();
            values = values.stream().filter(value -> !predictValues.contains(value)).toList();
            // 装填
            detailData.setData(List.of(keys, values));
            detailData.setPredictData(List.of(predictKeys, predictValues));
        }
        // 5. 搞定，返回
        return detailDataList;
    }
}
