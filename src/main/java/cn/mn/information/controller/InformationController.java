package cn.mn.information.controller;

import cn.mn.information.dto.InformationDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.mn.information.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 发布信息表 前端控制器
 *
 * @author menfajin
 * @since 2018-03-12
 */
@RestController
@Api(tags = "信息")
@RequestMapping(value = "/information")
public class InformationController {
    @Autowired
    private InformationService informationService;

    @RequestMapping(value = "/add",method = RequestMethod.PUT)
    @ApiOperation(value = "发布信息")
    public String add(@RequestBody InformationDto informationDto){
        informationService.addInformation(informationDto);
        return "发布成功";
    }
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    @ApiOperation(value = "信息列表")
    public List<InformationDto> getList(){
        return  informationService.getInformationList();
    }
}
