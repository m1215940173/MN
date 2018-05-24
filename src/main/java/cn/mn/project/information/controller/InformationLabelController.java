package cn.mn.project.information.controller;

import cn.mn.project.information.entity.InformationLabel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import cn.mn.project.information.service.InformationLabelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 信息标签表 前端控制器
 *
 * @author menfajin
 * @since 2018-03-12
 */
@RestController
@Api(tags ="信息标签")
@RequestMapping(value = "/informationLabel")
public class InformationLabelController {
    @Autowired
    InformationLabelService informationLabelService;

    @RequestMapping(value = "/get/allLabel" ,method = RequestMethod.GET)
    @ApiOperation(value = "获取信息标签列表")
    public List<InformationLabel> getAllLabel(@RequestParam Integer enable){
        return informationLabelService.getAllLabel(enable);
    }
    @RequestMapping(value = "/add/label" ,method = RequestMethod.PUT)
    @ApiOperation(value = "添加信息标签")
    public InformationLabel addLabel(@RequestBody InformationLabel informationLabel){
        informationLabelService.addLabel(informationLabel);
        return informationLabel;
    }
    @RequestMapping(value = "/update/label" ,method = RequestMethod.POST)
    @ApiOperation(value = "修改信息标签")
    public InformationLabel updateLabel(@RequestBody InformationLabel informationLabel){
        informationLabelService.updateLabel(informationLabel);
        return informationLabel;
    }
    @RequestMapping(value = "/update/enable" ,method = RequestMethod.POST)
    @ApiOperation(value = "启用禁用")
    public String updateEnable(@RequestParam Integer id){
        informationLabelService.updateEnable(id);
        return "修改成功";
    }
}
