package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guigu.pojo.Reviews;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
public interface ReviewsService extends IService<Reviews> {

    Map<String, String> orderpj(Reviews reviews);

    Page<Reviews> plallbyid(Reviews reviews,Integer pageno,Integer pagesize);
}
