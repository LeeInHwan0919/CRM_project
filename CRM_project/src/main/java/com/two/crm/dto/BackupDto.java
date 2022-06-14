package com.two.crm.dto;

public class BackupDto {
	
	
	//게시판 
	private int seq       ;
	private String title     ;
	private String content   ;
	private int important ;
	private String startdate ;
	private String enddate   ;
	private int s_count   ;
	private String post_use  ;
	
	
	//거래처
	private String cli_num ;
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
	private String ct_code;
	private String dcode_client;
	private String du_price;
	private String du_date;
	
	//재고
	private String dcode_goods;
	private String g_kg;
	private String g_country;
	private String g_content;
	private String g_amount;
	private String iv_cnt;
	
	
	//사원
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
	public BackupDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BackupDto(int seq, String title, String content, int important, String startdate, String enddate,
			int s_count, String post_use, String cli_num, String cli_name, String cli_addr, String cli_tel,
			String cli_area, String cli_use, String rate, String g_name, String g_code, String status,
			String ct_date_year_sum, String ct_start, String ct_end, String ctm_code, String ct_code,
			String dcode_client, String du_price, String du_date, String dcode_goods, String g_kg, String g_country,
			String g_content, String g_amount, String iv_cnt, String emp_code, String area_code, String emp_name,
			String emp_pw, String emp_gender, String emp_use, String emp_img, String emp_auth, String emp_tel,
			String area, String emp_addr) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.important = important;
		this.startdate = startdate;
		this.enddate = enddate;
		this.s_count = s_count;
		this.post_use = post_use;
		this.cli_num = cli_num;
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
		this.ct_code = ct_code;
		this.dcode_client = dcode_client;
		this.du_price = du_price;
		this.du_date = du_date;
		this.dcode_goods = dcode_goods;
		this.g_kg = g_kg;
		this.g_country = g_country;
		this.g_content = g_content;
		this.g_amount = g_amount;
		this.iv_cnt = iv_cnt;
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
	@Override
	public String toString() {
		return "BackupDto [seq=" + seq + ", title=" + title + ", content=" + content + ", important=" + important
				+ ", startdate=" + startdate + ", enddate=" + enddate + ", s_count=" + s_count + ", post_use="
				+ post_use + ", cli_num=" + cli_num + ", cli_name=" + cli_name + ", cli_addr=" + cli_addr + ", cli_tel="
				+ cli_tel + ", cli_area=" + cli_area + ", cli_use=" + cli_use + ", rate=" + rate + ", g_name=" + g_name
				+ ", g_code=" + g_code + ", status=" + status + ", ct_date_year_sum=" + ct_date_year_sum + ", ct_start="
				+ ct_start + ", ct_end=" + ct_end + ", ctm_code=" + ctm_code + ", ct_code=" + ct_code
				+ ", dcode_client=" + dcode_client + ", du_price=" + du_price + ", du_date=" + du_date
				+ ", dcode_goods=" + dcode_goods + ", g_kg=" + g_kg + ", g_country=" + g_country + ", g_content="
				+ g_content + ", g_amount=" + g_amount + ", iv_cnt=" + iv_cnt + ", emp_code=" + emp_code
				+ ", area_code=" + area_code + ", emp_name=" + emp_name + ", emp_pw=" + emp_pw + ", emp_gender="
				+ emp_gender + ", emp_use=" + emp_use + ", emp_img=" + emp_img + ", emp_auth=" + emp_auth + ", emp_tel="
				+ emp_tel + ", area=" + area + ", emp_addr=" + emp_addr + "]";
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getImportant() {
		return important;
	}
	public void setImportant(int important) {
		this.important = important;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public int getS_count() {
		return s_count;
	}
	public void setS_count(int s_count) {
		this.s_count = s_count;
	}
	public String getPost_use() {
		return post_use;
	}
	public void setPost_use(String post_use) {
		this.post_use = post_use;
	}
	public String getCli_num() {
		return cli_num;
	}
	public void setCli_num(String cli_num) {
		this.cli_num = cli_num;
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
	public String getDcode_goods() {
		return dcode_goods;
	}
	public void setDcode_goods(String dcode_goods) {
		this.dcode_goods = dcode_goods;
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
	
	
	
	
}



