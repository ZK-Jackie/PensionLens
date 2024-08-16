//package edu.gdou.pensionlens.security.service;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import edu.gdou.pensionlens.pojo.SysUser;
//import edu.gdou.pensionlens.mapper.SysMenuMapper;
//import edu.gdou.pensionlens.mapper.SysUserMapper;
//import edu.gdou.pensionlens.security.domain.LoginUser;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Objects;
//
//@Slf4j
////@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Resource
//    private SysUserMapper sysUserMapper;
//
//    @Resource
//    private SysMenuMapper sysMenuMapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //根据用户名查询用户信息
//        SysUser user = sysUserMapper.selectUserByUserName(username);
//        //如果查询不到数据就通过抛出异常来给出提示
//        if (Objects.isNull(user)) {
//            throw new UsernameNotFoundException("用户名或密码错误");
//        }
//        //TODO 根据用户查询权限信息 添加到LoginUser中
//        List<String> list = sysMenuMapper.selectPermsByUserId(user.getUserId());
//        log.info("用户权限信息：{}", list);
//        //封装成UserDetails对象返回
//        return new LoginUser(user, list);
//    }
//}
//
//
