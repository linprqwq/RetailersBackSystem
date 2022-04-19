package com.guigu.controller;

import com.guigu.pojo.Userinfo;
import com.guigu.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.StandardMethodMetadata;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController

public class RegisterController {

    @Autowired
    RegisterService registerService;

    @RequestMapping("/checkusername.action")
    @CrossOrigin
    public int checkusername(String username){
        return registerService.CheckUserName(username);
    }

    @RequestMapping("/checkloginname.action")
    @CrossOrigin
    public int checkloginname(String loginname){
        return registerService.CheckLoginName(loginname);
    }

    @RequestMapping("/registeruser.action")
    @CrossOrigin
    public int RegisterUser(Userinfo userinfo ,MultipartFile[] file, HttpServletRequest request) throws IOException {
        for (int i = 0; i < file.length; i++) {
            String path = request.getServletContext().getRealPath("/image"); //路径名
            String name = file[i].getOriginalFilename();  //文件名
            File savefile = new File(path,name);
            file[i].transferTo(savefile);
            //组装商品图片实体类对象
           userinfo.setImg("image/"+name);
            System.out.println(name+"*********");

        }
        return registerService.RegisterUser(userinfo);
    }
}
