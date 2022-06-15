package com.two.crm.ctrl;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.two.crm.dto.BoardDto;
import com.two.crm.dto.ClientDto;
import com.two.crm.dto.GoodsDto;
import com.two.crm.dto.UserDto;
import com.two.crm.model.service.Board_IService;
import com.two.crm.model.service.Client_IService;
import com.two.crm.model.service.Goods_IService;
import com.two.crm.model.service.Users_IService;



/**
* 모든 테이블을 excel로 백업을 위해 다운로드 해주는 클레스
* 2022.06.13
* @author nohsubin
*/

@Controller
public class BackUpController {
	
	
	@Autowired
	private Users_IService userService;
	
	@Autowired
	private Board_IService boardService;
	
	@Autowired
	private Client_IService clientService;
	
	@Autowired
	private Goods_IService goodsIService;
	
	
	@RequestMapping(value = "/Backup.do", method=RequestMethod.GET)
	public String UpdateClient() {
		return "backup";
	}

	//공지게시판 백업
	@RequestMapping(value = "/BackUpBoard.do", method =RequestMethod.POST)
	@ResponseBody
	public String BackUpBoard(@RequestParam("fileName") String fileName) throws java.io.IOException  {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("board");
		int rowNo = 0;
		
		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("Seq");
		headerRow.createCell(1).setCellValue("Emp_code");
		headerRow.createCell(2).setCellValue("Title");
		headerRow.createCell(3).setCellValue("Content");
		headerRow.createCell(4).setCellValue("Important");
		headerRow.createCell(5).setCellValue("Startdate");
		headerRow.createCell(6).setCellValue("Enddate");
		headerRow.createCell(7).setCellValue("S_count");
		headerRow.createCell(8).setCellValue("Post_use");
		
		List<BoardDto> lists = boardService.BackUpBoard();
		for (BoardDto blist : lists) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(blist.getSeq()); 
			row.createCell(1).setCellValue(blist.getEmp_code());
			row.createCell(2).setCellValue(blist.getTitle());
			row.createCell(3).setCellValue(blist.getContent());
			row.createCell(4).setCellValue(blist.getImportant());
			row.createCell(5).setCellValue(blist.getStartdate());
			row.createCell(6).setCellValue(blist.getEnddate());
			row.createCell(7).setCellValue(blist.getS_count());
			row.createCell(8).setCellValue(blist.getPost_use());
			
		}

