package com.two.crm.dto;

public class BoardDto {

	private int seq       ;
	private String emp_code  ;
	private String title     ;
	private String content   ;
	private int important ;
	private String startdate ;
	private String enddate   ;
	private int s_count   ;
	private String post_use  ;
	
	public BoardDto() {
		super();
	}

	public BoardDto(int seq, String emp_code, String title, String content, int important, String startdate,
			String enddate, int s_count, String post_use) {
		super();
		this.seq = seq;
		this.emp_code = emp_code;
		this.title = title;
		this.content = content;
		this.important = important;
		this.startdate = startdate;
		this.enddate = enddate;
		this.s_count = s_count;
		this.post_use = post_use;
	}

	@Override
	public String toString() {
		return "BoardDto [seq=" + seq + ", emp_code=" + emp_code + ", title=" + title + ", content=" + content
				+ ", important=" + important + ", startdate=" + startdate + ", enddate=" + enddate + ", s_count="
				+ s_count + ", post_use=" + post_use + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
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
	
	
	
}
