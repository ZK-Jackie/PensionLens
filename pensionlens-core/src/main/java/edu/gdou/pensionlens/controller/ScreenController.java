package edu.gdou.pensionlens.controller;

import edu.gdou.pensionlens.pojo.Result;
import edu.gdou.pensionlens.service.ScreenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class ScreenController {
    @Resource
    private ScreenService screenService;

    @GetMapping("/screen/{screenId}")
    public Result getScreenInfo(@PathVariable Integer screenId) {
        log.info("用户查询大屏：id={} 信息", screenId);
        return Result.success(screenService.getScreenInfo(screenId));
    }

}
