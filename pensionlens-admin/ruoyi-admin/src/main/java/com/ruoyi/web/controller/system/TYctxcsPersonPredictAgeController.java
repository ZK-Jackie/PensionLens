package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TYctxcsPersonPredictAge;
import com.ruoyi.system.service.ITYctxcsPersonPredictAgeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人口预测参数（按年龄）Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/person_predict_age")
public class TYctxcsPersonPredictAgeController extends BaseController
{
    @Autowired
    private ITYctxcsPersonPredictAgeService tYctxcsPersonPredictAgeService;

    /**
     * 查询人口预测参数（按年龄）列表
     */
    @PreAuthorize("@ss.hasPermi('system:person_predict_age:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsPersonPredictAge tYctxcsPersonPredictAge)
    {
        startPage();
        List<TYctxcsPersonPredictAge> list = tYctxcsPersonPredictAgeService.selectTYctxcsPersonPredictAgeList(tYctxcsPersonPredictAge);
        return getDataTable(list);
    }

    /**
     * 导出人口预测参数（按年龄）列表
     */
    @PreAuthorize("@ss.hasPermi('system:person_predict_age:export')")
    @Log(title = "人口预测参数（按年龄）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsPersonPredictAge tYctxcsPersonPredictAge)
    {
        List<TYctxcsPersonPredictAge> list = tYctxcsPersonPredictAgeService.selectTYctxcsPersonPredictAgeList(tYctxcsPersonPredictAge);
        ExcelUtil<TYctxcsPersonPredictAge> util = new ExcelUtil<TYctxcsPersonPredictAge>(TYctxcsPersonPredictAge.class);
        util.exportExcel(response, list, "人口预测参数（按年龄）数据");
    }

    /**
     * 获取人口预测参数（按年龄）详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:person_predict_age:query')")
    @GetMapping(value = "/{planArea}")
    public AjaxResult getInfo(@PathVariable("planArea") Long planArea)
    {
        return success(tYctxcsPersonPredictAgeService.selectTYctxcsPersonPredictAgeByPlanArea(planArea));
    }

    /**
     * 新增人口预测参数（按年龄）
     */
    @PreAuthorize("@ss.hasPermi('system:person_predict_age:add')")
    @Log(title = "人口预测参数（按年龄）", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsPersonPredictAge tYctxcsPersonPredictAge)
    {
        return toAjax(tYctxcsPersonPredictAgeService.insertTYctxcsPersonPredictAge(tYctxcsPersonPredictAge));
    }

    /**
     * 修改人口预测参数（按年龄）
     */
    @PreAuthorize("@ss.hasPermi('system:person_predict_age:edit')")
    @Log(title = "人口预测参数（按年龄）", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsPersonPredictAge tYctxcsPersonPredictAge)
    {
        return toAjax(tYctxcsPersonPredictAgeService.updateTYctxcsPersonPredictAge(tYctxcsPersonPredictAge));
    }

    /**
     * 删除人口预测参数（按年龄）
     */
    @PreAuthorize("@ss.hasPermi('system:person_predict_age:remove')")
    @Log(title = "人口预测参数（按年龄）", businessType = BusinessType.DELETE)
	@DeleteMapping("/{planAreas}")
    public AjaxResult remove(@PathVariable Long[] planAreas)
    {
        return toAjax(tYctxcsPersonPredictAgeService.deleteTYctxcsPersonPredictAgeByPlanAreas(planAreas));
    }
}
