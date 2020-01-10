package com.zhanghao.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 传统方式上传文件
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/testUpload1")
    public String testUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(realPath);
        File file = new File(realPath);

        //判断路径是否存在，不存在则创建
        if (!file.exists()) {
            file.mkdirs();
        }
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        List<FileItem> fileItems = upload.parseRequest(request);
        for (FileItem fileItem : fileItems) {

            if (fileItem.isFormField()) {
                //普通属性
            } else {
                //为上传文件项
                //获取文件名
                String fileItemName = fileItem.getName();
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                String filename = uuid + "_" + fileItemName;
                //上传文件
                fileItem.write(new File(realPath, filename));
                //删除缓存
                fileItem.delete();
            }

        }

        return "success";
    }

    /**
     * SpringMVC上传文件
     *
     * @param request
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("/testUpload2")
    public String testUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(realPath);
        File file = new File(realPath);

        //判断路径是否存在，不存在则创建
        if (!file.exists()) {
            file.mkdirs();
        }

        //获取文件名
        String fileItemName = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String filename = uuid + "_" + fileItemName;
        //上传文件
        upload.transferTo(new File(realPath, filename));
        return "success";
    }

    /**
     * 跨服务器上传文件
     *
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("/testUpload3")
    public String testUpload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器上传文件");
        //上传的路径
        String path = "http://localhost:9090/uploads/";

        //获取文件名
        String fileItemName = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String filename = uuid + "_" + fileItemName;

        //创建客户端对象
        Client client = Client.create();

        //和图片服务器进行绑定
        WebResource webResource = client.resource(path + filename);

        //上传文件,跨服务器
        webResource.put(upload.getBytes());

        return "success";
    }
}
