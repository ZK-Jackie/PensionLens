//package edu.gdou.pensionlens.security.service;
//
//
//import edu.gdou.pensionlens.pojo.Result;
//import edu.gdou.pensionlens.pojo.SysUser;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//import edu.gdou.pensionlens.constant.CacheConstants;
//import edu.gdou.pensionlens.security.domain.LoginUser;
//import edu.gdou.pensionlens.utils.JwtUtils;
//import edu.gdou.pensionlens.utils.RedisCache;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//
//@Slf4j
////@Service
//public class LoginServiceImpl implements LoginService {
//
//    @Resource
//    private AuthenticationManager authenticationManager;
//    @Resource
//    private RedisCache redisCache;
//
//    @Override
//    public Result login(SysUser user) {
//        // 1. 造一个UsernamePasswordAuthenticationToken，交给authenticationManager去验证
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
//        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
//        if (Objects.isNull(authenticate)) {
//            log.info("用户名或密码错误");
//            return new Result(HttpStatus.BAD_REQUEST.value(), "用户名或密码错误");
//        }
//        // 2. 验证通过，使用userid生成token
//        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
//        String userId = loginUser.getUser().getUserId().toString();
//        Map<String, String> claims = new HashMap<>();
//        claims.put("userId", userId);
//        String jwt = JwtUtils.generateJwt(claims);
//        // 3. 把authenticate凭证存入redis
//        redisCache.setCacheObject(CacheConstants.USER_LOGIN_KEY + userId, loginUser);
//        // 4. 把token响应给前端
//        HashMap<String, String> data = new HashMap<>();
//        data.put("token", jwt);
//        return new Result(HttpStatus.OK.value(), "登陆成功", data);
//    }
//
//    @Override
//    public Result logout() {
//        // 1. 获取当前用户loginUser
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
//        Long userid = loginUser.getUser().getUserId();
//        // 2. 删除redis中的loginUser
//        redisCache.deleteObject(CacheConstants.USER_LOGIN_KEY + userid);
//        return new Result(HttpStatus.OK.value(), "退出成功");
//    }
//}
