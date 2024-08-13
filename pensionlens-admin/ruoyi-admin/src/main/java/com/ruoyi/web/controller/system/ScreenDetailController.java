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
import com.ruoyi.system.domain.ScreenDetail;
import com.ruoyi.system.service.IScreenDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 大屏配置表Controller
 *
 * @author gdouyj
 * @date 2024-08-11
 */
@RestController
@RequestMapping("/system/screen_detail")
public class ScreenDetailController extends BaseController
{
    @Autowired
    private IScreenDetailService screenDetailService;

    /**
     * 查询大屏配置表列表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScreenDetail screenDetail)
    {
        startPage();
        List<ScreenDetail> list = screenDetailService.selectScreenDetailList(screenDetail);
        return getDataTable(list);
    }

    /**
     * 导出大屏配置表列表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_detail:export')")
    @Log(title = "大屏配置表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScreenDetail screenDetail)
    {
        List<ScreenDetail> list = screenDetailService.selectScreenDetailList(screenDetail);
        ExcelUtil<ScreenDetail> util = new ExcelUtil<ScreenDetail>(ScreenDetail.class);
        util.exportExcel(response, list, "大屏配置表数据");
    }

    /**
     * 获取大屏配置表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:screen_detail:query')")
    @GetMapping(value = "/{detailId}")
    public AjaxResult getInfo(@PathVariable("detailId") Long detailId)
    {
        return success(screenDetailService.selectScreenDetailByDetailId(detailId));
    }

    /**
     * 新增大屏配置表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_detail:add')")
    @Log(title = "大屏配置表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScreenDetail screenDetail)
    {
        return toAjax(screenDetailService.insertScreenDetail(screenDetail));
    }

    /**
     * 修改大屏配置表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_detail:edit')")
    @Log(title = "大屏配置表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScreenDetail screenDetail)
    {
        return toAjax(screenDetailService.updateScreenDetail(screenDetail));
    }

    /**
     * 删除大屏配置表
     */
    @PreAuthorize("@ss.hasPermi('system:screen_detail:remove')")
    @Log(title = "大屏配置表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{detailIds}")
    public AjaxResult remove(@PathVariable Long[] detailIds)
    {
        return toAjax(screenDetailService.deleteScreenDetailByDetailIds(detailIds));
    }
}
