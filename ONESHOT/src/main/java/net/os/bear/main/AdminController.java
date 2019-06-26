package net.os.bear.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.UriComponentsBuilderMethodArgumentResolver;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import net.os.bear.product.ProductDTO;
import net.os.bear.user.UserDTO;
import net.os.bear.user.UserService;


@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private MainService mainService;
	
	@RequestMapping("/{pg}")
	public String list(@PathVariable long pg, HttpSession session,Model model) {	//제품리스트
		try {
//			List<net.os.bear.product.ProductDTO> list = mainService.getProductList();
//			long pg = 1;
			int pageSize = 12;
			int blockSize = 10;
			
			long startNum = (pg-1)*pageSize +1;  //page 게시물 시작번호
			long endNum = pg*pageSize;
			long totalCount = 0; 	//전체 게시물 수 
			long totalPage = 0; 	//전체 페이지 수
			long startBlock = 0; 	//페이지 시작 블럭
			long endBlock = 0;		//페이지 끝 블럭
			try {
				PageDTO pageDTO = new PageDTO(startNum,endNum);
				System.out.println(pageDTO);
//				MainDAO mainDAO = (MainDAO) new MainServiceImpl();
//				
				totalCount = mainService.getUserCnt();
				totalPage = totalCount/pageSize;
				if(totalCount % pageSize !=0) totalPage++;
				startBlock = (pg-1)/blockSize * blockSize +1;
				endBlock   = (pg-1)/blockSize * blockSize +blockSize;
				if(endBlock > totalPage) endBlock = totalPage;
				List<net.os.bear.user.UserDTO> list =mainService.getUserList(pageDTO);
				System.out.println(list);
				
				model.addAttribute("list", list);
				model.addAttribute("startBlock", startBlock);
				model.addAttribute("endBlock", endBlock);
				model.addAttribute("totalPage", totalPage);
				model.addAttribute("totalCount", totalCount);
				model.addAttribute("pg", pg);
				
			}catch(Exception e) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		if (userInfo.getUser_level() != 2) {
		return "include/index";
		}
		return "shop/admin";	
		}
	@RequestMapping("/remove")
	public String deleteuser(HttpSession session,Model model,HttpServletRequest request) {
		try {
			String id=request.getParameter("bt");
			System.out.println("파라미터 값: "+id);
			
			Map<String,String> map= new HashMap<String, String>();
			map.put("id",id);
			
			mainService.DeleteUser(map);
			
			System.out.println("id삭제되었다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "redirect:../1";
	}
	@RequestMapping("/a/{pg}")
	public String question(@PathVariable long pg,HttpSession session,Model model,HttpServletRequest request) {
		try {
//			List<net.os.bear.product.ProductDTO> list = mainService.getProductList();
//			long pg = 1;
			int pageSize = 12;
			int blockSize = 10;
			
			long startNum = (pg-1)*pageSize +1;  //page 게시물 시작번호
			long endNum = pg*pageSize;
			long totalCount = 0; 	//전체 게시물 수 
			long totalPage = 0; 	//전체 페이지 수
			long startBlock = 0; 	//페이지 시작 블럭
			long endBlock = 0;		//페이지 끝 블럭
			try {
				PageDTO pageDTO = new PageDTO(startNum,endNum);
				System.out.println(pageDTO);
//				MainDAO mainDAO = (MainDAO) new MainServiceImpl();
//				
				totalCount = mainService.get1Cnt();
				totalPage = totalCount/pageSize;
				if(totalCount % pageSize !=0) totalPage++;
				startBlock = (pg-1)/blockSize * blockSize +1;
				endBlock   = (pg-1)/blockSize * blockSize +blockSize;
				if(endBlock > totalPage) endBlock = totalPage;
				List<net.os.bear.user.MyPageDTO> list =mainService.get1List(pageDTO);
				System.out.println(list);
				
				model.addAttribute("list", list);
				model.addAttribute("startBlock", startBlock);
				model.addAttribute("endBlock", endBlock);
				model.addAttribute("totalPage", totalPage);
				model.addAttribute("totalCount", totalCount);
				model.addAttribute("pg", pg);
				
			}catch(Exception e) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		if (userInfo.getUser_level() != 2) {
		return "include/index";
		}
		
		return "shop/question";
		
	}
	@Autowired
	private UserService userService;
	
	@RequestMapping("/a/{pg}/write")
	public String update1(@PathVariable long pg,HttpSession session,Model model,HttpServletRequest request) {
		try {
			String con=request.getParameter("rcon");
			String ck=request.getParameter("check");
			String no=request.getParameter("csno");
			System.out.println(con);
			System.out.println(ck);
			System.out.println(no);
			
			Map<String,String> map=new HashMap<String,String>();
			map.put("con",con);
			map.put("ck",ck);
			map.put("no",no);
			
			mainService.Write1(map);
			System.out.println("문의답변됐다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return "redirect:../1";
	}
	@RequestMapping("/b/{pg}")
	public String qna(@PathVariable long pg,HttpSession session,Model model,HttpServletRequest request) {
		try {
//			List<net.os.bear.product.ProductDTO> list = mainService.getProductList();
//			long pg = 1;
			int pageSize = 12;
			int blockSize = 10;
			
			long startNum = (pg-1)*pageSize +1;  //page 게시물 시작번호
			long endNum = pg*pageSize;
			long totalCount = 0; 	//전체 게시물 수 
			long totalPage = 0; 	//전체 페이지 수
			long startBlock = 0; 	//페이지 시작 블럭
			long endBlock = 0;		//페이지 끝 블럭
			try {
				PageDTO pageDTO = new PageDTO(startNum,endNum);
				System.out.println(pageDTO);
//				MainDAO mainDAO = (MainDAO) new MainServiceImpl();
//				
				totalCount = mainService.getqnaCnt();
				totalPage = totalCount/pageSize;
				if(totalCount % pageSize !=0) totalPage++;
				startBlock = (pg-1)/blockSize * blockSize +1;
				endBlock   = (pg-1)/blockSize * blockSize +blockSize;
				if(endBlock > totalPage) endBlock = totalPage;
				List<net.os.bear.user.MyPageDTO> list =mainService.getqnaList(pageDTO);
				System.out.println(list);
				
				model.addAttribute("list", list);
				model.addAttribute("startBlock", startBlock);
				model.addAttribute("endBlock", endBlock);
				model.addAttribute("totalPage", totalPage);
				model.addAttribute("totalCount", totalCount);
				model.addAttribute("pg", pg);
				
			}catch(Exception e) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		if (userInfo.getUser_level() != 2) {
		return "include/index";
		}
		
		return "shop/qna";
		
	}
	
	@RequestMapping("/b/{pg}/write")
	public String updateqna(@PathVariable long pg,HttpSession session,Model model,HttpServletRequest request) {
		try {
			String con=request.getParameter("rcon");
			String ck=request.getParameter("check");
			String no=request.getParameter("csno");
			System.out.println(con);
			System.out.println(ck);
			System.out.println(no);
			
			Map<String,String> map=new HashMap<String,String>();
			map.put("con",con);
			map.put("ck",ck);
			map.put("no",no);
			
			mainService.Writeqna(map);
			System.out.println("문의답변됐다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return "redirect:../1";
	}
}
