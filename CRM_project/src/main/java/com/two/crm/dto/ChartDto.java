package com.two.crm.dto;

public class ChartDto {
	
	
	private String cli_num ;
	private String ctm_code;
	private String ct_start;
	private String ct_end;
	
	
	public String getCli_num() {
		return cli_num;
	}
	public void setCli_num(String cli_num) {
		this.cli_num = cli_num;
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
	
	public String getCtm_code() {
		return ctm_code;
	}
	public void setCtm_code(String ctm_code) {
		this.ctm_code = ctm_code;
	}
	
	
	public ChartDto(String cli_num, String ctm_code, String ct_start, String ct_end) {
		super();
		this.cli_num = cli_num;
		this.ctm_code = ctm_code;
		this.ct_start = ct_start;
		this.ct_end = ct_end;
	}
	
	
	@Override
	public String toString() {
		return "ChartDto [cli_num=" + cli_num + ", ctm_code=" + ctm_code + ", ct_start=" + ct_start + ", ct_end="
				+ ct_end + "]";
	}
	public ChartDto() {
		super();
	}
	
	
	
}