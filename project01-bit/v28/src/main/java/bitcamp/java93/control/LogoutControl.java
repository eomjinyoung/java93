package bitcamp.java93.control;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutControl {
  @RequestMapping("/auth/logout")
  public String service(HttpServletRequest req, HttpServletResponse res) throws Exception {
    req.getSession().invalidate();  
    return "redirect:../auth/login.do";
  }
}









