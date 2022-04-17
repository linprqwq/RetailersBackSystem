package com.guigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.pojo.Commthinfo;
import com.guigu.pojo.Ordderdetails;
import com.guigu.pojo.Orderinfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 童总
 * @since 2022-03-28
 */
public interface OrdderdetailsService extends IService<Ordderdetails> {

    List<Ordderdetails> queryshorderdetails(Ordderdetails ordderdetails);

    Ordderdetails queryordd(Ordderdetails ordderdetails);

    Map<String,String> orderthuo(Commthinfo commthinfo, Orderinfo orderinfo);
}
