package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.*;
import com.guigu.pojo.*;
import com.guigu.service.UserinfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.io.File;
import java.io.IOException;

@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements UserinfoService{
    @Autowired
    UserinfoMapper userinfoMapper;

    //供应商分类表
    @Autowired
    SupplierGoodsCategoryMapper supplierGoodsCategoryMapper;

    //供应商表
    @Autowired
    GoodsuppliedMapper goodsuppliedMapper;

    @Autowired
    CustomerbalancelogMapper customerbalancelogMapper;

    @Autowired
    ShopTypeInfoMapper shopTypeInfoMapper;


    //去修改供应商的信息()
    @Override
    public Map updatesupplier(Integer id, String username, Integer[] ids, MultipartFile img,
                              String apppath) {
        Map map = new HashMap();
        //去根据id,查询用户对象，补全属性
        Userinfo userinfo = userinfoMapper.selectById(id);
        userinfo.setUsername(username);
        //去判断是否上传了图片
        if (img.getSize() > 0) {
            //上传图片
            //  String apppath = ;
            File file = new File(apppath);
            if (!file.exists()) {
                //不存在就去创建
                file.mkdirs();
            }
            //去获取文件名称
            String fileName = img.getOriginalFilename();
            //去保存文件到路径
            try {
                img.transferTo(new File(apppath, fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //去将路径设置到对象
            userinfo.setImgpath("image/" + fileName);
        }

        //进行修改
        userinfoMapper.updateById(userinfo);

        //根据用户id，删除该供应商下的所有可提供的商品分类数据
        QueryWrapper<SupplierGoodsCategory> queryWrapper = new QueryWrapper();
        queryWrapper.eq("p_id", id);
        supplierGoodsCategoryMapper.delete(queryWrapper);
        //循环添加供应商提供的分类表数据
        for (Integer i : ids) {
            SupplierGoodsCategory temp_obj = new SupplierGoodsCategory();
            temp_obj.setPId(id);
            temp_obj.setSortId(i);
            supplierGoodsCategoryMapper.insert(temp_obj);
        }
        map.put("msg", "修改成功！");
        map.put("x", true);
        return map;
    }

    //根据id去查找  商品的分类
    @Override
    public Userinfo querybyUserbyid(Integer id) {
        //根据id 去查询用户表里面的数据
        Userinfo userinfo = userinfoMapper.selectById(id);
        //补全属性  检查看是否是供应商  getGysState
        try {
            if (userinfo.getGysState() != null || userinfo.getGysState() == 0 || userinfo.getGysState() == 1) {

                //供应商分类集合
                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("p_id", id);
                //供应商商品分类 去查询
                List<SupplierGoodsCategory> supplierGoodsCategoryList = supplierGoodsCategoryMapper.selectList((queryWrapper));
                System.out.println(supplierGoodsCategoryList);
                userinfo.setSupplierGoodsCategoryList(supplierGoodsCategoryList);
                //循环供应商分类集合 补全属性
                //去一个名子保存 分类名
                String allSupplierGoodsCategoryName = "";
                //循环获取分类名
                for (SupplierGoodsCategory supplierGoodsCategory : supplierGoodsCategoryList) {
                    //查询商品分类表
                    supplierGoodsCategory.setName(shopTypeInfoMapper.selectById(supplierGoodsCategory.getSortId()).getName());
                    System.out.println("商品分类" + supplierGoodsCategory.getName());
                    //拼接分类名称
                    allSupplierGoodsCategoryName += supplierGoodsCategory.getName() + ",";
                }

                userinfo.setSupplierGoodsCategoryName(allSupplierGoodsCategoryName.substring(0, allSupplierGoodsCategoryName.length() - 1));
                userinfo.setSupplierGoodsCategoryList(supplierGoodsCategoryList);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return userinfo;
    }

    @Override
    //用户登录
    public Userinfo userlogin(Userinfo userinfo) {
        Userinfo userinfo1 = userinfoMapper.userlogin(userinfo);
        if (userinfo1 == null) {
            return null;
        }
        return userinfo1;
    }

    @Override
    public Map update(Userinfo userinfo) {
        boolean num = this.updateById(userinfo);
        Map map = new HashMap();
        map.put("code", "0");
        map.put("msg", "修改失败");
        if (num) {
            map.put("code", "1");
            map.put("msg", "修改成功");
        }
        return map;
    }

    @Override
    public PageVo<Userinfo> querybyconduser(Userinfo userinfo, Integer pageno, Integer pagesize) {
        Page<Userinfo> page = new Page<Userinfo>(pageno, pagesize);
        //条件查询
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<Userinfo>();
        if (StringUtils.isNotBlank(userinfo.getUsername())) {
            queryWrapper.like("username", userinfo.getUsername());
        }
        Page<Userinfo> page1 = this.page(page, queryWrapper);
        PageVo<Userinfo> pageVo = new PageVo<Userinfo>();
        pageVo.setTotal(page1.getTotal());
        pageVo.setRows(page1.getRecords());
        return pageVo;
    }

    //去申请成为供销商
    @Override
    public Map apply_supplier(Userinfo userinfo, Integer[] supplierGoodsCategoryIds,
                              MultipartFile img, String apppath) {
        Map map = new HashMap();
        //去为供应商分类表里去添加数据
        for (Integer i : supplierGoodsCategoryIds) {
            SupplierGoodsCategory tem_obj = new SupplierGoodsCategory();
            tem_obj.setPId(userinfo.getId());
            tem_obj.setSortId(i);
            supplierGoodsCategoryMapper.insert(tem_obj);
        }
        //去补全属性
        //去将注册供应商状态改为等待审核
        userinfo.setGysState(0);
        //去判断是否上传了图片
        if (img != null && img.getSize() > 0) {
            //上传图片
            //  String apppath = ;
            File file = new File(apppath);
            if (!file.exists()) {
                //不存在就去创建
                file.mkdirs();
            }
            //去获取文件名称
            String fileName = img.getOriginalFilename();
            //去保存文件到路径
            try {
                img.transferTo(new File(apppath, fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //去将路径设置到对象
            userinfo.setImgpath("/img/" + fileName);
        }
        //去进行修改
        boolean b = this.updateById(userinfo);
        if (b) {
            map.put("msg", "发出申请，等待审核结果");
            map.put("x", true);
        } else {
            map.put("msg", "操作失败");
            map.put("x", false);
        }
        return map;

    }

    //审核供应商
    @Override
    public Map updstate(Userinfo userinfo) {
        boolean num = this.updateById(userinfo);
        Map map = new HashMap();
        map.put("code", "0");
        map.put("msg", "审核失败");
        if (num) {
            map.put("code", "1");
            map.put("msg", "审核成功");
        }
        return map;
    }

    //审核供应商
    @Override
    public Map updstatebtg(Userinfo userinfo) {
        boolean num = this.updateById(userinfo);
        Map map = new HashMap();
        map.put("code", "0");
        map.put("msg", "审核未通过失败");
        if (num) {
            map.put("code", "1");
            map.put("msg", "审核未通过");
        }
        return map;
    }

    @Override
    public PageVo<Userinfo> querybyconduser2(Userinfo userinfo, Integer pageno, Integer pagesize) {
        Page<Userinfo> page = new Page<Userinfo>(pageno, pagesize);
        //条件查询
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<Userinfo>();
        if (StringUtils.isNotBlank(userinfo.getUsername())) {
            queryWrapper.like("username", userinfo.getUsername());
        }
        if (userinfo.getShState() != null) {
            queryWrapper.like("sh_state", userinfo.getShState());
        }
        if (userinfo.getGysState() != null) {
            queryWrapper.like("gys_state", userinfo.getGysState());
        }
        Page<Userinfo> page1 = this.page(page, queryWrapper);
        PageVo<Userinfo> pageVo = new PageVo<Userinfo>();
        pageVo.setTotal(page1.getTotal());
        pageVo.setRows(page1.getRecords());
        return pageVo;
    }

    @Override
    public PageVo<Userinfo> queryallGysJl(Userinfo userinfo, Integer pageno, Integer pagesize) {
        Page<Userinfo> page = new Page<Userinfo>(pageno, pagesize);
        //条件查询
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<Userinfo>();
        if (StringUtils.isNotBlank(userinfo.getUsername())) {
            queryWrapper.like("username", userinfo.getUsername());
        }
        if (userinfo.getGysState() != null) {
            queryWrapper.like("gys_state", userinfo.getGysState());
        }
        queryWrapper.isNotNull("gys_state");
        Page<Userinfo> page1 = this.page(page, queryWrapper);
        PageVo<Userinfo> pageVo = new PageVo<Userinfo>();
        pageVo.setTotal(page1.getTotal());
        pageVo.setRows(page1.getRecords());
        return pageVo;
    }

    @Override
    public Integer CartCount(Integer id) {
        int i = userinfoMapper.CartCount(id);
        if (i == 0) {
            return i;
        }
        return i;
    }

    @Override
    public PageVo<Userinfo> queryallShJl(Userinfo userinfo, Integer pageno, Integer pagesize) {
        Page<Userinfo> page = new Page<Userinfo>(pageno, pagesize);
        //条件查询
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<Userinfo>();
        if (StringUtils.isNotBlank(userinfo.getUsername())) {
            queryWrapper.like("username", userinfo.getUsername());
        }
        if (userinfo.getShState() != null) {
            queryWrapper.eq("sh_state", userinfo.getShState());
        }
        queryWrapper.isNotNull("sh_state");
        Page<Userinfo> page1 = this.page(page, queryWrapper);
        PageVo<Userinfo> pageVo = new PageVo<Userinfo>();
        pageVo.setTotal(page1.getTotal());
        pageVo.setRows(page1.getRecords());
        return pageVo;
    }

//    @Override
//    public boolean addgoods(Userinfo userinfo) {
//        boolean result = false;
//        //添加商品
//        //将商品id加入图片类中
//
//        //添加商品图片信息
//        result= this.save(userinfo);
//
//        return result;
//    }

    @Override
    public Map delUser(Integer id) {
        boolean num = this.removeById(id);
        Map map = new HashMap();
        map.put("code", "0");
        map.put("msg", "删除失败");
        if (num) {
            map.put("code", "1");
            map.put("msg", "删除成功");
        }
        return map;
    }

    @Override
    public boolean updateusers(Userinfo userinfo) {
        boolean result = false;

        //修改商品信息
        result = this.updateById(userinfo);


        return result;
    }

    @Override
    public Userinfo queryusersbyid(String path, int id) {
        Userinfo userinfo = this.getById(id);

        return userinfo;
    }

    @Override
    public Map updstateuser(Userinfo userinfo) {
        Map map = new HashMap();
        if(userinfo.getUstate()==1){
            boolean num = this.updateById(userinfo);
            map.put("code", "0");
            map.put("msg", "冻结失败");
            if (num) {
                map.put("code", "1");
                map.put("msg", "冻结成功");
            }
        }else{
            boolean num = this.updateById(userinfo);
            map.put("code", "0");
            map.put("msg", "解冻失败");
            if (num) {
                map.put("code", "1");
                map.put("msg", "解冻成功");
            }
        }
        return map;
    }

    @Override
    public boolean registerUser(Userinfo userinfo) {
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<Userinfo>();
        queryWrapper.eq("loginname", userinfo.getLoginname());
        Userinfo userinfo1 = this.getOne(queryWrapper);
        if (userinfo1 == null) {
            userinfo.setIdentity(1);
            return this.save(userinfo);
        } else {
            return false;
        }
    }

    //充值
    @Override
    public Map<String, String> userinforecharge(Userinfo userinfo) {
        Map map = new HashMap();
        map.put("code", "0");
        map.put("msg", "充值失败");

        //用户充值
        Userinfo userinfo1 = userinfoMapper.selectById(userinfo.getId());
        userinfo1.setUmoney(userinfo1.getUmoney() + userinfo.getUmoney());
        userinfoMapper.updateById(userinfo1);

        //用户余额变动表添加数据
        Customerbalancelog customerbalancelog = new Customerbalancelog();
        customerbalancelog.setUid(userinfo1.getId());
        customerbalancelog.setAmount(userinfo.getUmoney());
        customerbalancelog.setSource(3);
        customerbalancelog.setCtime(new Date());

        System.out.println(customerbalancelog);

        int insert = customerbalancelogMapper.insert(customerbalancelog);
        if (insert >= 1) {
            map.put("code", "1");
            map.put("msg", "充值成功");
        }
        return map;
    }

    @Override
    public Map zcsh(Userinfo userinfo) {
        boolean num = this.updateById(userinfo);
        Map map = new HashMap();
        map.put("code", "0");
        map.put("msg", "注册失败");
        if (num) {
            map.put("code", "1");
            map.put("msg", "注册成功,等待审核");
        }
        return map;

    }

    @Override
    public List<Userinfo> QueryLikeSh(Userinfo userinfo) {
        return userinfoMapper.QueryLikeSh(userinfo);
    }

    @Override
    public int addaddress(Userinfo userinfo) {
        int i = 0;
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id", userinfo.getId());
        updateWrapper.set("address", userinfo.getAddress());
        baseMapper.update(userinfo, updateWrapper);
        if (updateWrapper != null) {
            i = 1;
            return i;
        }
        return i;
    }
}
