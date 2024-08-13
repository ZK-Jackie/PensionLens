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
import com.ruoyi.system.domain.YYctxcsIndexDescription;
import com.ruoyi.system.service.IYYctxcsIndexDescriptionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测算方案参数描述表Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/index_description")
public class YYctxcsIndexDescriptionController extends BaseController
{
    @Autowired
    private IYYctxcsIndexDescriptionService yYctxcsIndexDescriptionService;

    /**
     * 查询测算方案参数描述表列表
     */
    @PreAuthorize("@ss.hasPermi('system:index_description:list')")
    @GetMapping("/list")
    public TableDataInfo list(YYctxcsIndexDescription yYctxcsIndexDescription)
    {
        startPage();
        List<YYctxcsIndexDescription> list = yYctxcsIndexDescriptionService.selectYYctxcsIndexDescriptionList(yYctxcsIndexDescription);
        return getDataTable(list);
    }

    /**
     * 导出测算方案参数描述表列表
     */
    @PreAuthorize("@ss.hasPermi('system:index_description:export')")
    @Log(title = "测算方案参数描述表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, YYctxcsIndexDescription yYctxcsIndexDescription)
    {
        List<YYctxcsIndexDescription> list = yYctxcsIndexDescriptionService.selectYYctxcsIndexDescriptionList(yYctxcsIndexDescription);
        ExcelUtil<YYctxcsIndexDescription> util = new ExcelUtil<YYctxcsIndexDescription>(YYctxcsIndexDescription.class);
        util.exportExcel(response, list, "测算方案参数描述表数据");
    }

    /**
     * 获取测算方案参数描述表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:index_description:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(yYctxcsIndexDescriptionService.selectYYctxcsIndexDescriptionById(id));
    }

    /**
     * 新增测算方案参数描述表
     */
    @PreAuthorize("@ss.hasPermi('system:index_description:add')")
    @Log(title = "测算方案参数描述表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody YYctxcsIndexDescription yYctxcsIndexDescription)
    {
        return toAjax(yYctxcsIndexDescriptionService.insertYYctxcsIndexDescription(yYctxcsIndexDescription));
    }

    /**
     * 修改测算方案参数描述表
     */
    @PreAuthorize("@ss.hasPermi('system:index_description:edit')")
    @Log(title = "测算方案参数描述表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody YYctxcsIndexDescription yYctxcsIndexDescription)
    {
        return toAjax(yYctxcsIndexDescriptionService.updateYYctxcsIndexDescription(yYctxcsIndexDescription));
    }

    /**
     * 删除测算方案参数描述表
     */
    @PreAuthorize("@ss.hasPermi('system:index_description:remove')")
    @Log(title = "测算方案参数描述表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(yYctxcsIndexDescriptionService.deleteYYctxcsIndexDescriptionByIds(ids));
    }
}
