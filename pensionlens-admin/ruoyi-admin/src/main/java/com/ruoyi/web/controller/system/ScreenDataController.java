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
import com.ruoyi.system.domain.ScreenData;
import com.ruoyi.system.service.IScreenDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 大屏数据定位Controller
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
@RestController
@RequestMapping("/system/screen_data")
public class ScreenDataController extends BaseController
{
    @Autowired
    private IScreenDataService screenDataService;

    /**
     * 查询大屏数据定位列表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_data:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScreenData screenData)
    {
        startPage();
        List<ScreenData> list = screenDataService.selectScreenDataList(screenData);
        return getDataTable(list);
    }

    /**
     * 导出大屏数据定位列表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_data:export')")
    @Log(title = "大屏数据定位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScreenData screenData)
    {
        List<ScreenData> list = screenDataService.selectScreenDataList(screenData);
        ExcelUtil<ScreenData> util = new ExcelUtil<ScreenData>(ScreenData.class);
        util.exportExcel(response, list, "大屏数据定位数据");
    }

    /**
     * 获取大屏数据定位详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:screen_data:query')")
    @GetMapping(value = "/{dataId}")
    public AjaxResult getInfo(@PathVariable("dataId") Long dataId)
    {
        return success(screenDataService.selectScreenDataByDataId(dataId));
    }

    /**
     * 新增大屏数据定位
     */
    @PreAuthorize("@ss.hasPermi('system:screen_data:add')")
    @Log(title = "大屏数据定位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScreenData screenData)
    {
        return toAjax(screenDataService.insertScreenData(screenData));
    }

    /**
     * 修改大屏数据定位
     */
    @PreAuthorize("@ss.hasPermi('system:screen_data:edit')")
    @Log(title = "大屏数据定位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScreenData screenData)
    {
        return toAjax(screenDataService.updateScreenData(screenData));
    }

    /**
     * 删除大屏数据定位
     */
    @PreAuthorize("@ss.hasPermi('system:screen_data:remove')")
    @Log(title = "大屏数据定位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dataIds}")
    public AjaxResult remove(@PathVariable Long[] dataIds)
    {
        return toAjax(screenDataService.deleteScreenDataByDataIds(dataIds));
    }
}
