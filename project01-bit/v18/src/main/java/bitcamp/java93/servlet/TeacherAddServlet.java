package bitcamp.java93.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.dao.TeacherDao;
import bitcamp.java93.domain.Teacher;

@WebServlet(urlPatterns="/teacher/add")
public class TeacherAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    Teacher t = new Teacher();
    t.setName(req.getParameter("name"));
    t.setTel(req.getParameter("tel"));
    t.setEmail(req.getParameter("email"));
    t.setPassword(req.getParameter("password"));
    t.setHomepage(req.getParameter("homepage"));
    t.setFacebook(req.getParameter("facebook"));
    t.setTwitter(req.getParameter("twitter"));
    
    try {
      MemberDao memberDao = (MemberDao)this.getServletContext().getAttribute("memberDao");
      memberDao.insert(t);
      
      TeacherDao teacherDao = (TeacherDao)this.getServletContext().getAttribute("teacherDao");
      teacherDao.insert(t);

      res.sendRedirect("list");
      
    } catch (Exception e) {
      req.setAttribute("error", e); 
      RequestDispatcher rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    
  }
}









