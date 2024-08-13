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
import com.ruoyi.system.domain.TYctxcsPlanIndexAgeHis;
import com.ruoyi.system.service.ITYctxcsPlanIndexAgeHisService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测算方案参数历史表（按年龄）Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/index_age_his")
public class TYctxcsPlanIndexAgeHisController extends BaseController
{
    @Autowired
    private ITYctxcsPlanIndexAgeHisService tYctxcsPlanIndexAgeHisService;

    /**
     * 查询测算方案参数历史表（按年龄）列表
     */
    @PreAuthorize("@ss.hasPermi('system:index_age_his:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsPlanIndexAgeHis tYctxcsPlanIndexAgeHis)
    {
        startPage();
        List<TYctxcsPlanIndexAgeHis> list = tYctxcsPlanIndexAgeHisService.selectTYctxcsPlanIndexAgeHisList(tYctxcsPlanIndexAgeHis);
        return getDataTable(list);
    }

    /**
     * 导出测算方案参数历史表（按年龄）列表
     */
    @PreAuthorize("@ss.hasPermi('system:index_age_his:export')")
    @Log(title = "测算方案参数历史表（按年龄）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsPlanIndexAgeHis tYctxcsPlanIndexAgeHis)
    {
        List<TYctxcsPlanIndexAgeHis> list = tYctxcsPlanIndexAgeHisService.selectTYctxcsPlanIndexAgeHisList(tYctxcsPlanIndexAgeHis);
        ExcelUtil<TYctxcsPlanIndexAgeHis> util = new ExcelUtil<TYctxcsPlanIndexAgeHis>(TYctxcsPlanIndexAgeHis.class);
        util.exportExcel(response, list, "测算方案参数历史表（按年龄）数据");
    }

    /**
     * 获取测算方案参数历史表（按年龄）详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:index_age_his:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tYctxcsPlanIndexAgeHisService.selectTYctxcsPlanIndexAgeHisById(id));
    }

    /**
     * 新增测算方案参数历史表（按年龄）
     */
    @PreAuthorize("@ss.hasPermi('system:index_age_his:add')")
    @Log(title = "测算方案参数历史表（按年龄）", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsPlanIndexAgeHis tYctxcsPlanIndexAgeHis)
    {
        return toAjax(tYctxcsPlanIndexAgeHisService.insertTYctxcsPlanIndexAgeHis(tYctxcsPlanIndexAgeHis));
    }

    /**
     * 修改测算方案参数历史表（按年龄）
     */
    @PreAuthorize("@ss.hasPermi('system:index_age_his:edit')")
    @Log(title = "测算方案参数历史表（按年龄）", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsPlanIndexAgeHis tYctxcsPlanIndexAgeHis)
    {
        return toAjax(tYctxcsPlanIndexAgeHisService.updateTYctxcsPlanIndexAgeHis(tYctxcsPlanIndexAgeHis));
    }

    /**
     * 删除测算方案参数历史表（按年龄）
     */
    @PreAuthorize("@ss.hasPermi('system:index_age_his:remove')")
    @Log(title = "测算方案参数历史表（按年龄）", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tYctxcsPlanIndexAgeHisService.deleteTYctxcsPlanIndexAgeHisByIds(ids));
    }
}
