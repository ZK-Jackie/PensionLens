package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.YYctxcsIndexDescription;

/**
 * 测算方案参数描述表Mapper接口
 * 
 * @author gdouyj
 * @date 2024-08-09
 */
public interface YYctxcsIndexDescriptionMapper 
{
    /**
     * 查询测算方案参数描述表
     * 
     * @param id 测算方案参数描述表主键
     * @return 测算方案参数描述表
     */
    public YYctxcsIndexDescription selectYYctxcsIndexDescriptionById(Long id);

    /**
     * 查询测算方案参数描述表列表
     * 
     * @param yYctxcsIndexDescription 测算方案参数描述表
     * @return 测算方案参数描述表集合
     */
    public List<YYctxcsIndexDescription> selectYYctxcsIndexDescriptionList(YYctxcsIndexDescription yYctxcsIndexDescription);

    /**
     * 新增测算方案参数描述表
     * 
     * @param yYctxcsIndexDescription 测算方案参数描述表
     * @return 结果
     */
    public int insertYYctxcsIndexDescription(YYctxcsIndexDescription yYctxcsIndexDescription);

    /**
     * 修改测算方案参数描述表
     * 
     * @param yYctxcsIndexDescription 测算方案参数描述表
     * @return 结果
     */
    public int updateYYctxcsIndexDescription(YYctxcsIndexDescription yYctxcsIndexDescription);

    /**
     * 删除测算方案参数描述表
     * 
     * @param id 测算方案参数描述表主键
     * @return 结果
     */
    public int deleteYYctxcsIndexDescriptionById(Long id);

    /**
     * 批量删除测算方案参数描述表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYYctxcsIndexDescriptionByIds(Long[] ids);
}
