package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.CommthinfoMapper;
import com.guigu.mapper.OrdderdetailsMapper;
import com.guigu.mapper.OrderinfoMapper;
import com.guigu.pojo.Commthinfo;
import com.guigu.pojo.Ordderdetails;
import com.guigu.pojo.Orderinfo;
import com.guigu.service.OrdderdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    OrderinfoMapper orderinfoMapper;

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
    public Map<String,String> orderthuo(Commthinfo commthinfo ,Orderinfo orderinfo) {
        Map<String,String> map = new HashMap<>();
        map.put("code","0");
        map.put("msg","失败");
        //商户id
       Orderinfo orderinfo1 =  orderinfoMapper.selectById(orderinfo.getOrderid());
        commthinfo.setSid(orderinfo1.getSid());

        Ordderdetails ordderdetails = ordderdetailsMapper.selectById(commthinfo.getOrddid());
        //待退款状态
        ordderdetails.setRefund(2);
        //评价
        ordderdetails.setEvaluatea(3);
        ordderdetailsMapper.updateById(ordderdetails);

        int insert = commthinfoMapper.insert(commthinfo);
        if (insert>=1){
            map.put("code","1");
            map.put("msg","等待后台人员审核");
        }
        return map;
    }
}
