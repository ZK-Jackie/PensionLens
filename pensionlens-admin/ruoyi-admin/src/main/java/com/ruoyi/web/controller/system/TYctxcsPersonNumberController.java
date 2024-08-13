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
import com.ruoyi.system.domain.TYctxcsPersonNumber;
import com.ruoyi.system.service.ITYctxcsPersonNumberService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测算默认年份分年龄性别人数Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/person_number")
public class TYctxcsPersonNumberController extends BaseController
{
    @Autowired
    private ITYctxcsPersonNumberService tYctxcsPersonNumberService;

    /**
     * 查询测算默认年份分年龄性别人数列表
     */
    @PreAuthorize("@ss.hasPermi('system:person_number:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsPersonNumber tYctxcsPersonNumber)
    {
        startPage();
        List<TYctxcsPersonNumber> list = tYctxcsPersonNumberService.selectTYctxcsPersonNumberList(tYctxcsPersonNumber);
        return getDataTable(list);
    }

    /**
     * 导出测算默认年份分年龄性别人数列表
     */
    @PreAuthorize("@ss.hasPermi('system:person_number:export')")
    @Log(title = "测算默认年份分年龄性别人数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsPersonNumber tYctxcsPersonNumber)
    {
        List<TYctxcsPersonNumber> list = tYctxcsPersonNumberService.selectTYctxcsPersonNumberList(tYctxcsPersonNumber);
        ExcelUtil<TYctxcsPersonNumber> util = new ExcelUtil<TYctxcsPersonNumber>(TYctxcsPersonNumber.class);
        util.exportExcel(response, list, "测算默认年份分年龄性别人数数据");
    }

    /**
     * 获取测算默认年份分年龄性别人数详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:person_number:query')")
    @GetMapping(value = "/{planArea}")
    public AjaxResult getInfo(@PathVariable("planArea") Long planArea)
    {
        return success(tYctxcsPersonNumberService.selectTYctxcsPersonNumberByPlanArea(planArea));
    }

    /**
     * 新增测算默认年份分年龄性别人数
     */
    @PreAuthorize("@ss.hasPermi('system:person_number:add')")
    @Log(title = "测算默认年份分年龄性别人数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsPersonNumber tYctxcsPersonNumber)
    {
        return toAjax(tYctxcsPersonNumberService.insertTYctxcsPersonNumber(tYctxcsPersonNumber));
    }

    /**
     * 修改测算默认年份分年龄性别人数
     */
    @PreAuthorize("@ss.hasPermi('system:person_number:edit')")
    @Log(title = "测算默认年份分年龄性别人数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsPersonNumber tYctxcsPersonNumber)
    {
        return toAjax(tYctxcsPersonNumberService.updateTYctxcsPersonNumber(tYctxcsPersonNumber));
    }

    /**
     * 删除测算默认年份分年龄性别人数
     */
    @PreAuthorize("@ss.hasPermi('system:person_number:remove')")
    @Log(title = "测算默认年份分年龄性别人数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{planAreas}")
    public AjaxResult remove(@PathVariable Long[] planAreas)
    {
        return toAjax(tYctxcsPersonNumberService.deleteTYctxcsPersonNumberByPlanAreas(planAreas));
    }
}
