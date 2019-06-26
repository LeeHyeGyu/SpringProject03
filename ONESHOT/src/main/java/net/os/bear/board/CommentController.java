package net.os.bear.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.os.bear.user.UserDTO;

@Controller
@RequestMapping("board/{boa_no}/{pg}/{art_no}/{cpg}")
public class CommentController {
	private static final Logger logger = 
			LoggerFactory.getLogger(CommentController.class);

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	@ResponseBody
	public List<CommentDTO> comment_list(@ModelAttribute CommentDTO commentDTO) throws Exception{
		return boardService.getCommentList(commentDTO);
	}
	
	@PostMapping("/")
	@ResponseBody
	public List<CommentDTO> insert(
		@ModelAttribute CommentDTO commentDTO,
		HttpSession session,
		HttpServletRequest request) {
		
		commentDTO.setUserDTO((UserDTO)session.getAttribute("userInfo"));
		commentDTO.setCom_ip(request.getRemoteAddr());
		logger.info(commentDTO.toString());
		
		try {
			boardService.insertComment(commentDTO);
			return comment_list(commentDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DeleteMapping("/{com_no}")
	@ResponseBody
	public List<CommentDTO> delete(
		@ModelAttribute CommentDTO commentDTO,
		HttpSession session,
		HttpServletRequest request) {
		
		commentDTO.setUserDTO((UserDTO)session.getAttribute("userInfo"));
		commentDTO.setCom_ip(request.getRemoteAddr());
		logger.info(commentDTO.toString());
		
		try {
			boardService.deleteComment(commentDTO);
			return comment_list(commentDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
	@PostMapping("/{com_no}")
	@ResponseBody
	public List<CommentDTO> update(
		@ModelAttribute CommentDTO commentDTO,
		HttpSession session,
		HttpServletRequest request) {
		
		commentDTO.setUserDTO((UserDTO)session.getAttribute("userInfo"));
		commentDTO.setCom_ip(request.getRemoteAddr());
		logger.info(commentDTO.toString());
		
		try {
			boardService.updateComment(commentDTO);
			return comment_list(commentDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
		
	
}
