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
import com.ruoyi.system.domain.TYctxcsResultsHistory;
import com.ruoyi.system.service.ITYctxcsResultsHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 结果预测历史表Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/results_history")
public class TYctxcsResultsHistoryController extends BaseController
{
    @Autowired
    private ITYctxcsResultsHistoryService tYctxcsResultsHistoryService;

    /**
     * 查询结果预测历史表列表
     */
    @PreAuthorize("@ss.hasPermi('system:results_history:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsResultsHistory tYctxcsResultsHistory)
    {
        startPage();
        List<TYctxcsResultsHistory> list = tYctxcsResultsHistoryService.selectTYctxcsResultsHistoryList(tYctxcsResultsHistory);
        return getDataTable(list);
    }

    /**
     * 导出结果预测历史表列表
     */
    @PreAuthorize("@ss.hasPermi('system:results_history:export')")
    @Log(title = "结果预测历史表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsResultsHistory tYctxcsResultsHistory)
    {
        List<TYctxcsResultsHistory> list = tYctxcsResultsHistoryService.selectTYctxcsResultsHistoryList(tYctxcsResultsHistory);
        ExcelUtil<TYctxcsResultsHistory> util = new ExcelUtil<TYctxcsResultsHistory>(TYctxcsResultsHistory.class);
        util.exportExcel(response, list, "结果预测历史表数据");
    }

    /**
     * 获取结果预测历史表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:results_history:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tYctxcsResultsHistoryService.selectTYctxcsResultsHistoryById(id));
    }

    /**
     * 新增结果预测历史表
     */
    @PreAuthorize("@ss.hasPermi('system:results_history:add')")
    @Log(title = "结果预测历史表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsResultsHistory tYctxcsResultsHistory)
    {
        return toAjax(tYctxcsResultsHistoryService.insertTYctxcsResultsHistory(tYctxcsResultsHistory));
    }

    /**
     * 修改结果预测历史表
     */
    @PreAuthorize("@ss.hasPermi('system:results_history:edit')")
    @Log(title = "结果预测历史表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsResultsHistory tYctxcsResultsHistory)
    {
        return toAjax(tYctxcsResultsHistoryService.updateTYctxcsResultsHistory(tYctxcsResultsHistory));
    }

    /**
     * 删除结果预测历史表
     */
    @PreAuthorize("@ss.hasPermi('system:results_history:remove')")
    @Log(title = "结果预测历史表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tYctxcsResultsHistoryService.deleteTYctxcsResultsHistoryByIds(ids));
    }
}
