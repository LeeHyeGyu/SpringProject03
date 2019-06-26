package net.os.bear.product;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.os.bear.cs.CSDTO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public ProductDTO getProduct(int product_no) throws SQLException {
		return productDAO.getProduct(product_no);
	}
	@Override
	public List<ReviewDTO> getReview(int review_rating) throws SQLException {
		return productDAO.getReview(review_rating);
	}
	@Override
	public List<CSDTO> getCS(int product_no) throws SQLException {
		return productDAO.getCS(product_no);
	}
	@Override
	public double getRating(int review_rating) throws SQLException {
		double Rating = 0;
		double tmp = 0; 
		try {
			Rating=	Math.round(productDAO.getRating(review_rating)*100)/100.0;
			tmp = (Rating - Math.round(productDAO.getRating(review_rating)*100)/100);
			tmp = Math.round(tmp*100)/100.0;
			System.out.println(tmp);
			if(tmp>=0.75) {
				Rating=	Math.ceil(Rating);
			}else if (tmp<=0.25) {				
				Rating=	Math.floor(Rating);
			}else {
				Rating = (Math.round(productDAO.getRating(review_rating)*100)/100)+0.5;
			}						
			return Rating;
		} catch (Exception e) {
			return Rating;
		}

	}
	@Override
	public int getReviewCount(int product_no) throws SQLException {
		int count = 0;
		try {
			count =	productDAO.getReviewCount(product_no);
			
			return count;
		} catch (Exception e) {
			return count;
		}

	}
	@Override
	public HashMap<String, Integer> getBeerCount(List<ReviewDTO> reviewDTO) throws SQLException {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
			int one=0;
			int two=0;
			int three=0;
			int four=0;
			int five=0;
			
		for(ReviewDTO list: reviewDTO) {
			
			switch(list.getReview_rating()) {
			case 1:
				one++; 
	            break;
			case 2:
				two++; 
	            break;
			case 3:
				three++; 
	            break;
			case 4:
				four++; 
	            break;
			case 5:
				five++; 
	            break;
					
			};
			
			
		}
		map.put("one", one);
		map.put("two", two);
		map.put("three", three);
		map.put("four", four);
		map.put("five", five);
		
		
			return map;
		}
	@Override
	public void QnAinsert(CSDTO csdto) throws SQLException {
		if (productDAO.QnAinsert(csdto) == 0) {
			throw new RuntimeException("존재하지 않거나 접근 권한이 없습니다.");
		}
	}
	@Override
	public MarkDTO getmark(MarkDTO makrdto) throws SQLException {

		return productDAO.getmark(makrdto);
	}
	
	@Override
	public void Markadd(MarkDTO makrdto) throws SQLException {
		if (productDAO.Markadd(makrdto) == 0) {
			throw new RuntimeException("존재하지 않거나 접근 권한이 없습니다.");
		}
	}
	
	@Override
	public void Markdel(MarkDTO makrdto) throws SQLException {
		if (productDAO.Markdel(makrdto) == 0) {
			throw new RuntimeException("존재하지 않거나 접근 권한이 없습니다.");
		}

	}
	@Override
	public void Reviewadd(ReviewDTO reviewdto) throws SQLException {
		if (productDAO.Reviewadd(reviewdto) == 0) {
			throw new RuntimeException("존재하지 않거나 접근 권한이 없습니다.");
		}
		
	}
	@Override
	public String ReviewCheck(ReviewDTO reviewdto) throws SQLException {
		String reviewcheck;
		try {
			reviewcheck =	productDAO.ReviewCheck(reviewdto);
			
			return reviewcheck;
		} catch (Exception e) {
			reviewcheck = "zero";
			return reviewcheck;
		}
	}
	@Override
	public String doubleCheck(ReviewDTO reviewdto) throws SQLException {
		String reviewcheck;
		try {
			reviewcheck =	productDAO.doubleCheck(reviewdto);
			
			return reviewcheck;
		} catch (Exception e) {
			reviewcheck = "zero";
			return reviewcheck;
		}
	}
	
	@Override
	public String CartCheck(ReviewDTO reviewdto) throws SQLException {
		String cartcheck;
		try {
			cartcheck =	productDAO.CartCheck(reviewdto);
			return cartcheck;
		} catch (Exception e) {
			cartcheck = "zero";
			return cartcheck;
		}
	}


}
