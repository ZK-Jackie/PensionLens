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
import com.ruoyi.system.domain.TYctxcsPlanIndexUrban;
import com.ruoyi.system.service.ITYctxcsPlanIndexUrbanService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测算城镇化率参数表Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/index_urban")
public class TYctxcsPlanIndexUrbanController extends BaseController
{
    @Autowired
    private ITYctxcsPlanIndexUrbanService tYctxcsPlanIndexUrbanService;

    /**
     * 查询测算城镇化率参数表列表
     */
    @PreAuthorize("@ss.hasPermi('system:index_urban:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsPlanIndexUrban tYctxcsPlanIndexUrban)
    {
        startPage();
        List<TYctxcsPlanIndexUrban> list = tYctxcsPlanIndexUrbanService.selectTYctxcsPlanIndexUrbanList(tYctxcsPlanIndexUrban);
        return getDataTable(list);
    }

    /**
     * 导出测算城镇化率参数表列表
     */
    @PreAuthorize("@ss.hasPermi('system:index_urban:export')")
    @Log(title = "测算城镇化率参数表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsPlanIndexUrban tYctxcsPlanIndexUrban)
    {
        List<TYctxcsPlanIndexUrban> list = tYctxcsPlanIndexUrbanService.selectTYctxcsPlanIndexUrbanList(tYctxcsPlanIndexUrban);
        ExcelUtil<TYctxcsPlanIndexUrban> util = new ExcelUtil<TYctxcsPlanIndexUrban>(TYctxcsPlanIndexUrban.class);
        util.exportExcel(response, list, "测算城镇化率参数表数据");
    }

    /**
     * 获取测算城镇化率参数表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:index_urban:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tYctxcsPlanIndexUrbanService.selectTYctxcsPlanIndexUrbanById(id));
    }

    /**
     * 新增测算城镇化率参数表
     */
    @PreAuthorize("@ss.hasPermi('system:index_urban:add')")
    @Log(title = "测算城镇化率参数表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsPlanIndexUrban tYctxcsPlanIndexUrban)
    {
        return toAjax(tYctxcsPlanIndexUrbanService.insertTYctxcsPlanIndexUrban(tYctxcsPlanIndexUrban));
    }

    /**
     * 修改测算城镇化率参数表
     */
    @PreAuthorize("@ss.hasPermi('system:index_urban:edit')")
    @Log(title = "测算城镇化率参数表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsPlanIndexUrban tYctxcsPlanIndexUrban)
    {
        return toAjax(tYctxcsPlanIndexUrbanService.updateTYctxcsPlanIndexUrban(tYctxcsPlanIndexUrban));
    }

    /**
     * 删除测算城镇化率参数表
     */
    @PreAuthorize("@ss.hasPermi('system:index_urban:remove')")
    @Log(title = "测算城镇化率参数表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tYctxcsPlanIndexUrbanService.deleteTYctxcsPlanIndexUrbanByIds(ids));
    }
}
