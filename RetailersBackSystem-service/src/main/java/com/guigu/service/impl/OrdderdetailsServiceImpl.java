package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.CommthinfoMapper;
import com.guigu.mapper.OrdderdetailsMapper;
import com.guigu.pojo.Commthinfo;
import com.guigu.pojo.Ordderdetails;
import com.guigu.service.OrdderdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    CommthinfoMapper commthinfoMapper;

    @Override
    public List<Ordderdetails> queryshorderdetails(Ordderdetails ordderdetails) {
        QueryWrapper<Ordderdetails> queryWrapper=new QueryWrapper<Ordderdetails>();
        queryWrapper.eq("orderid",ordderdetails.getOrderid());
        List<Ordderdetails> list=new ArrayList<Ordderdetails>();
        return list(queryWrapper);
    }

    //退款查询订单详情数据
    @Override
    public Ordderdetails queryordd(Ordderdetails ordderdetails) {
        QueryWrapper<Ordderdetails> queryWrapper=new QueryWrapper<Ordderdetails>();
        queryWrapper.eq("id",ordderdetails.getId());
        queryWrapper.eq("orderid",ordderdetails.getOrderid());
        return ordderdetailsMapper.selectOne(queryWrapper);
    }

    @Override
    public Map<String,String> addgoods(Commthinfo commthinfo) {
        Map<String,String> map = new HashMap<>();
        map.put("code","0");
        map.put("msg","失败");

        Ordderdetails ordderdetails = ordderdetailsMapper.selectById(commthinfo.getOrddid());
        ordderdetails.setRefund(2);
        ordderdetailsMapper.updateById(ordderdetails);

        int insert = commthinfoMapper.insert(commthinfo);
        if (insert>=1){
            map.put("code","1");
            map.put("msg","等待后台人员审核");
        }
        return map;
    }
}
