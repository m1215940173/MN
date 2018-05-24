package cn.mn.project.information.dao;

import cn.mn.project.information.entity.InformationType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 信息类型表 Mapper 接口
 *
 * @author menfajin
 * @since 2018-03-09
 */
@Mapper
public interface InformationTypeMapper  {

    int insert(InformationType entity);

    int deleteById(Integer id);

    int updateById(InformationType entity);

    InformationType selectById(Integer id);

    List<InformationType> selectAll(Integer enable);
}