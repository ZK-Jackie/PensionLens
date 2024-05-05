package edu.gdou.pensionlens.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScreenMapper {
    // 示例：查询数据库
    @Select("SELECT screen_detail_id FROM screen_detail WHERE screen_id = #{screenId}")
    List<Integer> getScreenDetailIds(Integer screenId);
}
