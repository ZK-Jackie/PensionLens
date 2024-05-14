package edu.gdou.pensionlens.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysMenuMapper {
    @Select("select m.perms from sys_menu m " +
            "left join sys_role_menu rm on m.id = rm.menu_id " +
            "left join sys_role r on rm.role_id = r.id " +
            "left join sys_user_role ur on r.id = ur.role_id " +
            "left join sys_user u on ur.user_id = u.id " +
            "where u.id = #{id}")
    List<String> selectPermsByUserId(Long id);
}
