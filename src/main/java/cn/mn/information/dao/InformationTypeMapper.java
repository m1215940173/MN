package cn.mn.information.dao;

import cn.mn.information.entity.InformationType;

import java.util.List;

/**
 * 信息类型表 Mapper 接口
 *
 * @author menfajin
 * @since 2018-03-09
 */
public interface InformationTypeMapper  {

    int insert(InformationType entity);

    int deleteById(Integer id);

    int updateById(InformationType entity);

    InformationType selectById(Integer id);

    List<InformationType> selectAll(Integer enable);
}