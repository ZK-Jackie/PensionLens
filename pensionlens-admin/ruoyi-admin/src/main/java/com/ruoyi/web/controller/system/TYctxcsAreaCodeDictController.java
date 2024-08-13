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
import com.ruoyi.system.domain.TYctxcsAreaCodeDict;
import com.ruoyi.system.service.ITYctxcsAreaCodeDictService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测算统筹区域Controller
 *
 * @author gdouyj
 * @date 2024-08-09
 */
@RestController
@RequestMapping("/system/area_code_dict")
public class TYctxcsAreaCodeDictController extends BaseController
{
    @Autowired
    private ITYctxcsAreaCodeDictService tYctxcsAreaCodeDictService;

    /**
     * 查询测算统筹区域列表
     */
    @PreAuthorize("@ss.hasPermi('system:area_code_dict:list')")
    @GetMapping("/list")
    public TableDataInfo list(TYctxcsAreaCodeDict tYctxcsAreaCodeDict)
    {
        startPage();
        List<TYctxcsAreaCodeDict> list = tYctxcsAreaCodeDictService.selectTYctxcsAreaCodeDictList(tYctxcsAreaCodeDict);
        return getDataTable(list);
    }

    /**
     * 导出测算统筹区域列表
     */
    @PreAuthorize("@ss.hasPermi('system:area_code_dict:export')")
    @Log(title = "测算统筹区域", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TYctxcsAreaCodeDict tYctxcsAreaCodeDict)
    {
        List<TYctxcsAreaCodeDict> list = tYctxcsAreaCodeDictService.selectTYctxcsAreaCodeDictList(tYctxcsAreaCodeDict);
        ExcelUtil<TYctxcsAreaCodeDict> util = new ExcelUtil<TYctxcsAreaCodeDict>(TYctxcsAreaCodeDict.class);
        util.exportExcel(response, list, "测算统筹区域数据");
    }

    /**
     * 获取测算统筹区域详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:area_code_dict:query')")
    @GetMapping(value = "/{code}")
    public AjaxResult getInfo(@PathVariable("code") Long code)
    {
        return success(tYctxcsAreaCodeDictService.selectTYctxcsAreaCodeDictByCode(code));
    }

    /**
     * 新增测算统筹区域
     */
    @PreAuthorize("@ss.hasPermi('system:area_code_dict:add')")
    @Log(title = "测算统筹区域", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TYctxcsAreaCodeDict tYctxcsAreaCodeDict)
    {
        return toAjax(tYctxcsAreaCodeDictService.insertTYctxcsAreaCodeDict(tYctxcsAreaCodeDict));
    }

    /**
     * 修改测算统筹区域
     */
    @PreAuthorize("@ss.hasPermi('system:area_code_dict:edit')")
    @Log(title = "测算统筹区域", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TYctxcsAreaCodeDict tYctxcsAreaCodeDict)
    {
        return toAjax(tYctxcsAreaCodeDictService.updateTYctxcsAreaCodeDict(tYctxcsAreaCodeDict));
    }

    /**
     * 删除测算统筹区域
     */
    @PreAuthorize("@ss.hasPermi('system:area_code_dict:remove')")
    @Log(title = "测算统筹区域", businessType = BusinessType.DELETE)
	@DeleteMapping("/{codes}")
    public AjaxResult remove(@PathVariable Long[] codes)
    {
        return toAjax(tYctxcsAreaCodeDictService.deleteTYctxcsAreaCodeDictByCodes(codes));
    }
}
