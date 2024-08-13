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
import com.ruoyi.system.domain.TYctxcsResults;
import com.ruoyi.system.service.ITYctxcsResultsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 结果预测表Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/results")
public class TYctxcsResultsController extends BaseController
{
    @Autowired
    private ITYctxcsResultsService tYctxcsResultsService;

    /**
     * 查询结果预测表列表
     */
    @PreAuthorize("@ss.hasPermi('system:results:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsResults tYctxcsResults)
    {
        startPage();
        List<TYctxcsResults> list = tYctxcsResultsService.selectTYctxcsResultsList(tYctxcsResults);
        return getDataTable(list);
    }

    /**
     * 导出结果预测表列表
     */
    @PreAuthorize("@ss.hasPermi('system:results:export')")
    @Log(title = "结果预测表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsResults tYctxcsResults)
    {
        List<TYctxcsResults> list = tYctxcsResultsService.selectTYctxcsResultsList(tYctxcsResults);
        ExcelUtil<TYctxcsResults> util = new ExcelUtil<TYctxcsResults>(TYctxcsResults.class);
        util.exportExcel(response, list, "结果预测表数据");
    }

    /**
     * 获取结果预测表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:results:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tYctxcsResultsService.selectTYctxcsResultsById(id));
    }

    /**
     * 新增结果预测表
     */
    @PreAuthorize("@ss.hasPermi('system:results:add')")
    @Log(title = "结果预测表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsResults tYctxcsResults)
    {
        return toAjax(tYctxcsResultsService.insertTYctxcsResults(tYctxcsResults));
    }

    /**
     * 修改结果预测表
     */
    @PreAuthorize("@ss.hasPermi('system:results:edit')")
    @Log(title = "结果预测表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsResults tYctxcsResults)
    {
        return toAjax(tYctxcsResultsService.updateTYctxcsResults(tYctxcsResults));
    }

    /**
     * 删除结果预测表
     */
    @PreAuthorize("@ss.hasPermi('system:results:remove')")
    @Log(title = "结果预测表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tYctxcsResultsService.deleteTYctxcsResultsByIds(ids));
    }
}
