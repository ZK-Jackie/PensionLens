package edu.gdou.pensionlens.service;

import edu.gdou.pensionlens.pojo.DetailData;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DetailDataService {
    List<DetailData> getDetailData(Integer detailId);
}
