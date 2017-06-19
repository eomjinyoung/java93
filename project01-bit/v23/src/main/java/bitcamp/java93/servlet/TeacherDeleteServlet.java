package bitcamp.java93.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.service.TeacherService;

@WebServlet(urlPatterns="/teacher/delete") 
public class TeacherDeleteServlet  extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
      int no = Integer.parseInt(req.getParameter("no"));

      TeacherService teacherService = 
          (TeacherService)this.getServletContext().getAttribute("teacherService");      
      teacherService.remove(no);
      
      req.setAttribute("view", "redirect:list.do");
      
    } catch (Exception e) {
      req.setAttribute("error", e); 
    }
  }
}









