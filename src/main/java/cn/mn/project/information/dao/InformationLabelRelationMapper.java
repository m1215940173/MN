package cn.mn.project.information.dao;

import cn.mn.project.information.entity.InformationLabelRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 信息标签关联表 Mapper 接口
 *
 * @author menfajin
 * @since 2018-03-12
 */
@Mapper
public interface InformationLabelRelationMapper  {

    int insert(InformationLabelRelation entity);

    int deleteById(Integer id);

    int updateById(InformationLabelRelation entity);

    InformationLabelRelation selectById(Integer id);

    List<InformationLabelRelation> selectByInformationId(Integer informationId);
}