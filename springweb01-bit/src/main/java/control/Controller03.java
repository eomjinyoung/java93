/* Spring WebMVC: 요청 URL 계산하기
 * 요청 URL = class에 붙은 URL + 메서드에 붙은 URL 
 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller03/") 
public class Controller03 {
  
  @RequestMapping("a") // ==> /control/controller03/a
  public void a(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("aaaa");
  }
  
  @RequestMapping("b") 
  public void b(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("bbbb");
  }
  
  @RequestMapping("c") 
  public void c(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("cccc");
  }

}


















