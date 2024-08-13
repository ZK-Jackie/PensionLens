package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TYctxcsAreaCodeDict;

/**
 * 测算统筹区域Service接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface ITYctxcsAreaCodeDictService 
{
    /**
     * 查询测算统筹区域
     * 
     * @param code 测算统筹区域主键
     * @return 测算统筹区域
     */
    public TYctxcsAreaCodeDict selectTYctxcsAreaCodeDictByCode(Long code);

    /**
     * 查询测算统筹区域列表
     * 
     * @param tYctxcsAreaCodeDict 测算统筹区域
     * @return 测算统筹区域集合
     */
    public List<TYctxcsAreaCodeDict> selectTYctxcsAreaCodeDictList(TYctxcsAreaCodeDict tYctxcsAreaCodeDict);

    /**
     * 新增测算统筹区域
     * 
     * @param tYctxcsAreaCodeDict 测算统筹区域
     * @return 结果
     */
    public int insertTYctxcsAreaCodeDict(TYctxcsAreaCodeDict tYctxcsAreaCodeDict);

    /**
     * 修改测算统筹区域
     * 
     * @param tYctxcsAreaCodeDict 测算统筹区域
     * @return 结果
     */
    public int updateTYctxcsAreaCodeDict(TYctxcsAreaCodeDict tYctxcsAreaCodeDict);

    /**
     * 批量删除测算统筹区域
     * 
     * @param codes 需要删除的测算统筹区域主键集合
     * @return 结果
     */
    public int deleteTYctxcsAreaCodeDictByCodes(Long[] codes);

    /**
     * 删除测算统筹区域信息
     * 
     * @param code 测算统筹区域主键
     * @return 结果
     */
    public int deleteTYctxcsAreaCodeDictByCode(Long code);
}
