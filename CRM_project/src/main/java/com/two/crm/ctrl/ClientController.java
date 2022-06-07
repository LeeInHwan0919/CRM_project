package com.two.crm.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
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
		
		System.out.println(user.getName());

		model.addAttribute("cVo",cVo);
		return "clientDetail";
	}
	
	@RequestMapping(value = "/insertPage.do",method = RequestMethod.GET)
	public String insertPage() {
		logger.info("ClientController insertPage");
		return "insertClient";
	}
	
	
	
	@RequestMapping(value = "/selectMGR.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectMGR(@RequestParam Map<String, Object> map) {
		Map<String, Object> rMap = new HashMap<String, Object>();
		
		//service
		List<ClientDto> dto = cService.selectConractCode();
		
		rMap.put("data", dto.get(0).getCtm_code());
		rMap.put("status", "OK");
		return rMap;
	}
	
	
	//거래처 등록
	@RequestMapping(value = "/insertClient.do", method = RequestMethod.POST)
	@ResponseBody
	public String insertclient(@RequestParam Map<String, Object> map, Authentication user) {
		Map<String, Object> rMap = new HashMap<String, Object>();
		Map<String, Object> rMap2 = new HashMap<String, Object>();
		Map<String, Object> rMap3 = new HashMap<String, Object>();
		
		// 거래처등록
		rMap.put("cli_num", map.get("cli_num"));
		rMap.put("emp_code", user.getName());
		rMap.put("cli_name", map.get("cli_name"));
		rMap.put("cli_addr", map.get("cli_addr"));
		rMap.put("cli_tel", map.get("cli_tel"));
		rMap.put("cli_area", map.get("cli_area"));
		
		
		int n = cService.insertClient(rMap);
		if(n>0) {
			System.out.println("거래처 등록에 성공하였습니다.");
		}
		
		
		rMap2.put("cli_num", map.get("cli_num"));
		rMap2.put("ctm_code", map.get("ctm_code"));
		
		int n2 = cService.insertMGT(rMap2);
		 if(n2>0) {
			 System.out.println("거래처 등록에 성공하였습니다.");
		 }
		
		rMap3.put("ct_start", map.get("ct_start"));
		rMap3.put("ct_end", map.get("ct_end"));
		rMap3.put("ctm_code", map.get("ctm_code"));
		rMap3.put("du_date", map.get("du_date"));
		
		
		rMap3.put("du_date", map.get("du_date"));
		
		int n3 = cService.insertContract(rMap3);
		
		if(n3>0) {
			System.out.println("거래처 등록에 성공하였습니다.");
		}
		
		
	
		// 계약상품등록
		logger.info("ClientController insertClient");
		return "insertClient";
	}
	
	
//거래처 등록
	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertGoods(@RequestParam Map<String, Object> map) {
		Map<String, Object> rMaps = new HashMap<String, Object>();
		
		
		ArrayList<Integer> countList = (ArrayList<Integer>) map.get("cofficeCountList");
		ArrayList<Integer> priceList = (ArrayList<Integer>) map.get("cofficePriceList");
		ArrayList<String> nameList = (ArrayList<String>) map.get("cofficeNameList");
		ArrayList<String> codeList = (ArrayList<String>) map.get("cofficeCodeList");
		
		for(int i=0;i<22;i++) {
			Map<String, Object> rMap = new HashMap<String, Object>();
			
			rMap.put("du_cnt",countList.get(i).toString());
			rMap.put("g_price",priceList.get(i).toString());
			rMap.put("g_name",nameList.get(i).toString());
			rMap.put("g_code",codeList.get(i).toString());
			cService.insertGoods(rMap);
		}
		return rMaps;
	}
	
	
	//거래처 삭제 
	@RequestMapping(value = "/deleteClient.do", method = RequestMethod.POST)
	public String DeleteClient(@RequestParam String cli_num) {
		logger.info("DeleteClient : {}",cli_num);
		String n = cService.DeleteClient(cli_num);
		if(n.length()>0) {
			logger.info("삭제를 완료하였습니다");
		}
		return "redirect:/clientList.do";
	}

	
	
	
	@RequestMapping(value = "/selectGoodsName.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectGoodsName(@RequestParam Map<String, Object> map) {
		Map<String, Object> rMap = new HashMap<String, Object>();
		List<String> datalistGcode = new ArrayList<String>();
		List<String> datalistGname = new ArrayList<String>();
 		

		//상품정보가져오기
		List<ClientDto> dto = cService.selectGoodsName();
		System.out.println(dto.isEmpty());
		
		for(ClientDto s : dto) {
			
			
			System.out.println(s.getG_code());
			System.out.println(s.getG_name());
			
			if(s.getG_code() != null) {
				datalistGname.add(s.getG_name());
				datalistGcode.add(s.getG_code());
			}
		}

		logger.info("ClientController insertClient");
		
		rMap.put("gCode", datalistGcode);
		rMap.put("gName", datalistGname);
		rMap.put("status", "OK");
		return rMap;
	}
	
	//거래처 사업자번호 조회
	@RequestMapping(value = "/selectCliNum.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectCliNum(@RequestParam Map<String, Object> map) {
		Map<String, Object> rMap = new HashMap<String, Object>();
		List<String> datalisCliNum= new ArrayList<String>();
 		
	
		//상품정보가져오기
		List<ClientDto> dto = cService.selectCliNum();
		System.out.println(dto.isEmpty());
		
		for(ClientDto s : dto) {
			
			
			System.out.println(s.getCli_num());
			
			if(s.getCli_num() != null) {
				datalisCliNum.add(s.getCli_num());
			}
		}
		
		logger.info("ClientController selectCliNum");
		
		rMap.put("gCliNum", datalisCliNum);
		rMap.put("status", "OK");
		return rMap;
	}
	

	
	

}
