package com.two.crm.dto;

public class ClientDto {
	
	
	private String cli_num ;
	private String emp_code;
	private String cli_name;
	private String cli_addr;
	private String cli_tel ;
	private String cli_area;
	private String cli_use ;
	
	private String rate;
	private String g_name;
	private String g_code;
	private String status;
	private String ct_date_year_sum;
	private String ct_start;
	private String ct_end;
	
	
	public ClientDto() {
		super();
	}
	
	
	public ClientDto(String cli_num, String emp_code, String cli_name, String cli_addr, String cli_tel, String cli_area,
			String cli_use, String rate, String g_name, String g_code, String status, String ct_date_year_sum,
			String ct_start, String ct_end) {
		super();
		this.cli_num = cli_num;
		this.emp_code = emp_code;
		this.cli_name = cli_name;
		this.cli_addr = cli_addr;
		this.cli_tel = cli_tel;
		this.cli_area = cli_area;
		this.cli_use = cli_use;
		this.rate = rate;
		this.g_name = g_name;
		this.g_code = g_code;
		this.status = status;
		this.ct_date_year_sum = ct_date_year_sum;
		this.ct_start = ct_start;
		this.ct_end = ct_end;
	}
	
	
	@Override
	public String toString() {
		return "ClientDto [cli_num=" + cli_num + ", emp_code=" + emp_code + ", cli_name=" + cli_name + ", cli_addr="
				+ cli_addr + ", cli_tel=" + cli_tel + ", cli_area=" + cli_area + ", cli_use=" + cli_use + ", rate="
				+ rate + ", g_name=" + g_name + ", g_code=" + g_code + ", status=" + status + ", ct_date_year_sum="
				+ ct_date_year_sum + ", ct_start=" + ct_start + ", ct_end=" + ct_end + "]";
	}
	public String getCli_num() {
		return cli_num;
	}
	public void setCli_num(String cli_num) {
		this.cli_num = cli_num;
	}
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getCli_name() {
		return cli_name;
	}
	public void setCli_name(String cli_name) {
		this.cli_name = cli_name;
	}
	public String getCli_addr() {
		return cli_addr;
	}
	public void setCli_addr(String cli_addr) {
		this.cli_addr = cli_addr;
	}
	public String getCli_tel() {
		return cli_tel;
	}
	public void setCli_tel(String cli_tel) {
		this.cli_tel = cli_tel;
	}
	public String getCli_area() {
		return cli_area;
	}
	public void setCli_area(String cli_area) {
		this.cli_area = cli_area;
	}
	public String getCli_use() {
		return cli_use;
	}
	public void setCli_use(String cli_use) {
		this.cli_use = cli_use;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getG_code() {
		return g_code;
	}
	public void setG_code(String g_code) {
		this.g_code = g_code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCt_date_year_sum() {
		return ct_date_year_sum;
	}
	public void setCt_date_year_sum(String ct_date_year_sum) {
		this.ct_date_year_sum = ct_date_year_sum;
	}
	public String getCt_start() {
		return ct_start;
	}
	public void setCt_start(String ct_start) {
		this.ct_start = ct_start;
	}
	public String getCt_end() {
		return ct_end;
	}
	public void setCt_end(String ct_end) {
		this.ct_end = ct_end;
	}
	
	
	
	
	
}
