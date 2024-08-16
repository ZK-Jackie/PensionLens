package edu.gdou.pensionlens.mapper;

import edu.gdou.pensionlens.config.MapResultHandler;
import edu.gdou.pensionlens.pojo.DetailData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface DetailDataMapper {

    List<DetailData> getDetailData(Integer detailId);

    void customDataQuery(@Param("sqlStr")String sqlStr, MapResultHandler<Integer, BigDecimal> mapResultHandler);

    void getDataFromCalc(@Param("tableName") String tableName,
                         @Param("x") String colX,
                         @Param("y") String colY,
                         @Param("startTime") Integer startTime,
                         @Param("endTime") Integer endTime,
                         MapResultHandler<Integer, Double> mapResultHandler);

    void insuredNumber(MapResultHandler<Integer, BigDecimal> resultHandler);
}
