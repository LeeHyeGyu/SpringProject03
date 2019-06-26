package net.os.bear.order;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDAO orderDAO;

	@Override
	public OrderDTO getOrder(String order_no) throws SQLException {
		OrderDTO orderInfo = orderDAO.getOrder(order_no);
		if(orderInfo == null) {
			throw new RuntimeException("상세 구매정보가 없습니다.");
		}
		return orderInfo;
	}

	@Override
	public void insertOrder(OrderDTO orderDTO) throws SQLException {
		orderDAO.insertOrder(orderDTO);
		
	}

	@Override
	public void deleteAll(String user_id) throws SQLException {
		orderDAO.deleteAll(user_id);
	}

	@Override
	public void orderInfo_Detail(OrderDTO orderDTO) throws SQLException {
		orderDAO.orderInfo_Detail(orderDTO);	
	}




}
