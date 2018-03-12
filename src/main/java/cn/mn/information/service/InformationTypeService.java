package cn.mn.information.service;

import cn.mn.information.dao.InformationTypeMapper;
import cn.mn.information.entity.InformationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mengfajin on 2018/3/9.
 */
@Service
public class InformationTypeService {
    @Autowired
    InformationTypeMapper informationTypeMapper;
    public List<InformationType> getAllType(Integer enable){
        return informationTypeMapper.selectAll(enable);
    }
    public void addType(InformationType informationType){
        informationTypeMapper.insert(informationType);
    }
    public void updateType(InformationType informationType){
        informationTypeMapper.updateById(informationType);
    }
    public void updateEnable(Integer id){
        InformationType informationType = informationTypeMapper.selectById(id);
        if(informationType!=null){
            if(informationType.getEnable()==1){
                informationType.setEnable(0);
            }else{
                informationType.setEnable(1);
            }
            updateType(informationType);
        }
    }
}
