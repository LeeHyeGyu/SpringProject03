package net.os.bear.cs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cs")
public class CSController {
	
//	@Autowired
//	private CSService csService;
	
	@GetMapping("/")
	public String cs() {
		
		return "cs/qna_personal";
	}
}
