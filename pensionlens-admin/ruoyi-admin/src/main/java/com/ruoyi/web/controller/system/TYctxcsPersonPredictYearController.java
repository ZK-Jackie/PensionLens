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
import com.ruoyi.system.domain.TYctxcsPersonPredictYear;
import com.ruoyi.system.service.ITYctxcsPersonPredictYearService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人口预测参数（按年份）Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/person_predict_year")
public class TYctxcsPersonPredictYearController extends BaseController
{
    @Autowired
    private ITYctxcsPersonPredictYearService tYctxcsPersonPredictYearService;

    /**
     * 查询人口预测参数（按年份）列表
     */
    @PreAuthorize("@ss.hasPermi('system:person_predict_year:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsPersonPredictYear tYctxcsPersonPredictYear)
    {
        startPage();
        List<TYctxcsPersonPredictYear> list = tYctxcsPersonPredictYearService.selectTYctxcsPersonPredictYearList(tYctxcsPersonPredictYear);
        return getDataTable(list);
    }

    /**
     * 导出人口预测参数（按年份）列表
     */
    @PreAuthorize("@ss.hasPermi('system:person_predict_year:export')")
    @Log(title = "人口预测参数（按年份）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsPersonPredictYear tYctxcsPersonPredictYear)
    {
        List<TYctxcsPersonPredictYear> list = tYctxcsPersonPredictYearService.selectTYctxcsPersonPredictYearList(tYctxcsPersonPredictYear);
        ExcelUtil<TYctxcsPersonPredictYear> util = new ExcelUtil<TYctxcsPersonPredictYear>(TYctxcsPersonPredictYear.class);
        util.exportExcel(response, list, "人口预测参数（按年份）数据");
    }

    /**
     * 获取人口预测参数（按年份）详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:person_predict_year:query')")
    @GetMapping(value = "/{planArea}")
    public AjaxResult getInfo(@PathVariable("planArea") Long planArea)
    {
        return success(tYctxcsPersonPredictYearService.selectTYctxcsPersonPredictYearByPlanArea(planArea));
    }

    /**
     * 新增人口预测参数（按年份）
     */
    @PreAuthorize("@ss.hasPermi('system:person_predict_year:add')")
    @Log(title = "人口预测参数（按年份）", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsPersonPredictYear tYctxcsPersonPredictYear)
    {
        return toAjax(tYctxcsPersonPredictYearService.insertTYctxcsPersonPredictYear(tYctxcsPersonPredictYear));
    }

    /**
     * 修改人口预测参数（按年份）
     */
    @PreAuthorize("@ss.hasPermi('system:person_predict_year:edit')")
    @Log(title = "人口预测参数（按年份）", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsPersonPredictYear tYctxcsPersonPredictYear)
    {
        return toAjax(tYctxcsPersonPredictYearService.updateTYctxcsPersonPredictYear(tYctxcsPersonPredictYear));
    }

    /**
     * 删除人口预测参数（按年份）
     */
    @PreAuthorize("@ss.hasPermi('system:person_predict_year:remove')")
    @Log(title = "人口预测参数（按年份）", businessType = BusinessType.DELETE)
	@DeleteMapping("/{planAreas}")
    public AjaxResult remove(@PathVariable Long[] planAreas)
    {
        return toAjax(tYctxcsPersonPredictYearService.deleteTYctxcsPersonPredictYearByPlanAreas(planAreas));
    }
}
