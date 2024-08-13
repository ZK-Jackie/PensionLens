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
import com.ruoyi.system.domain.TYctxcsIndex;
import com.ruoyi.system.service.ITYctxcsIndexService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 延迟退休测算方案默认参数表Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/index")
public class TYctxcsIndexController extends BaseController
{
    @Autowired
    private ITYctxcsIndexService tYctxcsIndexService;

    /**
     * 查询延迟退休测算方案默认参数表列表
     */
    @PreAuthorize("@ss.hasPermi('system:index:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsIndex tYctxcsIndex)
    {
        startPage();
        List<TYctxcsIndex> list = tYctxcsIndexService.selectTYctxcsIndexList(tYctxcsIndex);
        return getDataTable(list);
    }

    /**
     * 导出延迟退休测算方案默认参数表列表
     */
    @PreAuthorize("@ss.hasPermi('system:index:export')")
    @Log(title = "延迟退休测算方案默认参数表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsIndex tYctxcsIndex)
    {
        List<TYctxcsIndex> list = tYctxcsIndexService.selectTYctxcsIndexList(tYctxcsIndex);
        ExcelUtil<TYctxcsIndex> util = new ExcelUtil<TYctxcsIndex>(TYctxcsIndex.class);
        util.exportExcel(response, list, "延迟退休测算方案默认参数表数据");
    }

    /**
     * 获取延迟退休测算方案默认参数表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:index:query')")
    @GetMapping(value = "/{planArea}")
    public AjaxResult getInfo(@PathVariable("planArea") Long planArea)
    {
        return success(tYctxcsIndexService.selectTYctxcsIndexByPlanArea(planArea));
    }

    /**
     * 新增延迟退休测算方案默认参数表
     */
    @PreAuthorize("@ss.hasPermi('system:index:add')")
    @Log(title = "延迟退休测算方案默认参数表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsIndex tYctxcsIndex)
    {
        return toAjax(tYctxcsIndexService.insertTYctxcsIndex(tYctxcsIndex));
    }

    /**
     * 修改延迟退休测算方案默认参数表
     */
    @PreAuthorize("@ss.hasPermi('system:index:edit')")
    @Log(title = "延迟退休测算方案默认参数表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsIndex tYctxcsIndex)
    {
        return toAjax(tYctxcsIndexService.updateTYctxcsIndex(tYctxcsIndex));
    }

    /**
     * 删除延迟退休测算方案默认参数表
     */
    @PreAuthorize("@ss.hasPermi('system:index:remove')")
    @Log(title = "延迟退休测算方案默认参数表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{planAreas}")
    public AjaxResult remove(@PathVariable Long[] planAreas)
    {
        return toAjax(tYctxcsIndexService.deleteTYctxcsIndexByPlanAreas(planAreas));
    }
}
