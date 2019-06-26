package net.os.bear.product;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.os.bear.cs.CSDTO;
import net.os.bear.user.UserDTO;

@Controller
@RequestMapping("product/{product_no}")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public String product(
			@PathVariable int product_no,  
			Model model,
			HttpSession session) {

		try {
			ProductDTO product = productService.getProduct(product_no);
			List<ReviewDTO> review =  productService.getReview(product_no);
			List<CSDTO> CS =  productService.getCS(product_no);
			double rating =  productService.getRating(product_no);
			int count =  productService.getReviewCount(product_no);
			HashMap<String, Integer> BeerCount =  productService.getBeerCount(review);
			UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
			ReviewDTO reviewdto =new ReviewDTO();
			reviewdto.setUserdto(userInfo);
			reviewdto.setProduct_no(product_no);
			
			
			
			MarkDTO  Markdto =  new MarkDTO();
			Markdto.setProductdto(new ProductDTO());
			Markdto.getProductdto().setProduct_no(product_no);
			Markdto.setUserdto(userInfo);
			MarkDTO  markdto =  new MarkDTO();
		try {
			
			String RCheck = productService.ReviewCheck(reviewdto);
			String DCheck = productService.doubleCheck(reviewdto);
			String CCheck = productService.CartCheck(reviewdto);
			markdto = productService.getmark(Markdto);
			
			logger.info(RCheck+"여긴넘어옴?");
			
			model.addAttribute("markdto", markdto);
			model.addAttribute("RCheck", RCheck);
			model.addAttribute("DCheck", DCheck);
			model.addAttribute("CCheck", CCheck);
		} catch (Exception e) {
		}

			model.addAttribute("product", product);
			model.addAttribute("review", review);
			model.addAttribute("rating", rating);
			model.addAttribute("count", count);
			model.addAttribute("CS", CS);
			model.addAttribute("BeerCount", BeerCount);
//			model.addAttribute("OSpage", OSpage);
			model.addAttribute("userInfo", userInfo);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "order/prdct";
	}


	@PostMapping("QnAinsert")
	public ModelAndView insert(
			@ModelAttribute CSDTO csDTO,
			HttpSession session) {
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		csDTO.setUserDTO(userInfo);
		
		logger.info(csDTO.toString());
		try {
			productService.QnAinsert(csDTO);
			return new ModelAndView("redirect:../"+csDTO.getProduct_no()+"/");
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg","입력 실패");
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
	}
	@RequestMapping("Markadd")
	@ResponseBody
	public ModelAndView Markadd(
			@ModelAttribute ProductDTO productdto,
			HttpSession session) {
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		MarkDTO markdto = new MarkDTO();
		markdto.setUserdto(userInfo);
		logger.info(markdto.getUserdto().toString());
		markdto.setProductdto(productdto);
		logger.info(markdto.getProductdto().toString());
		
		try {
			productService.Markadd(markdto);

			return new ModelAndView("redirect:./");
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg","입력 실패");
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
	}
	
	@RequestMapping("Markdel")
	@ResponseBody
	public ModelAndView Markdel(
			@ModelAttribute ProductDTO productdto,
			HttpSession session) {
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		MarkDTO markdto = new MarkDTO();
		markdto.setUserdto(userInfo);
		logger.info(markdto.getUserdto().toString());
		markdto.setProductdto(productdto);
		logger.info(markdto.getProductdto().toString());
		
		try {
			productService.Markdel(markdto);

			return new ModelAndView("redirect:./");
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg","입력 실패");
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
	}
	@RequestMapping("reviewadd")
	@ResponseBody
	public ModelAndView review(
			@PathVariable int product_no, 
			@ModelAttribute ReviewDTO reviewdto,
//			@ModelAttribute int review_rating
			HttpSession session) {
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		reviewdto.setUserdto(userInfo);
		logger.info(reviewdto.getUserdto().toString() +"여긴넘어옴?");
		reviewdto.setProduct_no(product_no);
		
		try {
			productService.Reviewadd(reviewdto);

			return new ModelAndView("redirect:./");
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg","입력 실패");
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
	}
}
