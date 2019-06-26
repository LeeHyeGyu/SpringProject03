package net.os.bear.user;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.os.bear.product.ProductDTO;


@Controller
@RequestMapping("user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		
		return "user/login";
	}
	@PostMapping("/login")
	public String login(
			@ModelAttribute UserDTO userDTO,
			Model model,
			HttpSession session) {
		logger.info("userDTO : " + userDTO.toString());
		try {
			UserDTO userInfo = userService.getUser(userDTO);
			session.setAttribute("userInfo", userInfo);
			model.addAttribute("userInfo",userInfo);
			logger.info("userDTO : " + userDTO.toString());
			logger.info("로그인 userInfo : " + userInfo);
			return "redirect:../";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			model.addAttribute("url", "./");
			return "user/login";
		}
	}
	
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	@PostMapping("/join")
	public ModelAndView join(@ModelAttribute UserDTO userDTO,
			HttpServletRequest request,
			HttpSession session) {
		logger.info("userDTO: "+userDTO.toString());
		try {
			String[] taste = userDTO.getUser_taste().split(",");
				userDTO.setUser_taste(taste[0]);
				userDTO.setUser_taste2(taste[1]);
				userDTO.setUser_taste3(taste[2]);
//			logger.info(userDTO.getUser_taste());
//			logger.info(userDTO.getUser_taste2());
//			logger.info(userDTO.getUser_taste3());
			userService.joinUser(userDTO);
			logger.info("회원가입 성공~!");
			return new ModelAndView("redirect:/user/login");
		} catch (SQLException e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg","회원가입에 실패하였습니다.");
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
		
	}
	
	@RequestMapping("mypage")
	public String mypage(
			Model model,
			HttpSession session,
			MyPageDTO mypageDTO) {
		UserDTO userInfo = (UserDTO)session.getAttribute("userInfo");
		if(userInfo==null) {
			return "user/login";
		}
		try {
			mypageDTO.setUserDTO(userInfo);
			logger.info("mypageDTO");
			model.addAttribute("mypagedto",mypageDTO);
			List<MyPageDTO> orderlist = userService.getOrderList(mypageDTO);
			List<MyPageDTO> marklist = userService.getMarkList(mypageDTO);
			model.addAttribute("orderlist", orderlist);
			model.addAttribute("marklist",marklist);
			logger.info(orderlist.toString());
			logger.info("orderlist");
			return "user/mypage";
		} catch (Exception e) {
			e.printStackTrace();
			return "../";
		}
	}
	
	@GetMapping("changeinfo")
	public String changeInfo() {
		return "user/mypage/changeinfo";
	}
	
	@PostMapping("changeinfo")
	@ResponseBody
	public ModelAndView changeInfo(
			UserDTO userDTO,
			HttpSession session,
			Model model
			) {
		
		try {
			String[] taste = userDTO.getUser_taste().split(",");
			userDTO.setUser_taste(taste[0]);
			userDTO.setUser_taste2(taste[1]);
			userDTO.setUser_taste3(taste[2]);
			userService.changeInfo(userDTO);
			logger.info("회정정보수정 완료~~");
			return new ModelAndView("redirect:/user/login");
		} catch (SQLException e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg","입력 실패");
			mav.addObject("url","javascript:history.back();");
			return mav;
			
		}
		
	}
	@RequestMapping("delete")
	public ModelAndView delete(
			UserDTO userDTO,
			HttpSession session
			) {
		logger.info(userDTO.toString());
		
		try {
			userDTO = (UserDTO) session.getAttribute("userInfo");
			userService.delete(userDTO);
			logger.info("회원탈퇴 완료 ㅠㅠ");
			return new ModelAndView("redirect:../../");
		} catch (SQLException e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg","입력 실패");
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		if(userInfo.getUser_id()==null) {
			return "user/login";
		}
		session.invalidate();
		model.addAttribute("msg", "(" +userInfo.getUser_id() + ")님이 로그아웃 하였습니다.");
		model.addAttribute("url", "../");
		return "result";
	}
	
	@ResponseBody
	@RequestMapping("idcheck")
	public int idCheck(UserDTO user_id){
		int result = -1;
		try {
			result = userService.idcheck(user_id);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return result;

		}
	}
}
