package net.os.bear.product;

import java.sql.SQLException;
import java.util.List;

import net.os.bear.cs.CSDTO;


public interface ProductDAO {
	ProductDTO getProduct(int product_no) throws SQLException;
	List<ReviewDTO> getReview(int product_no) throws SQLException;
	double getRating(int product_no) throws SQLException;
	int getReviewCount(int product_no);
//	OSPageDTO getPage(OSPageDTO OSpageDTO) throws SQLException;
	List<CSDTO> getCS(int product_no) throws SQLException;
	int QnAinsert(CSDTO csdto) throws SQLException;
	MarkDTO getmark(MarkDTO markDTO) throws SQLException;
	int Markadd(MarkDTO makrdto) throws SQLException;
	int Markdel(MarkDTO markdto) throws SQLException;
	int Reviewadd(ReviewDTO reviewdto) throws SQLException;
	String ReviewCheck(ReviewDTO reviewdto) throws SQLException;
	String doubleCheck(ReviewDTO reviewdto) throws SQLException;
	String CartCheck(ReviewDTO reviewdto) throws SQLException;

}
