package com.guigu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.Userinfo;
import com.guigu.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import java.io.File;
import java.io.IOException;
import java.sql.Savepoint;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserinfoController {

    @Autowired
    UserinfoService userinfoService;

    //修改供应商信息
        //修改供应商信息(可以修改用户名、供应商商品分类数据、营业执照)
    @PostMapping("updateSupplier.action")
    public Map updateSupplier(Integer id,String username,Integer[] ids,MultipartFile img,HttpServletRequest request){
        return userinfoService.updatesupplier(id,username,ids,img,request.getServletContext().getRealPath("/img/"));
    }

    @RequestMapping("/login.action")
    @CrossOrigin
    //用户登录
    public Userinfo login(Userinfo userinfo){
       return userinfoService.userlogin(userinfo);
    }


    //去根据用户id去查询
    @RequestMapping("/selsid.action")
    public Userinfo selsid(int id) {
        return userinfoService.getById(id);
    }
    @RequestMapping("/userGysoption.action")
    public List<Userinfo> userGysoption() {
        QueryWrapper queryWrapper=new QueryWrapper<Userinfo>();
        queryWrapper.eq("identity",3);
        queryWrapper.eq("gys_state",1);
        return userinfoService.list(queryWrapper);
    }
    @RequestMapping("/queryUserGysone.action")
    public Userinfo queryUserGysone(Integer id) {
        return userinfoService.getById(id);
    }

    @RequestMapping("/updatesh.action")
    @CrossOrigin
    public Map updatesh(Userinfo userinfo, MultipartFile[] file, HttpServletRequest request) throws IOException {
        for (int i = 0; i < file.length; i++) {
            String path = request.getServletContext().getRealPath("/img"); //路径名
            String name = file[i].getOriginalFilename();  //文件名
            File savefile = new File(path,name);
            file[i].transferTo(savefile);
            //组装商品图片实体类对象
            userinfo.setImgpath("image/"+name);
        }


        return userinfoService.update(userinfo);
    }

    @RequestMapping("/queryallUser.action")
    @CrossOrigin
    public PageVo<Userinfo> queryallUser(Userinfo userinfo,
                                     @RequestParam(value = "pageno", defaultValue = "1") Integer pageno,
                                     @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize) {
        return userinfoService.querybyconduser(userinfo, pageno, pagesize);
    }
    @RequestMapping("/queryallUser2.action")
    @CrossOrigin
    public PageVo<Userinfo> queryallUser2(Userinfo userinfo,
                                     @RequestParam(value = "pageno", defaultValue = "1") Integer pageno,
                                     @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize) {
        return userinfoService.querybyconduser2(userinfo, pageno, pagesize);
    }
    @RequestMapping("/queryallGysJl.action")
    @CrossOrigin
    public PageVo<Userinfo> queryallGysJl(Userinfo userinfo,
                                     @RequestParam(value = "pageno", defaultValue = "1") Integer pageno,
                                     @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize) {
        return userinfoService.queryallGysJl(userinfo, pageno, pagesize);
    }
    @RequestMapping("/queryallShJl.action")

    public PageVo<Userinfo> queryallShJl(Userinfo userinfo,
                                     @RequestParam(value = "pageno", defaultValue = "1") Integer pageno,
                                     @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize) {
        return userinfoService.queryallShJl(userinfo, pageno, pagesize);
    }
//    @RequestMapping("/addUser.action")
//    public boolean addUser(Userinfo userinfo, MultipartFile[] file, HttpServletRequest request) throws IOException {
//
//        for (int i = 0; i < file.length; i++) {
//            String path = request.getServletContext().getRealPath("/img"); //路径名
//            String name = file[i].getOriginalFilename();  //文件名
//            File savefile = new File(path,name);
//            file[i].transferTo(savefile);
//            //组装图片实体类对象
//
//            userinfo.setImgpath("/img/"+name);
//        }
//
//        return  userinfoService.addgoods(userinfo);
//    }
    @RequestMapping("/registerUser.action")
    public boolean registerUser(Userinfo userinfo, MultipartFile[] file, HttpServletRequest request) throws IOException {

        for (int i = 0; i < file.length; i++) {
            String path = request.getServletContext().getRealPath("/img"); //路径名
            String name = file[i].getOriginalFilename();  //文件名
            File savefile = new File(path,name);
            file[i].transferTo(savefile);
            //组装图片实体类对象

            userinfo.setImgpath("/img/"+name);
        }

        return userinfoService.registerUser(userinfo);
    }
    @DeleteMapping("/delUser.action/{id}")
    public Map delUser(@PathVariable Integer id) {

        return userinfoService.delUser(id);
    }
    @RequestMapping("/updUser.action")
    public boolean updUser(Userinfo userinfo, MultipartFile[] file,String[] filenames, HttpServletRequest request) throws IOException {
        System.out.println(userinfo+" "+file+" :"+filenames+" :");
        //将新的文件保存在服务器 并存入保存对象
        for (int i = 0; i < file.length; i++) {
            String path = request.getServletContext().getRealPath("/img"); //路径名
            String name = file[i].getOriginalFilename();  //文件名
            File savefile = new File(path,name);
            file[i].transferTo(savefile);
            //组装商品图片实体类对象
            userinfo.setImgpath("/img/"+name);
        }
        //将不变的文件记录
        if(filenames!=null && filenames.length>0) {
            for (String filename : filenames) {

                userinfo.setImgpath(filename);
            }
        }

        return  userinfoService.updateusers(userinfo);
    }
    @PutMapping("/updstateuser.action")
    public Map updstateuser(@RequestBody Userinfo userinfo) {

        return  userinfoService.updstateuser(userinfo);
    }
    @RequestMapping("queryUsersbyid.action/{id}")
    public Userinfo querybyid(@PathVariable int id,HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/"); //路径名
        return userinfoService.queryusersbyid(path,id);
    }
    /**
     * 供应商注册状态通过
     * @param userinfo
     * @return
     */
    @PutMapping("/updstatetg.action")
    @CrossOrigin
    public Map updstate(@RequestBody Userinfo userinfo) {
        System.out.println(userinfo);
        return userinfoService.updstate(userinfo);
    }
    /**
     * 供应商注册状态未通过
     * @param userinfo
     * @return
     */
    @PutMapping("/updstatebtg.action")
    @CrossOrigin
    public Map updstatebtg(@RequestBody Userinfo userinfo) {
        return userinfoService.updstatebtg(userinfo);
    }
    /**
     * 商户注册状态通过
     * @param userinfo
     * @return
     */
    @PutMapping("/updshstatetg.action")
    @CrossOrigin
    public Map updshstatetg(@RequestBody Userinfo userinfo) {
        System.out.println(userinfo);
        return userinfoService.updstate(userinfo);
    }

    /**
     * 商户注册状态不通过
     * @param userinfo
     * @return
     */
    @PutMapping("/updshstatebtg.action")
    @CrossOrigin
    public Map updshstatebtg(@RequestBody Userinfo userinfo) {
        return userinfoService.updstatebtg(userinfo);
    }


    //申请成为供应商
    @PostMapping("apply_supplier.action")
    @CrossOrigin
    public  Map apply_supplier(Userinfo userinfo, Integer[]  supplierGoodsCategoryIds,
                               MultipartFile img,HttpServletRequest request){

        System.out.println("数据"+"user");
        System.out.println("数组"+supplierGoodsCategoryIds);
        System.out.println("图片"+img);
        return userinfoService.apply_supplier(userinfo,supplierGoodsCategoryIds,img,request.getServletContext().getRealPath("/upload"));
    }


    //统计用户购物车数量
    @RequestMapping("/cartcount.action")
    @CrossOrigin
    public int CartCount(Integer id) {
        return userinfoService.CartCount(id);
    }

    @RequestMapping("/queryallusername.action")
    @CrossOrigin
    public List<Userinfo> queryallusername() {
        return userinfoService.list();
    }

    @RequestMapping("usreinforecharge.action")
    @CrossOrigin
    public Map<String,String> usreinforecharge(Userinfo userinfo){

        return userinfoService.userinforecharge(userinfo);
    }
}
