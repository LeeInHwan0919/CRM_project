package com.two.crm.dto;


public class UserDto {

	private String emp_code;
	private String area_code;
	private String emp_name;
	private String emp_pw;
	private String emp_gender;
	private String emp_use ;
	private String emp_img;
	private String emp_auth;
	private String emp_tel;
	private String area;
	private String emp_addr;
	
	
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getArea_code() {
		return area_code;
	}
	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_pw() {
		return emp_pw;
	}
	public void setEmp_pw(String emp_pw) {
		this.emp_pw = emp_pw;
	}
	public String getEmp_gender() {
		return emp_gender;
	}
	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}
	public String getEmp_use() {
		return emp_use;
	}
	public void setEmp_use(String emp_use) {
		this.emp_use = emp_use;
	}
	public String getEmp_img() {
		return emp_img;
	}
	public void setEmp_img(String emp_img) {
		this.emp_img = emp_img;
	}
	public String getEmp_auth() {
		return emp_auth;
	}
	public void setEmp_auth(String emp_auth) {
		this.emp_auth = emp_auth;
	}
	public String getEmp_tel() {
		return emp_tel;
	}
	public void setEmp_tel(String emp_tel) {
		this.emp_tel = emp_tel;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getEmp_addr() {
		return emp_addr;
	}
	public void setEmp_addr(String emp_addr) {
		this.emp_addr = emp_addr;
	}
	@Override
	public String toString() {
		return "UserDto [emp_code=" + emp_code + ", area_code=" + area_code + ", emp_name=" + emp_name + ", emp_pw="
				+ emp_pw + ", emp_gender=" + emp_gender + ", emp_use=" + emp_use + ", emp_img=" + emp_img
				+ ", emp_auth=" + emp_auth + ", emp_tel=" + emp_tel + ", area=" + area + ", emp_addr=" + emp_addr + "]";
	}
	public UserDto(String emp_code, String area_code, String emp_name, String emp_pw, String emp_gender, String emp_use,
			String emp_img, String emp_auth, String emp_tel, String area, String emp_addr) {
		super();
		this.emp_code = emp_code;
		this.area_code = area_code;
		this.emp_name = emp_name;
		this.emp_pw = emp_pw;
		this.emp_gender = emp_gender;
		this.emp_use = emp_use;
		this.emp_img = emp_img;
		this.emp_auth = emp_auth;
		this.emp_tel = emp_tel;
		this.area = area;
		this.emp_addr = emp_addr;
	}
	public UserDto() {
		super();
	}
	
	
	
	
	
	
	
	

}
