package net.os.bear.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String list(Model model) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/board_list";
	}
	
	

}