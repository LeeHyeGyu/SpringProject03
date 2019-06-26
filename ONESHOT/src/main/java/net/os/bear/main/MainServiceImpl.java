package net.os.bear.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.os.bear.main.MainDAO;
import net.os.bear.product.ProductDTO;
import net.os.bear.user.MyPageDTO;
import net.os.bear.user.UserDTO;

@Service
public class MainServiceImpl implements MainService{

	@Autowired
	private MainDAO mainDAO;
	
	@Override
	public List<ProductDTO> getProductList(ProductDTO productDTO) throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.getProductList(productDTO);
	}

	@Override
	public List<ProductDTO> getProductList() throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.getProductList();
	}


	@Override
	public List<ProductDTO> getPagingList(PageDTO pageDTO) throws SQLException {
		
		return mainDAO.getPagingList(pageDTO);
	}

	@Override
	public int resultSearchCnt(String s) throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.resultSearchCnt(s);
	}

	@Override
	public List<ProductDTO> resultSearch(PageDTO pageDTO) throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.resultSearch(pageDTO);
	}

	@Override
	public List<ProductDTO> getPagingList2(PageDTO pageDTO) throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.getPagingList2(pageDTO);
	}

	@Override
	public List<ProductDTO> getALPagingList(PageDTO pageDTO) throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.getALPagingList(pageDTO);
	}

	@Override
	public List<ProductDTO> getAHPagingList(PageDTO pageDTO) throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.getAHPagingList(pageDTO);
	}

	@Override
	public List<ProductDTO> getFPagingList(PageDTO pageDTO) throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.getFPagingList(pageDTO);
	}

	@Override
	public int getFcnt(PageDTO pageDTO) throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.getFcnt(pageDTO);
	}
	@Override
	public List<ProductDTO> getFNPagingList(PageDTO pagedto) throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.getFNPagingList(pagedto);
	}
	@Override
	public List<ProductDTO> getFALPagingList(PageDTO pagedto) throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.getFALPagingList(pagedto);
	}
	@Override
	public List<ProductDTO> getFAHPagingList(PageDTO pagedto) throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.getFAHPagingList(pagedto);
	}

	@Override
	public List<ProductDTO> getMainBestList() throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.getMainBestList();
	}

	@Override
	public long getUserCnt() throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.getUserCnt();
	}

	@Override
	public List<UserDTO> getUserList(PageDTO pageDTO) throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.getUserList(pageDTO);
	}

	@Override
	public Object DeleteUser(String id) throws SQLException {
		return mainDAO.DeleteUser(id);
	}

	@Override
	public Object DeletesUser(String id) throws SQLException {
		return mainDAO.DeleteUser(id);
	}

	@Override
	public long get1Cnt() throws SQLException {
		return mainDAO.get1Cnt();
	}

	@Override
	public long getqnaCnt() throws SQLException {
		return mainDAO.getqnaCnt();
	}

	@Override
	public List<MyPageDTO> get1List(PageDTO pageDTO) throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.get1List(pageDTO);
	}

	@Override
	public List<MyPageDTO> getqnaList(PageDTO pageDTO) throws SQLException {
		// TODO Auto-generated method stub
		return mainDAO.getqnaList(pageDTO);
	}

	@Override
	public void Write1(String con, String ck, String no) throws SQLException {
		mainDAO.Write1(con, ck, no);
	}

	@Override
	public void Writeqna(String con, String ck, String no) throws SQLException {
		mainDAO.Writeqna(con, ck, no);
	}

	@Override
	public void Write1(Map<String, String> map) throws SQLException {
		mainDAO.Write1(map);
	}

	@Override
	public void Writeqna(Map<String, String> map) throws SQLException {
		mainDAO.Writeqna(map);
		
	}

	@Override
	public void DeleteUser(Map<String, String> map) throws SQLException {
		mainDAO.DeleteUser(map);
	}
}
