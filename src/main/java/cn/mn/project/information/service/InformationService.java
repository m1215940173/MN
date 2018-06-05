package cn.mn.project.information.service;

import cn.mn.project.information.entity.*;
import cn.mn.tools.fileupload.service.FileUploadService;
import cn.mn.tools.fileupload.vo.FileLocation;
import cn.mn.project.information.dao.InformationMapper;
import cn.mn.project.information.dto.InformationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    InformationLabelService informationLabelService;
    @Autowired
    InformationTypeService informationTypeService;
    @Autowired
    FileUploadService fileUploadService;

    public void addInformation (InformationDto informationDto){
        if(informationDto.getInformation()!=null){
            Information information = informationDto.getInformation();
            information.setCreationTime(new Date());
            baseMapper.insert(information);
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
            informationDto.setInformationFileList(informationFileService.getInformationFiles(information.getId()));
            informationDto.setInformationLabelList(informationLabelService.getInformationLabels(information.getId()));
            informationDto.setInformationTypeList(informationTypeService.getInformationTypes(information.getId()));
            informationDtoList.add(informationDto);
        }
        return informationDtoList;
    }

    public FileLocation uploadFile(MultipartFile multipartFile){
        FileLocation fileLocation = fileUploadService.upload(multipartFile);
         fileUploadService.view(fileLocation);
        return fileLocation;
    }
}
