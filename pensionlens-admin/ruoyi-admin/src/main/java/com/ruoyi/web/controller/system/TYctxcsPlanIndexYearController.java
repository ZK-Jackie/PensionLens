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
import com.ruoyi.system.domain.TYctxcsPlanIndexYear;
import com.ruoyi.system.service.ITYctxcsPlanIndexYearService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测算方案参数表（按年）Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/index_year")
public class TYctxcsPlanIndexYearController extends BaseController
{
    @Autowired
    private ITYctxcsPlanIndexYearService tYctxcsPlanIndexYearService;

    /**
     * 查询测算方案参数表（按年）列表
     */
    @PreAuthorize("@ss.hasPermi('system:index_year:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsPlanIndexYear tYctxcsPlanIndexYear)
    {
        startPage();
        List<TYctxcsPlanIndexYear> list = tYctxcsPlanIndexYearService.selectTYctxcsPlanIndexYearList(tYctxcsPlanIndexYear);
        return getDataTable(list);
    }

    /**
     * 导出测算方案参数表（按年）列表
     */
    @PreAuthorize("@ss.hasPermi('system:index_year:export')")
    @Log(title = "测算方案参数表（按年）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsPlanIndexYear tYctxcsPlanIndexYear)
    {
        List<TYctxcsPlanIndexYear> list = tYctxcsPlanIndexYearService.selectTYctxcsPlanIndexYearList(tYctxcsPlanIndexYear);
        ExcelUtil<TYctxcsPlanIndexYear> util = new ExcelUtil<TYctxcsPlanIndexYear>(TYctxcsPlanIndexYear.class);
        util.exportExcel(response, list, "测算方案参数表（按年）数据");
    }

    /**
     * 获取测算方案参数表（按年）详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:index_year:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tYctxcsPlanIndexYearService.selectTYctxcsPlanIndexYearById(id));
    }

    /**
     * 新增测算方案参数表（按年）
     */
    @PreAuthorize("@ss.hasPermi('system:index_year:add')")
    @Log(title = "测算方案参数表（按年）", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsPlanIndexYear tYctxcsPlanIndexYear)
    {
        return toAjax(tYctxcsPlanIndexYearService.insertTYctxcsPlanIndexYear(tYctxcsPlanIndexYear));
    }

    /**
     * 修改测算方案参数表（按年）
     */
    @PreAuthorize("@ss.hasPermi('system:index_year:edit')")
    @Log(title = "测算方案参数表（按年）", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsPlanIndexYear tYctxcsPlanIndexYear)
    {
        return toAjax(tYctxcsPlanIndexYearService.updateTYctxcsPlanIndexYear(tYctxcsPlanIndexYear));
    }

    /**
     * 删除测算方案参数表（按年）
     */
    @PreAuthorize("@ss.hasPermi('system:index_year:remove')")
    @Log(title = "测算方案参数表（按年）", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tYctxcsPlanIndexYearService.deleteTYctxcsPlanIndexYearByIds(ids));
    }
}
