package com.two.crm.dto;

public class GoodsDto {

	private String g_code;
	private String dcode_goods;
	private String g_name;
	private String g_kg;
	private String g_country;
	private String g_content;
	private String g_amount;
	private String iv_cnt;
	public String getG_code() {
		return g_code;
	}
	public void setG_code(String g_code) {
		this.g_code = g_code;
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
	@Override
	public String toString() {
		return "GoodsDto [g_code=" + g_code + ", dcode_goods=" + dcode_goods + ", g_name=" + g_name + ", g_kg=" + g_kg
				+ ", g_country=" + g_country + ", g_content=" + g_content + ", g_amount=" + g_amount + ", iv_cnt="
				+ iv_cnt + "]";
	}
	public GoodsDto(String g_code, String dcode_goods, String g_name, String g_kg, String g_country, String g_content,
			String g_amount, String iv_cnt) {
		this.g_code = g_code;
		this.dcode_goods = dcode_goods;
		this.g_name = g_name;
		this.g_kg = g_kg;
		this.g_country = g_country;
		this.g_content = g_content;
		this.g_amount = g_amount;
		this.iv_cnt = iv_cnt;
	}
	public GoodsDto() {
	}

	

}
