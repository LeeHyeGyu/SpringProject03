package net.os.bear.product;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import net.os.bear.cs.CSDTO;

public interface ProductService {

	
	ProductDTO getProduct(int product_no) throws SQLException;
	List<ReviewDTO> getReview(int review_rating) throws SQLException;
	double getRating(int review_rating) throws SQLException;
	int getReviewCount(int product_no) throws SQLException;
//	OSPageDTO getPage(OSPageDTO OSpageDTO) throws SQLException;
	List<CSDTO> getCS(int product_no) throws SQLException;
	HashMap<String, Integer> getBeerCount(List<ReviewDTO> reviewDTO) throws SQLException;
	void QnAinsert(CSDTO csdto) throws SQLException;
	MarkDTO getmark(MarkDTO makrdto) throws SQLException;
	void Markadd(MarkDTO makrdto) throws SQLException;
	void Markdel(MarkDTO markdto) throws SQLException;
	void Reviewadd(ReviewDTO reviewdto) throws SQLException;
	String ReviewCheck(ReviewDTO reviewdto) throws SQLException;
	String doubleCheck(ReviewDTO reviewdto) throws SQLException;
	String CartCheck(ReviewDTO reviewdto) throws SQLException;

}
