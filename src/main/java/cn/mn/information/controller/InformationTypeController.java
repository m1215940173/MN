package cn.mn.information.controller;

import cn.mn.information.entity.InformationType;
import cn.mn.information.service.InformationTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mengfajin on 2018/3/9.
 */
@RestController
@Api(tags ="信息类型")
@RequestMapping(value = "/informationType")
public class InformationTypeController {
    @Autowired
    InformationTypeService informationTypeService;

    @RequestMapping(value = "/get/allType" ,method = RequestMethod.GET)
    @ApiOperation(value = "获取信息类型列表")
    public List<InformationType> getAllType(@RequestParam Integer enable){
        return informationTypeService.getAllType(enable);
    }
    @RequestMapping(value = "/add/type" ,method = RequestMethod.PUT)
    @ApiOperation(value = "添加信息类型")
    public InformationType addType(@RequestBody InformationType informationType){
        informationTypeService.addType(informationType);
        return informationType;
    }
    @RequestMapping(value = "/update/type" ,method = RequestMethod.POST)
    @ApiOperation(value = "修改信息类型")
    public InformationType updateType(@RequestBody InformationType informationType){
        informationTypeService.updateType(informationType);
        return informationType;
    }
    @RequestMapping(value = "/update/enable" ,method = RequestMethod.POST)
    @ApiOperation(value = "启用禁用")
    public String updateEnable(@RequestParam Integer id){
        informationTypeService.updateEnable(id);
        return "修改成功";
    }
}
