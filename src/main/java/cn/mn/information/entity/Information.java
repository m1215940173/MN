package cn.mn.information.entity;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

/**
 * 发布信息表
 *
 * @author menfajin
 * @since 2018-03-12
 */
@Data
public class Information {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "期数")
    private Integer sequence;

    @ApiModelProperty(value = "创建时间")
    private Date creationTime;

}
