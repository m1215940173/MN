package cn.mn.information.dto;

import cn.mn.information.entity.Information;
import cn.mn.information.entity.InformationFile;
import cn.mn.information.entity.InformationLabel;
import cn.mn.information.entity.InformationType;
import lombok.Data;

import java.util.List;

/**
 * Created by mengfajin on 2018/3/12.
 */
@Data
public class InformationDto {
    private Information information;
    private List<InformationFile> informationFileList;
    private List<InformationType> informationTypeList;
    private List<InformationLabel> informationLabelList;
}
