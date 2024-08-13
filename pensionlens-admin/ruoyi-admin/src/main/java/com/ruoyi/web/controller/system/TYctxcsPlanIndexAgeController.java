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
import com.ruoyi.system.domain.TYctxcsPlanIndexAge;
import com.ruoyi.system.service.ITYctxcsPlanIndexAgeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测算方案参数表（按年龄）Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/index_age")
public class TYctxcsPlanIndexAgeController extends BaseController
{
    @Autowired
    private ITYctxcsPlanIndexAgeService tYctxcsPlanIndexAgeService;

    /**
     * 查询测算方案参数表（按年龄）列表
     */
    @PreAuthorize("@ss.hasPermi('system:index_age:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsPlanIndexAge tYctxcsPlanIndexAge)
    {
        startPage();
        List<TYctxcsPlanIndexAge> list = tYctxcsPlanIndexAgeService.selectTYctxcsPlanIndexAgeList(tYctxcsPlanIndexAge);
        return getDataTable(list);
    }

    /**
     * 导出测算方案参数表（按年龄）列表
     */
    @PreAuthorize("@ss.hasPermi('system:index_age:export')")
    @Log(title = "测算方案参数表（按年龄）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsPlanIndexAge tYctxcsPlanIndexAge)
    {
        List<TYctxcsPlanIndexAge> list = tYctxcsPlanIndexAgeService.selectTYctxcsPlanIndexAgeList(tYctxcsPlanIndexAge);
        ExcelUtil<TYctxcsPlanIndexAge> util = new ExcelUtil<TYctxcsPlanIndexAge>(TYctxcsPlanIndexAge.class);
        util.exportExcel(response, list, "测算方案参数表（按年龄）数据");
    }

    /**
     * 获取测算方案参数表（按年龄）详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:index_age:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tYctxcsPlanIndexAgeService.selectTYctxcsPlanIndexAgeById(id));
    }

    /**
     * 新增测算方案参数表（按年龄）
     */
    @PreAuthorize("@ss.hasPermi('system:index_age:add')")
    @Log(title = "测算方案参数表（按年龄）", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsPlanIndexAge tYctxcsPlanIndexAge)
    {
        return toAjax(tYctxcsPlanIndexAgeService.insertTYctxcsPlanIndexAge(tYctxcsPlanIndexAge));
    }

    /**
     * 修改测算方案参数表（按年龄）
     */
    @PreAuthorize("@ss.hasPermi('system:index_age:edit')")
    @Log(title = "测算方案参数表（按年龄）", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsPlanIndexAge tYctxcsPlanIndexAge)
    {
        return toAjax(tYctxcsPlanIndexAgeService.updateTYctxcsPlanIndexAge(tYctxcsPlanIndexAge));
    }

    /**
     * 删除测算方案参数表（按年龄）
     */
    @PreAuthorize("@ss.hasPermi('system:index_age:remove')")
    @Log(title = "测算方案参数表（按年龄）", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tYctxcsPlanIndexAgeService.deleteTYctxcsPlanIndexAgeByIds(ids));
    }
}
