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
import com.ruoyi.system.domain.TYctxcsPlanHistory;
import com.ruoyi.system.service.ITYctxcsPlanHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 延迟退休测算方案历史表Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/plan_history")
public class TYctxcsPlanHistoryController extends BaseController
{
    @Autowired
    private ITYctxcsPlanHistoryService tYctxcsPlanHistoryService;

    /**
     * 查询延迟退休测算方案历史表列表
     */
    @PreAuthorize("@ss.hasPermi('system:plan_history:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsPlanHistory tYctxcsPlanHistory)
    {
        startPage();
        List<TYctxcsPlanHistory> list = tYctxcsPlanHistoryService.selectTYctxcsPlanHistoryList(tYctxcsPlanHistory);
        return getDataTable(list);
    }

    /**
     * 导出延迟退休测算方案历史表列表
     */
    @PreAuthorize("@ss.hasPermi('system:plan_history:export')")
    @Log(title = "延迟退休测算方案历史表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsPlanHistory tYctxcsPlanHistory)
    {
        List<TYctxcsPlanHistory> list = tYctxcsPlanHistoryService.selectTYctxcsPlanHistoryList(tYctxcsPlanHistory);
        ExcelUtil<TYctxcsPlanHistory> util = new ExcelUtil<TYctxcsPlanHistory>(TYctxcsPlanHistory.class);
        util.exportExcel(response, list, "延迟退休测算方案历史表数据");
    }

    /**
     * 获取延迟退休测算方案历史表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:plan_history:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tYctxcsPlanHistoryService.selectTYctxcsPlanHistoryById(id));
    }

    /**
     * 新增延迟退休测算方案历史表
     */
    @PreAuthorize("@ss.hasPermi('system:plan_history:add')")
    @Log(title = "延迟退休测算方案历史表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsPlanHistory tYctxcsPlanHistory)
    {
        return toAjax(tYctxcsPlanHistoryService.insertTYctxcsPlanHistory(tYctxcsPlanHistory));
    }

    /**
     * 修改延迟退休测算方案历史表
     */
    @PreAuthorize("@ss.hasPermi('system:plan_history:edit')")
    @Log(title = "延迟退休测算方案历史表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsPlanHistory tYctxcsPlanHistory)
    {
        return toAjax(tYctxcsPlanHistoryService.updateTYctxcsPlanHistory(tYctxcsPlanHistory));
    }

    /**
     * 删除延迟退休测算方案历史表
     */
    @PreAuthorize("@ss.hasPermi('system:plan_history:remove')")
    @Log(title = "延迟退休测算方案历史表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tYctxcsPlanHistoryService.deleteTYctxcsPlanHistoryByIds(ids));
    }
}
