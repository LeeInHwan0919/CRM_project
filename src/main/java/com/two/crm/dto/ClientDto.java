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
	private String ctm_code;
	private String du_cnt;
	private String g_price;
	private String seq;
	private String ct_code;
	
	private String dcode_client;
	private String du_date;
	
	private String du_price;
	private String pre_sum;
	private String sum_price;
	@Override
	public String toString() {
		return "ClientDto [cli_num=" + cli_num + ", emp_code=" + emp_code + ", cli_name=" + cli_name + ", cli_addr="
				+ cli_addr + ", cli_tel=" + cli_tel + ", cli_area=" + cli_area + ", cli_use=" + cli_use + ", rate="
				+ rate + ", g_name=" + g_name + ", g_code=" + g_code + ", status=" + status + ", ct_date_year_sum="
				+ ct_date_year_sum + ", ct_start=" + ct_start + ", ct_end=" + ct_end + ", ctm_code=" + ctm_code
				+ ", du_cnt=" + du_cnt + ", g_price=" + g_price + ", seq=" + seq + ", ct_code=" + ct_code
				+ ", dcode_client=" + dcode_client + ", du_date=" + du_date + ", du_price=" + du_price + ", pre_sum="
				+ pre_sum + ", sum_price=" + sum_price + "]";
	}
	public ClientDto(String cli_num, String emp_code, String cli_name, String cli_addr, String cli_tel, String cli_area,
			String cli_use, String rate, String g_name, String g_code, String status, String ct_date_year_sum,
			String ct_start, String ct_end, String ctm_code, String du_cnt, String g_price, String seq, String ct_code,
			String dcode_client, String du_date, String du_price, String pre_sum, String sum_price) {
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
		this.ctm_code = ctm_code;
		this.du_cnt = du_cnt;
		this.g_price = g_price;
		this.seq = seq;
		this.ct_code = ct_code;
		this.dcode_client = dcode_client;
		this.du_date = du_date;
		this.du_price = du_price;
		this.pre_sum = pre_sum;
		this.sum_price = sum_price;
	}
	public ClientDto() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getCtm_code() {
		return ctm_code;
	}
	public void setCtm_code(String ctm_code) {
		this.ctm_code = ctm_code;
	}
	public String getDu_cnt() {
		return du_cnt;
	}
	public void setDu_cnt(String du_cnt) {
		this.du_cnt = du_cnt;
	}
	public String getG_price() {
		return g_price;
	}
	public void setG_price(String g_price) {
		this.g_price = g_price;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getCt_code() {
		return ct_code;
	}
	public void setCt_code(String ct_code) {
		this.ct_code = ct_code;
	}
	public String getDcode_client() {
		return dcode_client;
	}
	public void setDcode_client(String dcode_client) {
		this.dcode_client = dcode_client;
	}
	public String getDu_date() {
		return du_date;
	}
	public void setDu_date(String du_date) {
		this.du_date = du_date;
	}
	public String getDu_price() {
		return du_price;
	}
	public void setDu_price(String du_price) {
		this.du_price = du_price;
	}
	public String getPre_sum() {
		return pre_sum;
	}
	public void setPre_sum(String pre_sum) {
		this.pre_sum = pre_sum;
	}
	public String getSum_price() {
		return sum_price;
	}
	public void setSum_price(String sum_price) {
		this.sum_price = sum_price;
	}
	
	
	
	
	
}
