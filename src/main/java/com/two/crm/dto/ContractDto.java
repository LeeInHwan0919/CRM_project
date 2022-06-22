package com.two.crm.dto;

public class ContractDto {

	private String ct_code;
	private String ctm_code;
	private String dcode_client;
	private String du_price;
	private String du_date;
	private String ct_start;
	private String ct_end;
	private String cli_num;
	public String getCt_code() {
		return ct_code;
	}
	public void setCt_code(String ct_code) {
		this.ct_code = ct_code;
	}
	public String getCtm_code() {
		return ctm_code;
	}
	public void setCtm_code(String ctm_code) {
		this.ctm_code = ctm_code;
	}
	public String getDcode_client() {
		return dcode_client;
	}
	public void setDcode_client(String dcode_client) {
		this.dcode_client = dcode_client;
	}
	public String getDu_price() {
		return du_price;
	}
	public void setDu_price(String du_price) {
		this.du_price = du_price;
	}
	public String getDu_date() {
		return du_date;
	}
	public void setDu_date(String du_date) {
		this.du_date = du_date;
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
	public String getCli_num() {
		return cli_num;
	}
	public void setCli_num(String cli_num) {
		this.cli_num = cli_num;
	}
	@Override
	public String toString() {
		return "ContractDto [ct_code=" + ct_code + ", ctm_code=" + ctm_code + ", dcode_client=" + dcode_client
				+ ", du_price=" + du_price + ", du_date=" + du_date + ", ct_start=" + ct_start + ", ct_end=" + ct_end
				+ ", cli_num=" + cli_num + "]";
	}
	public ContractDto(String ct_code, String ctm_code, String dcode_client, String du_price, String du_date,
			String ct_start, String ct_end, String cli_num) {
		super();
		this.ct_code = ct_code;
		this.ctm_code = ctm_code;
		this.dcode_client = dcode_client;
		this.du_price = du_price;
		this.du_date = du_date;
		this.ct_start = ct_start;
		this.ct_end = ct_end;
		this.cli_num = cli_num;
	}
	public ContractDto() {
		super();
	}
	
	
}
