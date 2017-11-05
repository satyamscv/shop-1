package com.shop.bean;

import javax.validation.constraints.NotNull;

public class ShopAddress {
	
	@NotNull
	private Integer number;	
	@NotNull
	private String postCode;
	@NotNull
	private String address;

	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
