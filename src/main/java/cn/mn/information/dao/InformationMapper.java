package cn.mn.information.dao;

import cn.mn.information.entity.Information;

import java.util.List;

/**
 * 发布信息表 Mapper 接口
 *
 * @author menfajin
 * @since 2018-03-12
 */
public interface InformationMapper  {

    int insert(Information entity);

    int deleteById(Integer id);

    int updateById(Information entity);

    Information selectById(Integer id);

    List<Information> selectAll();
}