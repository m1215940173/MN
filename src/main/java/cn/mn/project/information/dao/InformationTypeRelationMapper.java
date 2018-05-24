package cn.mn.project.information.dao;

import cn.mn.project.information.entity.InformationTypeRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 信息类型关联表 Mapper 接口
 *
 * @author menfajin
 * @since 2018-03-12
 */
@Mapper
public interface InformationTypeRelationMapper  {

    int insert(InformationTypeRelation entity);

    int deleteById(Integer id);

    int updateById(InformationTypeRelation entity);

    InformationTypeRelation selectById(Integer id);

    List<InformationTypeRelation> selectByInformationId(Integer informationId);
}