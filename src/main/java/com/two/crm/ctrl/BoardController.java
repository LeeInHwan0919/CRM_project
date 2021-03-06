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
 * Handles requests for the application home page.
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
      
//      for( user.getAuthorities() ) ???????????? ????????????????????? ???????????? ???????????? ??????
      model.addAttribute("user", user.getName());
      return "boardList";
   }
   
   
   //????????? ???????????? 
   //??? ???????????? ????????? ????????? 
   @RequestMapping(value = "/boardDetail.do",method = RequestMethod.GET)
   public String getOneBoard(@RequestParam int seq, Authentication user, HttpServletRequest request, Model model, HttpServletResponse response) {
      
      BoardDto bVo = bService.BoardDetail(seq);

      System.out.println(user.getName());
   
      Cookie[] cookies = request.getCookies();
      
      // ???????????? ?????? ????????? ??????
        Cookie viewCookie = null;

        if (cookies != null && cookies.length > 0) 
        {
            for (int i = 0; i < cookies.length; i++)
            {
                // Cookie??? name??? cookie + reviewNo??? ???????????? ????????? viewCookie??? ????????? 
                if (cookies[i].getName().equals("cookie"+seq))
                { 
                    System.out.println("????????? ?????? ?????? ??? ??? ??????????????????.");
                    viewCookie = cookies[i];
                }
            }
        }
        
        if (bVo != null) {
            System.out.println("?????? ??????????????? ?????????????????? ???????????????.");
            
            // ?????? viewCookie??? null??? ?????? ????????? ???????????? ????????? ?????? ????????? ?????????.
            if (viewCookie == null) {    
                System.out.println("cookie ??????");
                
                // ?????? ??????(??????, ???)
                Cookie newCookie = new Cookie("cookie"+seq, "|" + seq + "|");
                                
                // ?????? ??????
                response.addCookie(newCookie);
 
                // ????????? ?????? ????????? ????????? ????????????
                Map<String, Object> rMap = new HashMap<String, Object>();
                rMap.put("seq",seq); 
                rMap.put("emp_code",user.getName());
                
                int result = bService.countBoard(rMap);
      
                if(result>0) {
                    System.out.println("????????? ??????????????????.");
                }else {
                    System.out.println("????????? ?????????.");
                }
            }
            // viewCookie??? null??? ???????????? ????????? ???????????? ????????? ?????? ????????? ???????????? ??????.
            else {
                System.out.println("cookie ??????");
                
                // ?????? ??? ?????????.
                String value = viewCookie.getValue();
                System.out.println("cookie ??? ?????? ????????????. : " + value);
            }
        }
      model.addAttribute("bVo",bVo);
      return "boardDetail";
   }
   
   
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
         logger.info("????????? ?????????????????????");
      }
      return "redirect:/boardList.do";
   }
   
   
   
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
          logger.info("????????? ????????????"); 
       }
      return "redirect:/boardList.do";
   }
   
   
   @RequestMapping(value = "/insertBoardPage.do", method = RequestMethod.GET)
   public String insertPage() {
      return "insertBoard";
   }
   
   
   //seq ??????
   @ResponseBody
   @RequestMapping(value = "/selectSEQ.do", method = RequestMethod.POST)
   public int selectSEQ() {
      int n =  bService.selectSEQ();
      return n;
   }
   
   
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
	* ????????? ?????????
	* 2022.06.06
	* @author nohsubin
	*/
	//?????? ?????????
	@PostMapping(value = "/fileUpload.do") //ajax?????? ???????????? ??????
	@ResponseBody
	public void upload(MultipartHttpServletRequest multipartRequest,@RequestParam int seq) { //Multipart??? ?????????.
	        
//			System.out.println("????????????");
			
			System.out.println(seq);
	        Iterator<String> itr =  multipartRequest.getFileNames();
	        
	        String filePath = "C:/test"; //??????????????? ??????.
	        
	        while (itr.hasNext()) { //?????? ???????????? ?????? ?????????.
	            
	            
	            MultipartFile mpf = multipartRequest.getFile(itr.next());
	            
	            String originalFilename = mpf.getOriginalFilename(); //?????????
	            String fileFullPath = filePath+"/"+originalFilename; //?????? ?????? ??????
	            
	            Map<String, Object> map = new HashMap<String, Object>();


               map.put("file_name", originalFilename);
               map.put("file_folder", fileFullPath);
               map.put("file_size", 0);
               map.put("board_seq", seq);
               
               int n = bService.insertFile(map); 
               
                if(n > 0) { 
                logger.info("????????? ????????????"); 
             }
        
               try {
                   //?????? ??????
                   mpf.transferTo(new File(fileFullPath)); //???????????? ???????????? service?????? ??????
                   
                   
                   System.out.println("originalFilename => "+originalFilename);
                   System.out.println("fileFullPath => "+fileFullPath);
        
               } catch (Exception e) {
                   System.out.println("postTempFile_ERROR======>"+fileFullPath);
                   e.printStackTrace();
               }
          }
       }
   
   
   //?????? ????????????
   @PostMapping(value = "/filedownload.do") //ajax?????? ???????????? ??????
   @ResponseBody
   public ResponseEntity<Resource> fileDownload(@RequestParam Map<String, Object> map) throws IOException {

      Path path1 = Paths.get(map.get("filePath").toString()); // ???????????? ??? ????????? ?????? ??????
      String contentType = Files.probeContentType(path1); // ?????? ????????????

      Resource resource = new InputStreamResource(Files.newInputStream(path1)); // path1??? 

      return ResponseEntity.ok()
              .header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + map.get("fileName").toString() +"\"")
              .header(HttpHeaders.CONTENT_TYPE, contentType)
              .body(resource);

	}
	
}