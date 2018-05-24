package cn.mn.project.information.dao;

import cn.mn.project.information.entity.Information;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 发布信息表 Mapper 接口
 *
 * @author menfajin
 * @since 2018-03-12
 */
@Mapper
public interface InformationMapper  {

    int insert(Information entity);

    int deleteById(Integer id);

    int updateById(Information entity);

    Information selectById(Integer id);

    List<Information> selectAll();
}