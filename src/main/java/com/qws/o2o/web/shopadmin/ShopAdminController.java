package com.qws.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "shopadmin", method = { RequestMethod.GET })
/**
 * 主要用来解析路由并转发到相应的html中
 * 
 *
 */
public class ShopAdminController {
	
	@RequestMapping(value = "/shopoperation")
	public String shopOperation() {
		// 转发至店铺注册/编辑页面
		//在springmvc的配置中已经设定了前后缀
		return "shop/shopoperation";
	}
 
}
