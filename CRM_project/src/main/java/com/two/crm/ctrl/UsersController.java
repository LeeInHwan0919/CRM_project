package com.two.crm.ctrl;

import java.util.List;


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
	
		
		
	
		//사원 상세 조회 이동 
				@RequestMapping(value = "/insertUser.do", method = RequestMethod.GET)
				public String userDetail(Model model, Authentication user) {
					logger.info("UsersController insertUser GET");
				return "insertUser";
					}
	


}
