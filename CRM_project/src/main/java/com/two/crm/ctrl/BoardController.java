package com.two.crm.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		
//		for( user.getAuthorities() ) 권한으로 체크하기위해서 권한정보 가져와서 비교
		model.addAttribute("user", user.getName());
		return "boardList";
	}
	
	
	//게시판 상세보기 
	//한 아이디당 한번씩 카운트 
	@RequestMapping(value = "/boardDetail.do",method = RequestMethod.GET)
	public String getOneBoard(@RequestParam int seq, Authentication user, HttpServletRequest request, Model model, HttpServletResponse response) {
		
		BoardDto bVo = bService.BoardDetail(seq);
		
		System.out.println(user.getName());
		//UserDetails userdto = (UserDetails) user.getPrincipal();
		//System.out.println("user_id ::: " + userdto.getUsername());
		
		//model.addAttribute("user", );
		
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
	
	
	@RequestMapping(value = "/updateBoard.do", method=RequestMethod.GET)
	public String modify(int seq, Model model) {
		BoardDto bVo = bService.BoardDetail(seq);
		model.addAttribute("bVo", bVo);
		return "updateBoard";
	}
	
	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.POST)
	public String updateBoard(@RequestParam Map<String, Object> map, HttpSession session,Model model) {
		Map<String, Object> rMap = new HashMap<String, Object>();
		rMap.put("seq", map.get("bSeq"));
		rMap.put("title", map.get("title"));
		rMap.put("content", map.get("content"));
		int n = bService.updateBoard(rMap);
		if(n>0) {
			logger.info("수정에 성공하였습니다");
		}
		return "redirect:/boardList.do";
	}
	
	
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public String insertBoard() {
		logger.info("BoardController insertForm");
		return "insertBoard";
	}
	
	

	
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(BoardDto bDto) {
		BoardDto bVo = new BoardDto();
		bVo.setTitle(bDto.getTitle());
		bVo.setContent(bDto.getContent());
		int n = bService.insertBoard(bDto);
		if(n > 0) {
			logger.info("게시글 입력성공");
		}
		return "redirect:/boardList.do";
		
	}
	
	
	
	@RequestMapping(value = "/deleteBoard.do", method = {RequestMethod.POST,RequestMethod.GET})
	public String deleteBoard(@RequestParam int seq) {
		logger.info("deleteBoard : {}",seq);
		int n = bService.deleteBoard(seq);
		if(n>0) {
			logger.info("삭제를 완료하였습니다");
		}
		return "redirect:/boardList.do";
	}
	
	
}