package com.shop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.shop.bean.Location;
import com.shop.bean.Shop;
import com.shop.bean.User;
import com.shop.util.JsonUtil;

@Service
public class ShopServiceImpl implements ShopService {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ShopServiceImpl.class);

	private static String URL = "https://maps.googleapis.com/maps/api/geocode/json?";

	private final Map<String, Shop> shops = new HashMap<String, Shop>();

	@Override
	public void addShop(final Shop shop) {
		Shop previousShop = shops.get(shop.getShopName());
		LOGGER.debug(" addshop method processing ...");
		if (previousShop != null) {
			shop.setMessage(" previous version of Shop is updated by " + shop.getUpdatedBy());

		}
		String url = URL + "address=" + shop.getShopName() + shop.getShopAddress().getNumber() + shop.getShopAddress().getAddress()+ "&zipcode="
				+ shop.getShopAddress().getPostCode();
		
		LOGGER.debug("URL : "+url);		
		JsonUtil jsonObject = new JsonUtil();		
		List<Location> loc = jsonObject.getDetails(url);
		if (!loc.isEmpty()) {
			shop.setLat(loc.get(0).getLat());
			shop.setLng(loc.get(0).getLng());
			shop.getShopAddress().setAddress(loc.get(0).getAddress());
		}
		shops.put(shop.getShopName(), shop);

	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Shop getShop(final User user) {
		LOGGER.debug(" getShop method processing ...");
		Shop shop = null;
		if (user != null) {
			String url = URL + "latlng=" + String.valueOf(user.getLat()) + ","+ String.valueOf(user.getLng())
					+ "&sensor=false";
			LOGGER.debug("URL : "+url);		
			JsonUtil jsonObject = new JsonUtil();
			List<Location> loc = jsonObject.getDetails(url);
			// get Shop object from Map.
			for (Object o : shops.keySet()) {
				if (shops.get(o).getShopAddress().getAddress().equals(loc.get(0).getAddress())) {
					LOGGER.debug(" shop details is matched :");	
					return shops.get(o);
				}
			}			
						
		}
		return shop;

	}

}
