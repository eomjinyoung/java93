package bitcamp.java93.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.java93.service.TeacherService;

@Controller
public class TeacherDeleteControl {
  @Autowired
  TeacherService teacherService;
  
  @RequestMapping("/teacher/delete")
  public String service(HttpServletRequest req, HttpServletResponse res) throws Exception {
    int no = Integer.parseInt(req.getParameter("no"));
    teacherService.remove(no);
    return "redirect:list.do";
  }
}









