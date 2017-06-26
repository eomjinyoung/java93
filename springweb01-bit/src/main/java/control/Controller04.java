/* Spring WebMVC: 요청 URL 계산하기 II
 * 요청 URL = class에 붙은 URL + 메서드에 붙은 URL 
 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller04/ok") 
public class Controller04 {
  
  @RequestMapping
  public void a(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("okok");
  }
  
  
  
}


















