package net.os.bear.board;

import java.sql.Date;
import java.util.StringTokenizer;

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

import net.os.bear.user.MsgDTO;
import net.os.bear.user.UserDTO;

@Controller
@RequestMapping("board/{section_no}/{social_no}")
public class ArticleDetailController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleDetailController.class);

	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String detail(@PathVariable int section_no, @PathVariable int social_no, Model model) {
		logger.info("게시판 번호 : " + section_no);
		logger.info("게시물 번호 : " + social_no);

		try {
			ArticleDTO articleDTO = boardService.getArticle(social_no);
			model.addAttribute("articleDTO", articleDTO);
			logger.info(articleDTO.toString());
			if (section_no == 1) {
				return "board/detail1";
			} else {
				return "board/detail2";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			model.addAttribute("url", "../");
			return "result";
		}
	}

	@GetMapping("/delete")
	public ModelAndView delete(@ModelAttribute ArticleDTO articleDTO, HttpSession session) {

		articleDTO.setUserDTO((UserDTO) session.getAttribute("userInfo"));

		try {
			boardService.deleteArticle(articleDTO);
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg", articleDTO.getSocial_no() + "번 게시물이 삭제되었습니다.");
			mav.addObject("url", "../");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}
	}

	@GetMapping("update")
	public ModelAndView update(HttpSession session, @PathVariable int section_no) {
		UserDTO userDTO = (UserDTO) session.getAttribute("userInfo");
		logger.info("=================================================" + userDTO.getUser_level());
		ModelAndView mav = new ModelAndView("board/insert");
		mav.addObject("social_section", section_no);
		return mav;
	}

	@PostMapping("update")
	public ModelAndView update(@ModelAttribute ArticleDTO articleDTO, @PathVariable int section_no,
			@PathVariable int social_no, HttpSession session) throws Exception {
		articleDTO.setUserDTO((UserDTO) session.getAttribute("userInfo"));
		ModelAndView mav = new ModelAndView("result");
		articleDTO.setSocial_no(social_no);
		if (section_no == 1) {
			articleDTO.setEvent_date(new Date(990101));
			articleDTO.setDeadline(new Date(990101));
			articleDTO.setMaxp(0);
			articleDTO.setJoin_stat(0);
			articleDTO.setJoin_list(" ");
		} else if (section_no == 2) {
			String list = boardService.getArticle(social_no).getJoin_list();
			articleDTO.setJoin_list(list);
		}
		try {
			logger.info(articleDTO.toString());
			boardService.updateArticle(articleDTO);
			mav.addObject("msg", articleDTO.getSocial_no() + "번 글이 수정되었습니다.");
			mav.addObject("url", "../");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "result");
			return mav;
		}
	}

	@GetMapping("join")
	public ModelAndView join(@ModelAttribute ArticleDTO articleDTO, @PathVariable int section_no,
			@PathVariable int social_no, HttpSession session) throws Exception {
		UserDTO dto = ((UserDTO) session.getAttribute("userInfo"));

		ArticleDTO adto = null;
		ModelAndView mav = new ModelAndView("result");

		adto = boardService.getArticle(social_no);
		adto.setUserDTO(dto);
		String user = dto.getUser_id();
		String joinList = adto.getJoin_list();
		int joinstat = adto.getJoin_stat();
		int maxp = adto.getMaxp();
		boolean join = false;
		String str = null;

		if (joinstat == 0) {
			adto.setJoin_list(dto.getUser_id());
			joinstat++;
			adto.setJoin_stat(joinstat);

		} else {
			StringTokenizer st = new StringTokenizer(joinList, " ");
			for (int i = 0; st.hasMoreTokens(); i++) {
				if (st.nextToken().equals(user)) {
					join = true;
				}
			}

			if (maxp <= joinstat) {
				mav.addObject("msg", "참여인원이 초과되었습니다.");
				mav.addObject("url", "../");
				return mav;
			} else {
				if (join == false) {
					joinList = joinList + " " + dto.getUser_id();
					adto.setJoin_list(joinList);
					joinstat++;
					adto.setJoin_stat(joinstat);

				} else {
					StringTokenizer st2 = new StringTokenizer(joinList, " ");
					String str2 = "";
					String element = "";
					for (int i = 0; st2.hasMoreTokens(); i++) {
						element = st2.nextToken();
						if (element.equals(user)) {
							str2 = str2 + "";
						} else {
							str2 = str2 + " " + element;
						}
					}
					adto.setJoin_list(str2);
					joinstat--;
					adto.setJoin_stat(joinstat);

				}
			}
		}

		try {
			MsgDTO msggDTO = new MsgDTO();
			if (join == false) {
				str = dto.getUser_id() + "님이 " + social_no + "번 이벤트에 참여하셨습니다.";
			} else {
				str = dto.getUser_id() + "님이 " + social_no + "번 이벤트 참여를 취소하셨습니다.";
			}
			msggDTO.setMsg_recv_id(adto.getUser_id());
			msggDTO.setMsg_content(str);
			msggDTO.setUser_id(dto.getUser_id());
			logger.info(adto.toString());
			boardService.updateArticle(adto);
			boardService.sendMsgg(msggDTO);
			mav.addObject("msg", str);
			mav.addObject("url", "../");
			return mav;
		} catch (Exception e) {
			logger.info("adto : " + adto.toString());
			e.printStackTrace();
			mav.addObject("msg", "getMapping:join 실패");
			mav.addObject("url", "../");
			return mav;
		}

	}
}
