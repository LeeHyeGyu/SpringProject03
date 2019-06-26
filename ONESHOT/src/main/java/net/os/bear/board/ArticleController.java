package net.os.bear.board;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.ModelAndView;

import net.os.bear.user.UserDTO;

@Controller
@RequestMapping("board/{section_no}")
public class ArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String list(@PathVariable int section_no, Model model) {
		try {
			List<ArticleDTO> list = boardService.getArticleList(section_no);
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (section_no == 1) {
			return "board/article_list1";
		} else if (section_no == 2) {
			return "board/article_list2";
		} else {
			return "board/recomm";
		}
	}

	@GetMapping("insert")
	public ModelAndView insert(HttpSession session, @PathVariable int section_no) {
		if (session.getAttribute("userInfo") == null) {
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg", "로그인 해주세요");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("board/insert");
			mav.addObject("social_section", section_no);
			return mav;

		}

	}

	@PostMapping("insert")
	public ModelAndView insert(@ModelAttribute ArticleDTO articleDTO, @PathVariable int section_no, HttpSession session,
			HttpServletRequest request) {

		articleDTO.setUserDTO((UserDTO) session.getAttribute("userInfo"));
		try {
			articleDTO.setSocial_section(section_no);
			if (section_no == 1) {
				articleDTO.setDeadline(new Date(990101));
				articleDTO.setEvent_date(new Date(990101));
			}
			logger.info("============================================\n");
			logger.info(articleDTO.toString());

			boardService.insertArticle(articleDTO);
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg", "게시물이 입력되었습니다.");
			mav.addObject("url", "../");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg", "입력 실패");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}
	}
}
