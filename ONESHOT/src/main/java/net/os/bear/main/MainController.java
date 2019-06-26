package net.os.bear.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.servlet.mvc.method.annotation.UriComponentsBuilderMethodArgumentResolver;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import net.os.bear.product.ProductDTO;


@Controller
@RequestMapping("shop")
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String home(@RequestParam String search, Model model) {	//메인서치
		long pg=1;//값이 안넘어오면 1로 채운다.
		int pageSize=10;
		int blockSize=10;
		
		long startNum=(pg-1)*pageSize+1;
		long endNum=pg*pageSize;
		long totalCount=0;				//전체 게시물 수
		long totalPage=0;				//전체 페이지 수
		long startBlock=0;				//페이지 블럭의 시작
		long endBlock=0;		
		
		PageDTO pageDTO=new PageDTO(startNum,endNum);
		try {
			System.out.println(search);
			totalCount=mainService.resultSearchCnt(search);
			System.out.println(totalCount);
			totalPage=totalCount/pageSize;
			if(totalCount%pageSize!=0) totalPage++;
			startBlock=((pg-1)/blockSize*blockSize+1); 
			endBlock=((pg-1)/blockSize*blockSize+blockSize); 
			if(endBlock>totalPage)endBlock=totalPage;
		
			PageDTO pagedto=new PageDTO(search,startNum,endNum);
			
			List<net.os.bear.product.ProductDTO> list3=mainService.resultSearch(pagedto);
			
			System.out.println(list3+"==============");
			if(search=="") {
				throw new RuntimeException("검색 내용을 입력해 주세요.");			
				}
			
			model.addAttribute("list3", list3);
			model.addAttribute("search", search);
			model.addAttribute("startBlock", startBlock);
			model.addAttribute("endBlock", endBlock);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("pg", pg);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "mainsearch";
	}
	@RequestMapping("/{pg}")
	public String list(@PathVariable("pg") long pg,Model model) {	//제품리스트
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
				totalCount = 100;
				totalPage = totalCount/pageSize;
				if(totalCount % pageSize !=0) totalPage++;
				startBlock = (pg-1)/blockSize * blockSize +1;
				endBlock   = (pg-1)/blockSize * blockSize +blockSize;
				if(endBlock > totalPage) endBlock = totalPage;
				List<net.os.bear.product.ProductDTO> list =mainService.getPagingList(pageDTO);
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
		return "shop/shoplist";
	}
	@RequestMapping("/new/{pg}")
	public String sortlist(@PathVariable("pg") long pg,Model model) { //최신순정렬
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
				totalCount = 100;
				totalPage = totalCount/pageSize;
				if(totalCount % pageSize !=0) totalPage++;
				startBlock = (pg-1)/blockSize * blockSize +1;
				endBlock   = (pg-1)/blockSize * blockSize +blockSize;
				if(endBlock > totalPage) endBlock = totalPage;
				List<net.os.bear.product.ProductDTO> list =mainService.getPagingList2(pageDTO);
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
		
		return "shop/shoplist";
	}
	@RequestMapping("/alcl/{pg}")
	public String sortlist2(@PathVariable("pg") long pg,Model model) {//알콜정렬
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
				totalCount = 100;
				totalPage = totalCount/pageSize;
				if(totalCount % pageSize !=0) totalPage++;
				startBlock = (pg-1)/blockSize * blockSize +1;
				endBlock   = (pg-1)/blockSize * blockSize +blockSize;
				if(endBlock > totalPage) endBlock = totalPage;
				List<net.os.bear.product.ProductDTO> list =mainService.getALPagingList(pageDTO);
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
		
		return "shop/shoplist";
	}
	@RequestMapping("/alch/{pg}")
	public String sortlist3(@PathVariable("pg") long pg,Model model) {//알콜정렬
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
				totalCount = 100;
				totalPage = totalCount/pageSize;
				if(totalCount % pageSize !=0) totalPage++;
				startBlock = (pg-1)/blockSize * blockSize +1;
				endBlock   = (pg-1)/blockSize * blockSize +blockSize;
				if(endBlock > totalPage) endBlock = totalPage;
				List<net.os.bear.product.ProductDTO> list =mainService.getAHPagingList(pageDTO);
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
		
		return "shop/shoplist";
	}

	@RequestMapping("/filter/{pg}")
	public String searchPost(@PathVariable long pg,HttpServletRequest request,Model model){
		try {
			String arr[]=request.getParameterValues("check"); //취향 체크박스 값을 받아온다.
			String arr2[]=request.getParameterValues("check2"); //맛 체크박스 값을 받아온다.
			String arr3[]=request.getParameterValues("check3"); //종류 체크박스 값을 받아온다.
			String arr4[]=request.getParameterValues("check4"); //도수 체크박스 값을 받아온다.
			String arr5[]=request.getParameterValues("check5"); //원산지 체크박스 값을 받아온다.
			
			//값이 null이면 쿼리에 넣을 때 오류가 발생하므로 null일땐 ""로 대체해준다.
		    if(arr==null&&arr2==null&&arr3==null&&arr4==null&&arr5==null) { //셋다 null일때 메인으로 보낸다.
		    	throw new RuntimeException("조건을 입력해야해");
		    
			}else if(arr==null) { //취향이 null일때 ""을 넣는다.
				arr= new String[]{""};
				if(arr2==null) {arr2= new String[]{""};}
				if(arr3==null) {arr3= new String[]{""};}
				if(arr4==null) {arr4= new String[]{""};}
				if(arr5==null) {arr5= new String[]{""};}
				
			}else if(arr2==null) { //맛이 null일때 ""을 넣는다.
				arr2= new String[]{""};
				if(arr3==null) {arr3= new String[]{""};}
				if(arr4==null) {arr4= new String[]{""};}
				if(arr5==null) {arr5= new String[]{""};}
			}else if(arr3==null) { //종류가 null일때 ""을 넣는다.
				arr3= new String[]{""};
				if(arr4==null) {arr4= new String[]{""};}
				if(arr5==null) {arr5= new String[]{""};}
			}else if(arr4==null) { //종류가 null일때 ""을 넣는다.
				arr4= new String[]{""};
				if(arr5==null) {arr5= new String[]{""};}
			}else if(arr5==null) { //종류가 null일때 ""을 넣는다.
				arr5= new String[]{""};
			}
		    		
			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(arr2));
			System.out.println(Arrays.toString(arr3));
			System.out.println(Arrays.toString(arr4));
			System.out.println(Arrays.toString(arr5));

//			long pg = 1;
			int pageSize = 12; //한 페이지에 보여줄 게시물 수
			int blockSize = 10; //최대한 보여질 페이지 숫자
			
			long startNum = (pg-1)*pageSize +1;  //page 게시물 시작번호
			long endNum = pg*pageSize;
			long totalCount = 0; 	//전체 게시물 수 
			long totalPage = 0; 	//전체 페이지 수
			long startBlock = 0; 	//페이지 시작 블럭
			long endBlock = 0;		//페이지 끝 블럭
			try {
				
				PageDTO pageDTO = new PageDTO(arr,arr2,arr3,arr4,arr5); //totalCount를 구하기위해 DTO에 arr들을 담는다.
				System.out.println(pageDTO);
				
				totalCount = mainService.getFcnt(pageDTO); //arr들이 담긴 DTO를 메서드에 넣는다.
				System.out.println("토탈카운트 = "+totalCount);
				totalPage = totalCount/pageSize;
				if(totalCount % pageSize !=0) totalPage++;
				startBlock = (pg-1)/blockSize * blockSize +1;
				endBlock   = (pg-1)/blockSize * blockSize +blockSize;
				if(endBlock > totalPage) endBlock = totalPage;
				System.out.println("토탈페이지 수 = "+totalPage);
				System.out.println("스타트블럭 = "+startBlock);
				System.out.println("엔드블럭 = "+endBlock);
				
				PageDTO pagedto=new PageDTO(arr,arr2,arr3,arr4,arr5,startNum,endNum);
				System.out.println(pagedto.toString());
				System.out.println("======================이밑으로 필터리스트======================================");
				
				List<net.os.bear.product.ProductDTO> list =mainService.getFPagingList(pagedto);
				System.out.println(list);
				
				model.addAttribute("arr",arr);
				model.addAttribute("arr2",arr2);
				model.addAttribute("arr3",arr3);
				model.addAttribute("arr4",arr4);
				model.addAttribute("arr5",arr5);
				model.addAttribute("pagedto",pagedto);
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
		return "shop/tastefilter";
	}
	
	@RequestMapping("/filter/new/{pg}")
	public String filtesrsort(@PathVariable("pg") long pg,HttpServletRequest request,Model model){
		try {
			
			String arr[]=request.getParameterValues("arr");//취향
			String arr2[]=request.getParameterValues("arr2");//맛
			String arr3[]=request.getParameterValues("arr3");//종류
			String arr4[]=request.getParameterValues("arr4");//종류
			String arr5[]=request.getParameterValues("arr5");//종류
	
			//값이 null이면 쿼리에 넣을 때 오류가 발생하므로 null일땐 ""로 대체해준다.
		    if(arr==null&&arr2==null&&arr3==null&&arr4==null&&arr5==null) { //셋다 null일때 메인으로 보낸다.
		    	throw new RuntimeException("조건을 입력해야해");
		    
			}else if(arr==null) { //취향이 null일때 ""을 넣는다.
				arr= new String[]{""};
				if(arr2==null) {arr2= new String[]{""};}
				if(arr3==null) {arr3= new String[]{""};}
				if(arr4==null) {arr4= new String[]{""};}
				if(arr5==null) {arr5= new String[]{""};}
				
			}else if(arr2==null) { //맛이 null일때 ""을 넣는다.
				arr2= new String[]{""};
				if(arr3==null) {arr3= new String[]{""};}
				if(arr4==null) {arr4= new String[]{""};}
				if(arr5==null) {arr5= new String[]{""};}
			}else if(arr3==null) { //종류가 null일때 ""을 넣는다.
				arr3= new String[]{""};
				if(arr4==null) {arr4= new String[]{""};}
				if(arr5==null) {arr5= new String[]{""};}
			}else if(arr4==null) { //종류가 null일때 ""을 넣는다.
				arr4= new String[]{""};
				if(arr5==null) {arr5= new String[]{""};}
			}else if(arr5==null) { //종류가 null일때 ""을 넣는다.
				arr5= new String[]{""};
			}
		    		
			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(arr2));
			System.out.println(Arrays.toString(arr3));
			System.out.println(Arrays.toString(arr4));
			System.out.println(Arrays.toString(arr5));
			
			int pageSize = 12;
			int blockSize = 10;
			
			long startNum = (pg-1)*pageSize +1;  //page 게시물 시작번호
			long endNum = pg*pageSize;
			long totalCount = 0; 	//전체 게시물 수 
			long totalPage = 0; 	//전체 페이지 수
			long startBlock = 0; 	//페이지 시작 블럭
			long endBlock = 0;		//페이지 끝 블럭
			try {
				PageDTO pageDTO = new PageDTO(arr,arr2,arr3,arr4,arr5);
				System.out.println(pageDTO);
				
				PageDTO pagedto=new PageDTO(arr,arr2,arr3,arr4,arr5,startNum,endNum);
				List<net.os.bear.product.ProductDTO> list =mainService.getFNPagingList(pagedto);
				
				totalCount = mainService.getFcnt(pageDTO);
				System.out.println(totalCount);
				totalPage = totalCount/pageSize;
				if(totalCount % pageSize !=0) totalPage++;
				startBlock = (pg-1)/blockSize * blockSize +1;
				endBlock   = (pg-1)/blockSize * blockSize +blockSize;
				if(endBlock > totalPage) endBlock = totalPage;
				System.out.println(totalPage);
				System.out.println(startBlock);
				System.out.println(endBlock);
				
				System.out.println(pagedto.toString());
				System.out.println("======================이밑으로 필터리스트======================================");
				
				model.addAttribute("arr",arr);
				model.addAttribute("arr2",arr2);
				model.addAttribute("arr3",arr3);
				model.addAttribute("arr4",arr4);
				model.addAttribute("arr4",arr5);
				model.addAttribute("pagedto",pagedto);
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
		return "shop/tastefilter";
	}
}
