package cn.mn.information.controller;

import cn.mn.information.entity.InformationType;
import cn.mn.information.service.InformationTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mengfajin on 2018/3/9.
 */
@RestController
@Api(tags ="信息类型")
@RequestMapping(value = "/informationType")
public class InformationController {
    @Autowired
    InformationTypeService informationTypeService;

    @RequestMapping(value = "/get/allType" ,method = RequestMethod.GET)
    @ApiOperation(value = "获取信息类型列表")
    public List<InformationType> getAllType(){
        return informationTypeService.getAllType();
    }
    @RequestMapping(value = "/add/type" ,method = RequestMethod.PUT)
    @ApiOperation(value = "添加信息类型")
    public String addType(@RequestBody InformationType informationType){
        informationTypeService.addType(informationType);
        return "添加成功";
    }
}
