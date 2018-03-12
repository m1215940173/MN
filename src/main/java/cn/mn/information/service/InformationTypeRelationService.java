package cn.mn.information.service;

import cn.mn.information.dao.InformationTypeRelationMapper;
import cn.mn.information.entity.InformationTypeRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 信息类型关联表 服务类
 *
 * @author menfajin
 * @since 2018-03-12
 */
@Service
public class InformationTypeRelationService {

    @Autowired
    InformationTypeRelationMapper baseMapper;

    public void add(InformationTypeRelation informationTypeRelation){
        baseMapper.insert(informationTypeRelation);
    }

    public List<InformationTypeRelation> getInformationTypeRelationList(Integer informationId){
        return baseMapper.selectByInformationId(informationId);
    }

}
