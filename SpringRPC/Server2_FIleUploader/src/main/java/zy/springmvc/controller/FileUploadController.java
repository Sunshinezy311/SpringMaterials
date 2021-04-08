package zy.springmvc.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("user/fileUpload")
public class FileUploadController {

    @RequestMapping(value = "/fileUploadBySpringWay", method = RequestMethod.PUT)
    //再次强调，这个参数名和表单里写的名字必须一致
    public String fileUploadBySpringWay(MultipartFile upload) {
        System.out.println("正在执行fileUploadBySpringWay...");
        String realPath = System.getProperties().getProperty("user.dir") + File.separator + "uploads";
        //判断该路径是否存在
        System.out.println("上传文件路径：" + realPath);
        File file = new File(realPath);
        if (!file.exists() && !file.mkdirs()) {
            System.out.println("文件不存在且创建失败！");
        }
        String fileName = UUID.randomUUID().toString().replace("-", "") + "_" + upload.getOriginalFilename();
        System.out.println("上传的文件项：" + realPath + fileName);
        try {
            upload.transferTo(new File(realPath, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
