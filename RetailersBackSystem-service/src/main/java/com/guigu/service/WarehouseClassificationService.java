package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.WarehouseClassification;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 童总
 * @since 2022-04-18
 */
public interface WarehouseClassificationService extends IService<WarehouseClassification> {

    List queryallcksp(int id);
}
