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
import com.ruoyi.system.domain.Screen;
import com.ruoyi.system.service.IScreenService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 大屏表Controller
 * 
 * @author gdouyj
 * @date 2024-08-11
 */
@RestController
@RequestMapping("/system/screen")
public class ScreenController extends BaseController
{
    @Autowired
    private IScreenService screenService;

    /**
     * 查询大屏表列表
     */
    @PreAuthorize("@ss.hasPermi('system:screen:list')")
    @GetMapping("/list")
    public TableDataInfo list(Screen screen)
    {
        startPage();
        List<Screen> list = screenService.selectScreenList(screen);
        return getDataTable(list);
    }

    /**
     * 导出大屏表列表
     */
    @PreAuthorize("@ss.hasPermi('system:screen:export')")
    @Log(title = "大屏表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Screen screen)
    {
        List<Screen> list = screenService.selectScreenList(screen);
        ExcelUtil<Screen> util = new ExcelUtil<Screen>(Screen.class);
        util.exportExcel(response, list, "大屏表数据");
    }

    /**
     * 获取大屏表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:screen:query')")
    @GetMapping(value = "/{screenId}")
    public AjaxResult getInfo(@PathVariable("screenId") Long screenId)
    {
        return success(screenService.selectScreenByScreenId(screenId));
    }

    /**
     * 新增大屏表
     */
    @PreAuthorize("@ss.hasPermi('system:screen:add')")
    @Log(title = "大屏表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Screen screen)
    {
        return toAjax(screenService.insertScreen(screen));
    }

    /**
     * 修改大屏表
     */
    @PreAuthorize("@ss.hasPermi('system:screen:edit')")
    @Log(title = "大屏表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Screen screen)
    {
        return toAjax(screenService.updateScreen(screen));
    }

    /**
     * 删除大屏表
     */
    @PreAuthorize("@ss.hasPermi('system:screen:remove')")
    @Log(title = "大屏表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{screenIds}")
    public AjaxResult remove(@PathVariable Long[] screenIds)
    {
        return toAjax(screenService.deleteScreenByScreenIds(screenIds));
    }
}
