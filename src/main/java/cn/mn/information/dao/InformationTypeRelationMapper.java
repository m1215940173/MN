package cn.mn.information.dao;

import cn.mn.information.entity.InformationTypeRelation;

/**
 * 信息类型关联表 Mapper 接口
 *
 * @author menfajin
 * @since 2018-03-12
 */
public interface InformationTypeRelationMapper  {

    int insert(InformationTypeRelation entity);

    int deleteById(Integer id);

    int updateById(InformationTypeRelation entity);

    InformationTypeRelation selectById(Integer id);
}