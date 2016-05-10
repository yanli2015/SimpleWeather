package com.yanweather.model;

public class State {
private int id;
private String stateName;
private String stateCode;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStateName() {
	return stateName;
}
public void setProvinceName(String provinceName) {
	this.stateName = provinceName;
}
public String getStateCode() {
	return stateCode;
}
public void setProvinceCode(String provinceCode) {
	this.stateCode = provinceCode;
}

}
