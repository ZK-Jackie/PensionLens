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
import com.ruoyi.system.domain.TYctxcsUrbanRate;
import com.ruoyi.system.service.ITYctxcsUrbanRateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测算城镇化率默认参数表Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/urban_rate")
public class TYctxcsUrbanRateController extends BaseController
{
    @Autowired
    private ITYctxcsUrbanRateService tYctxcsUrbanRateService;

    /**
     * 查询测算城镇化率默认参数表列表
     */
    @PreAuthorize("@ss.hasPermi('system:urban_rate:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsUrbanRate tYctxcsUrbanRate)
    {
        startPage();
        List<TYctxcsUrbanRate> list = tYctxcsUrbanRateService.selectTYctxcsUrbanRateList(tYctxcsUrbanRate);
        return getDataTable(list);
    }

    /**
     * 导出测算城镇化率默认参数表列表
     */
    @PreAuthorize("@ss.hasPermi('system:urban_rate:export')")
    @Log(title = "测算城镇化率默认参数表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsUrbanRate tYctxcsUrbanRate)
    {
        List<TYctxcsUrbanRate> list = tYctxcsUrbanRateService.selectTYctxcsUrbanRateList(tYctxcsUrbanRate);
        ExcelUtil<TYctxcsUrbanRate> util = new ExcelUtil<TYctxcsUrbanRate>(TYctxcsUrbanRate.class);
        util.exportExcel(response, list, "测算城镇化率默认参数表数据");
    }

    /**
     * 获取测算城镇化率默认参数表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:urban_rate:query')")
    @GetMapping(value = "/{planArea}")
    public AjaxResult getInfo(@PathVariable("planArea") Long planArea)
    {
        return success(tYctxcsUrbanRateService.selectTYctxcsUrbanRateByPlanArea(planArea));
    }

    /**
     * 新增测算城镇化率默认参数表
     */
    @PreAuthorize("@ss.hasPermi('system:urban_rate:add')")
    @Log(title = "测算城镇化率默认参数表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsUrbanRate tYctxcsUrbanRate)
    {
        return toAjax(tYctxcsUrbanRateService.insertTYctxcsUrbanRate(tYctxcsUrbanRate));
    }

    /**
     * 修改测算城镇化率默认参数表
     */
    @PreAuthorize("@ss.hasPermi('system:urban_rate:edit')")
    @Log(title = "测算城镇化率默认参数表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsUrbanRate tYctxcsUrbanRate)
    {
        return toAjax(tYctxcsUrbanRateService.updateTYctxcsUrbanRate(tYctxcsUrbanRate));
    }

    /**
     * 删除测算城镇化率默认参数表
     */
    @PreAuthorize("@ss.hasPermi('system:urban_rate:remove')")
    @Log(title = "测算城镇化率默认参数表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{planAreas}")
    public AjaxResult remove(@PathVariable Long[] planAreas)
    {
        return toAjax(tYctxcsUrbanRateService.deleteTYctxcsUrbanRateByPlanAreas(planAreas));
    }
}
