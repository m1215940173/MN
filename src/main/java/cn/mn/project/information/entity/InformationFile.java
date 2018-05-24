package cn.mn.project.information.entity;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

/**
 * 信息文件表
 *
 * @author menfajin
 * @since 2018-03-12
 */
@Data
public class InformationFile {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "信息id")
    private Integer informationId;

    @ApiModelProperty(value = "文件路径")
    private String fileUrl;

    @ApiModelProperty(value = "图片路径")
    private String imgUrl;

    @ApiModelProperty(value = "时长")
    private String whenLong;

    @ApiModelProperty(value = "创建时间")
    private Date creationTime;

}
