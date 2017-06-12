package bitcamp.java93.servlet;
/* 페이지 상단의 정보를 출력하는 서블릿*/


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.domain.Member;

@WebServlet(urlPatterns="/header") 
public class HeaderServlet  extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter out = res.getWriter();
    
    out.println("<div class='header'>");
    out.println("  <div id='logo'>비트캠프</div>");
    out.println("  <div id='login'>");
    //out.println("  <a href='/project01/auth/login.html'>로그인</a>");
    Member loginMember = (Member)req.getAttribute("loginMember");
    if (loginMember != null) {
      out.printf("%s(%s)\n", loginMember.getName(), loginMember.getEmail());
      out.printf("  <a href='%s/auth/logout'>로그아웃</a>\n", req.getContextPath());
    }
    out.println("  </div> ");
    out.println("</div>");
  }
}









