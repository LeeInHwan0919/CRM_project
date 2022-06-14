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
	
	//파일 업로드
	private int file_seq   ;
	private int board_seq  ;
	private String file_size  ;
	private String file_folder;
	private String file_name  ;
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardDto(int seq, String emp_code, String title, String content, int important, String startdate,
			String enddate, int s_count, String post_use, int file_seq, int board_seq, String file_size,
			String file_folder, String file_name) {
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
		this.file_seq = file_seq;
		this.board_seq = board_seq;
		this.file_size = file_size;
		this.file_folder = file_folder;
		this.file_name = file_name;
	}
	@Override
	public String toString() {
		return "BoardDto [seq=" + seq + ", emp_code=" + emp_code + ", title=" + title + ", content=" + content
				+ ", important=" + important + ", startdate=" + startdate + ", enddate=" + enddate + ", s_count="
				+ s_count + ", post_use=" + post_use + ", file_seq=" + file_seq + ", board_seq=" + board_seq
				+ ", file_size=" + file_size + ", file_folder=" + file_folder + ", file_name=" + file_name + "]";
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
	public int getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(int file_seq) {
		this.file_seq = file_seq;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getFile_size() {
		return file_size;
	}
	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}
	public String getFile_folder() {
		return file_folder;
	}
	public void setFile_folder(String file_folder) {
		this.file_folder = file_folder;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	
	
	
}
