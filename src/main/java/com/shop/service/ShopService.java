package com.shop.service;

import com.shop.bean.Shop;
import com.shop.bean.User;

public interface ShopService {

	public void addShop(Shop shop);

	public Shop getShop(User user);
}
