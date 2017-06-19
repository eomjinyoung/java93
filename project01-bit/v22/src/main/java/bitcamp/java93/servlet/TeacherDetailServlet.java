package bitcamp.java93.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;

@WebServlet(urlPatterns="/teacher/detail")
public class TeacherDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
      int no = Integer.parseInt(req.getParameter("no"));

      TeacherService teacherService = 
          (TeacherService)this.getServletContext().getAttribute("teacherService");      
      Teacher teacher = teacherService.get(no);
      
      if (teacher == null) {
        throw new Exception(no + "번 강사가 없습니다.");
      }
      
      res.setContentType("text/html;charset=UTF-8");
      req.setAttribute("teacher", teacher);
      RequestDispatcher rd = req.getRequestDispatcher("/teacher/detail.jsp");
      rd.include(req, res);
      
    } catch (Exception e) {
      req.setAttribute("error", e); 
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.forward(req, res);
      return;
    }
    
  }
}









