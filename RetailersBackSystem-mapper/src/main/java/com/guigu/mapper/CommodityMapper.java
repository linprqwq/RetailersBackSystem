package com.guigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.pojo.Commodity;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
public interface CommodityMapper extends BaseMapper<Commodity> {
        List<Commodity> QueryAllCommodity();

        List<Commodity> QueryAllCommodityHS();

        List<Commodity> QueryAllCommodityRL();
}
