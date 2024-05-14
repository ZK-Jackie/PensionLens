package edu.gdou.pensionlens.security.handler;


import edu.gdou.pensionlens.security.domain.LoginUser;
import edu.gdou.pensionlens.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import edu.gdou.pensionlens.pojo.SysUser;
import edu.gdou.pensionlens.service.SysUserService;
import edu.gdou.pensionlens.utils.JwtUtils;
import edu.gdou.pensionlens.utils.RedisCache;
import edu.gdou.pensionlens.utils.WebUtil;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Resource
    private RedisCache redisCache;

    @Resource
    private SysUserService sysUserService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String token = request.getHeader("token");
        //解析token
        String userid;
        try {
            Claims claims = JwtUtils.parseJwt(token);
            userid = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        // 获取用户信息

        LoginUser loginUser = redisCache.getCacheObject("login:" + userid);
        if (loginUser == null) {
            throw new RuntimeException("用户未登录");
        }
        // 删除用户缓存记录
        redisCache.deleteObject("login:" + userid);

        WebUtil.renderString(response, "退出成功");
    }
}
