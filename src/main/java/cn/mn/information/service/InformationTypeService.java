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
    public List<InformationType> getAllType(){
        return informationTypeMapper.selectAll();
    }
    public void addType(InformationType informationType){
        informationTypeMapper.insert(informationType);
    }
}
