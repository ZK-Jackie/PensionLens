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
import com.ruoyi.system.domain.TYctxcsPlanIndexUrbanHis;
import com.ruoyi.system.service.ITYctxcsPlanIndexUrbanHisService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测算城镇化率历史表Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/index_urban_his")
public class TYctxcsPlanIndexUrbanHisController extends BaseController
{
    @Autowired
    private ITYctxcsPlanIndexUrbanHisService tYctxcsPlanIndexUrbanHisService;

    /**
     * 查询测算城镇化率历史表列表
     */
    @PreAuthorize("@ss.hasPermi('system:index_urban_his:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsPlanIndexUrbanHis tYctxcsPlanIndexUrbanHis)
    {
        startPage();
        List<TYctxcsPlanIndexUrbanHis> list = tYctxcsPlanIndexUrbanHisService.selectTYctxcsPlanIndexUrbanHisList(tYctxcsPlanIndexUrbanHis);
        return getDataTable(list);
    }

    /**
     * 导出测算城镇化率历史表列表
     */
    @PreAuthorize("@ss.hasPermi('system:index_urban_his:export')")
    @Log(title = "测算城镇化率历史表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsPlanIndexUrbanHis tYctxcsPlanIndexUrbanHis)
    {
        List<TYctxcsPlanIndexUrbanHis> list = tYctxcsPlanIndexUrbanHisService.selectTYctxcsPlanIndexUrbanHisList(tYctxcsPlanIndexUrbanHis);
        ExcelUtil<TYctxcsPlanIndexUrbanHis> util = new ExcelUtil<TYctxcsPlanIndexUrbanHis>(TYctxcsPlanIndexUrbanHis.class);
        util.exportExcel(response, list, "测算城镇化率历史表数据");
    }

    /**
     * 获取测算城镇化率历史表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:index_urban_his:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tYctxcsPlanIndexUrbanHisService.selectTYctxcsPlanIndexUrbanHisById(id));
    }

    /**
     * 新增测算城镇化率历史表
     */
    @PreAuthorize("@ss.hasPermi('system:index_urban_his:add')")
    @Log(title = "测算城镇化率历史表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsPlanIndexUrbanHis tYctxcsPlanIndexUrbanHis)
    {
        return toAjax(tYctxcsPlanIndexUrbanHisService.insertTYctxcsPlanIndexUrbanHis(tYctxcsPlanIndexUrbanHis));
    }

    /**
     * 修改测算城镇化率历史表
     */
    @PreAuthorize("@ss.hasPermi('system:index_urban_his:edit')")
    @Log(title = "测算城镇化率历史表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsPlanIndexUrbanHis tYctxcsPlanIndexUrbanHis)
    {
        return toAjax(tYctxcsPlanIndexUrbanHisService.updateTYctxcsPlanIndexUrbanHis(tYctxcsPlanIndexUrbanHis));
    }

    /**
     * 删除测算城镇化率历史表
     */
    @PreAuthorize("@ss.hasPermi('system:index_urban_his:remove')")
    @Log(title = "测算城镇化率历史表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tYctxcsPlanIndexUrbanHisService.deleteTYctxcsPlanIndexUrbanHisByIds(ids));
    }
}
