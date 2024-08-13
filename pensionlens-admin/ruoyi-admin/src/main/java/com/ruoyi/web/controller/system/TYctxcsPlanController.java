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
import com.ruoyi.system.domain.TYctxcsPlan;
import com.ruoyi.system.service.ITYctxcsPlanService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 延迟退休测算计划表Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/plan")
public class TYctxcsPlanController extends BaseController
{
    @Autowired
    private ITYctxcsPlanService tYctxcsPlanService;

    /**
     * 查询延迟退休测算计划表列表
     */
    @PreAuthorize("@ss.hasPermi('system:plan:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsPlan tYctxcsPlan)
    {
        startPage();
        List<TYctxcsPlan> list = tYctxcsPlanService.selectTYctxcsPlanList(tYctxcsPlan);
        return getDataTable(list);
    }

    /**
     * 导出延迟退休测算计划表列表
     */
    @PreAuthorize("@ss.hasPermi('system:plan:export')")
    @Log(title = "延迟退休测算计划表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsPlan tYctxcsPlan)
    {
        List<TYctxcsPlan> list = tYctxcsPlanService.selectTYctxcsPlanList(tYctxcsPlan);
        ExcelUtil<TYctxcsPlan> util = new ExcelUtil<TYctxcsPlan>(TYctxcsPlan.class);
        util.exportExcel(response, list, "延迟退休测算计划表数据");
    }

    /**
     * 获取延迟退休测算计划表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:plan:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tYctxcsPlanService.selectTYctxcsPlanById(id));
    }

    /**
     * 新增延迟退休测算计划表
     */
    @PreAuthorize("@ss.hasPermi('system:plan:add')")
    @Log(title = "延迟退休测算计划表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsPlan tYctxcsPlan)
    {
        return toAjax(tYctxcsPlanService.insertTYctxcsPlan(tYctxcsPlan));
    }

    /**
     * 修改延迟退休测算计划表
     */
    @PreAuthorize("@ss.hasPermi('system:plan:edit')")
    @Log(title = "延迟退休测算计划表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsPlan tYctxcsPlan)
    {
        return toAjax(tYctxcsPlanService.updateTYctxcsPlan(tYctxcsPlan));
    }

    /**
     * 删除延迟退休测算计划表
     */
    @PreAuthorize("@ss.hasPermi('system:plan:remove')")
    @Log(title = "延迟退休测算计划表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tYctxcsPlanService.deleteTYctxcsPlanByIds(ids));
    }
}
