/* 로그인 서블릿 : HttpSession 객체 이용하기
 * => 특정 클라이언트 전용 HttpSession 보관소 준비하기
 *    - HttpServletRequest.getSession()
 * => getSession() 실행 과정
 *    1 만약 클라이언트가 쿠키로 세션아이디를 보냈다면,
 *      1.1) 마침 서블릿컨테이너에 그 세션아이디에 해당하는 HttpSession 객체가 있고
 *           그 HttpSession 객체가 유효하다면, 
 *           => 그 HttpSession 객체를 리턴한다.
 *      1.2) 마침 서블릿컨테이너에 그 세션아이디에 해당하는 HttpSession 객체가 있고
 *           그 HttpSession 객체가 무효하다면,
 *           => 새 HttpSession 객체를 만들어 리턴한다.
 *      2.3) 무효한 세션아이디라면,
 *           => 새 HttpSession 객체를 만들어 리턴한다.
 *    2. 만약 클라이언트가 쿠키로 세션아이디를 보내지 않았다면,
 *       => 새 HttpSession 객체를 만들어 리턴한다.
 * 
 * 
 */
package bitcamp.java93.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitcamp.java93.domain.Member;
import bitcamp.java93.service.TeacherService;

@WebServlet(urlPatterns="/auth/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher rd = req.getRequestDispatcher("/auth/form.jsp");
    rd.forward(req, resp);
  }
  
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String userType = req.getParameter("userType");
    String email = req.getParameter("email");
    String password = req.getParameter("password");
    
    try {
      Member member = null;
      if (userType.equals("teacher")) {
        TeacherService teacherService = 
            (TeacherService)this.getServletContext().getAttribute("teacherService");      
        member = teacherService.getByEmailPassword(email, password);
      }
      
      if (member != null) { // 로그인 성공!
        // HttpSession 객체 준비
        HttpSession session = req.getSession(); // 클라이언트를 위한 HttpSession 객체 준비.
        
        // HttpSession 보관소에 로그인 회원 정보를 저장한다.
        session.setAttribute("loginMember", member);
        
        // 이메일을 저장하거나 제거한다.
        String saveEmail = req.getParameter("saveEmail");
        if (saveEmail != null) { // 이메일 저장을 체크했다면,
          Cookie cookie2 = new Cookie("email", email);
          cookie2.setMaxAge(60 * 60 * 24 * 7); // 7일간 유지!
          res.addCookie(cookie2);
        } else {
          Cookie cookie2 = new Cookie("email", "");
          cookie2.setMaxAge(0); // 유효기간이 0이면 즉시 무효화된다. 즉 제거하라는 의미이다.
          res.addCookie(cookie2);
        }
        
        res.sendRedirect("../teacher/list");
        
      } else {
        RequestDispatcher rd = req.getRequestDispatcher("/auth/fail.jsp");
        rd.forward(req, res);
      }
      
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.forward(req, res);
      return;
    }
    
  }
}









