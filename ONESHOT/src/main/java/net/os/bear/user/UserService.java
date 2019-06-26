package net.os.bear.user;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

	UserDTO getUser(UserDTO userDTO) throws SQLException;

	void joinUser(UserDTO userDTO) throws SQLException;

	int idcheck(UserDTO userDTO) throws SQLException;

	void changeInfo(UserDTO userDTO) throws SQLException;

	void delete(UserDTO userDTO) throws SQLException;

	List<MyPageDTO> getOrderList(MyPageDTO mypageDTO) throws SQLException;

	List<MyPageDTO> getReviewList(MyPageDTO mypageDTO) throws SQLException;

	List<MyPageDTO> getSocialList(MyPageDTO mypageDTO) throws SQLException;

	List<MyPageDTO> getMarkList(MyPageDTO mypageDTO) throws SQLException;

	List<MyPageDTO> getCSList(MyPageDTO mypageDTO) throws SQLException;
	
	List<MyPageDTO> getProductCSList(MyPageDTO mypageDTO) throws SQLException;

	List<MyPageDTO> getRecvMSGList(MyPageDTO mypageDTO) throws SQLException; 

	List<MyPageDTO> getSendMSGList(MyPageDTO mypageDTO) throws SQLException;

	void getSendMsg(MsgDTO msgDTO) throws SQLException;

	MsgDTO getMSG(int msg_no) throws SQLException;

	void deleteArticle(MyPageDTO mypageDTO) throws SQLException;

	void recvDelete(MsgDTO msgDTO) throws SQLException, Exception;

	void sendDelete(MsgDTO msgDTO) throws SQLException, Exception;

	void realDelete() throws SQLException, Exception;

	int getMarkCnt(UserDTO userDTO) throws SQLException;

	void readCheck(int msg_no) throws SQLException;

	int getCartCnt(UserDTO userDTO) throws SQLException;

	void reviewDelete(int review_no) throws SQLException;

	void socialDelete(int review_no) throws SQLException;

	void csDelete(long cs_no) throws SQLException;

	void cscsDelete(long cs_no) throws SQLException;



}
