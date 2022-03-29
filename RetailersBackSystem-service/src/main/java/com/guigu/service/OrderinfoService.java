package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Orderinfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
public interface OrderinfoService extends IService<Orderinfo> {

    List<Orderinfo> queryuserorder(Orderinfo order);
}
