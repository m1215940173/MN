package cn.mn.information.dao;

import cn.mn.information.entity.InformationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 信息类型表 Mapper 接口
 *
 * @author menfajin
 * @since 2018-03-09
 */
@Mapper
public interface InformationTypeMapper  {

    @Insert("INSERT INTO information_type (id,type) values(#{id},#{type})")
    int insert(InformationType entity);

    int deleteById(Integer id);

    int updateById(InformationType entity);

    @Select(" SELECT *  FROM information_type" )
    List<InformationType> selectAll();
}