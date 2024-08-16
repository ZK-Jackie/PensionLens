//package edu.gdou.pensionlens.controller;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import edu.gdou.pensionlens.pojo.Result;
//import edu.gdou.pensionlens.constant.CacheConstants;
//import edu.gdou.pensionlens.pojo.SysUser;
//import edu.gdou.pensionlens.pojo.request.UserLoginRequest;
//import edu.gdou.pensionlens.security.service.LoginService;
//import edu.gdou.pensionlens.utils.RedisCache;
//
//import javax.annotation.Resource;
//
//@Slf4j
//@RestController
//public class SysUserController {
//
//    @Resource
//    private LoginService loginService;
//
//    @Resource
//    private RedisCache redisCache;
//
//    @PostMapping("/login")
//    public Result login(@RequestBody UserLoginRequest user){
//        if (user == null){
//            return Result.error(HttpStatus.BAD_REQUEST.value(),"参数不能为空");
//        }
//        // 1. 验证码校验
//        Result captchaResult = validateCaptcha(user.getUsername(), user.getCode(), user.getUuid());
//        if (captchaResult != null) {
//            return captchaResult;
//        }
//        // 2. 登录前校验
//        Result precheckResult = loginPreCheck(user.getUsername(), user.getPassword());
//        if(precheckResult != null){
//            return precheckResult;
//        }
//        // 3. spring security登录
//        SysUser sysUser = new SysUser();
//        sysUser.setUserName(user.getUsername());
//        sysUser.setPassword(user.getPassword());
//        return loginService.login(sysUser);
//    }
//
//
//
//    public Result validateCaptcha(String username, String code, String uuid){
//        // 验证码校验
//        // 1. 组织查询key
//        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + uuid;
//        log.info("用户:{}", username);
//        log.info("验证码key:{}", verifyKey);
//        String captcha = redisCache.getCacheObject(verifyKey);
//        redisCache.deleteObject(verifyKey);
//        if (captcha == null){
//            return Result.error(HttpStatus.BAD_REQUEST.value(),"验证码已失效");
//        }
//        if (!code.equalsIgnoreCase(captcha)){
//            return Result.error(HttpStatus.BAD_REQUEST.value(),"验证码错误");
//        }
//        return null;
//    }
//
//    public Result loginPreCheck(String username, String password){
//        if(username == null || password == null){
//            return Result.error(HttpStatus.BAD_REQUEST.value(),"用户名或密码不能为空");
//        }
//        if (password.length() < 6 || password.length() > 20){
//            return Result.error(HttpStatus.BAD_REQUEST.value(),"密码长度不符合要求");
//        }
//        if (username.length() < 2 || username.length() > 20){
//            return Result.error(HttpStatus.BAD_REQUEST.value(),"用户名长度不符合要求");
//        }
//        return null;
//    }
//
//}
