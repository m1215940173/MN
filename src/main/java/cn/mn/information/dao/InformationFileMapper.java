package cn.mn.information.dao;

import cn.mn.information.entity.InformationFile;

import java.util.List;

/**
 * 信息文件表 Mapper 接口
 *
 * @author menfajin
 * @since 2018-03-12
 */
public interface InformationFileMapper  {

    int insert(InformationFile entity);

    int deleteById(Integer id);

    int updateById(InformationFile entity);

    InformationFile selectById(Integer id);

    List<InformationFile> selectByInformationId(Integer informationId);
}