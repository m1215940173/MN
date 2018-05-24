package cn.mn.project.information.controller;

import cn.mn.project.information.service.InformationService;
import cn.mn.tools.fileupload.vo.FileLocation;
import cn.mn.project.information.dto.InformationDto;
import cn.mn.project.information.entity.InformationFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

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
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    @ApiOperation(value = "上传文件")
    public FileLocation uploadFile(@RequestParam MultipartFile multipartFile){
        return informationService.uploadFile(multipartFile);
    }
    @RequestMapping(value = "/uploadInformation",method = RequestMethod.POST)
    @ApiOperation(value = "上传文件信息")
    public void uploadFile(@RequestBody InformationFile informationFile){
        informationService.uploadFile(null);
    }
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    @ApiOperation(value = "信息列表")
    public List<InformationDto> getList(){
        return  informationService.getInformationList();
    }
}
