package com.guigu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.WarehouseDetailsInfo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 童总
 * @since 2022-04-18
 */
public interface WarehouseDetailsInfoService extends IService<WarehouseDetailsInfo> {

    Page<WarehouseDetailsInfo> querywaredetails(WarehouseDetailsInfo warehouseDetailsInfo, Integer pageno, Integer pagesize);
}
