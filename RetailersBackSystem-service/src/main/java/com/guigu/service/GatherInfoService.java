package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.GatherInfo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 童总
 * @since 2022-04-18
 */
public interface GatherInfoService extends IService<GatherInfo> {

    Map addGatherInfoandDetailPurchaseInfo(Integer id);
}
