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


}
