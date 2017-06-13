package bitcamp.java93.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;

@WebServlet(urlPatterns="/teacher/update") 
public class TeacherUpdateServlet  extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    Teacher t = new Teacher();
    t.setNo(Integer.parseInt(req.getParameter("no")));
    t.setName(req.getParameter("name"));
    t.setTel(req.getParameter("tel"));
    t.setEmail(req.getParameter("email"));
    t.setPassword(req.getParameter("password"));
    t.setHomepage(req.getParameter("homepage"));
    t.setFacebook(req.getParameter("facebook"));
    t.setTwitter(req.getParameter("twitter"));
    
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
    out.println("<h1>강사 변경</h1>");
    
    try {
      TeacherService teacherService = 
          (TeacherService)this.getServletContext().getAttribute("teacherService");
      teacherService.update(t);
      
      out.println("<p>변경 성공입니다.</p>");
      
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









