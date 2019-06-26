package net.os.bear.cart;

import java.sql.SQLException;
import java.util.List;

public interface CartService {
	List<CartDTO> getPrice() throws SQLException;//상품별 금액 
	void insertCart(CartDTO cartDTO) throws SQLException; //카트
	List<CartDTO> getCart(String user_id) throws SQLException;//목록 
	void delete(int cart_id) throws SQLException;
	void update(int cart_id) throws SQLException;
	int sumPrice(String user_id) throws SQLException;
	int countCart(String user_id, int product_id) throws SQLException;//장바구니에 이미 상품 담겼는지 쳌 
	void updateCart(CartDTO cartDTO) throws SQLException;//수량 변경
	void modifyCart(CartDTO cartDTO) throws SQLException;
	void deleteAll(String user_id);//장바구니 비우기 
	void qupdatecart(CartDTO cartDTO) throws SQLException;//장바구니 비우기 
}
