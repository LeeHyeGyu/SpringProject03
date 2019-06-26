package net.os.bear.order;

import java.sql.SQLException;

public interface OrderService {
	OrderDTO getOrder(String order_no) throws SQLException;
	void insertOrder(OrderDTO orderDTO) throws SQLException;
	void deleteAll(String user_id) throws SQLException;//cart 비우기
	void orderInfo_Detail(OrderDTO orderDTO) throws SQLException;
}
