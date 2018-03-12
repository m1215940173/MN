package cn.mn.information.service;

import cn.mn.information.dao.InformationMapper;
import cn.mn.information.dto.InformationDto;
import cn.mn.information.entity.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 发布信息表 服务类
 *
 * @author menfajin
 * @since 2018-03-12
 */
@Service
public class InformationService {

    @Autowired
    InformationMapper baseMapper;
    @Autowired
    InformationFileService informationFileService;
    @Autowired
    InformationTypeRelationService informationTypeRelationService;
    @Autowired
    InformationLabelRelationService informationLabelRelationService;

    public void addInformation (InformationDto informationDto){
        if(informationDto.getInformation()!=null){
            Information information = informationDto.getInformation();
            information.setCreationTime(new Date());
            baseMapper.insert(information);
            if(informationDto.getInformationFileList().size()!=0){
                for (InformationFile informationFile:informationDto.getInformationFileList()) {
                    informationFile.setCreationTime(new Date());
                    informationFileService.add(informationFile);
                }
            }
            if(informationDto.getInformationTypeList().size()!=0){
                for(InformationType informationType:informationDto.getInformationTypeList()){
                    InformationTypeRelation informationTypeRelation = new InformationTypeRelation();
                    informationTypeRelation.setInformationId(information.getId());
                    informationTypeRelation.setTypeId(informationType.getId());
                    informationTypeRelationService.add(informationTypeRelation);
                }
            }
            if(informationDto.getInformationLabelList().size()!=0){
                for(InformationLabel informationLabel:informationDto.getInformationLabelList()){
                    InformationLabelRelation informationLabelRelation = new InformationLabelRelation();
                    informationLabelRelation.setInformationId(information.getId());
                    informationLabelRelation.setLabelId(informationLabel.getId());
                    informationLabelRelationService.add(informationLabelRelation);
                }
            }
        }
    }

    public List<InformationDto> getInformationList(){
        List<InformationDto> informationDtoList = new ArrayList<>();
        List<Information> informationList = baseMapper.selectAll();
        for (Information information:informationList){
            InformationDto informationDto = new InformationDto();
            informationDto.setInformation(information);
            informationDto.setInformationFileList(null);
            informationDto.setInformationLabelList(null);
            informationDto.setInformationTypeList(null);
            informationDtoList.add(informationDto);
        }
        return informationDtoList;
    }
}
