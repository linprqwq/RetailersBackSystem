package com.guigu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Commodity;
import com.guigu.pojo.Commthinfo;
import com.guigu.pojo.Orderinfo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 童总
 * @since 2022-04-12
 */
public interface CommthinfoService extends IService<Commthinfo> {

    Page<Commthinfo> queryreturnstop(Commthinfo commthinfo, int pageno, int pagesize);

    Map uptcommstate(Commthinfo commthinfo);
}
