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
import com.ruoyi.system.domain.TYctxcsDefaultResults;
import com.ruoyi.system.service.ITYctxcsDefaultResultsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测算结果默认表Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/default_results")
public class TYctxcsDefaultResultsController extends BaseController
{
    @Autowired
    private ITYctxcsDefaultResultsService tYctxcsDefaultResultsService;

    /**
     * 查询测算结果默认表列表
     */
    @PreAuthorize("@ss.hasPermi('system:default_results:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsDefaultResults tYctxcsDefaultResults)
    {
        startPage();
        List<TYctxcsDefaultResults> list = tYctxcsDefaultResultsService.selectTYctxcsDefaultResultsList(tYctxcsDefaultResults);
        return getDataTable(list);
    }

    /**
     * 导出测算结果默认表列表
     */
    @PreAuthorize("@ss.hasPermi('system:default_results:export')")
    @Log(title = "测算结果默认表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsDefaultResults tYctxcsDefaultResults)
    {
        List<TYctxcsDefaultResults> list = tYctxcsDefaultResultsService.selectTYctxcsDefaultResultsList(tYctxcsDefaultResults);
        ExcelUtil<TYctxcsDefaultResults> util = new ExcelUtil<TYctxcsDefaultResults>(TYctxcsDefaultResults.class);
        util.exportExcel(response, list, "测算结果默认表数据");
    }

    /**
     * 获取测算结果默认表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:default_results:query')")
    @GetMapping(value = "/{planArea}")
    public AjaxResult getInfo(@PathVariable("planArea") Long planArea)
    {
        return success(tYctxcsDefaultResultsService.selectTYctxcsDefaultResultsByPlanArea(planArea));
    }

    /**
     * 新增测算结果默认表
     */
    @PreAuthorize("@ss.hasPermi('system:default_results:add')")
    @Log(title = "测算结果默认表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsDefaultResults tYctxcsDefaultResults)
    {
        return toAjax(tYctxcsDefaultResultsService.insertTYctxcsDefaultResults(tYctxcsDefaultResults));
    }

    /**
     * 修改测算结果默认表
     */
    @PreAuthorize("@ss.hasPermi('system:default_results:edit')")
    @Log(title = "测算结果默认表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsDefaultResults tYctxcsDefaultResults)
    {
        return toAjax(tYctxcsDefaultResultsService.updateTYctxcsDefaultResults(tYctxcsDefaultResults));
    }

    /**
     * 删除测算结果默认表
     */
    @PreAuthorize("@ss.hasPermi('system:default_results:remove')")
    @Log(title = "测算结果默认表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{planAreas}")
    public AjaxResult remove(@PathVariable Long[] planAreas)
    {
        return toAjax(tYctxcsDefaultResultsService.deleteTYctxcsDefaultResultsByPlanAreas(planAreas));
    }
}
