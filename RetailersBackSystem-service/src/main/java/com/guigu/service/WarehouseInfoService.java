package com.guigu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.WarehouseInfo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 童总
 * @since 2022-04-18
 */
public interface WarehouseInfoService extends IService<WarehouseInfo> {

    Page<WarehouseInfo> queryallck(WarehouseInfo warehouseInfo, Integer pageno, Integer pagesize);

    Map<String, String> cxwhouse(WarehouseInfo warehouseInfo);

    Map<String, String> tjck(WarehouseInfo warehouseInfo, int[] arr);

    Page<WarehouseInfo> queryallshck(WarehouseInfo warehouseInfo, Integer pageno, Integer pagesize);

    WarehouseInfo querywarehouseInfobyid(WarehouseInfo warehouseInfo);

    Map<String, String> updatewarehbyid(WarehouseInfo warehouseInfo, int[] list);

    Map cksh(WarehouseInfo warehouseInfo);
}
