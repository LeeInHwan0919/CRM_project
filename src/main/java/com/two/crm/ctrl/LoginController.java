package com.two.crm.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.two.crm.dto.BoardDto;

import com.two.crm.dto.UserDto;
import com.two.crm.model.service.Board_IService;
import com.two.crm.model.service.Graph_IService;
import com.two.crm.model.service.Login_IService;
import com.two.crm.model.service.SMS_Service;

@Controller
@SessionAttributes("id")
public class LoginController {

	@Autowired
	Login_IService service;
	
	@Autowired
	private Board_IService bService;
	
	
	@Autowired
	private SMS_Service sms_service;
	
	@Autowired
	private Graph_IService g_service;
	
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	// 로그인 페이지로 가는 매핑
	@RequestMapping(value = "/loginPage.do", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Authentication user, Model model, HttpServletRequest req) {

		logger.info("LoginController login이동");
		  
		if (error != null) {
			model.addAttribute("msg", "아이디 또는 비밀번호를 다시 입력해 주세요.");
		}
		
		if (logout != null) {
			model.addAttribute("msg", "로그아웃 성공");
		}
		
		if(user != null) {
			return "redirect:/result.do";
		}
		return "login";
	}



	//로그인 완료 후 메인 페이지로 가는 매핑
	@RequestMapping(value = "/result.do", method = RequestMethod.GET)
	public String maingo(Authentication user, Model model ) {
		UserDetails userdto = (UserDetails) user.getPrincipal();
		model.addAttribute("user", userdto.toString());
		System.out.println("userDto.toString:" + userdto.toString());
		System.out.println("비밀번호 : " + userdto.getPassword());
		
		List<BoardDto> lists = bService.AllBoard();
		model.addAttribute("lists", lists);
		model.addAttribute("id",userdto.getUsername());
		
		return "main";
	}

	//거래처 차트 
	@RequestMapping(value = "/ClientChart.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Integer> barchart() {
		List<Integer> clist = g_service.ClientGraph();
		System.out.println("사이즈"+clist.size());
		return clist;
	}
	
	//상품 차트
	@RequestMapping(value = "/GoodsChart.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Integer> piechart() {
		List<Integer> glist = g_service.GoodsGraph();
		System.out.println("사이즈"+glist.size());
		return glist;
	}
	
	//지역 차트
		@RequestMapping(value = "/LocationChart.do", method = RequestMethod.POST)
		@ResponseBody
		public List<Integer> bubblechart() {
			List<Integer> llist = g_service.LocationGraph();
			System.out.println("사이즈"+llist.size());
			return llist;
		}
	

	@RequestMapping(value = "/AuthError.do", method = RequestMethod.GET)
	public String AuthError(Model model) {
		return "AuthError";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout() {
		return "redirect:/logingo.do";
	}
	
	@RequestMapping(value = "/findpw.do", method = RequestMethod.GET)
	public String findpw() {
		return "findpw";
	}
	
	

	@RequestMapping(value = "/findpw.do", produces="application/string;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String findpw(String phoneNumber) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("emp_tel", phoneNumber);
		int cnt = service.match(map);
		System.out.println(cnt+"cntcntcnt");
		return (cnt>0)?"성공":"실패";
	}
	
	@RequestMapping(value = "/newpw.do", method = RequestMethod.GET)
	public String newpw(@RequestParam String emp_code, Model model) {
		model.addAttribute("emp_code",emp_code);
		return "newpw";
	}
	
	@RequestMapping(value = "/sendSMS.do",method = RequestMethod.POST)
	@ResponseBody
	public String sendSMS(String phoneNumber) {
        Random rand  = new Random(); // 인증번호를 위한 난수 생성
        String numStr = "";
        for(int i=0; i<4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }
        System.out.println("수신자 번호 : " + phoneNumber);
        System.out.println("인증번호 : " + numStr);
        sms_service.certifiedPhoneNumber(phoneNumber,numStr);
        return numStr;
    }

	//비밀번호 변경
	@RequestMapping(value="/modifyPW.do",method = RequestMethod.POST)
	public String modifyPW(UserDto dto) {
		System.out.println("회원가입 정보"+dto.toString());
		service.modifyPW(dto);
		return "redirect:/loginPage.do";
	}
}
