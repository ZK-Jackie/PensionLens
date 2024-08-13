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
import com.ruoyi.system.domain.TYctxcsPlanIndexYearHis;
import com.ruoyi.system.service.ITYctxcsPlanIndexYearHisService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测算方案参数历史表（按年）Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/index_year_his")
public class TYctxcsPlanIndexYearHisController extends BaseController
{
    @Autowired
    private ITYctxcsPlanIndexYearHisService tYctxcsPlanIndexYearHisService;

    /**
     * 查询测算方案参数历史表（按年）列表
     */
    @PreAuthorize("@ss.hasPermi('system:index_year_his:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsPlanIndexYearHis tYctxcsPlanIndexYearHis)
    {
        startPage();
        List<TYctxcsPlanIndexYearHis> list = tYctxcsPlanIndexYearHisService.selectTYctxcsPlanIndexYearHisList(tYctxcsPlanIndexYearHis);
        return getDataTable(list);
    }

    /**
     * 导出测算方案参数历史表（按年）列表
     */
    @PreAuthorize("@ss.hasPermi('system:index_year_his:export')")
    @Log(title = "测算方案参数历史表（按年）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsPlanIndexYearHis tYctxcsPlanIndexYearHis)
    {
        List<TYctxcsPlanIndexYearHis> list = tYctxcsPlanIndexYearHisService.selectTYctxcsPlanIndexYearHisList(tYctxcsPlanIndexYearHis);
        ExcelUtil<TYctxcsPlanIndexYearHis> util = new ExcelUtil<TYctxcsPlanIndexYearHis>(TYctxcsPlanIndexYearHis.class);
        util.exportExcel(response, list, "测算方案参数历史表（按年）数据");
    }

    /**
     * 获取测算方案参数历史表（按年）详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:index_year_his:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tYctxcsPlanIndexYearHisService.selectTYctxcsPlanIndexYearHisById(id));
    }

    /**
     * 新增测算方案参数历史表（按年）
     */
    @PreAuthorize("@ss.hasPermi('system:index_year_his:add')")
    @Log(title = "测算方案参数历史表（按年）", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsPlanIndexYearHis tYctxcsPlanIndexYearHis)
    {
        return toAjax(tYctxcsPlanIndexYearHisService.insertTYctxcsPlanIndexYearHis(tYctxcsPlanIndexYearHis));
    }

    /**
     * 修改测算方案参数历史表（按年）
     */
    @PreAuthorize("@ss.hasPermi('system:index_year_his:edit')")
    @Log(title = "测算方案参数历史表（按年）", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsPlanIndexYearHis tYctxcsPlanIndexYearHis)
    {
        return toAjax(tYctxcsPlanIndexYearHisService.updateTYctxcsPlanIndexYearHis(tYctxcsPlanIndexYearHis));
    }

    /**
     * 删除测算方案参数历史表（按年）
     */
    @PreAuthorize("@ss.hasPermi('system:index_year_his:remove')")
    @Log(title = "测算方案参数历史表（按年）", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tYctxcsPlanIndexYearHisService.deleteTYctxcsPlanIndexYearHisByIds(ids));
    }
}
