package com.two.crm.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.two.crm.dto.UserDto;
import com.two.crm.model.service.Login_IService;

@Controller
public class LoginController {

	@Autowired
	Login_IService service;

	// 로그인 페이지로 가는 매핑
	@RequestMapping(value = "/loginPage.do", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Authentication user, Model model, HttpServletRequest req) {

		  
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
	


}
