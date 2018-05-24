package cn.mn.project.information.dao;

import cn.mn.project.information.entity.InformationFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 信息文件表 Mapper 接口
 *
 * @author menfajin
 * @since 2018-03-12
 */
@Mapper
public interface InformationFileMapper  {

    int insert(InformationFile entity);

    int deleteById(Integer id);

    int updateById(InformationFile entity);

    InformationFile selectById(Integer id);

    List<InformationFile> selectByInformationId(Integer informationId);
}