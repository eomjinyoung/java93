package bitcamp.java93.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;

@WebServlet(urlPatterns="/teacher/add")
public class TeacherAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    // 멀티파트 데이터 처리
    DiskFileItemFactory partFactory = new DiskFileItemFactory();
    ServletFileUpload partParser = new ServletFileUpload(partFactory);
    try {
      List<FileItem> partList = partParser.parseRequest(req);
      HashMap<String,FileItem> partMap = new HashMap<>();
      for (FileItem part : partList) {
        partMap.put(part.getFieldName(), part);
      }
    } catch (Exception e) {
      req.setAttribute("error", e); 
      RequestDispatcher rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    
    Teacher t = new Teacher();
    t.setName(req.getParameter("name"));
    t.setTel(req.getParameter("tel"));
    t.setEmail(req.getParameter("email"));
    t.setPassword(req.getParameter("password"));
    t.setHomepage(req.getParameter("homepage"));
    t.setFacebook(req.getParameter("facebook"));
    t.setTwitter(req.getParameter("twitter"));
    
    try {
      TeacherService teacherService = 
          (TeacherService)this.getServletContext().getAttribute("teacherService");   
      teacherService.add(t);
      
      res.sendRedirect("list");
      
    } catch (Exception e) {
      req.setAttribute("error", e); 
      RequestDispatcher rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    
  }
}









