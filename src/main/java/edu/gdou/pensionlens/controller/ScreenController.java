package edu.gdou.pensionlens.controller;

import edu.gdou.pensionlens.pojo.Result;
import edu.gdou.pensionlens.service.ScreenService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

@Controller
public class ScreenController {
    @Resource
    private ScreenService screenService;

    @GetMapping("/list/{screenId}")
    public Result screen(@PathVariable Integer screenId) {
        // 示例：直接返回结果
        return Result.success(screenService.getScreenDetailIds(screenId));
    }

}
