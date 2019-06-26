package net.os.bear.cart;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.os.bear.product.ProductDTO;
import net.os.bear.user.UserDTO;

@Controller
@RequestMapping("cart")
public class CartController {
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	CartService cartService;
	
		
	@RequestMapping("/")
	public ModelAndView list(HttpSession session,
			Model model
			) {

		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");

		ModelAndView mav = new ModelAndView("cart/cartlist");

			try {
				List<CartDTO> cartList = cartService.getCart(userInfo.getUser_id());
				int sumPrice = cartService.sumPrice(userInfo.getUser_id());//총합 

				int shippingFee = sumPrice >= 30000 ? 0 : 2500;//3만원 이상 무료배송
				model.addAttribute("cartList", cartList);
				model.addAttribute("shippingFee", shippingFee);
				model.addAttribute("sumPrice", sumPrice);
				model.addAttribute("sumTotal", sumPrice + shippingFee);
				model.addAttribute("count",cartList.size()); //장바구니 담긴 제품 개수
				System.out.println(cartList.size());
				mav.addObject("cartList", cartList);
				mav.addObject("count",cartList.size()); 
			} catch (Exception e) {
				e.printStackTrace();
			}

		return mav;
	}
	
	//cart 추가
	@RequestMapping("cartadd")
	public ModelAndView insert(@ModelAttribute ProductDTO productDTO,@ModelAttribute CartDTO cartDTO,
			HttpSession session, Model model) {
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		
		if(userInfo.getUser_id() == null) { //세션 존재X
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg", "Please do login first.");
			mav.addObject("url", "javascript:history.back();");
			return new ModelAndView("user/login");
		}
		
		try {
			cartDTO.setUserDTO(userInfo);
			cartDTO.setProductDTO(productDTO);
			cartService.insertCart(cartDTO);//cart 테이블에 저장
			logger.info(cartDTO.toString());
			
			model.addAttribute("cartDTO",cartDTO);
			model.addAttribute("userDTO",userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return new ModelAndView("redirect:./");
	}
	
	
	@RequestMapping("delete")
	public String delete(@RequestParam int cart_id) {
		try {
			cartService.delete(cart_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:./";                                                                                                                                                                       
	}
	
	@RequestMapping("deleteAll")
	@ResponseBody
	public String deleteAll(@ModelAttribute UserDTO user_id ,HttpSession session) {
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		if(user_id != null) {
			cartService.deleteAll(user_id.getUser_id());
		}
		return "../";
	}
	
	@RequestMapping("update")
	public String update(@RequestParam int[] cart_qty,
				         @RequestParam int[] product_no,
				         HttpSession session) {
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		String user_id = (String) session.getAttribute(userInfo.getUser_id());
		if(user_id != null) {
			try {
				for(int i=0;i<product_no.length;i++) {
					CartDTO cartDTO = new CartDTO();
					cartDTO.setUserDTO(userInfo);
//					cartDTO.setProduct_no(product_no[i]);
					cartDTO.setCart_qty(cart_qty[i]);
					cartService.modifyCart(cartDTO);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return "../";
	}
	
	@RequestMapping("order")
	public ModelAndView checkout(HttpSession session,
			Model model
			) {
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		ModelAndView mav = new ModelAndView("order/checkout");
			try {
				List<CartDTO> orderList = cartService.getCart(userInfo.getUser_id());
				int sumPrice = cartService.sumPrice(userInfo.getUser_id());//총합 
				int shippingFee = sumPrice >= 30000 ? 0 : 2500;//3만원 이상 무료배송
				model.addAttribute("orderList", orderList);
				model.addAttribute("shippingFee", shippingFee);
				model.addAttribute("sumPrice", sumPrice);
				model.addAttribute("sumTotal", sumPrice + shippingFee);
				model.addAttribute("count",orderList.size()); //장바구니 담긴 제품 개수
				System.out.println(orderList.size());
				mav.addObject("orderList", orderList);
				mav.addObject("count",orderList.size()); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		return mav;
	}
	
	@RequestMapping("qupdate")
	public String qupdate(HttpServletRequest request,Model model,
				         HttpSession session) {
		logger.info("되나요");
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
			try {
				String quantitys[]=request.getParameterValues("quantitys"); //취향 체크박스 값을 받아온다.
				String quantitysno[]=request.getParameterValues("quantitysno"); //맛 체크박스 값을 받아온다.
//				logger.info(quantitys[3]+"이거랑"+quantitysno[3]+"이거");
				CartDTO cart = new CartDTO();
				cart.setProductDTO(new ProductDTO());
				cart.setUserDTO(userInfo);
				int count = 0;
			 for(String str: quantitysno) {
				 int no ;
				 int qty;
				 no  = Integer.parseInt(str);
				 qty = Integer.parseInt(quantitys[count]);
				 cart.setCart_qty(qty);
				 cart.getProductDTO().setProduct_no(no);
				 cartService.qupdatecart(cart);	 	
//				 logger.info("됩니다"+quantitys[count]);
				 
				 count++;
				 
				 
			 }
//			 logger.info("끝?"+count);
			}catch(Exception e) {
				e.printStackTrace();
			}
		return "redirect:../cart/";
	}
}
