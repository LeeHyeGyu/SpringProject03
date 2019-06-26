package net.os.bear.user;

import java.util.Date;

public class MarkDTO {
	private String mark_no    ;
	private int product_no ;
	private String user_id    ;
	private Date mark_date  ;
	
	
	public String getMark_no() {
		return mark_no;
	}
	public void setMark_no(String mark_no) {
		this.mark_no = mark_no;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getMark_date() {
		return mark_date;
	}
	public void setMark_date(Date mark_date) {
		this.mark_date = mark_date;
	}
	@Override
	public String toString() {
		return "MarkDTO [mark_no=" + mark_no + ", product_no=" + product_no + ", user_id=" + user_id + ", mark_date="
				+ mark_date + "]";
	}
	
	
}
