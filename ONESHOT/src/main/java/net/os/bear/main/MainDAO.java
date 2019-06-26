package net.os.bear.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import net.os.bear.product.ProductDTO;
import net.os.bear.user.MyPageDTO;
import net.os.bear.user.UserDTO;

public interface MainDAO {
	List<ProductDTO> getProductList(ProductDTO productDTO) throws SQLException;

	List<ProductDTO> getProductList() throws SQLException;

//	public PageDTO getPage(PageDTO pageDTO) throws SQLException;
	public List<ProductDTO> getPagingList(PageDTO pageDTO) throws SQLException;

	public List<ProductDTO> resultSearch(String s) throws SQLException;

	public int resultSearchCnt(String s) throws SQLException;

	public List<ProductDTO> resultSearch(PageDTO pageDTO) throws SQLException;

	public List<ProductDTO> getPagingList2(PageDTO pageDTO) throws SQLException;

	public List<ProductDTO> getALPagingList(PageDTO pageDTO) throws SQLException;

	public List<ProductDTO> getAHPagingList(PageDTO pageDTO) throws SQLException;
	
	public List<ProductDTO> getFPagingList(PageDTO pageDTO) throws SQLException;
	
	public int getFcnt(PageDTO pageDTO) throws SQLException;
	
	public List<ProductDTO> getFNPagingList(PageDTO pagedto) throws SQLException;
	public List<ProductDTO> getFALPagingList(PageDTO pagedto) throws SQLException;
	public List<ProductDTO> getFAHPagingList(PageDTO pagedto) throws SQLException;
	
	public List<ProductDTO> getMainBestList() throws SQLException;

	public long getUserCnt() throws SQLException;
	
	public List<UserDTO> getUserList(PageDTO pageDTO) throws SQLException;
	
	public Object DeleteUser(String id) throws SQLException;
	public Object DeletesUser(String id) throws SQLException;
	
	public long get1Cnt() throws SQLException;
	public long getqnaCnt() throws SQLException;
	
	public List<MyPageDTO> get1List(PageDTO pageDTO) throws SQLException;
	public List<MyPageDTO> getqnaList(PageDTO pageDTO) throws SQLException;
	
	public void Write1(String con, String ck, String no) throws SQLException;;
	public void Writeqna(String con, String ck, String no) throws SQLException;;
	
	public void Write1(Map<String, String> map) throws SQLException;
	
	public void Writeqna(Map<String, String> map) throws SQLException;
	
	public void DeleteUser(Map<String, String> map) throws SQLException;
}
