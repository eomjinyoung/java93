/* Spring WebMVC: 파일 업로드 처리하기 
 * => <input type="file"> 로 보낸 값을 받으려면,
 *    멀티파트 인코딩 값을 처리하는 객체를 스프링에 등록해야 한다.
 *    
 * => application-context.xml 파일에 멀티파트 요청 데이터를 처리할 객체를 등록하라!
<bean id="multipartResolver"
        class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
  <!-- 각 파일의 최대 크기(byte)를 지정할 수 있다. -->
  <property name="maxUploadSize" value="10000000"/>
</bean>
 */
package control;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/control/controller16/") 
public class Controller16 {
  
  // ServletContext 객체는 Request Handler의 아규먼트로 받을 수 없다.
  // 대신에 주입시켜 달라고 요청하라!
  @Autowired ServletContext servletContext;
  
  // 1) 업로드 파일 받기 
  //    => controller16_ok1_form.html 에서 요청할 것!
  @RequestMapping("ok1")
  @ResponseBody
  public String ok1(String name, int age, MultipartFile file1, MultipartFile file2) throws Exception {
    System.out.println(name);
    System.out.println(age);
    
    // 클라이언트가 파일을 보내지 않아도 MultipartFile 객체는 생성되어 넘어온다.
    // 즉 파일을 보내지 않아다고 해서 null 값이 넘어오는 것은 아니다.
    // 그럼, 파일을 보냈는지 아닌지 어떻게 아는가? 파일의 크기가 0인지 따져봐라!
    System.out.println(file1);
    System.out.println(file2);
    System.out.println("---------------------------------");
    return "controller16_ok1";
  }

  // 2) 업로드 파일 정보 출력하기 
  //    => controller16_ok2_form.html 에서 요청할 것!
  @RequestMapping("ok2")
  @ResponseBody
  public String ok2(String name, int age, MultipartFile file1, MultipartFile file2) throws Exception {
    System.out.println(name);
    System.out.println(age);
    
    if (!file1.isEmpty()) { // 파일이 넘어 왔다면, 파일 정보를 출력한다.
      System.out.println("----------------------------------");
      System.out.printf("파일명: %s\n", file1.getOriginalFilename());
      System.out.printf("임시 파일명: %s\n", file1.getName());
      System.out.printf("파일 크기: %d\n", file1.getSize());
      System.out.printf("파일 형식: %s\n", file1.getContentType());
    }
    
    if (!file2.isEmpty()) { // 파일이 넘어 왔다면, 파일 정보를 출력한다.
      System.out.println("----------------------------------");
      System.out.printf("파일명: %s\n", file2.getOriginalFilename());
      System.out.printf("파라미터명: %s\n", file2.getName());
      System.out.printf("파일 크기: %d\n", file2.getSize());
      System.out.printf("파일 형식: %s\n", file2.getContentType());
    }
    
    return "controller16_ok2";
  }
  
  // 2) 업로드 파일 저장하기 
  //    => controller16_ok3_form.html 에서 요청할 것!
  @RequestMapping("ok3")
  public String ok3(String name, int age, MultipartFile file1, MultipartFile file2, Model model) throws Exception {
    
    model.addAttribute("name", name);
    model.addAttribute("age", age);
    
    if (!file1.isEmpty()) { // 파일이 넘어 왔다면, 파일을 저장한다.
      String filename = getNewFilename();
      model.addAttribute("file1", filename); // 저장된 파일명을 JSP가 알 수 있도록 Model에 담는다.
      
      file1.transferTo(new File(
          servletContext.getRealPath("/upload/" + filename)));
    }
    
    if (!file2.isEmpty()) { // 파일이 넘어 왔다면, 파일을 저장한다.
      String filename = getNewFilename();
      model.addAttribute("file2", filename); // 저장된 파일명을 JSP가 알 수 있도록 Model에 담는다.
      
      file2.transferTo(new File(
          servletContext.getRealPath("/upload/" + filename)));
    }
    
    return "controller16_ok3";
  } 
  
  int count = 0;
  synchronized private String getNewFilename() {
    if (count > 100) {
      count = 0;
    }
    return String.format("%d_%d", System.currentTimeMillis(), ++count); 
  }
}









































