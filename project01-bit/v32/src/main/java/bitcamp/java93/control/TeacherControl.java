package bitcamp.java93.control;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;

@Controller
@RequestMapping("/teacher/")
public class TeacherControl {
  
  @Autowired ServletContext servletContext;
  @Autowired TeacherService teacherService;
  
  @RequestMapping("list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo, 
      @RequestParam(defaultValue="5") int pageSize, 
      Model model) throws Exception {
    
    model.addAttribute("list", teacherService.list(pageNo, pageSize));
    
    return "teacher/list";
  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model) throws Exception {
    Teacher teacher = teacherService.get(no);
    if (teacher == null) {
      throw new Exception(no + "번 강사가 없습니다.");
    }
    model.addAttribute("teacher", teacher);
    return "teacher/detail";
  }
  
  @RequestMapping("update")
  public String update(Teacher teacher, MultipartFile[] photo) throws Exception {
    teacher.setPhotoList(processMultipartFiles(photo));
    teacherService.update(teacher);
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(int no) throws Exception {
    teacherService.remove(no);
    return "redirect:list.do";
  }  
  
  @RequestMapping("form")
  public void form() throws Exception {}

  @RequestMapping("add")
  public String add(Teacher teacher, MultipartFile[] photo) throws Exception {
    teacher.setPhotoList(processMultipartFiles(photo));
    teacherService.add(teacher);
    return "redirect:list.do";
  }  
  
  private List<String> processMultipartFiles(MultipartFile[] files) throws Exception {
    ArrayList<String> photoList = new ArrayList<>();
    for (MultipartFile file : files) {
      if (file.isEmpty())
        continue;
      String filename = getNewFilename();
      file.transferTo(new File(servletContext.getRealPath("/teacher/photo/" + filename)));
      photoList.add(filename);
    }
    return photoList;
  }
  
  
  int count = 0;
  synchronized private String getNewFilename() {
    if (count > 100) {
      count = 0;
    }
    return String.format("%d_%d", System.currentTimeMillis(), ++count); 
  }
}









