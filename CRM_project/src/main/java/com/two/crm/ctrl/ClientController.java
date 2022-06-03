package com.two.crm.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.two.crm.dto.BoardDto;
import com.two.crm.dto.ClientDto;
import com.two.crm.model.service.Client_IService;

@Controller
public class ClientController {
	
	@Autowired
	private Client_IService cService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	
	//거래처 전체 조회 
	@RequestMapping(value = "/clientList.do", method = RequestMethod.GET)
	public String boardList(Model model, Authentication user) {
		List<ClientDto> clists = cService.AllClient();
		model.addAttribute("clists", clists);
		
//		for( user.getAuthorities() ) 권한으로 체크하기위해서 권한정보 가져와서 비교
		model.addAttribute("user", user.getName());
		return "clientList";
	}
	
	
	//거래처 상세 조회 
	@RequestMapping(value = "/clientDetail.do",method = RequestMethod.GET)
	public String getOneBoard(@RequestParam String cli_num, Authentication user, Model model) {
		System.out.println("사업자 번호 입니다 :"+cli_num);
		List<ClientDto> cVo = cService.DetailClient(cli_num);
//		ClientDto cVo = cService.DetailClient(cli_num);
		
		System.out.println(user.getName());

		model.addAttribute("cVo",cVo);
		return "clientDetail";
	}
	
	
	//거래처 삭제 
	@RequestMapping(value = "/deleteClient.do", method = {RequestMethod.POST,RequestMethod.GET})
	public String DeleteClient(@RequestParam String cli_num) {
		logger.info("DeleteClient : {}",cli_num);
		String n = cService.DeleteClient(cli_num);
		if(n.length()>0) {
			logger.info("삭제를 완료하였습니다");
		}
		return "redirect:/clientList.do";
	}
	
	
	
	//거래처 수정
	@RequestMapping(value = "/updateClient.do", method=RequestMethod.GET)
	public String modify(String cli_num, Model model) {
		List<ClientDto> cVo = cService.DetailClient(cli_num);
		model.addAttribute("cVo", cVo);
		return "updateClient";
	}
	
	
	
	@RequestMapping(value = "/updateClient.do", method = RequestMethod.POST)
	public String updateBoard(@RequestParam Map<String, Object> map, HttpSession session,Model model) {
		Map<String, Object> rMap = new HashMap<String, Object>();
		rMap.put("cli_num", map.get("cNum"));
		rMap.put("cli_tel", map.get("ctel"));
		rMap.put("cli_addr", map.get("caddr"));
		int n = cService.UpdateClient(rMap);
		if(n>0) {
			logger.info("수정에 성공하였습니다");
		}
		return "redirect:/clientList.do";
	}
	

}
