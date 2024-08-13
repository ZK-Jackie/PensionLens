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
import com.ruoyi.system.domain.ScreenDetailData;
import com.ruoyi.system.service.IScreenDetailDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 大屏空位与大屏数据对照表Controller
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
@RestController
@RequestMapping("/system/screen_detail_data")
public class ScreenDetailDataController extends BaseController
{
    @Autowired
    private IScreenDetailDataService screenDetailDataService;

    /**
     * 查询大屏空位与大屏数据对照表列表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_detail_data:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScreenDetailData screenDetailData)
    {
        startPage();
        List<ScreenDetailData> list = screenDetailDataService.selectScreenDetailDataList(screenDetailData);
        return getDataTable(list);
    }

    /**
     * 导出大屏空位与大屏数据对照表列表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_detail_data:export')")
    @Log(title = "大屏空位与大屏数据对照表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScreenDetailData screenDetailData)
    {
        List<ScreenDetailData> list = screenDetailDataService.selectScreenDetailDataList(screenDetailData);
        ExcelUtil<ScreenDetailData> util = new ExcelUtil<ScreenDetailData>(ScreenDetailData.class);
        util.exportExcel(response, list, "大屏空位与大屏数据对照表数据");
    }

    /**
     * 获取大屏空位与大屏数据对照表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:screen_detail_data:query')")
    @GetMapping(value = "/{detailId}")
    public AjaxResult getInfo(@PathVariable("detailId") Long detailId)
    {
        return success(screenDetailDataService.selectScreenDetailDataByDetailId(detailId));
    }

    /**
     * 新增大屏空位与大屏数据对照表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_detail_data:add')")
    @Log(title = "大屏空位与大屏数据对照表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScreenDetailData screenDetailData)
    {
        return toAjax(screenDetailDataService.insertScreenDetailData(screenDetailData));
    }

    /**
     * 修改大屏空位与大屏数据对照表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_detail_data:edit')")
    @Log(title = "大屏空位与大屏数据对照表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScreenDetailData screenDetailData)
    {
        return toAjax(screenDetailDataService.updateScreenDetailData(screenDetailData));
    }

    /**
     * 删除大屏空位与大屏数据对照表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_detail_data:remove')")
    @Log(title = "大屏空位与大屏数据对照表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{detailIds}")
    public AjaxResult remove(@PathVariable Long[] detailIds)
    {
        return toAjax(screenDetailDataService.deleteScreenDetailDataByDetailIds(detailIds));
    }
}
