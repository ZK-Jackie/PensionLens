package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.YYctxcsIndexDescriptionMapper;
import com.ruoyi.system.domain.YYctxcsIndexDescription;
import com.ruoyi.system.service.IYYctxcsIndexDescriptionService;

/**
 * 测算方案参数描述表Service业务层处理
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
@Service
public class YYctxcsIndexDescriptionServiceImpl implements IYYctxcsIndexDescriptionService 
{
    @Autowired
    private YYctxcsIndexDescriptionMapper yYctxcsIndexDescriptionMapper;

    /**
     * 查询测算方案参数描述表
     * 
     * @param id 测算方案参数描述表主键
     * @return 测算方案参数描述表
     */
    @Override
    public YYctxcsIndexDescription selectYYctxcsIndexDescriptionById(Long id)
    {
        return yYctxcsIndexDescriptionMapper.selectYYctxcsIndexDescriptionById(id);
    }

    /**
     * 查询测算方案参数描述表列表
     * 
     * @param yYctxcsIndexDescription 测算方案参数描述表
     * @return 测算方案参数描述表
     */
    @Override
    public List<YYctxcsIndexDescription> selectYYctxcsIndexDescriptionList(YYctxcsIndexDescription yYctxcsIndexDescription)
    {
        return yYctxcsIndexDescriptionMapper.selectYYctxcsIndexDescriptionList(yYctxcsIndexDescription);
    }

    /**
     * 新增测算方案参数描述表
     * 
     * @param yYctxcsIndexDescription 测算方案参数描述表
     * @return 结果
     */
    @Override
    public int insertYYctxcsIndexDescription(YYctxcsIndexDescription yYctxcsIndexDescription)
    {
        return yYctxcsIndexDescriptionMapper.insertYYctxcsIndexDescription(yYctxcsIndexDescription);
    }

    /**
     * 修改测算方案参数描述表
     * 
     * @param yYctxcsIndexDescription 测算方案参数描述表
     * @return 结果
     */
    @Override
    public int updateYYctxcsIndexDescription(YYctxcsIndexDescription yYctxcsIndexDescription)
    {
        return yYctxcsIndexDescriptionMapper.updateYYctxcsIndexDescription(yYctxcsIndexDescription);
    }

    /**
     * 批量删除测算方案参数描述表
     * 
     * @param ids 需要删除的测算方案参数描述表主键
     * @return 结果
     */
    @Override
    public int deleteYYctxcsIndexDescriptionByIds(Long[] ids)
    {
        return yYctxcsIndexDescriptionMapper.deleteYYctxcsIndexDescriptionByIds(ids);
    }

    /**
     * 删除测算方案参数描述表信息
     * 
     * @param id 测算方案参数描述表主键
     * @return 结果
     */
    @Override
    public int deleteYYctxcsIndexDescriptionById(Long id)
    {
        return yYctxcsIndexDescriptionMapper.deleteYYctxcsIndexDescriptionById(id);
    }
}
