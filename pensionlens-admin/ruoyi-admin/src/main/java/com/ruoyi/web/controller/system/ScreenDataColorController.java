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
import com.ruoyi.system.domain.ScreenDataColor;
import com.ruoyi.system.service.IScreenDataColorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 大屏数据颜色设置Controller
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
@RestController
@RequestMapping("/system/screen_data_color")
public class ScreenDataColorController extends BaseController
{
    @Autowired
    private IScreenDataColorService screenDataColorService;

    /**
     * 查询大屏数据颜色设置列表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_data_color:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScreenDataColor screenDataColor)
    {
        startPage();
        List<ScreenDataColor> list = screenDataColorService.selectScreenDataColorList(screenDataColor);
        return getDataTable(list);
    }

    /**
     * 导出大屏数据颜色设置列表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_data_color:export')")
    @Log(title = "大屏数据颜色设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScreenDataColor screenDataColor)
    {
        List<ScreenDataColor> list = screenDataColorService.selectScreenDataColorList(screenDataColor);
        ExcelUtil<ScreenDataColor> util = new ExcelUtil<ScreenDataColor>(ScreenDataColor.class);
        util.exportExcel(response, list, "大屏数据颜色设置数据");
    }

    /**
     * 获取大屏数据颜色设置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:screen_data_color:query')")
    @GetMapping(value = "/{dataColorId}")
    public AjaxResult getInfo(@PathVariable("dataColorId") Long dataColorId)
    {
        return success(screenDataColorService.selectScreenDataColorByDataColorId(dataColorId));
    }

    /**
     * 新增大屏数据颜色设置
     */
    @PreAuthorize("@ss.hasPermi('system:screen_data_color:add')")
    @Log(title = "大屏数据颜色设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScreenDataColor screenDataColor)
    {
        return toAjax(screenDataColorService.insertScreenDataColor(screenDataColor));
    }

    /**
     * 修改大屏数据颜色设置
     */
    @PreAuthorize("@ss.hasPermi('system:screen_data_color:edit')")
    @Log(title = "大屏数据颜色设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScreenDataColor screenDataColor)
    {
        return toAjax(screenDataColorService.updateScreenDataColor(screenDataColor));
    }

    /**
     * 删除大屏数据颜色设置
     */
    @PreAuthorize("@ss.hasPermi('system:screen_data_color:remove')")
    @Log(title = "大屏数据颜色设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dataColorIds}")
    public AjaxResult remove(@PathVariable Long[] dataColorIds)
    {
        return toAjax(screenDataColorService.deleteScreenDataColorByDataColorIds(dataColorIds));
    }
}
