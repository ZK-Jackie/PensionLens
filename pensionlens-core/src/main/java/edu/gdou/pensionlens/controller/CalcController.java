package edu.gdou.pensionlens.controller;

import edu.gdou.pensionlens.pojo.Result;
import edu.gdou.pensionlens.pojo.Screen;
import edu.gdou.pensionlens.service.CalcService;
import edu.gdou.pensionlens.service.ScreenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class CalcController {
    @Resource
    private ScreenService screenService;

    @Resource
    private CalcService calcService;

    /**
     * 获取测算大屏页面默认数据
     * @return Result 测算大屏页面调配项数据
     */
    @GetMapping("/calc")
    public Result getCalcOrigin(){
        Integer planScreenId = 4;
        return Result.success(screenService.getScreenInfo(planScreenId));
    }

    /**
     * 前端提交调整后的数据
     * @return Result 向前端返回计算结果数据
     * */
    @PostMapping("/calc")
    public Result postCalcResult(@RequestBody Screen screenData){
        return Result.success(calcService.calculate(screenData));
    }


}
