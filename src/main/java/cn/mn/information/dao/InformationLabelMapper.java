package cn.mn.information.dao;

import cn.mn.information.entity.InformationLabel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 信息标签表 Mapper 接口
 *
 * @author menfajin
 * @since 2018-03-12
 */
public interface InformationLabelMapper  {

    int insert(InformationLabel entity);

    int deleteById(Integer id);

    int updateById(InformationLabel entity);

    InformationLabel selectById(Integer id);

    List<InformationLabel> selectAll(@Param("enable") Integer enable);
}