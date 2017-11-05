package com.shop.bean;

import javax.validation.constraints.NotNull;

public class User {
	
	@NotNull (message = " provide lat value. ")
	private Double lat;
	@NotNull (message = " provide lng value. ")
	private Double lng;
	
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	
}
   