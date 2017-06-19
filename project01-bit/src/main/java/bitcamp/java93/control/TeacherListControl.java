package bitcamp.java93.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.annotation.Component;
import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;

@Component("/teacher/list")
public class TeacherListControl implements Controller {
  TeacherService teacherService;
  
  public void setTeacherService(TeacherService teacherService) {
    this.teacherService = teacherService;
  }

  @Override
  public String service(HttpServletRequest req, HttpServletResponse res) throws Exception {
    int pageNo = 1;
    int pageSize = 5;
    
    try { 
      pageNo = Integer.parseInt(req.getParameter("pageNo"));
    } catch (Exception e) {}
    
    try { 
      pageSize = Integer.parseInt(req.getParameter("pageSize"));
    } catch (Exception e) {}
    
    List<Teacher> list = teacherService.list(pageNo, pageSize);
    req.setAttribute("list", list);
    
    return "/teacher/list.jsp";
  }
}









