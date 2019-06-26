package net.os.bear.user;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.os.bear.cs.CSDTO;
import net.os.bear.product.ReviewDTO;

@Controller
@RequestMapping("user")
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("orderdelivery")
	public String orderdelivery(
			MyPageDTO mypageDTO,
			Model model, 
			HttpSession session) {
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		if (userInfo.getUser_id() == null) {
			return "user/login";
		}
		try {
			mypageDTO.setUserDTO(userInfo);
			model.addAttribute("mypagedto", mypageDTO);
			List<MyPageDTO> orderlist = userService.getOrderList(mypageDTO);
			model.addAttribute("orderlist", orderlist);
			return "user/mypage/orderdelivery";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "user/mypage";
		}
	}
	@RequestMapping(value="review", method = RequestMethod.GET)
	public String review(
			Model model,
			HttpSession session,
			MyPageDTO mypageDTO
			) {
		UserDTO userInfo = (UserDTO)session.getAttribute("userInfo");
		if (userInfo.getUser_id() == null) {
			return "user/login";
		}
		try {
			mypageDTO.setUserDTO(userInfo);
			List<MyPageDTO> reviewlist = userService.getReviewList(mypageDTO);
			model.addAttribute("reviewlist",reviewlist);
			model.addAttribute("mypagedto",mypageDTO);
			return "user/mypage/review";
		} catch (SQLException e) {
			e.printStackTrace();
			return "user/mypage";
		}
	}
	
	@RequestMapping(value="review", method = RequestMethod.POST)
	public ModelAndView review(
			@ModelAttribute ReviewDTO reviewDTO,
			HttpSession session
			) {
		UserDTO userInfo = (UserDTO)session.getAttribute("userInfo");
		try {
			int review_no = reviewDTO.getReview_no();
			ModelAndView mav = new ModelAndView("result");
			userService.reviewDelete(review_no);
			mav.addObject("msg","리뷰가 삭제 되었습니다.");
			mav.addObject("url","./review");
			return mav;
		}catch(Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg",e.getMessage());
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
	}
	
	@RequestMapping(value="social",method = RequestMethod.GET)
	public String social(
			Model model,
			HttpSession session,
			MyPageDTO mypageDTO) {
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		if(userInfo.getUser_id() ==null) {
			return "user/login";
		}
		mypageDTO.setUserDTO(userInfo);
		
		try {
			List<MyPageDTO> sociallist = userService.getSocialList(mypageDTO);
			model.addAttribute("mypagedto",mypageDTO);
			model.addAttribute("sociallist",sociallist);
			return "user/mypage/social";
		} catch (SQLException e) {
			e.printStackTrace();
			return "user/mypage";
		}
		
	}
	@RequestMapping(value="social", method = RequestMethod.POST)
	public ModelAndView social(
			@ModelAttribute SocialDTO socialDTO,
			HttpSession session
			) {
		UserDTO userInfo = (UserDTO)session.getAttribute("userInfo");
		try {
			int review_no = socialDTO.getSocial_no();
			ModelAndView mav = new ModelAndView("result");
			userService.socialDelete(review_no);
			mav.addObject("msg","글이 삭제 되었습니다.");
			mav.addObject("url","./social");
			return mav;
		}catch(Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg",e.getMessage());
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
	}
	@RequestMapping("mark")
	public String mark(
			Model model,
			HttpSession session,
			MyPageDTO mypageDTO
			) {
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		if(userInfo.getUser_id() ==null) {
			return "user/login";
		}
		try {
			mypageDTO.setUserDTO(userInfo);
			List<MyPageDTO> marklist = userService.getMarkList(mypageDTO);
			model.addAttribute("marklist",marklist);
			model.addAttribute("mypagedto",mypageDTO);
			return "user/mypage/mark";	
		}catch(SQLException e) {
			e.printStackTrace();
			return "user/mypage";
		}
	}
//	1:1문의 section = A
	@RequestMapping(value="cs", method = RequestMethod.GET)
	public String cs(
			Model model ,
			HttpSession session,
			MyPageDTO mypageDTO
			) {
		UserDTO userInfo = (UserDTO)session.getAttribute("userInfo");
		try {
			mypageDTO.setUserDTO(userInfo);
			List<MyPageDTO> cslist=userService.getCSList(mypageDTO);
			model.addAttribute("mypagedto",mypageDTO);
			model.addAttribute("cslist",cslist);
			return "user/mypage/cs";
		} catch (SQLException e) {
			e.printStackTrace();
			return "user/mypage";
		}
	}
	//1:1 문의 삭제
	@RequestMapping(value="cs", method = RequestMethod.POST)
	public ModelAndView cs(
			@ModelAttribute CSDTO csDTO,
			HttpSession session
			) {
		UserDTO userInfo = (UserDTO)session.getAttribute("userInfo");
		try {
			long cs_no = csDTO.getCs_no();
			ModelAndView mav = new ModelAndView("result");
			userService.cscsDelete(cs_no);
			mav.addObject("msg","1:1 문의가 삭제 되었습니다.");
			mav.addObject("url","./cs");
			return mav;
		}catch(Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg",e.getMessage());
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
	}
//	제품문의 section = B
	@RequestMapping(value="productcs", method = RequestMethod.GET)
	public String productcs(
			Model model ,
			HttpSession session,
			MyPageDTO mypageDTO
			) {
		UserDTO userInfo = (UserDTO)session.getAttribute("userInfo");
		if(userInfo.getUser_id() == null) {
			return "user/login";
		}
		try {
			mypageDTO.setUserDTO(userInfo);
			List<MyPageDTO> productcslist=userService.getProductCSList(mypageDTO);
			model.addAttribute("mypagedto",mypageDTO);
			model.addAttribute("productcslist",productcslist);
			return "user/mypage/productcs";
		} catch (SQLException e) {
			e.printStackTrace();
			return "user/mypage";
		}
	}
	//제품문의 삭제
	@RequestMapping(value="productcs", method = RequestMethod.POST)
	public ModelAndView productcs(
			@ModelAttribute CSDTO csDTO,
			HttpSession session
			) {
		UserDTO userInfo = (UserDTO)session.getAttribute("userInfo");
		try {
			long cs_no = csDTO.getCs_no();
			ModelAndView mav = new ModelAndView("result");
			userService.csDelete(cs_no);
			mav.addObject("msg","제품문의가 삭제 되었습니다.");
			mav.addObject("url","./productcs");
			return mav;
		}catch(Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg",e.getMessage());
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
	}
	//받은 메세지
	@RequestMapping(value="recvmsg", method = RequestMethod.GET)
	public String recvmsg(
			Model model ,
			HttpSession session,
			MyPageDTO mypageDTO
			) {
		UserDTO userInfo = (UserDTO)session.getAttribute("userInfo");
		if(userInfo.getUser_id() ==null) {
			return "user/login";
		}
		
		try {
			mypageDTO.setUserDTO(userInfo);
			List<MyPageDTO> recvmsglist=userService.getRecvMSGList(mypageDTO);
			model.addAttribute("mypagedto",mypageDTO);
			model.addAttribute("recvmsglist",recvmsglist);
			return "user/msg/recvmsg";
		} catch (SQLException e) {
			e.printStackTrace();
			return "user/msg";
		}
	}
	//보낸 메세지
	@RequestMapping(value="sendmsg", method = RequestMethod.GET)
	public String sendmsg(
			Model model ,
			HttpSession session,
			MyPageDTO mypageDTO
			) {
		UserDTO userInfo = (UserDTO)session.getAttribute("userInfo");
		if(userInfo.getUser_id() ==null) {
			return "user/login";
		}
		
		try {
			mypageDTO.setUserDTO(userInfo);
			List<MyPageDTO> sendmsglist=userService.getSendMSGList(mypageDTO);
			model.addAttribute("mypagedto",mypageDTO);
			model.addAttribute("sendmsglist",sendmsglist);
			return "user/msg/sendmsg";
		} catch (SQLException e) {
			e.printStackTrace();
			return "user/msg";
		}
	}
//	 메세지 쓰기
	@GetMapping("msg")
	public String msg() {
		return "user/msg/msg";
	}
//	 메세지 쓰기
	@PostMapping("msg")
	public String msg(
			@ModelAttribute MsgDTO msgDTO,
			Model model,
			HttpSession session
			) {
		UserDTO userInfo = (UserDTO)session.getAttribute("userInfo");
		if(userInfo.getUser_id()==null) {
			return "user/login";
		}
		
		try {
			msgDTO.setUser_id(userInfo.getUser_id());
			userService.getSendMsg(msgDTO);
			logger.info("메세지 전송 성공~!");
			return "redirect:./sendmsg/";
		} catch (SQLException e) {
			logger.info("메세지 전송 실패ㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜ");
			e.printStackTrace();
			return "user/msg/msg";
		}
		
	}
//	보낸 메세지 상세보기
	@GetMapping("sendmsg/{msg_no}/")
	public String msgdetail(
			@PathVariable int msg_no,
			Model model,
			HttpSession session
			) {
		UserDTO userInfo = (UserDTO)session.getAttribute("userInfo");
		if(userInfo.getUser_id() ==null) {
			return "user/login";
		}
		
		try {
			 MsgDTO msgDTO= userService.getMSG(msg_no);
			 model.addAttribute("msgdto",msgDTO);
			logger.info("보일랑 말랑");
			return "user/msg/detail";
		} catch (SQLException e) {
			e.printStackTrace();
			return "user/msg/sendmsg";
		}
	}
//	받은 메세지 상세보기
	@GetMapping("recvmsg/{msg_no}/")
	public String recvmsgdetail(
			@PathVariable int msg_no,
			Model model,
			HttpSession session
			) {
		UserDTO userInfo = (UserDTO)session.getAttribute("userInfo");
		if(userInfo.getUser_id() ==null) {
			return "user/login";
		}
		
		try {
			userService.readCheck(msg_no); 
			MsgDTO msgDTO= userService.getMSG(msg_no);
			model.addAttribute("msgdto",msgDTO);
			 
			logger.info("보일랑 말랑");
			return "user/msg/detail";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "user/msg/recvmsg";
	}
//	받은 메세지 삭제
	@RequestMapping(value="recvmsg", method = RequestMethod.POST)
	public ModelAndView recvdelete(
			@ModelAttribute MsgDTO msgDTO,
			HttpSession session
			) {
		try {
			logger.info(msgDTO.toString());
			int msg_no = msgDTO.getMsg_no();
			ModelAndView mav = new ModelAndView("result");
			userService.recvDelete(msgDTO);
			userService.realDelete();
			mav.addObject("msg","쪽지가 삭제 되었습니다.");
			mav.addObject("url","./recvmsg");
			return mav;
		}catch(Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg",e.getMessage());
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
		
	}
//	보낸 메세지 삭제
	@RequestMapping(value="sendmsg", method = RequestMethod.POST)
	public ModelAndView senddelete(
			@ModelAttribute MsgDTO msgDTO,
			HttpSession session
			) {
		try {
			logger.info(msgDTO.toString());
			int msg_no = msgDTO.getMsg_no();
			ModelAndView mav = new ModelAndView("result");
			userService.sendDelete(msgDTO);
			userService.realDelete();
			mav.addObject("msg","쪽지가 삭제 되었습니다.");
			mav.addObject("url","./sendmsg");
			return mav;
		}catch(Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg",e.getMessage());
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
		
	}
}
