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
import com.ruoyi.system.domain.TYctxcsPersonIndex;
import com.ruoyi.system.service.ITYctxcsPersonIndexService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测算默认人口数量表Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/person_index")
public class TYctxcsPersonIndexController extends BaseController
{
    @Autowired
    private ITYctxcsPersonIndexService tYctxcsPersonIndexService;

    /**
     * 查询测算默认人口数量表列表
     */
    @PreAuthorize("@ss.hasPermi('system:person_index:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsPersonIndex tYctxcsPersonIndex)
    {
        startPage();
        List<TYctxcsPersonIndex> list = tYctxcsPersonIndexService.selectTYctxcsPersonIndexList(tYctxcsPersonIndex);
        return getDataTable(list);
    }

    /**
     * 导出测算默认人口数量表列表
     */
    @PreAuthorize("@ss.hasPermi('system:person_index:export')")
    @Log(title = "测算默认人口数量表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsPersonIndex tYctxcsPersonIndex)
    {
        List<TYctxcsPersonIndex> list = tYctxcsPersonIndexService.selectTYctxcsPersonIndexList(tYctxcsPersonIndex);
        ExcelUtil<TYctxcsPersonIndex> util = new ExcelUtil<TYctxcsPersonIndex>(TYctxcsPersonIndex.class);
        util.exportExcel(response, list, "测算默认人口数量表数据");
    }

    /**
     * 获取测算默认人口数量表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:person_index:query')")
    @GetMapping(value = "/{planArea}")
    public AjaxResult getInfo(@PathVariable("planArea") Long planArea)
    {
        return success(tYctxcsPersonIndexService.selectTYctxcsPersonIndexByPlanArea(planArea));
    }

    /**
     * 新增测算默认人口数量表
     */
    @PreAuthorize("@ss.hasPermi('system:person_index:add')")
    @Log(title = "测算默认人口数量表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsPersonIndex tYctxcsPersonIndex)
    {
        return toAjax(tYctxcsPersonIndexService.insertTYctxcsPersonIndex(tYctxcsPersonIndex));
    }

    /**
     * 修改测算默认人口数量表
     */
    @PreAuthorize("@ss.hasPermi('system:person_index:edit')")
    @Log(title = "测算默认人口数量表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsPersonIndex tYctxcsPersonIndex)
    {
        return toAjax(tYctxcsPersonIndexService.updateTYctxcsPersonIndex(tYctxcsPersonIndex));
    }

    /**
     * 删除测算默认人口数量表
     */
    @PreAuthorize("@ss.hasPermi('system:person_index:remove')")
    @Log(title = "测算默认人口数量表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{planAreas}")
    public AjaxResult remove(@PathVariable Long[] planAreas)
    {
        return toAjax(tYctxcsPersonIndexService.deleteTYctxcsPersonIndexByPlanAreas(planAreas));
    }
}
