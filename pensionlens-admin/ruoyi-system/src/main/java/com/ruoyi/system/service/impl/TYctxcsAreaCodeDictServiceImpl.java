package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TYctxcsAreaCodeDictMapper;
import com.ruoyi.system.domain.TYctxcsAreaCodeDict;
import com.ruoyi.system.service.ITYctxcsAreaCodeDictService;

/**
 * 测算统筹区域Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class TYctxcsAreaCodeDictServiceImpl implements ITYctxcsAreaCodeDictService 
{
    @Autowired
    private TYctxcsAreaCodeDictMapper tYctxcsAreaCodeDictMapper;

    /**
     * 查询测算统筹区域
     * 
     * @param code 测算统筹区域主键
     * @return 测算统筹区域
     */
    @Override
    public TYctxcsAreaCodeDict selectTYctxcsAreaCodeDictByCode(Long code)
    {
        return tYctxcsAreaCodeDictMapper.selectTYctxcsAreaCodeDictByCode(code);
    }

    /**
     * 查询测算统筹区域列表
     * 
     * @param tYctxcsAreaCodeDict 测算统筹区域
     * @return 测算统筹区域
     */
    @Override
    public List<TYctxcsAreaCodeDict> selectTYctxcsAreaCodeDictList(TYctxcsAreaCodeDict tYctxcsAreaCodeDict)
    {
        return tYctxcsAreaCodeDictMapper.selectTYctxcsAreaCodeDictList(tYctxcsAreaCodeDict);
    }

    /**
     * 新增测算统筹区域
     * 
     * @param tYctxcsAreaCodeDict 测算统筹区域
     * @return 结果
     */
    @Override
    public int insertTYctxcsAreaCodeDict(TYctxcsAreaCodeDict tYctxcsAreaCodeDict)
    {
        return tYctxcsAreaCodeDictMapper.insertTYctxcsAreaCodeDict(tYctxcsAreaCodeDict);
    }

    /**
     * 修改测算统筹区域
     * 
     * @param tYctxcsAreaCodeDict 测算统筹区域
     * @return 结果
     */
    @Override
    public int updateTYctxcsAreaCodeDict(TYctxcsAreaCodeDict tYctxcsAreaCodeDict)
    {
        return tYctxcsAreaCodeDictMapper.updateTYctxcsAreaCodeDict(tYctxcsAreaCodeDict);
    }

    /**
     * 批量删除测算统筹区域
     * 
     * @param codes 需要删除的测算统筹区域主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsAreaCodeDictByCodes(Long[] codes)
    {
        return tYctxcsAreaCodeDictMapper.deleteTYctxcsAreaCodeDictByCodes(codes);
    }

    /**
     * 删除测算统筹区域信息
     * 
     * @param code 测算统筹区域主键
     * @return 结果
     */
    @Override
    public int deleteTYctxcsAreaCodeDictByCode(Long code)
    {
        return tYctxcsAreaCodeDictMapper.deleteTYctxcsAreaCodeDictByCode(code);
    }
}
