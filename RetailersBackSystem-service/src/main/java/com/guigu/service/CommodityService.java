package com.guigu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Commodity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface CommodityService extends IService<Commodity> {

    //去添加商品
    public Map addsp(Commodity commodity, MultipartFile imgs,String appth);

    //查询商品id
    Commodity querycommodityid(Integer id);

    //查询所有商品并分页
    Page<Commodity> queryAllshop(Commodity commodity,Integer pageno,Integer pagesize);

    //查询所有水果
    List<Commodity> QueryAllCommodity();

    //查询所有海鲜
    List<Commodity> QueryAllCommodityHS();

    List<Commodity> QueryAllCommodityRL();
}
