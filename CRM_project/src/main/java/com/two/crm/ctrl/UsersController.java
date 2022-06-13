package com.two.crm.ctrl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.two.crm.dto.UserDto;
import com.two.crm.model.service.Users_IService;

@Controller
public class UsersController {
	
	@Autowired
	private Users_IService uService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	
	//사원 전체 조회 
	@RequestMapping(value = "/UsersList.do", method = RequestMethod.GET)
	public String usersList(Model model, Authentication user) {
		logger.info("UsersController userList GET");
		List<UserDto> users = uService.AllUsers();
		model.addAttribute("users", users);
		
		return "usersList";
	}
	
	//사원 상세 조회 이동 
		@RequestMapping(value = "/usersDetail.do", method = RequestMethod.GET)
		public String userDetail(Model model, Authentication user,@RequestParam String emp_code) {
			logger.info("UsersController userDetail GET");
			List<UserDto> users = uService.UserDetail(emp_code);
			model.addAttribute("users", users);
			System.out.println(users);
			return "usersDetail";
		}
	
		
		
	
	//사원 정보 수정
		@RequestMapping(value = "/updateUser.do", method = RequestMethod.POST)
		@ResponseBody
		public String updateUser(Model model, Authentication user,@RequestParam Map<String, Object> map) {
			System.out.println("updateUser 파라미터값 :"+map.toString());
			int cnt = uService.updateUser(map);
			System.out.println("updateUser cnt값 :"+cnt);
			return (cnt>0)?"성공":"실패";
		}
		
		//사원 등록 페이지 이동 
		@RequestMapping(value = "/insertUserGo.do", method = RequestMethod.GET)
		public String insertUser() {
			logger.info("UsersController insertUser 페이지이동");
			return "insertUser";
		}
		
		//사원 등록
		@RequestMapping(value="/insertUser.do", method = RequestMethod.POST)
		@ResponseBody
		public String insertUser(@RequestParam Map<String, Object> map) {
			System.out.println("UserController insertUser POST실행 dto값 : "+map.toString());
			int cnt = uService.insertUser(map);
			System.out.println("updateUser cnt값 :"+cnt);
			return (cnt>0)?"성공":"실패";
		}


}
