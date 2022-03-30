package com.guigu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Orderinfo;

public interface OrderinfoService extends IService<Orderinfo> {

    Page<Orderinfo> queryuserorder(Orderinfo order, int Pageno, int pagesize);
}
