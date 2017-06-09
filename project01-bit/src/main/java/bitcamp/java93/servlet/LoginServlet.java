/* 로그인 서블릿 */
package bitcamp.java93.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.domain.Member;

@WebServlet(urlPatterns="/auth/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String email = req.getParameter("email");
    String password = req.getParameter("password");
    
    try {
      MemberDao memberDao = (MemberDao)this.getServletContext().getAttribute("memberDao");      
      Member member = memberDao.selectOneByEmailPassword(email, password);
      if (member != null) { // 로그인 성공!
        res.sendRedirect("../member/list");
        return;
      }
      
      res.setHeader("Refresh", "2;url=login.html");
      res.setContentType("text/html;charset=UTF-8");
      PrintWriter out = res.getWriter();
      
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("  <meta charset='UTF-8'>");
      out.println("  <title>로그인</title>");
      
      RequestDispatcher rd = req.getRequestDispatcher("/style/core");
      rd.include(req, res);
      
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>로그인 오류!</h1>");
      out.println("<p>이메일 또는 암호가 맞지 않습니다.</p>");

      rd = req.getRequestDispatcher("/footer");
      rd.include(req, res);
      
      out.println("</body>");
      out.println("</html>");
      
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    
  }
}









