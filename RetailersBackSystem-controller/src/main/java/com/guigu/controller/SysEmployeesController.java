package com.guigu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.SysEmployees;
import com.guigu.pojo.Sysemployeesimgs;
import com.guigu.service.SysEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 童总                       x
 * @since 2022-03-28
 */
/*@Controller
@RequestMapping("/sysEmployees")*/
    @RestController
public class SysEmployeesController {
    @Autowired
    SysEmployeesService sysEmployeesService;

    @PostMapping("/addsysemployees.action")
    @CrossOrigin
    public Map addsysemployees(SysEmployees sysEmployees, MultipartFile file, HttpServletRequest request ) throws IOException {
      if(file!=null){
          String path = request.getServletContext().getRealPath("/img"); //路径名
          String name = file.getOriginalFilename();  //文件名
          File savefile = new File(path,name);
          file.transferTo(savefile);
          Sysemployeesimgs sysemployeesimgs=new Sysemployeesimgs();
          sysEmployees.setEmpImg("img/"+name);
      }

        return sysEmployeesService.addSysemployees(sysEmployees);
    }

    @PostMapping("/delesysemployees.action/{id}")
    @CrossOrigin
    public Map delesysemployees(@PathVariable int id) {
        return sysEmployeesService.deleteemployees(id);

    }

    @PostMapping("/updateemployees.action")
    @CrossOrigin
    public Map updateemployees(SysEmployees sysEmployees, MultipartFile file, HttpServletRequest request ) throws IOException {
        System.out.println("图片"+file);
        System.out.println(sysEmployees);
        if(file!=null){
            if(file.getSize()>0){
                String path = request.getServletContext().getRealPath("/img"); //路径名
                String name = file.getOriginalFilename();  //文件名
                File savefile = new File(path,name);
                file.transferTo(savefile);
                Sysemployeesimgs sysemployeesimgs=new Sysemployeesimgs();
                sysEmployees.setEmpImg("img/"+name);
            }else {
                sysEmployees.setEmpImg(null);
            }
        }
        return sysEmployeesService.updateemplouees(sysEmployees) ;

    }
    @RequestMapping("quersysemployeesbyid.action/{id}")
    @CrossOrigin
    public SysEmployees quersysemployeesbyid(@PathVariable int id,HttpServletRequest request){

        return  sysEmployeesService.quertsempliyeesbyid(id);
    }
    @GetMapping("/queryallsysempd.action")
    @CrossOrigin
    public Page<SysEmployees> queryallsysemp2(SysEmployees sysEmployees,
                                @RequestParam(value = "pageno", defaultValue = "1") Integer pageno,
                                @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize) {

        System.out.println(sysEmployees);

        return sysEmployeesService.querysysemp2(sysEmployees, pageno, pagesize);

    }
}

