package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.ScreenColor;
import com.ruoyi.system.service.IScreenColorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 大屏颜色设置Controller
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
@RestController
@RequestMapping("/system/screen_color")
public class ScreenColorController extends BaseController
{
    @Autowired
    private IScreenColorService screenColorService;

    /**
     * 查询大屏颜色设置列表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_color:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScreenColor screenColor)
    {
        startPage();
        List<ScreenColor> list = screenColorService.selectScreenColorList(screenColor);
        return getDataTable(list);
    }

    /**
     * 导出大屏颜色设置列表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_color:export')")
    @Log(title = "大屏颜色设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScreenColor screenColor)
    {
        List<ScreenColor> list = screenColorService.selectScreenColorList(screenColor);
        ExcelUtil<ScreenColor> util = new ExcelUtil<ScreenColor>(ScreenColor.class);
        util.exportExcel(response, list, "大屏颜色设置数据");
    }

    /**
     * 获取大屏颜色设置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:screen_color:query')")
    @GetMapping(value = "/{dataColorId}")
    public AjaxResult getInfo(@PathVariable("dataColorId") Long dataColorId)
    {
        return success(screenColorService.selectScreenColorByDataColorId(dataColorId));
    }

    /**
     * 新增大屏颜色设置
     */
    @PreAuthorize("@ss.hasPermi('system:screen_color:add')")
    @Log(title = "大屏颜色设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScreenColor screenColor)
    {
        return toAjax(screenColorService.insertScreenColor(screenColor));
    }

    /**
     * 修改大屏颜色设置
     */
    @PreAuthorize("@ss.hasPermi('system:screen_color:edit')")
    @Log(title = "大屏颜色设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScreenColor screenColor)
    {
        return toAjax(screenColorService.updateScreenColor(screenColor));
    }

    /**
     * 删除大屏颜色设置
     */
    @PreAuthorize("@ss.hasPermi('system:screen_color:remove')")
    @Log(title = "大屏颜色设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dataColorIds}")
    public AjaxResult remove(@PathVariable Long[] dataColorIds)
    {
        return toAjax(screenColorService.deleteScreenColorByDataColorIds(dataColorIds));
    }
}
