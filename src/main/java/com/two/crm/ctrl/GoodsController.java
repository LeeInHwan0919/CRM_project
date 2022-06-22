package com.two.crm.ctrl;





import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.two.crm.dto.GoodsDto;
import com.two.crm.model.service.Goods_IService;

@Controller
public class GoodsController {
	
	@Autowired
	private Goods_IService gService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	
	//재고 전체 조회 
	@RequestMapping(value = "/GoodsList.do", method = RequestMethod.GET)
	public String goodsList(Model model, Authentication user) {
		logger.info("GoodsController goodsList GET");
		List<GoodsDto> goods = gService.AllGoods();
		model.addAttribute("goods", goods);
		
		model.addAttribute("user", user.getName());
		return "goodsList";
	}

	
//	재고관리 pdf , excel 다운로드
	
	@RequestMapping(value = "/DBtoExcel.do", method =RequestMethod.POST)
	@ResponseBody
	public String DBtoExcel(
			@RequestParam("fileName") String fileName/* ,HttpServletResponse response */) throws IOException{

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("재고리스트");
		int rowNo = 0;

		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("상품코드");
		headerRow.createCell(1).setCellValue("원두명");
		headerRow.createCell(2).setCellValue("kg");
		headerRow.createCell(3).setCellValue("지역");
		headerRow.createCell(4).setCellValue("원두 함량");
		headerRow.createCell(5).setCellValue("EA");
		headerRow.createCell(6).setCellValue("개수");
		headerRow.createCell(7).setCellValue("비고");

		List<GoodsDto> lists = gService.AllGoods();
		for (GoodsDto goods : lists) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(goods.getG_code());
			row.createCell(2).setCellValue(goods.getG_name());
			row.createCell(3).setCellValue(goods.getG_kg());
			row.createCell(4).setCellValue(goods.getG_country());
			row.createCell(5).setCellValue(goods.getG_content());
			row.createCell(6).setCellValue(goods.getG_amount());
			row.createCell(7).setCellValue(goods.getIv_cnt());
			row.createCell(1).setCellValue(goods.getDcode_goods());
		}

		FileOutputStream fileOutPut = new FileOutputStream("C:\\Users\\User\\Downloads\\재고리스트_"+fileName+".xlsx");
	    workbook.write(fileOutPut);
	    fileOutPut.close();
	    return "excel complete";
	}

	@RequestMapping(value = "/DBtoPdf.do", method = { RequestMethod.POST })   
	public @ResponseBody String DBtoPdf(@RequestParam("fileName") String fileName) {

		// ArrayList에 담기
		List<GoodsDto> data = new ArrayList<GoodsDto>();

		// 파일을 읽어서 excel을 핸들링하기 위해 try catch 예외처리 해줌
		// try문 안에 파일을 연결할 수 있는 FileInputStream으로 fileName을 불러와준다
		try (FileInputStream fis = new FileInputStream("C:/Users/User/Downloads/재고리스트_"+fileName+".xlsx")) { 
			

			//XSSFWorkbook을 활용하여 fis에 담겨있는 엑셀 파일 로딩
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			//첫번째 시트는 0번째 시트이기때문에 0 을 가져옴 
			XSSFSheet sheet = workbook.getSheetAt(0);
			// 시트를 열거형으로 row를 가져오는rowIterator 메소드 사용
			Iterator<Row> rows = sheet.rowIterator(); 
			
			//rows.next(); //첫번째 row 건너뛰기
			String[] imsi = new String[9];
			while (rows.hasNext()) { // row의 유무를 판단
				//next가 row type으로 row의 자식 type인 XSSFRow로 가져오려면 다운케스팅 해주기
				XSSFRow row = (XSSFRow) rows.next();
				// 하나의 row에 전체cell의 정보 불러와주기
				Iterator<Cell> cells = row.cellIterator();
				int i = 0;
				// cell의 유무를 판단
				while (cells.hasNext()) {
					XSSFCell cell = (XSSFCell) cells.next();// cell이 있다면 가져오기,캐스팅 해주기
					imsi[i] = cell.toString(); // i번째의 cell을 String값으로 넣기
					i++;
//					if (1 == 5)
//						break;

				}
				GoodsDto vo = new GoodsDto(imsi[0], imsi[1], imsi[2], imsi[3], imsi[4], imsi[5], imsi[6], imsi[7]);
				data.add(vo);
			}
			pdf_maker(data, fileName+".pdf");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "OK";
	}


	private static void pdf_maker(List<GoodsDto> data, String pdffile) {
		
		Document doc = new Document(PageSize.A4); 
		float[] widths = {30, 30, 30, 30, 30, 30, 30, 30};
		PdfPTable table = new PdfPTable(widths);
		try{
			PdfWriter.getInstance(doc, new FileOutputStream(new File("C:/Users/User/Downloads/재고리스트_"+ pdffile)));//경로 설정 후 pdf 파일 생성
			doc.open(); //Document open
			
			//폰트설정 ("폰트이름","폰트 배열","외부에 있는 폰트 사용")
			BaseFont basefont = BaseFont.createFont("C:\\eclipse-jee-2020-12-R-win32-x86_64\\eclipse\\workspace_web\\iText_API\\HANDOTUM.TTF",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			
			Font fontRow = new Font(basefont,10);//Row 폰트. 크기 설정
			

			table.completeRow();//Row가 하나 만들어졌으니 마감해준다.
			
			//ArrayList에 저장되어 있는 데이터를 Row로 변환
			for (GoodsDto vo : data) {
				Phrase phrase = new Phrase(vo.getG_code(),fontRow); //vo의 getseq를 입력하고 폰트 지정
				table.addCell(new PdfPCell(phrase));//table에 넣어준다
				
				phrase = new Phrase(vo.getDcode_goods(),fontRow);
				table.addCell(new PdfPCell(phrase));
				
				phrase = new Phrase(vo.getG_name(),fontRow);
				table.addCell(new PdfPCell(phrase));
				
				phrase = new Phrase(vo.getG_kg(),fontRow);
				table.addCell(new PdfPCell(phrase));
				
				phrase = new Phrase(vo.getG_country(),fontRow);
				table.addCell(new PdfPCell(phrase));
				
				phrase = new Phrase(vo.getG_content(),fontRow);
				table.addCell(new PdfPCell(phrase));
				
				phrase = new Phrase(vo.getG_amount(),fontRow);
				table.addCell(new PdfPCell(phrase));
				
				phrase = new Phrase(vo.getIv_cnt(),fontRow);
				table.addCell(new PdfPCell(phrase));
				
				table.completeRow();//Row가 하나 만들어졌으니 마감해준다.
			}
			doc.addTitle("PDF Table Test ");//Document 의 title 생성
			doc.add(table); //table에 넣어주고 
			System.out.println("생성완료"); //모든 작업이 오류 없이 완료 되면 "생성완료" 출력
			doc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			doc.open();
		}			
	}



}
