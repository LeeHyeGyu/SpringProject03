package net.os.bear.product;

import java.sql.Date;

import net.os.bear.user.UserDTO;

public class MarkDTO {
	private String mark_no;
	private ProductDTO productdto;
	private Date mark_date;
	private UserDTO userdto;
	public String getMark_no() {
		return mark_no;
	}
	public void setMark_no(String mark_no) {
		this.mark_no = mark_no;
	}
	public ProductDTO getProductdto() {
		return productdto;
	}
	public void setProductdto(ProductDTO productdto) {
		this.productdto = productdto;
	}
	public Date getMark_date() {
		return mark_date;
	}
	public void setMark_date(Date mark_date) {
		this.mark_date = mark_date;
	}
	public UserDTO getUserdto() {
		return userdto;
	}
	public void setUserdto(UserDTO userdto) {
		this.userdto = userdto;
	}
	@Override
	public String toString() {
		return "MarkDTO [mark_no=" + mark_no + ", productdto=" + productdto + ", mark_date=" + mark_date + ", userdto="
				+ userdto + "]";
	}

}
