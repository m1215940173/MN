package cn.mn.project.information.service;

import cn.mn.project.information.dao.InformationFileMapper;
import cn.mn.project.information.entity.InformationFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 信息文件表 服务类
 *
 * @author menfajin
 * @since 2018-03-12
 */
@Service
public class InformationFileService {

    @Autowired
    InformationFileMapper baseMapper;
    public void add (InformationFile informationFile){
        baseMapper.insert(informationFile);
    }
    public List<InformationFile> getInformationFiles(Integer informationId){
        return baseMapper.selectByInformationId(informationId);
    }
}
