package com.two.crm.ctrl;

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

import com.two.crm.dto.UserDto;
import com.two.crm.model.service.Login_IService;
import com.two.crm.model.service.SMS_Service;

@Controller
public class LoginController {

	@Autowired
	Login_IService service;
	
	
	@Autowired
	private SMS_Service sms_service;
	
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	// 로그인 페이지로 가는 매핑
	@RequestMapping(value = "/loginPage.do", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Authentication user, Model model, HttpServletRequest req) {

		logger.info("LoginController login이동");
		  
		if (error != null) {
			model.addAttribute("msg", "로그인 에러");
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
		System.out.println(":::::::::::::::::::::::: " + userdto.toString());
		System.out.println("비밀번호 : " + userdto.getPassword());
		return "main";
	}


	//회원가입으로 가는 매핑
	@RequestMapping(value = "/signUpgo.do", method = RequestMethod.GET)
	public String SignUpgo() {
		return "SignUp";
	}


	// 회원가입 성공 매핑
	@RequestMapping(value = "/signUpSc.do", method = RequestMethod.POST)
	public String maingo(UserDto dto, Model model) {
		System.out.println("회원가입 정보"+dto.toString());
		service.signUp(dto);
		return "login";
	}
	
	//관리자 페이지
	@RequestMapping(value = "/admin/adminPage.do", method = RequestMethod.GET)
	public String adminPasge(Model model) {
		System.out.println("관리자 페이지");
		System.out.println();
		return "adminPage";
	}
	
	@RequestMapping(value = "/AuthError.do", method = RequestMethod.GET)
	public String AuthError(Model model) {
		return "AuthError";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout() {
		return "redirect:/logingo.do";
	}
	
	@RequestMapping(value = "/duplicateLogin.do", method = RequestMethod.GET)
	public String duplicateLogin() {
		return "duplicateLogin";
	}
	
	@RequestMapping(value = "/findpw.do", method = RequestMethod.GET)
	public String findpw() {
		return "findpw";
	}

	@RequestMapping(value = "/newpw.do", method = RequestMethod.GET)
	public String newpw() {
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
}