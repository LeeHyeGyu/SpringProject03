package net.os.bear.cs;

import java.io.Serializable;
import java.util.Date;

import net.os.bear.user.UserDTO;

public class CSDTO implements Serializable {
	private String cs_title;
	private String cs_content;
	private String cs_answer;
	private int cs_check;		  //1:처리완료 0:미완 
	private String cs_section;    //'1:1문의' or '제품 문의'
	private Date cs_question_date;
	private Date cs_answer_date;
	private long cs_no;
	private UserDTO userDTO;
	private long product_no;
	public String getCs_title() {
		return cs_title;
	}
	public void setCs_title(String cs_title) {
		this.cs_title = cs_title;
	}
	public String getCs_content() {
		return cs_content;
	}
	public void setCs_content(String cs_content) {
		this.cs_content = cs_content;
	}
	public String getCs_answer() {
		return cs_answer;
	}
	public void setCs_answer(String cs_answer) {
		this.cs_answer = cs_answer;
	}
	public int getCs_check() {
		return cs_check;
	}
	public void setCs_check(int cs_check) {
		this.cs_check = cs_check;
	}
	public String getCs_section() {
		return cs_section;
	}
	public void setCs_section(String cs_section) {
		this.cs_section = cs_section;
	}
	public Date getCs_question_date() {
		return cs_question_date;
	}
	public void setCs_question_date(Date cs_question_date) {
		this.cs_question_date = cs_question_date;
	}
	public Date getCs_answer_date() {
		return cs_answer_date;
	}
	public void setCs_answer_date(Date cs_answer_date) {
		this.cs_answer_date = cs_answer_date;
	}
	public long getCs_no() {
		return cs_no;
	}
	public void setCs_no(long cs_no) {
		this.cs_no = cs_no;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public long getProduct_no() {
		return product_no;
	}
	public void setProduct_no(long product_no) {
		this.product_no = product_no;
	}
	@Override
	public String toString() {
		return "CSDTO [cs_title=" + cs_title + ", cs_content=" + cs_content + ", cs_answer=" + cs_answer + ", cs_check="
				+ cs_check + ", cs_section=" + cs_section + ", cs_question_date=" + cs_question_date
				+ ", cs_answer_date=" + cs_answer_date + ", cs_no=" + cs_no + ", userDTO=" + userDTO + ", product_no="
				+ product_no + "]";
	}
	
	
	
	
}
