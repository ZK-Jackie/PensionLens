package edu.gdou.pensionlens.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.lang.UUID;
import edu.gdou.pensionlens.constant.CacheConstants;
import edu.gdou.pensionlens.pojo.Result;
import edu.gdou.pensionlens.utils.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class CaptchaController {
    @Resource
    private RedisCache redisCache;

    @GetMapping("/captchaImage")
    public Result captcha(HttpServletResponse response){
        HashMap<String, Object> data = new HashMap<>();
        // 1. 生成uuid
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString(true);
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + uuidString;
        // 2. 生成验证码
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
        String code = captcha.getCode();
        log.info("验证码:{}", code);

        // 3. 保存验证码信息
        redisCache.setCacheObject(verifyKey, code, CacheConstants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        BufferedImage image = captcha.getImage();
        try {
            ImageIO.write(image, "png", os);
        } catch (IOException e) {
            log.error("验证码生成失败:", e);
            return new Result(500, "获取验证码失败", null);
        }
        log.info("验证码生成成功,uuid为{}", uuidString);
        data.put("uuid", uuidString);
        data.put("img", Base64.encode(os.toByteArray()));
        return new Result(200, "获取验证码成功", data);
    }
}
