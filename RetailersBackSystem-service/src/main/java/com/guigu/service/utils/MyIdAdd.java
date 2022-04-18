package com.guigu.service.utils;

import com.guigu.service.OrderinfoService;
import com.guigu.service.PurchaseInfoService;
import com.guigu.service.ReturnShopInfoService;
import com.guigu.service.ShopTypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class MyIdAdd {

    @Autowired
    ShopTypeInfoService shopTypeInfoService;//商品

    @Autowired
    PurchaseInfoService purchaseService; //采购单

    @Autowired
    OrderinfoService ordersService;//订单

    @Autowired
    ReturnShopInfoService returnService; //退货申请

    //str是编号的前缀，dateYes是是否要追加当前日期(产品编号不需要当前日期)
    public String idadd(String str,boolean dateYes)
    {
        //获取当前日期
        String datestr=getDate();
        //最大流水号
        Integer maxId=0;
        //最大流水号位数
        Integer max_number=0;
        List<String> ids=null;
        //检查传来的编号前缀
        switch (str.substring(0,3)){
            case "100":
                //调用方法，获取编号集合
                ids=shopTypeInfoService.getIds(str);
                max_number=6;
                break;
            case "200":
                //调用方法，获取编号集合
                ids=purchaseService.getIds(str);
                max_number=6;
                break;
            case "300":
                //调用方法，获取编号集合
                ids=ordersService.getIds(str);
                max_number=6;
                break;
            case "400":
                //调用方法，获取编号集合
                ids=returnService.getIds(str);
                max_number=6;
                break;

        }
        //检查是否要追加当前日期
        if(dateYes)
        {
            str=str+datestr;
        }
        //对字符串集合进行检查，是否查询到编号
        if(ids!=null && ids.size()>0)
        {
            //有编号，循环数组，获取最大流水号
            for(String obj : ids)
            {
                Integer tempNumber=Integer.parseInt(obj.substring(obj.length()-max_number));
                maxId=maxId>tempNumber?maxId:tempNumber;
            }
        }
        //自增编号
        maxId++;
        //对最大流水号进行补零并且转字符串
        return str+String.format("%0"+max_number+"d",maxId);
    }


    public String getDate()
    {
        Calendar date=Calendar.getInstance();
        Integer year=date.get(Calendar.YEAR);
        Integer month=date.get(Calendar.MONTH)+1;
        Integer day=date.get(Calendar.DATE);
        return (year<10?"0"+year:""+year)+(month<10?"0"+month:""+month)+(day<10?"0"+day:""+day);
    }
}
