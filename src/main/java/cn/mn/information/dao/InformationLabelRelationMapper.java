package cn.mn.information.dao;

import cn.mn.information.entity.InformationLabelRelation;

/**
 * 信息标签关联表 Mapper 接口
 *
 * @author menfajin
 * @since 2018-03-12
 */
public interface InformationLabelRelationMapper  {

    int insert(InformationLabelRelation entity);

    int deleteById(Integer id);

    int updateById(InformationLabelRelation entity);

    InformationLabelRelation selectById(Integer id);
}