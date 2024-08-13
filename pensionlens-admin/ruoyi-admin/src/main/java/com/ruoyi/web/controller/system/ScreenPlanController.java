package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.ScreenPlan;
import com.ruoyi.system.service.IScreenPlanService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 大屏绑定预测方案Controller
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
@RestController
@RequestMapping("/system/screen_plan")
public class ScreenPlanController extends BaseController
{
    @Autowired
    private IScreenPlanService screenPlanService;

    /**
     * 查询大屏绑定预测方案列表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_plan:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScreenPlan screenPlan)
    {
        startPage();
        List<ScreenPlan> list = screenPlanService.selectScreenPlanList(screenPlan);
        return getDataTable(list);
    }

    /**
     * 导出大屏绑定预测方案列表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_plan:export')")
    @Log(title = "大屏绑定预测方案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScreenPlan screenPlan)
    {
        List<ScreenPlan> list = screenPlanService.selectScreenPlanList(screenPlan);
        ExcelUtil<ScreenPlan> util = new ExcelUtil<ScreenPlan>(ScreenPlan.class);
        util.exportExcel(response, list, "大屏绑定预测方案数据");
    }

    /**
     * 获取大屏绑定预测方案详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:screen_plan:query')")
    @GetMapping(value = "/{screenId}")
    public AjaxResult getInfo(@PathVariable("screenId") Long screenId)
    {
        return success(screenPlanService.selectScreenPlanByScreenId(screenId));
    }

    /**
     * 新增大屏绑定预测方案
     */
    @PreAuthorize("@ss.hasPermi('system:screen_plan:add')")
    @Log(title = "大屏绑定预测方案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScreenPlan screenPlan)
    {
        return toAjax(screenPlanService.insertScreenPlan(screenPlan));
    }

    /**
     * 修改大屏绑定预测方案
     */
    @PreAuthorize("@ss.hasPermi('system:screen_plan:edit')")
    @Log(title = "大屏绑定预测方案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScreenPlan screenPlan)
    {
        return toAjax(screenPlanService.updateScreenPlan(screenPlan));
    }

    /**
     * 删除大屏绑定预测方案
     */
    @PreAuthorize("@ss.hasPermi('system:screen_plan:remove')")
    @Log(title = "大屏绑定预测方案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{screenIds}")
    public AjaxResult remove(@PathVariable Long[] screenIds)
    {
        return toAjax(screenPlanService.deleteScreenPlanByScreenIds(screenIds));
    }
}
