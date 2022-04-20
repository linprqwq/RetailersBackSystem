package com.guigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guigu.mapper.PurchaseDetailInfoMapper;
import com.guigu.mapper.PurchaseInfoMapper;
import com.guigu.mapper.UserinfoMapper;
import com.guigu.pojo.Goodsupplied;
import com.guigu.pojo.PurchaseDetailInfo;
import com.guigu.pojo.PurchaseInfo;
import com.guigu.service.GoodsuppliedService;
import com.guigu.service.PurchaseDetailInfoService;
import com.guigu.service.PurchaseInfoService;
import com.guigu.service.utils.MyIdAdd;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 童总
 * @since 2022-03-29
 */
@Service
public class PurchaseInfoServiceImpl extends ServiceImpl<PurchaseInfoMapper, PurchaseInfo> implements PurchaseInfoService {

    @Autowired
    GoodsuppliedService goodsuppliedService;
    @Autowired
    PurchaseInfoMapper purchaseInfoMapper;
    @Autowired
    PurchaseDetailInfoMapper purchaseDetailInfoMapper;
    @Autowired
    UserinfoMapper userinfoMapper;
    @Autowired
    MyIdAdd myIdAdd;
    @Override
    public Map addPurchaseInfo(List<PurchaseInfo> purchaseList) {
        Map map = new HashMap();
        map.put("code", 0);
        map.put("msg", "创建失败");
        for (PurchaseInfo purchaseInfo : purchaseList) {
            purchaseInfo.setBuyNumber(myIdAdd.idadd("200",true));
            purchaseInfo.setPtime(new Date()); //设置时间
            purchaseInfo.setIsAudit(0); //设置未审核
            purchaseInfo.setIsDesign(0); //设置未设计
            purchaseInfo.setIsShipments(0); //设置未发货
            purchaseInfo.setIsDelete(0); //设置未删除
            Integer totalNum = 0; //总数量
            Double totalMoney = 0.0; //总金额
            boolean save = this.save(purchaseInfo);
            //采购添加后添加详情表
            if (save){
                for (PurchaseDetailInfo purchaseDetail : purchaseInfo.getPurchaseDetailInfoList()) {
                    //设置详情表的父id
                    purchaseDetail.setPid(purchaseInfo.getId());
                    //根据供应商维护表id查询维护信息
                    Goodsupplied goodsupplied = goodsuppliedService.queryById(purchaseDetail.getShopId());
                    //设置采购详情表单价
                    purchaseDetail.setShopPrice(goodsupplied.getSupplierPrice());
                    //设置采购详情表总价
                    purchaseDetail.setTotalPrice(purchaseDetail.getShopNum()*purchaseDetail.getShopPrice());
                    //设置未删除状态
                    purchaseDetail.setIsDelete(0);
                    //设置设计状态
                    purchaseDetail.setIsDesign(0);
                    //保存
                    purchaseDetailInfoMapper.insert(purchaseDetail);
                    totalNum += purchaseDetail.getShopNum();
                    totalMoney += purchaseDetail.getShopNum() * goodsupplied.getSupplierPrice();
                }
            }
            purchaseInfo.setTotalNum(totalNum);
            purchaseInfo.setTotalMoney(totalMoney);
            //通过修改设置总数量和总价格
            boolean b = this.updateById(purchaseInfo);
            if (b){
                map.put("code",1);
                map.put("msg","创建订单成功");
            }
        }
        return map;
    }

    @Override
    public List<String> getIds(String str) {
        List<String> list=new ArrayList<String>();
        QueryWrapper<PurchaseInfo> queryWrapper=new QueryWrapper<PurchaseInfo>();
        queryWrapper.likeRight("buy_number", str);
        List<PurchaseInfo> tempList = this.list(queryWrapper);
        for (PurchaseInfo o : tempList) {
            list.add(o.getBuyNumber());
        }
        return list;
    }

    @Override
    public Page<PurchaseInfo> queryAllPurchase(PurchaseInfo purchase, Integer pageno, Integer pagesize) {
        QueryWrapper<PurchaseInfo> queryWrapper=new QueryWrapper<PurchaseInfo>();
        queryWrapper.eq("is_delete",0);
        queryWrapper.select().orderByDesc("ptime");//时间倒叙排列
        //采购单号
        if (StringUtils.isNotBlank(purchase.getBuyNumber())){
            queryWrapper.like("buy_number",purchase.getBuyNumber());
        }
        System.out.println(purchase.getSupplyId());
        //供应商id
        if(purchase.getSupplyId()!=null){
            queryWrapper.eq("supply_id",purchase.getSupplyId());
        }
        //是否发货
        if (purchase.getIsShipments()!=null){
            queryWrapper.like("is_shipments",purchase.getIsShipments());
        }
        //审核状态
        if(purchase.getIsAudit()!=null){
            queryWrapper.eq("is_audit",purchase.getIsAudit());
        }
        //采购时间
        if (purchase.getPtime()!=null){
            queryWrapper.eq("ptime",purchase.getPtime());
        }
        //删除状态
        if (purchase.getIsDelete()!=null){
            queryWrapper.eq("is_delete",purchase.getIsDelete());
        }
        Page<PurchaseInfo> page = this.page(new Page<PurchaseInfo>(pageno, pagesize),queryWrapper);
        for (PurchaseInfo p : page.getRecords()) {
            //配置供应商对象
            p.setUserinfo(userinfoMapper.selectById(p.getSupplyId()));
        }
        return page;
    }

    @Override
    public Map changeIsAudit(PurchaseInfo purchase) {
        Map map=new HashMap();
        if(purchase.getIsAudit()==1){
            map.put("code",0);
            map.put("msg","审核失败");
            boolean b = this.updateById(purchase);
            if (b){
                map.put("code",1);
                map.put("msg","审核通过");
            }
        }else{
            map.put("code",0);
            map.put("msg","审核失败");
            boolean b = this.updateById(purchase);
            if (b){
                map.put("code",1);
                map.put("msg","审核未通过");
            }
        }
        return map;
    }
}
