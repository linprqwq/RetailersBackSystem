package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.CommodityMapper;
import com.guigu.mapper.CommthinfoMapper;
import com.guigu.mapper.OrdderdetailsMapper;
import com.guigu.pojo.Commodity;
import com.guigu.pojo.Commthinfo;
import com.guigu.pojo.Ordderdetails;
import com.guigu.pojo.Orderinfo;
import com.guigu.service.CommthinfoService;
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
 * @since 2022-04-12
 */
@Service
public class CommthinfoServiceImpl extends ServiceImpl<CommthinfoMapper, Commthinfo> implements CommthinfoService {

    @Autowired
    OrdderdetailsMapper ordderdetailsMapper;

    @Override
    public Page<Commthinfo> queryreturnstop(Commthinfo commthinfo, int pageno, int pagesize) {

        QueryWrapper queryWrapper = new QueryWrapper();


        queryWrapper.eq("audit",commthinfo.getAudit());
        queryWrapper.eq("commstate",commthinfo.getCommstate());
        queryWrapper.eq("sid",commthinfo.getSid());
        Page<Commthinfo> page = this.page(new Page<Commthinfo>(pageno, pagesize), queryWrapper);
        for (Commthinfo commthinfo1 : page.getRecords()) {
            //把订单详情数据添加到订单表实体类里
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("id",commthinfo1.getOrddid());
            commthinfo1.setOlist(ordderdetailsMapper.selectList(queryWrapper1));
        }
        System.out.println(page.getRecords());
        return page;
    }

    @Override
    public Map uptcommstate(Commthinfo commthinfo) {
        boolean num = this.updateById(commthinfo);
        Map map =new HashMap();
        map.put("code","0");
        map.put("msg","操作失败");
        if(num){
            map.put("code","1");
            map.put("msg","操作成功");
        }
        return map;
    }
}
