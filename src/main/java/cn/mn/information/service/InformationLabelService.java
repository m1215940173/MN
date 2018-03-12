package cn.mn.information.service;

import cn.mn.information.dao.InformationLabelMapper;
import cn.mn.information.entity.InformationLabel;
import cn.mn.information.entity.InformationLabelRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 信息标签表 服务类
 *
 * @author menfajin
 * @since 2018-03-12
 */
@Service
public class InformationLabelService {
    @Autowired
    InformationLabelMapper baseMapper;
    @Autowired
    InformationLabelRelationService informationLabelRelationService;
    public List<InformationLabel> getAllLabel(Integer enable){
        return baseMapper.selectAll(enable);
    }
    public void addLabel(InformationLabel informationLabel){
        baseMapper.insert(informationLabel);
    }
    public void updateLabel(InformationLabel informationLabel){
        baseMapper.updateById(informationLabel);
    }
    public void updateEnable(Integer id){
        InformationLabel informationLabel = baseMapper.selectById(id);
        if(informationLabel!=null){
            if(informationLabel.getEnable()==1){
                informationLabel.setEnable(0);
            }else{
                informationLabel.setEnable(1);
            }
            updateLabel(informationLabel);
        }
    }
    public List<InformationLabel> getInformationLabels(Integer informationId){
        List<InformationLabel> informationLabelList = new ArrayList<>();
        List<InformationLabelRelation> informationLabelRelations = informationLabelRelationService.getInformationLabelRelations(informationId);
        for(InformationLabelRelation informationLabelRelation:informationLabelRelations){
            informationLabelList.add(baseMapper.selectById(informationLabelRelation.getLabelId()));
        }
        return informationLabelList;
    }
}
