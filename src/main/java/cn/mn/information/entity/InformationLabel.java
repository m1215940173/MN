package cn.mn.information.entity;

import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

/**
 * 信息标签表
 *
 * @author menfajin
 * @since 2018-03-12
 */
@Data
public class InformationLabel {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "标签")
    private String label;

    @ApiModelProperty(value = "是否启用")
    private Integer enable;

}
