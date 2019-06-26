package net.os.bear.cart;

import net.os.bear.product.ProductDTO;
import net.os.bear.user.UserDTO;

public class CartDTO {
	private int cart_id;
	private int cart_qty;
	private ProductDTO productDTO;
	private UserDTO userDTO;//중첩 객체 
	private int money; //개수*금액 
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getCart_qty() {
		return cart_qty;
	}
	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "CartDTO [cart_id=" + cart_id + ", cart_qty=" + cart_qty + ", productDTO=" + productDTO + ", userDTO="
				+ userDTO + ", money=" + money + "]";
	}
	
}
