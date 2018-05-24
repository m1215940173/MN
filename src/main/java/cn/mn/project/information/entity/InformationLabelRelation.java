package cn.mn.project.information.entity;

import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

/**
 * 信息标签关联表
 *
 * @author menfajin
 * @since 2018-03-12
 */
@Data
public class InformationLabelRelation {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "信息id")
    private Integer informationId;

    @ApiModelProperty(value = "标签id")
    private Integer labelId;

}
