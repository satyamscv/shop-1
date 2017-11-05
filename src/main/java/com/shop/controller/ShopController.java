package com.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.bean.Shop;
import com.shop.bean.User;
import com.shop.service.ShopService;
import com.shop.service.ShopServiceImpl;

@RestController
public class ShopController {

	@Autowired
	ShopService shopservice;
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ShopServiceImpl.class);

	@RequestMapping(method = RequestMethod.POST, value = "/shopAppend")
	public Map<String,String> add(@RequestBody Shop shop) {
		LOGGER.debug(" processing addshop.. shop name ::" + shop.getShopName());
		shopservice.addShop(shop);
		Map<String,String> map = new HashMap<String,String> ();
		map.put("message", "Shop is added.");
		return map;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shopSearch")
	public Shop getShop(@RequestBody User user)  {
		LOGGER.debug(" processing getShop.. Lat ::" + user.getLat() + " , Lng ::"+ user.getLng());
		return shopservice.getShop(user);
		
	}
}
