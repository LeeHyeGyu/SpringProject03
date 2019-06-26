package net.os.bear.order;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.os.bear.user.UserDTO;

@Controller
@RequestMapping("order")
public class OrderController {
	
private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
@Autowired
	private OrderService orderService;
	
	@RequestMapping("/buying")
	public String buying(HttpServletRequest request,@ModelAttribute OrderDTO orderDTO,
				         HttpSession session,@RequestParam(value="addr2", required=false) String addr2
,@RequestParam(value="addr3", required=false) String addr3) {
		logger.info("되나요");
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		 UUID uuid = UUID.randomUUID();
         String order_no = uuid.toString().replaceAll("-", "").substring(24);
		UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
		orderDTO.setOrder_addr(addr2+addr3);
		orderDTO.setUserDTO(userInfo);
		orderDTO.setOrder_no(ymd+"_"+order_no);
		logger.info(orderDTO.toString());
			try {
				orderService.insertOrder(orderDTO);
				orderService.orderInfo_Detail(orderDTO);
				orderService.deleteAll(orderDTO.getUserDTO().getUser_id());
			}catch(Exception e) {
				e.printStackTrace();
			}
		return "redirect:/";
	}
	

}
