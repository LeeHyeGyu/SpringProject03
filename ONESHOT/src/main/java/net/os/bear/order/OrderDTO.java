package net.os.bear.order;

import java.io.Serializable;
import java.util.Arrays;

import net.os.bear.user.UserDTO;

public class OrderDTO implements Serializable {
	private String order_no;
	private int order_qty;
	private int order_delivery;
	private String order_addr;
	private UserDTO userDTO;
	private int order_price;
	private OrderDetailDTO[] orderdetailDTO;
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
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public OrderDetailDTO[] getOrderdetailDTO() {
		return orderdetailDTO;
	}
	public void setOrderdetailDTO(OrderDetailDTO[] orderdetailDTO) {
		this.orderdetailDTO = orderdetailDTO;
	}
	@Override
	public String toString() {
		return "OrderDTO [order_no=" + order_no + ", order_qty=" + order_qty + ", order_delivery=" + order_delivery
				+ ", order_addr=" + order_addr + ", userDTO=" + userDTO + ", order_price=" + order_price
				+ ", orderdetailDTO=" + Arrays.toString(orderdetailDTO) + "]";
	}
	
	
}
