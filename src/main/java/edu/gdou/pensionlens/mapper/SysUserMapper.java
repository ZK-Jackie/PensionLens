package edu.gdou.pensionlens.mapper;

import edu.gdou.pensionlens.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserMapper {
    @Select("select * from sys_user where username = #{username}")
    SysUser selectUserByUserName(String username);
}
