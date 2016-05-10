package com.yanweather.model;

public class City {
	private String cityName;
	private String stateCode;
	
	public City() {
		super();
	}
	public City(String cityName, String stateCode) {
		super();
		this.cityName = cityName;
		this.stateCode = stateCode;
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	
	
	

}
