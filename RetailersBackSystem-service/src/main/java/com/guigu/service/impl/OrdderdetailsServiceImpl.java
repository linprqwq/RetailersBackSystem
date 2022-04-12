package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.OrdderdetailsMapper;
import com.guigu.pojo.Ordderdetails;
import com.guigu.service.OrdderdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
@Service
public class OrdderdetailsServiceImpl extends ServiceImpl<OrdderdetailsMapper, Ordderdetails> implements OrdderdetailsService {
    @Autowired
    OrdderdetailsMapper ordderdetailsMapper;

    @Override
    public List<Ordderdetails> queryshorderdetails(Ordderdetails ordderdetails) {
        QueryWrapper<Ordderdetails> queryWrapper=new QueryWrapper<Ordderdetails>();
        queryWrapper.eq("orderid",ordderdetails.getOrderid());
        List<Ordderdetails> list=new ArrayList<Ordderdetails>();
        return list(queryWrapper);
    }
}
