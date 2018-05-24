package cn.mn.project.information.entity;

import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

/**
 * 信息类型表
 *
 * @author menfajin
 * @since 2018-03-09
 */
@Data
public class InformationType {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "是否启用")
    private Integer enable;

}
