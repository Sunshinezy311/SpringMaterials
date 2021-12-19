package zy.springmvc.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {
    @RequestMapping(value = "/fileUploadThroughServer")
    //再次强调，这个参数名和表单里写的名字必须一致
    public String fileUploadThroughServer(MultipartFile upload) {
        System.out.println("正在执行fileUploadThroughServer...");
        try {
            fileTransmission(upload);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    private void fileTransmission(MultipartFile upload) throws IOException {
        System.out.println("跨服务器文件上传...");
        String fileName = UUID.randomUUID().toString().replace("-", "") + "_" + upload.getOriginalFilename();
        //1.定义上传服务器的路径
        String url = "http://localhost:9090/uploads/user/fileUpload/fileUploadBySpringWay/";
        //2.创建客户端对象
        Client client = Client.create();
        //3.和图片服务器进行连接
        WebResource resource = client.resource(url);
        //4.上传文件
        resource.put(upload.getBytes());
    }
}
