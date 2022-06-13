package com.two.crm.dto;

public class LocationDto {

	private String area_code;
	private String area;
	public String getArea_code() {
		return area_code;
	}
	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "LocationDto [area_code=" + area_code + ", area=" + area + "]";
	}
	public LocationDto(String area_code, String area) {
		super();
		this.area_code = area_code;
		this.area = area;
	}
	public LocationDto() {
		super();
	}
	
	

}
