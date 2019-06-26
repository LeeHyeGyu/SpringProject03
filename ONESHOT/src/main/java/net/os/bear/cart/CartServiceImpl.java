package net.os.bear.cart;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDAO cartDAO;

	@Override
	public List<CartDTO> getPrice() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCart(CartDTO cartDTO) throws SQLException {
		cartDAO.insertCart(cartDTO);
	}

	@Override
	public List<CartDTO> getCart(String user_id) throws SQLException {
		return cartDAO.getCart(user_id);
	}

	@Override
	public void delete(int cart_id) throws SQLException {
		cartDAO.delete(cart_id);
	}

	@Override
	public void update(int cart_id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int sumPrice(String user_id) throws SQLException {
		return cartDAO.sumPrice(user_id);
	}

	@Override
	public int countCart(String user_id, int product_id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCart(CartDTO cartDTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyCart(CartDTO cartDTO) throws SQLException {
		cartDAO.modifyCart(cartDTO);
	}

	@Override
	public void deleteAll(String user_id) {
		cartDAO.deleteAll(user_id);
	}


	@Override
	public void qupdatecart(CartDTO cartDTO) throws SQLException {
		if (cartDAO.qupdatecart(cartDTO) == 0) {
			throw new RuntimeException("존재하지 않거나 접근 권한이 없습니다.");
		}

	}


	
}
