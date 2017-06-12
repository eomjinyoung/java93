/* 로그아웃 서블릿 : ServletContext에서 로그인 회원 정보를 제거하고, 로그인 페이지로 보낸다.*/
package bitcamp.java93.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/auth/logout")
public class LogoutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    Cookie[] cookies = req.getCookies();
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("sessionId")) {
        this.getServletContext().removeAttribute(cookie.getValue());
        break;
      }
    }
    
    res.sendRedirect("../auth/login");
  }
}









