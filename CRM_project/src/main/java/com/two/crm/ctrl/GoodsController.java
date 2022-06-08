package com.two.crm.ctrl;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.two.crm.dto.ClientDto;
import com.two.crm.dto.GoodsDto;
import com.two.crm.model.service.Goods_IService;

@Controller
public class GoodsController {
	
	@Autowired
	private Goods_IService gService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	
	//재고 전체 조회 
	@RequestMapping(value = "/GoodsList.do", method = RequestMethod.GET)
	public String goodsList(Model model, Authentication user) {
		logger.info("GoodsController goodsList GET");
		List<GoodsDto> goods = gService.AllGoods();
		model.addAttribute("goods", goods);
		
		model.addAttribute("user", user.getName());
		return "goodsList";
	}


}
