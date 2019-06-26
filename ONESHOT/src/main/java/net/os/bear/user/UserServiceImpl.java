package net.os.bear.user;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDTO getUser(UserDTO userDTO) throws SQLException {
		UserDTO userInfo = userDAO.getUser(userDTO);
		if (userInfo == null) {
			throw new RuntimeException("아이디 혹은 비밀번호가 틀립니다.");
		}
		return userInfo;
	}

	@Override
	public void joinUser(UserDTO userDTO) throws SQLException {
		userDAO.joinUser(userDTO);
	}

	@Override
	public int idcheck(UserDTO user_id) throws SQLException {
		int result = userDAO.idcheck(user_id);
		return result;
	}

	@Override
	public void changeInfo(UserDTO userDTO) throws SQLException {
		userDAO.changeInfo(userDTO);
	}

	@Override
	public void delete(UserDTO userDTO) throws SQLException {
		userDAO.delete(userDTO);
	}

	@Override
	public List<MyPageDTO> getOrderList(MyPageDTO mypageDTO) throws SQLException {
		return userDAO.getOrderList(mypageDTO);
	}

	@Override
	public List<MyPageDTO> getReviewList(MyPageDTO mypageDTO) throws SQLException {
		return userDAO.getReviewList(mypageDTO);
	}

	@Override
	public List<MyPageDTO> getSocialList(MyPageDTO mypageDTO) throws SQLException {
		return userDAO.getSocialList(mypageDTO);
	}

	@Override
	public List<MyPageDTO> getMarkList(MyPageDTO mypageDTO) throws SQLException {
		return userDAO.getMarkList(mypageDTO);
	}

	@Override
	public List<MyPageDTO> getCSList(MyPageDTO mypageDTO) throws SQLException {
		return userDAO.getCSList(mypageDTO);
	}

	@Override
	public List<MyPageDTO> getProductCSList(MyPageDTO mypageDTO) throws SQLException {
		return userDAO.getProductCSList(mypageDTO);
	}
	
	@Override
	public List<MyPageDTO> getRecvMSGList(MyPageDTO mypageDTO) throws SQLException {
		return userDAO.getRecvMSGList(mypageDTO);
	}

	@Override
	public List<MyPageDTO> getSendMSGList(MyPageDTO mypageDTO) throws SQLException {
		return userDAO.getSendMSGList(mypageDTO);
	}

	@Override
	public void getSendMsg(MsgDTO msgDTO) throws SQLException {
		userDAO.getSendMsg(msgDTO);
	}

	@Override
	public MsgDTO getMSG(int msg_no) throws SQLException {
		return userDAO.getMSG(msg_no);
	}

	@Override
	public void deleteArticle(MyPageDTO mypageDTO) throws SQLException {
		userDAO.deleteArticle(mypageDTO);
		
	}

	@Override
	public void recvDelete(MsgDTO msgDTO) throws Exception {
		userDAO.recvDelete(msgDTO);
	}

	@Override
	public void sendDelete(MsgDTO msgDTO) throws SQLException, Exception {
		userDAO.sendDelete(msgDTO);
	}

	@Override
	public void realDelete() throws SQLException, Exception {
		userDAO.realDelete();
		
	}

	@Override
	public int getMarkCnt(UserDTO userDTO) throws SQLException {
		return userDAO.getMarkCnt(userDTO);
	}

	@Override
	public void readCheck(int msg_no) throws SQLException {
		userDAO.readCheck(msg_no);
		
	}

	@Override
	public int getCartCnt(UserDTO userDTO) throws SQLException {
		return userDAO.getCartCnt(userDTO);
	}

	@Override
	public void reviewDelete(int review_no) throws SQLException {
		userDAO.reviewDelete(review_no);
	}

	@Override
	public void socialDelete(int review_no) throws SQLException {
		userDAO.socialDelete(review_no);
	}

	@Override
	public void csDelete(long cs_no) throws SQLException {
		userDAO.csDelete(cs_no);
	}

	@Override
	public void cscsDelete(long cs_no) throws SQLException {
		userDAO.cscsDelete(cs_no);

		
	}

}
