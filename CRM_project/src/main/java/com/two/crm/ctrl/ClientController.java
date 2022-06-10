package com.two.crm.ctrl;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import com.itextpdf.io.exceptions.IOException;
import com.two.crm.dto.ClientDto;
import com.two.crm.model.service.Client_IService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



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
	
	@RequestMapping(value = "/insertPage.do", method = RequestMethod.GET)
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
	public int insertGoods(@RequestParam Map<String, Object> map) {
		
		JSONArray arry = new JSONArray();
		 
		arry = JSONArray.fromObject(map.get("codeArrObj"));
		
		for(int i=0;i<arry.size();i++) {
			JSONObject obj = (JSONObject)arry.get(i);
			Map<String, Object> rMaps = new HashMap<String, Object>();
				
			rMaps.put("g_code",obj.get("code"));
			rMaps.put("g_price",obj.get("price"));
			rMaps.put("g_name",obj.get("name"));
			rMaps.put("du_cnt",obj.get("count"));
			
			int n = cService.insertGoods(rMaps);
			if(n>0) {
				System.out.println("저장 성공");
			}else {
				System.out.println("저장 실패");
			}
		}
	
		return 0;
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
	
	// 병합 후 

	@RequestMapping(value = "/DBtoExcel2.do", method =RequestMethod.POST)
	@ResponseBody
	public String DBtoExcel(@RequestParam Map<String, Object> map) throws IOException, java.io.IOException {

		Map<String, Object> rMap = new HashMap<String, Object>();
		
		rMap.put("status",map.get("status"));
		//rMap.put("date",map.get("date"));
 		

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("거래처 다운");
		int rowNo = 0;
		
		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("사업자번호");
		headerRow.createCell(1).setCellValue("사원코드");
		headerRow.createCell(2).setCellValue("업체명");
		headerRow.createCell(3).setCellValue("주소");
		headerRow.createCell(4).setCellValue("전화번호");
		headerRow.createCell(5).setCellValue("지역");
		headerRow.createCell(6).setCellValue("계약 시작 일");
		headerRow.createCell(7).setCellValue("계약 만료 일");
		headerRow.createCell(8).setCellValue("계약 상태");
		
		List<ClientDto> lists = cService.selectStatus(rMap);
		for (ClientDto clist : lists) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(clist.getCli_num());
			row.createCell(1).setCellValue(clist.getEmp_code());
			row.createCell(2).setCellValue(clist.getCli_name());
			row.createCell(3).setCellValue(clist.getCli_addr());
			row.createCell(4).setCellValue(clist.getCli_tel());
			row.createCell(5).setCellValue(clist.getCli_area());
			row.createCell(6).setCellValue(clist.getCt_start());
			row.createCell(7).setCellValue(clist.getCt_end());
			row.createCell(8).setCellValue(clist.getStatus());
			
		}

		FileOutputStream fileOutPut = new FileOutputStream("C:\\Users\\User\\Downloads\\거래처리스트_"+ map.get("date").toString() +".xlsx");
	    workbook.write(fileOutPut);
	    fileOutPut.close();
	    return "excel complete";
	}

	
	
	
	//거래처 수정 
	@RequestMapping(value = "/updateClientPage.do", method=RequestMethod.GET)
	public String UpdateClient() {
		return "updateClientPage";
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateClient.do", method = RequestMethod.POST)
	public String UpdateClient(@RequestParam Map<String, Object> map, Model model) {
		
		System.out.println("업데이트를 위해 받아온 사업자 번호 입니다 :"+ map);
		Map<String, Object> rMap = new HashMap<String, Object>();
		rMap.put("cli_num",map.get("cli_num"));
		rMap.put("cli_num",map.get("cli_name"));
		rMap.put("cli_num",map.get("cli_addr"));
		rMap.put("cli_num",map.get("cli_area"));
		rMap.put("cli_num",map.get("cli_tel"));
//		rMap.put("cli_num",map.get("ct_start"));
//		rMap.put("cli_num",map.get("ct_end"));
		
		int n = cService.UpdateClient(rMap);
		if(n>0) {
			logger.info("거래처 수정에 성공하였습니다. ");
		}
		
		return "redirect:/clientList.jsp.do";
	}
	

}
