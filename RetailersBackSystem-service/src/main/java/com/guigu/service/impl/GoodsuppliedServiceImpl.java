package com.guigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.GoodsuppliedMapper;
import com.guigu.mapper.RetreatGoodsMapper;
import com.guigu.pojo.Goodsupplied;
import com.guigu.service.GoodsuppliedService;
import org.springframework.stereotype.Service;

@Service
public class GoodsuppliedServiceImpl extends ServiceImpl<GoodsuppliedMapper, Goodsupplied>
        implements  GoodsuppliedService {
}
