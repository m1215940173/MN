package cn.mn.information.service;

import cn.mn.information.dao.InformationFileMapper;
import cn.mn.information.entity.Information;
import cn.mn.information.entity.InformationFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
