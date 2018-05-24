package cn.mn.tools.fileupload.service;

import cn.mn.tools.fileupload.vo.FileLocation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import java.io.*;
import java.util.UUID;

/**
 * Created by mengfajin on 2018/2/23.
 */
@Service
    public class FileUploadService extends HttpServlet {
    @Value("${upload.file.path}")  private String path;
    //文件上传相关代码
    @ResponseBody
    public FileLocation upload(MultipartFile file) {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传后的路径
        String filePath = System.getProperty("user.dir").concat("file/");
        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FileLocation(fileName, "file/"+ fileName);
    }

    public void view(FileLocation file) {
        file.setHost(path);
        if (null != file.getPath() && !file.getPath().startsWith("http")) {
            file.setUrl(file.getHost() + file.getPath());
        }
    }

}
