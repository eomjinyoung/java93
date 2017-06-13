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
import bitcamp.java93.dao.TeacherDao;

@WebServlet(urlPatterns="/teacher/delete") 
public class TeacherDeleteServlet  extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>강사관리</title>");
    
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
        
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강사 삭제</h1>");
    
    try {
      int no = Integer.parseInt(req.getParameter("no"));

      TeacherDao teacherDao = (TeacherDao)this.getServletContext().getAttribute("teacherDao");
      int count = teacherDao.delete(no);
      if (count < 1) {
        throw new Exception(no + "번 강사를 찾을 수 없습니다.");
      }
      
      try {
        MemberDao memberDao = (MemberDao)this.getServletContext().getAttribute("memberDao");      
        count = memberDao.delete(no);
      } catch (Exception e) {}
      
      out.println("<p>삭제 성공입니다.</p>");
      
      res.setHeader("Refresh", "1;url=list");
      
    } catch (Exception e) {
      req.setAttribute("error", e); 
      rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    
    rd = req.getRequestDispatcher("/footer");
    rd.include(req, res);
    
    out.println("</body>");
    out.println("</html>");
  }
}









