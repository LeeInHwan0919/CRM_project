package com.two.crm.ctrl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.two.crm.dto.BoardDto;
import com.two.crm.dto.ClientDto;
import com.two.crm.dto.UserDto;
import com.two.crm.model.service.Board_IService;


/**
* 게시판을 전체 조회하는 클래스 
* 2022.06.02
* @author nohsubin
*/
@Controller
public class BoardController {
	
	@Autowired
	private Board_IService bService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	
	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
	public String boardList(Model model, Authentication user) {
		List<BoardDto> lists = bService.AllBoard();
		model.addAttribute("lists", lists);
		
		model.addAttribute("user", user.getName());
		return "boardList";
	}
	
	
	/**
	* 게시판을 상세 조회 클래스 
	* 쿠키 정보를 통해 한번씩 카운트 
	* 2022.06.02
	* @author nohsubin
	*/
	@RequestMapping(value = "/boardDetail.do",method = RequestMethod.GET)
	public String getOneBoard(@RequestParam int seq, Authentication user, HttpServletRequest request, Model model, HttpServletResponse response) {
		
		BoardDto bVo = bService.BoardDetail(seq);

		System.out.println(user.getName());
	
		Cookie[] cookies = request.getCookies();
		
		// 비교하기 위해 새로운 쿠키
        Cookie viewCookie = null;

        if (cookies != null && cookies.length > 0) 
        {
            for (int i = 0; i < cookies.length; i++)
            {
                // Cookie의 name이 cookie + reviewNo와 일치하는 쿠키를 viewCookie에 넣어줌 
                if (cookies[i].getName().equals("cookie"+seq))
                { 
                    System.out.println("쿠키가 이미 생성 된 후 들어왔습니다.");
                    viewCookie = cookies[i];
                }
            }
        }
        
        if (bVo != null) {
            System.out.println("해당 공지사항의 상세페이지로 넘어갑니다.");
            
            // 만일 viewCookie가 null일 경우 쿠키를 생성해서 조회수 증가 로직을 처리함.
            if (viewCookie == null) {    
                System.out.println("cookie 없음");
                
                // 쿠키 생성(이름, 값)
                Cookie newCookie = new Cookie("cookie"+seq, "|" + seq + "|");
                                
                // 쿠키 추가
                response.addCookie(newCookie);
 
                // 쿠키를 추가 시키고 조회수 증가시킴
                Map<String, Object> rMap = new HashMap<String, Object>();
                rMap.put("seq",seq); 
                rMap.put("emp_code",user.getName());
                
                int result = bService.countBoard(rMap);
		
                if(result>0) {
                    System.out.println("조회수 증가했습니다.");
                }else {
                    System.out.println("등록자 입니다.");
                }
            }
            // viewCookie가 null이 아닐경우 쿠키가 있으므로 조회수 증가 로직을 처리하지 않음.
            else {
                System.out.println("cookie 있음");
                
                // 쿠키 값 받아옴.
                String value = viewCookie.getValue();
                System.out.println("cookie 값 이미 있습니다. : " + value);
            }
        }
		model.addAttribute("bVo",bVo);
		return "boardDetail";
	}
	
	
	/**
	* 게시판을 수정하는 클래스
	* 2022.06.02
	* @author nohsubin
	*/
	@RequestMapping(value = "/updateBoard.do", method=RequestMethod.GET)
	public String modify(int seq, Model model) {
		BoardDto bVo = bService.BoardDetail(seq);
		model.addAttribute("bVo", bVo);
		return "updateBoard";
	}
	
	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.POST)
	public String updateBoard(@RequestParam Map<String, Object> map, HttpSession session,Model model) {
		Map<String, Object> rMap = new HashMap<String, Object>();
		
		System.out.println(map.get("bSeq"));
		System.out.println(map.get("title"));
		System.out.println(map.get("content"));
		System.out.println(map.get("important"));
		
		rMap.put("seq", map.get("bSeq"));
		rMap.put("title", map.get("title"));
		rMap.put("content", map.get("content"));
		rMap.put("important", map.get("important"));
		int n = bService.updateBoard(rMap);
		if(n>0) {
			logger.info("수정에 성공하였습니다");
		}
		return "redirect:/boardList.do";
	}
	
	
	/**
	* 해당 게시글의 파일을 조회하는 클래스
	* 2022.06.06
	* @author nohsubin
	*/
	@ResponseBody
	@RequestMapping(value = "/selectFileInfo.do", method = RequestMethod.POST)
	public Map<String, Object> selectFileInfo(@RequestParam int seq, Model model) {
		System.out.println("==============seq :::::::::" + seq);
		
		Map<String, Object> rMap = new HashMap<String, Object>();
		
		List<BoardDto> Flist = bService.selectFileInfo(seq);
		
		model.addAttribute("Flist", Flist);
		
		rMap.put("data", Flist);
		return rMap;
	}
	
	/**
	* 새 게시글을 입력하는 클래스
	* 2022.06.02
	* @author nohsubin
	*/
	@ResponseBody
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(BoardDto bDto) {
		BoardDto bVo = new BoardDto();
		
		System.out.println(bDto.getEnddate()); 
		System.out.println(bDto.getTitle()); 
		System.out.println(bDto.getContent()); 
		System.out.println(bDto.getStartdate()); 
		System.out.println(bDto.getImportant());
		
		 bVo.setTitle(bDto.getTitle()); 
		 bVo.setContent(bDto.getContent());
		 bVo.setStartdate(bDto.getStartdate()); 
		 bVo.setEnddate(bDto.getEnddate()); 
		 bVo.setImportant(bDto.getImportant());
		 int n = bService.insertBoard(bDto); 
		 
		 if(n > 0) { 
			 logger.info("게시글 입력성공"); 
		 }
		return "redirect:/boardList.do";
	}
	
	
	@RequestMapping(value = "/insertBoardPage.do", method = RequestMethod.GET)
	public String insertPage() {
		return "insertBoard";
	}
	
	
	/**
	* 게시글의 seq를 확인하는 클래스
	* 2022.06.02
	* @author nohsubin
	*/
	//seq 조회
	@ResponseBody
	@RequestMapping(value = "/selectSEQ.do", method = RequestMethod.POST)
	public int selectSEQ() {
		int n =  bService.selectSEQ();
		return n;
	}
	
	/**
	* 공지사항을 삭제하는 클래스
	* 2022.06.02
	* @author nohsubin
	*/
	@ResponseBody
	@RequestMapping(value = "/deleteBoard.do", method = RequestMethod.POST)
	   public Map<String, Object> deleteBoard(BoardDto dto) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		System.out.println(dto.getSeq());
		
		bService.deleteBoard(dto.getSeq());
		
	      return result;
	   }	
	
	
	
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
    public String dragAndDrop(Model model) {
        return "fileUpload";
        
    }
	
	/**
	* 파일을 업로드하는 클래스
	* 2022.06.06
	* @author nohsubin
	*/
	@PostMapping(value = "/fileUpload.do") //ajax에서 호출하는 부분
	@ResponseBody
	public void upload(MultipartHttpServletRequest multipartRequest,@RequestParam int seq) { //Multipart로 받는다.
	        
//			System.out.println("확인확인");
			
			System.out.println(seq);
	        Iterator<String> itr =  multipartRequest.getFileNames();
	        
	        String filePath = "C:/test"; //설정파일로 뺀다.
	        
	        while (itr.hasNext()) { //받은 파일들을 모두 돌린다.
	            
	            
	            MultipartFile mpf = multipartRequest.getFile(itr.next());
	            
	            String originalFilename = mpf.getOriginalFilename(); //파일명
	            String fileFullPath = filePath+"/"+originalFilename; //파일 전체 경로
	            
	            Map<String, Object> map = new HashMap<String, Object>();

	            map.put("file_name", originalFilename);
	            map.put("file_folder", fileFullPath);
	            map.put("file_size", 0);
	            map.put("board_seq", seq);
	            
	            int n = bService.insertFile(map); 
	            
	   		 	if(n > 0) { 
	   			 logger.info("게시글 입력성공"); 
	   		 }
	     
	            try {
	                //파일 저장
	                mpf.transferTo(new File(fileFullPath)); //파일저장 실제로는 service에서 처리
	                
	                
	                System.out.println("originalFilename => "+originalFilename);
	                System.out.println("fileFullPath => "+fileFullPath);
	     
	            } catch (Exception e) {
	                System.out.println("postTempFile_ERROR======>"+fileFullPath);
	                e.printStackTrace();
	            }
	       }
	    }
	
	
	/**
	* 파일을 다운로드하는 클래스
	* 2022.06.13
	* @author nohsubin
	*/
	//파일 다운로드
	@PostMapping(value = "/filedownload.do") //ajax에서 호출하는 부분
	@ResponseBody
	public ResponseEntity<Resource> fileDownload(@RequestParam Map<String, Object> map) throws IOException {

      Path path1 = Paths.get(map.get("filePath").toString()); // 다운로드 할 파일의 최종 경로
      String contentType = Files.probeContentType(path1); // 타입 받아오기

      Resource resource = new InputStreamResource(Files.newInputStream(path1)); // path1의 

      return ResponseEntity.ok()
              .header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + map.get("fileName").toString() +"\"")
              .header(HttpHeaders.CONTENT_TYPE, contentType)
              .body(resource);
	}
	
	
}