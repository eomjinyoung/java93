package bitcamp.java93.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;

@Component("/teacher/detail")
public class TeacherDetailControl implements Controller {
  @Autowired
  TeacherService teacherService;
  
  @Override
  public String service(HttpServletRequest req, HttpServletResponse res) throws Exception {
    int no = Integer.parseInt(req.getParameter("no"));
    Teacher teacher = teacherService.get(no);
    
    if (teacher == null) {
      throw new Exception(no + "번 강사가 없습니다.");
    }
    
    req.setAttribute("teacher", teacher);
    return "/teacher/detail.jsp";
  }
}