		FileOutputStream fileOutPut = new FileOutputStream("C:\\Users\\User\\Downloads\\board_table_BackUp_"+fileName+".xlsx");
	    workbook.write(fileOutPut);
	    fileOutPut.close();
	    return "excel complete";
	}
	
	//첨부파일 백업
	@RequestMapping(value = "/BackUpFile.do", method =RequestMethod.POST)
	@ResponseBody
	public String BackUpFile(@RequestParam("fileName") String fileName) throws java.io.IOException  {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("board_file");
		int rowNo = 0;
		
		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("File_seq");
		headerRow.createCell(1).setCellValue("Board_seq");
		headerRow.createCell(2).setCellValue("File_size");
		headerRow.createCell(3).setCellValue("File_folder");
		headerRow.createCell(4).setCellValue("File_name");

		
		List<BoardDto> lists = boardService.BackUpFile();
		for (BoardDto clist : lists) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(clist.getFile_seq());
			row.createCell(1).setCellValue(clist.getBoard_seq());
			row.createCell(2).setCellValue(clist.getFile_size());
			row.createCell(3).setCellValue(clist.getFile_folder());
			row.createCell(4).setCellValue(clist.getFile_name());
			
		}

		FileOutputStream fileOutPut = new FileOutputStream("C:\\Users\\User\\Downloads\\board_file_table_BackUp_"+fileName+".xlsx");
	    workbook.write(fileOutPut);
	    fileOutPut.close();
	    return "excel complete";
	}
	
	
	
	//사원정보 백업
	@RequestMapping(value = "/BackUpUsers.do", method =RequestMethod.POST)
	@ResponseBody
	public String BackUpUsers(@RequestParam("fileName") String fileName) throws java.io.IOException  {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("user_info");
		int rowNo = 0;
		
		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("Emp_code");
		headerRow.createCell(1).setCellValue("Area_cod");
		headerRow.createCell(2).setCellValue("Emp_name");
		headerRow.createCell(3).setCellValue("Emp_pw");
		headerRow.createCell(4).setCellValue("Emp_gender");
		headerRow.createCell(5).setCellValue("Emp_use");
		headerRow.createCell(6).setCellValue("Emp_img");
		headerRow.createCell(7).setCellValue("getEmp_auth");
		headerRow.createCell(8).setCellValue("getEmp_tel");
		headerRow.createCell(9).setCellValue("getEmp_addr");

		
		List<UserDto> lists = userService.BackUpUsers();
		for (UserDto ulist : lists) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(ulist.getEmp_code());
			row.createCell(1).setCellValue(ulist.getArea_code());
			row.createCell(2).setCellValue(ulist.getEmp_name());
			row.createCell(3).setCellValue(ulist.getEmp_pw());
			row.createCell(4).setCellValue(ulist.getEmp_gender());
			row.createCell(5).setCellValue(ulist.getEmp_use());
			row.createCell(6).setCellValue(ulist.getEmp_img());
			row.createCell(7).setCellValue(ulist.getEmp_auth());
			row.createCell(8).setCellValue(ulist.getEmp_tel());
			row.createCell(9).setCellValue(ulist.getEmp_addr());
			
		}

		FileOutputStream fileOutPut = new FileOutputStream("C:\\Users\\User\\Downloads\\user_info_table_BackUp_"+fileName+".xlsx");
	    workbook.write(fileOutPut);
	    fileOutPut.close();
	    return "excel complete";
	}
	
	
	//지역 정보 백업
	@RequestMapping(value = "/BackUpLocation.do", method =RequestMethod.POST)
	@ResponseBody
	public String BackUpLocation(@RequestParam("fileName") String fileName) throws java.io.IOException  {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("location");
		int rowNo = 0;
		
		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("Area_code");
		headerRow.createCell(1).setCellValue("Area");

		
		List<UserDto> lists = userService.BackUpLocation();
		for (UserDto ulist : lists) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(ulist.getArea_code());
			row.createCell(1).setCellValue(ulist.getArea());
		
			
		}

		FileOutputStream fileOutPut = new FileOutputStream("C:\\Users\\User\\Downloads\\location_table_BackUp_"+fileName+".xlsx");
	    workbook.write(fileOutPut);
	    fileOutPut.close();
	    return "excel complete";
	}
	
	
	//재고관리 백업
	@RequestMapping(value = "/BackUpiMGR.do", method =RequestMethod.POST)
	@ResponseBody
	public String BackUpiMGR(@RequestParam("fileName") String fileName) throws java.io.IOException  {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("inventory_management");
		int rowNo = 0;
		
		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("Seq");
		headerRow.createCell(1).setCellValue("getG_code");
		headerRow.createCell(2).setCellValue("Emp_code");
		headerRow.createCell(3).setCellValue("G_name");
		headerRow.createCell(4).setCellValue("Iv_cnt");
		headerRow.createCell(5).setCellValue("Emp_use");
	

		
		List<GoodsDto> lists = goodsIService.BackUpiMGR();
		for (GoodsDto glist : lists) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(glist.getSeq());
			row.createCell(1).setCellValue(glist.getG_code());
			row.createCell(2).setCellValue(glist.getEmp_code());
			row.createCell(3).setCellValue(glist.getG_name());
			row.createCell(4).setCellValue(glist.getIv_cnt());
			row.createCell(5).setCellValue(glist.getEmp_use());
			
		}

		FileOutputStream fileOutPut = new FileOutputStream("C:\\Users\\User\\Downloads\\inventory_management_table_BackUp_"+fileName+".xlsx");
	    workbook.write(fileOutPut);
	    fileOutPut.close();
	    return "excel complete";
	}
	
	//재고상품 백업
	@RequestMapping(value = "/BackUpGoods.do", method =RequestMethod.POST)
	@ResponseBody
	public String BackUpGoods(@RequestParam("fileName") String fileName) throws java.io.IOException  {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("inventory_goods");
		int rowNo = 0;
		
		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("G_code");
		headerRow.createCell(1).setCellValue("Dcode_goods");
		headerRow.createCell(2).setCellValue("G_name");
		headerRow.createCell(3).setCellValue("Iv_cnt");
		headerRow.createCell(4).setCellValue("G_kg");
		headerRow.createCell(5).setCellValue("G_country");
		headerRow.createCell(6).setCellValue("G_content");
		headerRow.createCell(7).setCellValue("G_amount");
		headerRow.createCell(8).setCellValue("G_date");
	
		
		List<GoodsDto> lists = goodsIService.BackUpGoods();
		for (GoodsDto glist : lists) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(glist.getG_code());
			row.createCell(1).setCellValue(glist.getDcode_goods());
			row.createCell(2).setCellValue(glist.getG_name());
			row.createCell(3).setCellValue(glist.getIv_cnt());
			row.createCell(4).setCellValue(glist.getG_kg());
			row.createCell(5).setCellValue(glist.getG_country());
			row.createCell(6).setCellValue(glist.getG_content());
			row.createCell(7).setCellValue(glist.getG_amount());
			row.createCell(8).setCellValue(glist.getG_date());
			
		}

		FileOutputStream fileOutPut = new FileOutputStream("C:\\Users\\User\\Downloads\\inventory_goods_table_BackUp_"+fileName+".xlsx");
	    workbook.write(fileOutPut);
	    fileOutPut.close();
	    return "excel complete";
	}

	//계약 상품 백업
	@RequestMapping(value = "/BackUpContractGoods.do", method =RequestMethod.POST)
	@ResponseBody
	public String BackUpContractGoods(@RequestParam("fileName") String fileName) throws java.io.IOException  {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("contract_goods");
		int rowNo = 0;
		
		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("Seq");
		headerRow.createCell(1).setCellValue("Ct_code");
		headerRow.createCell(2).setCellValue("G_code");
		headerRow.createCell(3).setCellValue("G_name");
		headerRow.createCell(4).setCellValue("G_price");
		headerRow.createCell(5).setCellValue("Du_cnt");
	
		
		List<GoodsDto> lists = goodsIService.BackUpContractGoods();
		for (GoodsDto glist : lists) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(glist.getSeq());
			row.createCell(1).setCellValue(glist.getCt_code());
			row.createCell(2).setCellValue(glist.getG_code());
			row.createCell(3).setCellValue(glist.getG_name());
			row.createCell(4).setCellValue(glist.getG_price());
			row.createCell(5).setCellValue(glist.getDu_cnt());
		
			
		}

		FileOutputStream fileOutPut = new FileOutputStream("C:\\Users\\User\\Downloads\\contract_goods_table_BackUp_"+fileName+".xlsx");
	    workbook.write(fileOutPut);
	    fileOutPut.close();
	    return "excel complete";
	}
	
	
	//상품할인 백업
	@RequestMapping(value = "/BackUpGoodsDiscount.do", method =RequestMethod.POST)
	@ResponseBody
	public String BackUpGoodsDiscount(@RequestParam("fileName") String fileName) throws java.io.IOException  {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("goods_discount");
		int rowNo = 0;
		
		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("Dcode_goods");
		headerRow.createCell(1).setCellValue("Rate");
	
		
		List<GoodsDto> lists = goodsIService.BackUpGoodsDiscount();
		for (GoodsDto glist : lists) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(glist.getDcode_goods());
			row.createCell(1).setCellValue(glist.getRate());
			
		}

		FileOutputStream fileOutPut = new FileOutputStream("C:\\Users\\User\\Downloads\\goods_discount_table_BackUp_"+fileName+".xlsx");
	    workbook.write(fileOutPut);
	    fileOutPut.close();
	    return "excel complete";
	}
	
	
	//거래처 백업
	@RequestMapping(value = "/BackUpClient.do", method =RequestMethod.POST)
	@ResponseBody
	public String BackUpClient(@RequestParam("fileName") String fileName) throws java.io.IOException  {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("goods_discount");
		int rowNo = 0;
		
		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("Dcode_goods");
		headerRow.createCell(1).setCellValue("Rate");
	
		
		List<GoodsDto> lists = goodsIService.BackUpGoodsDiscount();
		for (GoodsDto glist : lists) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(glist.getDcode_goods());
			row.createCell(1).setCellValue(glist.getRate());
			
		}

		FileOutputStream fileOutPut = new FileOutputStream("C:\\Users\\User\\Downloads\\goods_discount_table_BackUp_"+fileName+".xlsx");
	    workbook.write(fileOutPut);
	    fileOutPut.close();
	    return "excel complete";
	}
	
	
	//계약관리 백업
	@RequestMapping(value = "/BackUpcMGR.do", method =RequestMethod.POST)
	@ResponseBody
	public String BackUpcMGR(@RequestParam("fileName") String fileName) throws java.io.IOException  {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("contract_management");
		int rowNo = 0;
		
		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("Ctm_code");
		headerRow.createCell(1).setCellValue("Cli_num");
	
		
		List<ClientDto> lists = clientService.BackUpcMGR();
		for (ClientDto clist : lists) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(clist.getCtm_code());
			row.createCell(1).setCellValue(clist.getCli_num());
			
		}

		FileOutputStream fileOutPut = new FileOutputStream("C:\\Users\\User\\Downloads\\contract_management_table_BackUp_"+fileName+".xlsx");
	    workbook.write(fileOutPut);
	    fileOutPut.close();
	    return "excel complete";
	}
	
	
	
	//계약 백업
	@RequestMapping(value = "/BackUpContract.do", method =RequestMethod.POST)
	@ResponseBody
	public String BackUpContract(@RequestParam("fileName") String fileName) throws java.io.IOException  {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("contract");
		int rowNo = 0;
		
		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("Ct_code");
		headerRow.createCell(1).setCellValue("Ctm_code");
		headerRow.createCell(2).setCellValue("Dcode_client");
		headerRow.createCell(3).setCellValue("Du_price");
		headerRow.createCell(4).setCellValue("Du_date");
		headerRow.createCell(5).setCellValue("Ct_start");
		headerRow.createCell(6).setCellValue("Ct_end");
	
		
		List<ClientDto> lists = clientService.BackUpContract();
		for (ClientDto clist : lists) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(clist.getCt_code());
			row.createCell(1).setCellValue(clist.getCtm_code());
			row.createCell(2).setCellValue(clist.getDcode_client());
			row.createCell(3).setCellValue(clist.getDu_price());
			row.createCell(4).setCellValue(clist.getDu_date());
			row.createCell(5).setCellValue(clist.getCt_start());
			row.createCell(6).setCellValue(clist.getCt_end());
			
		}

		FileOutputStream fileOutPut = new FileOutputStream("C:\\Users\\User\\Downloads\\contract_table_BackUp_"+fileName+".xlsx");
	    workbook.write(fileOutPut);
	    fileOutPut.close();
	    return "excel complete";
	}
	
	
	
	//계약 할인 백업
	
	@RequestMapping(value = "/BackUpGoodsClient.do", method =RequestMethod.POST)
	@ResponseBody
	public String BackUpGoodsClient(@RequestParam("fileName") String fileName) throws java.io.IOException  {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("client_discount");
		int rowNo = 0;
		
		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("Dcode_client");
		headerRow.createCell(1).setCellValue("Rate");
		
		
		List<ClientDto> lists = clientService.BackUpGoodsClient();
		for (ClientDto clist : lists) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(clist.getDcode_client());
			row.createCell(1).setCellValue(clist.getRate());
		}

		FileOutputStream fileOutPut = new FileOutputStream("C:\\Users\\User\\Downloads\\client_discount_table_BackUp_"+fileName+".xlsx");
	    workbook.write(fileOutPut);
	    fileOutPut.close();
	    return "excel complete";
	}
	

	
}
