package bitcamp.java93.control;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import bitcamp.java93.domain.Member;
import bitcamp.java93.service.TeacherService;

@Controller
@RequestMapping("/auth/")
@SessionAttributes({"loginMember"})
public class AuthControl {
  @Autowired
  TeacherService teacherService;

  @RequestMapping(path="login", method=RequestMethod.GET)
  public void form() {
    // JSP URL을 리턴하지 않으면, 요청 URL을 JSP URL로 사용한다.
  }
  
  @RequestMapping(path="login", method=RequestMethod.POST)
  public String login(String userType, String email, String password, String saveEmail, 
      Model model, HttpServletResponse response) throws Exception {

    Member member = null;
    if (userType.equals("teacher")) {
      member = teacherService.getByEmailPassword(email, password);
    }
    
    if (member != null) { 
      model.addAttribute("loginMember", member);
      
      if (saveEmail != null) {
        Cookie cookie2 = new Cookie("email", email);
        cookie2.setMaxAge(60 * 60 * 24 * 7); 
        response.addCookie(cookie2);
      } else {
        Cookie cookie2 = new Cookie("email", "");
        cookie2.setMaxAge(0);
        response.addCookie(cookie2);
      }
      
      return "redirect:../teacher/list.do";
      
    } else {
      return "auth/fail";
    }
  }
  
  @RequestMapping("logout")
  public String logout(HttpSession session, SessionStatus status) throws Exception {
    status.setComplete();
    session.invalidate();  
    return "redirect:../auth/login.do";
  }
}









