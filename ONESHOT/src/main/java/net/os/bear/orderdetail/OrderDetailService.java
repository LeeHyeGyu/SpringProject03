package net.os.bear.orderdetail;

import java.sql.SQLException;

public interface OrderDetailService {
	OrderDetailDTO getOrder(OrderDetailDTO orderDetailDTO) throws SQLException;
	void insertOrder(OrderDetailDTO orderDetailDTO) throws SQLException;
	void deleteAll(String user_id);//cart 비우기
}
