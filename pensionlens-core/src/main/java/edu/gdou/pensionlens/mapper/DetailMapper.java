package edu.gdou.pensionlens.mapper;

import edu.gdou.pensionlens.pojo.Detail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailMapper {
    List<Detail> getScreenDetails(Integer screenId);
}
