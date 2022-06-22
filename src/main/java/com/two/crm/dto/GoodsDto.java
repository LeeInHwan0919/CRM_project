package com.two.crm.dto;

public class GoodsDto {

	private String g_code;
	private String seq;
	private String dcode_goods;
	private String g_name;
	private String g_kg;
	private String g_country;
	private String g_content;
	private String g_amount;
	private String iv_cnt;
	private String emp_code;
	private String iv_date;
	private String rate;
	private String g_date;
	
	private String ct_code;
	private String g_price;
	private String du_cnt;
	private String emp_use;
	
	
	public GoodsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GoodsDto(String g_code, String seq, String dcode_goods, String g_name, String g_kg, String g_country,
			String g_content, String g_amount) {
		super();
		this.g_code = g_code;
		this.seq = seq;
		this.dcode_goods = dcode_goods;
		this.g_name = g_name;
		this.g_kg = g_kg;
		this.g_country = g_country;
		this.g_content = g_content;
		this.g_amount = g_amount;
		
	}
		
		public GoodsDto(String iv_cnt, String emp_code, String iv_date, String rate, String g_date, String ct_code,
				String g_price, String du_cnt,String emp_use) {
			super();
			this.iv_cnt = iv_cnt;
			this.emp_code = emp_code;
			this.iv_date = iv_date;
			this.rate = rate;
			this.g_date = g_date;
			this.ct_code = ct_code;
			this.g_price = g_price;
			this.du_cnt = du_cnt;
			this.emp_use = emp_use;
			
	
	}
		
	@Override
	public String toString() {
		return "GoodsDto [g_code=" + g_code + ", seq=" + seq + ", dcode_goods=" + dcode_goods + ", g_name=" + g_name
				+ ", g_kg=" + g_kg + ", g_country=" + g_country + ", g_content=" + g_content + ", g_amount=" + g_amount
				+ ", iv_cnt=" + iv_cnt + ", emp_code=" + emp_code + ", iv_date=" + iv_date + ", rate=" + rate
				+ ", g_date=" + g_date + ", ct_code=" + ct_code + ", g_price=" + g_price + ", du_cnt=" + du_cnt
				+ ", emp_use=" + emp_use + "]";
	}
	public String getG_code() {
		return g_code;
	}
	public void setG_code(String g_code) {
		this.g_code = g_code;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getDcode_goods() {
		return dcode_goods;
	}
	public void setDcode_goods(String dcode_goods) {
		this.dcode_goods = dcode_goods;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getG_kg() {
		return g_kg;
	}
	public void setG_kg(String g_kg) {
		this.g_kg = g_kg;
	}
	public String getG_country() {
		return g_country;
	}
	public void setG_country(String g_country) {
		this.g_country = g_country;
	}
	public String getG_content() {
		return g_content;
	}
	public void setG_content(String g_content) {
		this.g_content = g_content;
	}
	public String getG_amount() {
		return g_amount;
	}
	public void setG_amount(String g_amount) {
		this.g_amount = g_amount;
	}
	public String getIv_cnt() {
		return iv_cnt;
	}
	public void setIv_cnt(String iv_cnt) {
		this.iv_cnt = iv_cnt;
	}
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getIv_date() {
		return iv_date;
	}
	public void setIv_date(String iv_date) {
		this.iv_date = iv_date;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getG_date() {
		return g_date;
	}
	public void setG_date(String g_date) {
		this.g_date = g_date;
	}
	public String getCt_code() {
		return ct_code;
	}
	public void setCt_code(String ct_code) {
		this.ct_code = ct_code;
	}
	public String getG_price() {
		return g_price;
	}
	public void setG_price(String g_price) {
		this.g_price = g_price;
	}
	public String getDu_cnt() {
		return du_cnt;
	}
	public void setDu_cnt(String du_cnt) {
		this.du_cnt = du_cnt;
	}
	public String getEmp_use() {
		return emp_use;
	}
	public void setEmp_use(String emp_use) {
		this.emp_use = emp_use;
	}
	
	
	
	

}
