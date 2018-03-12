package cn.mn.information.service;

import cn.mn.information.dao.InformationLabelRelationMapper;
import cn.mn.information.entity.InformationLabelRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 信息标签关联表 服务类
 *
 * @author menfajin
 * @since 2018-03-12
 */
@Service
public class InformationLabelRelationService {

    @Autowired
    InformationLabelRelationMapper baseMapper;

    public void add(InformationLabelRelation informationLabelRelation){
        baseMapper.insert(informationLabelRelation);
    }

    public List<InformationLabelRelation> getInformationLabelRelations(Integer informationId){
        return baseMapper.selectByInformationId(informationId);
    }

}
