package cn.mn.information.entity;

import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

/**
 * 信息类型关联表
 *
 * @author menfajin
 * @since 2018-03-12
 */
@Data
public class InformationTypeRelation {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "消息id")
    private Integer informationId;

    @ApiModelProperty(value = "类型id")
    private Integer typeId;

}
