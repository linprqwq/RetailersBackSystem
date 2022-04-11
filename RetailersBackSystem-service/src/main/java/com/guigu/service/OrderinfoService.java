package com.guigu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Orderinfo;

import java.util.Map;

public interface OrderinfoService extends IService<Orderinfo> {

    Page<Orderinfo> queryuserorder(Orderinfo order, int Pageno, int pagesize);

    Map<String, String> delorderbyid(Orderinfo orderinfo);

    Page<Orderinfo> queryshorder(Orderinfo order, int pageno, int pagesize);

    Page<Orderinfo> queryshdshorder(Orderinfo order, int pageno, int pagesize);

    Map uptorderdsh(Orderinfo orderinfo);

    Map<String, String> cofirmorder(Orderinfo orderinfo);
}
