package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.ReturnShopInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 童总
 * @since 2022-03-29
 */
public interface ReturnShopInfoService extends IService<ReturnShopInfo> {

    List<String> getIds(String str);
}
