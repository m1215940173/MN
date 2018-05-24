package cn.mn.project.information.service;

import cn.mn.project.information.dao.InformationTypeMapper;
import cn.mn.project.information.entity.InformationType;
import cn.mn.project.information.entity.InformationTypeRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengfajin on 2018/3/9.
 */
@Service
public class InformationTypeService {
    @Autowired
    InformationTypeMapper baseMapper;
    @Autowired
    InformationTypeRelationService informationTypeRelationService;
    public List<InformationType> getAllType(Integer enable){
        return baseMapper.selectAll(enable);
    }
    public void addType(InformationType informationType){
        baseMapper.insert(informationType);
    }
    public void updateType(InformationType informationType){
        baseMapper.updateById(informationType);
    }
    public void updateEnable(Integer id){
        InformationType informationType = baseMapper.selectById(id);
        if(informationType!=null){
            if(informationType.getEnable()==1){
                informationType.setEnable(0);
            }else{
                informationType.setEnable(1);
            }
            updateType(informationType);
        }
    }
    public List<InformationType> getInformationTypes(Integer informationId){
        List<InformationType> informationTypeList = new ArrayList<>();
        List<InformationTypeRelation> informationTypeRelations = informationTypeRelationService.getInformationTypeRelationList(informationId);
        for(InformationTypeRelation informationTypeRelation:informationTypeRelations){
            informationTypeList.add(baseMapper.selectById(informationTypeRelation.getTypeId()));
        }
        return informationTypeList;
    }
}
