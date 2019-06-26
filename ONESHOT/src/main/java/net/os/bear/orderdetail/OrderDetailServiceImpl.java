package net.os.bear.orderdetail;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;


public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	@Override
	public OrderDetailDTO getOrder(OrderDetailDTO orderDetailDTO) throws SQLException {
		OrderDetailDTO orderdetailInfo = orderDetailDAO.getOrder(orderDetailDTO);
		if (orderdetailInfo == null) {
			throw new RuntimeException("해당 구매정보가 없습니다.");
		}
		return orderdetailInfo;
	}

	@Override
	public void insertOrder(OrderDetailDTO orderDetailDTO) throws SQLException {
		orderDetailDAO.insertOrder(orderDetailDTO);
	}

	@Override
	public void deleteAll(String user_id) {
		orderDetailDAO.deleteAll(user_id);
	}

}
