package bitcamp.java93.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java93.service.TeacherService;

@Component("/teacher/delete")
public class TeacherDeleteControl implements Controller {
  @Autowired
  TeacherService teacherService;
  
  @Override
  public String service(HttpServletRequest req, HttpServletResponse res) throws Exception {
    int no = Integer.parseInt(req.getParameter("no"));
    teacherService.remove(no);
    return "redirect:list.do";
  }
}









