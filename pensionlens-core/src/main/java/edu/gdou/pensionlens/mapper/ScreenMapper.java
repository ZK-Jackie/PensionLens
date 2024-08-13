package edu.gdou.pensionlens.mapper;

import edu.gdou.pensionlens.pojo.Screen;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface ScreenMapper {

    @Select("SELECT screen_id, screen_name, is_predict, is_active FROM screen WHERE screen_id = #{screenId}")
    Screen getScreenInfo(Integer screenId);

}
