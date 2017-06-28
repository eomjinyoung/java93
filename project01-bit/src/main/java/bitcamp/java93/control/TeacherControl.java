package bitcamp.java93.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;

@Controller
@RequestMapping("/teacher/")
public class TeacherControl {
  @Autowired
  TeacherService teacherService;
  
  @RequestMapping("list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo, 
      @RequestParam(defaultValue="5") int pageSize, 
      Model model) throws Exception {
    
    model.addAttribute("list", teacherService.list(pageNo, pageSize));
    
    return "teacher/list";
  }
}









