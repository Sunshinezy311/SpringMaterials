package zy.springmvc.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("user/fileUpload")
public class FileUploadController {
    @RequestMapping("/fileUploadByTraditionWay")
    public String fileUploadByTraditionWay(HttpServletRequest request) {
        System.out.println("正在执行fileUploadByTraditionWay...");
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        System.out.println("上传文件路径：" + realPath);
        File file = new File(realPath);
        if (!file.exists() && !file.mkdirs()) {
            System.out.println("文件不存在且创建失败！");
        }
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                //判断item是否为上传请求中使用的对象
                if (fileItem.isFormField()) {
                    System.out.println("上传的表单项");
                } else {
                    System.out.println("上传的文件项");
                    String fileName = UUID.randomUUID().toString().replace("-", "") + "_" + fileItem.getName();
                    fileItem.write(new File(realPath, fileName));
                    //删除临时文件
                    fileItem.delete();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping("/fileUploadBySpringWay")
    //再次强调，这个参数名和表单里写的名字必须一致
    public String fileUploadBySpringWay(HttpServletRequest request, MultipartFile upload) {
        System.out.println("正在执行fileUploadByTraditionWay...");
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
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
