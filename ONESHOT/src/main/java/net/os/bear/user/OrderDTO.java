package net.os.bear.user;

import java.io.Serializable;

import net.os.bear.user.UserDTO;

public class OrderDTO implements Serializable {
	private String order_no;
	private int order_qty;
	private int order_delivery;
	private String order_addr;
	private long product_no;
	private int order_detail_qty;
	private UserDTO userDTO;
	
	
	public int getOrder_detail_qty() {
		return order_detail_qty;
	}
	public void setOrder_detail_qty(int order_detail_qty) {
		this.order_detail_qty = order_detail_qty;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public int getOrder_qty() {
		return order_qty;
	}
	public void setOrder_qty(int order_qty) {
		this.order_qty = order_qty;
	}
	public int getOrder_delivery() {
		return order_delivery;
	}
	public void setOrder_delivery(int order_delivery) {
		this.order_delivery = order_delivery;
	}
	public String getOrder_addr() {
		return order_addr;
	}
	public void setOrder_addr(String order_addr) {
		this.order_addr = order_addr;
	}
	public long getProduct_no() {
		return product_no;
	}
	public void setProduct_no(long product_no) {
		this.product_no = product_no;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	@Override
	public String toString() {
		return "OrderDTO [order_no=" + order_no + ", order_qty=" + order_qty + ", order_delivery=" + order_delivery
				+ ", order_addr=" + order_addr + ", product_no=" + product_no + ", userDTO=" + userDTO + "]";
	}
	
	
}
