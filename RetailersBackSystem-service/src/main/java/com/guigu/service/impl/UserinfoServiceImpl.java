package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.UserinfoMapper;
import com.guigu.pojo.PageVo;
import com.guigu.pojo.SysEmployees;
import com.guigu.pojo.Userinfo;
import com.guigu.service.UserinfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements UserinfoService{
    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    //用户登录
    public Userinfo userlogin(Userinfo userinfo) {
        Userinfo userinfo1=userinfoMapper.userlogin(userinfo);
        if(userinfo1==null){
            return null;
        }
        System.out.println(userinfo1+"/*/*/*/**/*//*/*//*/*/*/");
        return userinfo1;
    }

    @Override
    public Map update(Userinfo userinfo) {
        boolean num = this.updateById(userinfo);
        Map map =new HashMap();
        map.put("code","0");
        map.put("msg","修改失败");
        if(num){
            map.put("code","1");
            map.put("msg","修改成功");
        }
        return map;
    }

    @Override
    public PageVo<Userinfo> querybyconduser(Userinfo userinfo, Integer pageno, Integer pagesize) {
        Page<Userinfo> page = new Page<Userinfo>(pageno,pagesize);
        //条件查询
        QueryWrapper<Userinfo> queryWrapper =new QueryWrapper<Userinfo>();
        if(StringUtils.isNotBlank(userinfo.getUsername())){
            queryWrapper.like("username",userinfo.getUsername());
        }
        Page<Userinfo> page1 = this.page(page,queryWrapper);
        PageVo<Userinfo> pageVo = new PageVo<Userinfo>();
        pageVo.setTotal(page1.getTotal());
        pageVo.setRows(page1.getRecords());
        return pageVo;
    }

    @Override
    public Map updstate(Userinfo userinfo) {
        boolean num = this.updateById(userinfo);
        Map map =new HashMap();
        map.put("code","0");
        map.put("msg","审核失败");
        if(num){
            map.put("code","1");
            map.put("msg","审核成功");
        }
        return map;
    }

    @Override
    public Map updstatebtg(Userinfo userinfo) {
        boolean num = this.updateById(userinfo);
        Map map =new HashMap();
        map.put("code","0");
        map.put("msg","审核未通过失败");
        if(num){
            map.put("code","1");
            map.put("msg","审核未通过");
        }
        return map;
    }

    @Override
    public PageVo<Userinfo> querybyconduser2(Userinfo userinfo, Integer pageno, Integer pagesize) {
        Page<Userinfo> page = new Page<Userinfo>(pageno,pagesize);
        //条件查询
        QueryWrapper<Userinfo> queryWrapper =new QueryWrapper<Userinfo>();
        if(StringUtils.isNotBlank(userinfo.getUsername())){
            queryWrapper.like("username",userinfo.getUsername());
        }
        if(userinfo.getShState()!=null){
            queryWrapper.like("sh_state",userinfo.getShState());
        }
        if(userinfo.getGysState()!=null){
            queryWrapper.like("gys_state",userinfo.getGysState());
        }
        Page<Userinfo> page1 = this.page(page,queryWrapper);
        PageVo<Userinfo> pageVo = new PageVo<Userinfo>();
        pageVo.setTotal(page1.getTotal());
        pageVo.setRows(page1.getRecords());
        return pageVo;
    }

    @Override
    public PageVo<Userinfo> queryallGysJl(Userinfo userinfo, Integer pageno, Integer pagesize) {
        Page<Userinfo> page = new Page<Userinfo>(pageno,pagesize);
        //条件查询
        QueryWrapper<Userinfo> queryWrapper =new QueryWrapper<Userinfo>();
        if(StringUtils.isNotBlank(userinfo.getUsername())){
            queryWrapper.like("username",userinfo.getUsername());
        }
        if(userinfo.getGysState()!=null){
            queryWrapper.like("gys_state",userinfo.getGysState());
        }
        queryWrapper.isNotNull("gys_state");
        Page<Userinfo> page1 = this.page(page,queryWrapper);
        PageVo<Userinfo> pageVo = new PageVo<Userinfo>();
        pageVo.setTotal(page1.getTotal());
        pageVo.setRows(page1.getRecords());
        return pageVo;
    }

    @Override
    public Integer CartCount(Integer id) {
        int i = userinfoMapper.CartCount(id);
        if(i==0){
            return i;
        }
        return i;
    }

    @Override
    public PageVo<Userinfo> queryallShJl(Userinfo userinfo, Integer pageno, Integer pagesize) {
        Page<Userinfo> page = new Page<Userinfo>(pageno,pagesize);
        //条件查询
        QueryWrapper<Userinfo> queryWrapper =new QueryWrapper<Userinfo>();
        if(StringUtils.isNotBlank(userinfo.getUsername())){
            queryWrapper.like("username",userinfo.getUsername());
        }
        if(userinfo.getShState()!=null){
            queryWrapper.eq("sh_state",userinfo.getShState());
        }
        queryWrapper.isNotNull("sh_state");
        Page<Userinfo> page1 = this.page(page,queryWrapper);
        PageVo<Userinfo> pageVo = new PageVo<Userinfo>();
        pageVo.setTotal(page1.getTotal());
        pageVo.setRows(page1.getRecords());
        return pageVo;
    }

    @Override
    public boolean addgoods(Userinfo userinfo) {
        boolean result = false;
        //添加商品
        //将商品id加入图片类中

        //添加商品图片信息
        result= this.save(userinfo);

        return result;
    }

    @Override
    public Map delUser(Integer id) {
        boolean num = this.removeById(id);
        Map map =new HashMap();
        map.put("code","0");
        map.put("msg","删除失败");
        if(num){
            map.put("code","1");
            map.put("msg","删除成功");
        }
        return map;
    }

    @Override
    public boolean updateusers(Userinfo userinfo) {
        boolean result =false;

        //修改商品信息
        result = this.updateById(userinfo);


        return result;
    }

    @Override
    public Userinfo queryusersbyid(String path, int id) {
        Userinfo userinfo = this.getById(id);

        return userinfo;
    }

}
