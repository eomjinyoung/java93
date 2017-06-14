package bitcamp.java93.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;
import bitcamp.java93.util.MultipartFormDataProcessor;

@WebServlet(urlPatterns="/teacher/update") 
public class TeacherUpdateServlet  extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
      Map<String,FileItem> partMap = MultipartFormDataProcessor.parse(req);
      
      Teacher t = new Teacher();
      t.setNo(Integer.parseInt(partMap.get("no").getString()));
      t.setName(partMap.get("name").getString("UTF-8"));
      t.setTel(partMap.get("tel").getString("UTF-8"));
      t.setEmail(partMap.get("email").getString("UTF-8"));
      t.setPassword(partMap.get("password").getString("UTF-8"));
      t.setHomepage(partMap.get("homepage").getString("UTF-8"));
      t.setFacebook(partMap.get("facebook").getString("UTF-8"));
      t.setTwitter(partMap.get("twitter").getString("UTF-8"));
      
      // 사진 데이터 처리
      ArrayList<String> photoList = new ArrayList<>();
      for (int i = 1; i <= 3; i++) {
        FileItem fileItem = partMap.get("photo" + i);
        if (fileItem.getSize() > 0) { // 파일이 업로드 된 경우
          File file = new File(this.getServletContext().getRealPath(
              "/teacher/photo/" + fileItem.getName()));
          fileItem.write(file);
          photoList.add(fileItem.getName());
        }
      }
      
      t.setPhotoList(photoList); // 업로드 한 사진 파일명을 저장한다.
    
      TeacherService teacherService = 
          (TeacherService)this.getServletContext().getAttribute("teacherService");
      teacherService.update(t);
    
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
      out.println("<p>변경 성공입니다.</p>");
      rd = req.getRequestDispatcher("/footer");
      rd.include(req, res);
      out.println("</body>");
      out.println("</html>");
      
      res.setHeader("Refresh", "1;url=list");
      
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
  }
}









