package com.guigu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import java.util.Map;


public interface UserinfoService extends IService<Userinfo> {


    //去修改供应商信息
    Map  updatesupplier(Integer id, String username, Integer [] ids, MultipartFile img,String  appth);


    //用户登录
    Userinfo userlogin(Userinfo userinfo);
    public Map update(Userinfo userinfo);

    PageVo<Userinfo> querybyconduser(Userinfo userinfo, Integer pageno, Integer pagesize);


    //去申请成为供销商
            Map apply_supplier(Userinfo userinfo, Integer[] supplierGoodsCategoryIds,
                           MultipartFile img, String apppath);


    Map updstate(Userinfo userinfo);

    Map updstatebtg(Userinfo userinfo);

    PageVo<Userinfo> querybyconduser2(Userinfo userinfo, Integer pageno, Integer pagesize);

    PageVo<Userinfo> queryallGysJl(Userinfo userinfo, Integer pageno, Integer pagesize);
//    public PageVo<Userinfo> querybyconduser(Userinfo userinfo,int pageno , int pagesize);

    //个人购物车商品数量
    Integer CartCount(Integer id);

    PageVo<Userinfo> queryallShJl(Userinfo userinfo, Integer pageno, Integer pagesize);

//    boolean addgoods(Userinfo userinfo);


    Map delUser(Integer id);

    boolean updateusers(Userinfo userinfo);

    Userinfo queryusersbyid(String path, int id);

    Map updstateuser(Userinfo userinfo);

    boolean registerUser(Userinfo userinfo);

    Map<String, String> userinforecharge(Userinfo userinfo);
}
