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
import com.ruoyi.system.domain.TYctxcsPlanVisit;
import com.ruoyi.system.service.ITYctxcsPlanVisitService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测算方案访问表Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/plan_visit")
public class TYctxcsPlanVisitController extends BaseController
{
    @Autowired
    private ITYctxcsPlanVisitService tYctxcsPlanVisitService;

    /**
     * 查询测算方案访问表列表
     */
    @PreAuthorize("@ss.hasPermi('system:plan_visit:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsPlanVisit tYctxcsPlanVisit)
    {
        startPage();
        List<TYctxcsPlanVisit> list = tYctxcsPlanVisitService.selectTYctxcsPlanVisitList(tYctxcsPlanVisit);
        return getDataTable(list);
    }

    /**
     * 导出测算方案访问表列表
     */
    @PreAuthorize("@ss.hasPermi('system:plan_visit:export')")
    @Log(title = "测算方案访问表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsPlanVisit tYctxcsPlanVisit)
    {
        List<TYctxcsPlanVisit> list = tYctxcsPlanVisitService.selectTYctxcsPlanVisitList(tYctxcsPlanVisit);
        ExcelUtil<TYctxcsPlanVisit> util = new ExcelUtil<TYctxcsPlanVisit>(TYctxcsPlanVisit.class);
        util.exportExcel(response, list, "测算方案访问表数据");
    }

    /**
     * 获取测算方案访问表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:plan_visit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tYctxcsPlanVisitService.selectTYctxcsPlanVisitById(id));
    }

    /**
     * 新增测算方案访问表
     */
    @PreAuthorize("@ss.hasPermi('system:plan_visit:add')")
    @Log(title = "测算方案访问表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsPlanVisit tYctxcsPlanVisit)
    {
        return toAjax(tYctxcsPlanVisitService.insertTYctxcsPlanVisit(tYctxcsPlanVisit));
    }

    /**
     * 修改测算方案访问表
     */
    @PreAuthorize("@ss.hasPermi('system:plan_visit:edit')")
    @Log(title = "测算方案访问表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsPlanVisit tYctxcsPlanVisit)
    {
        return toAjax(tYctxcsPlanVisitService.updateTYctxcsPlanVisit(tYctxcsPlanVisit));
    }

    /**
     * 删除测算方案访问表
     */
    @PreAuthorize("@ss.hasPermi('system:plan_visit:remove')")
    @Log(title = "测算方案访问表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tYctxcsPlanVisitService.deleteTYctxcsPlanVisitByIds(ids));
    }
}
