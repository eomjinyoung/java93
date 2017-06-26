/* Spring WebMVC: 파라미터의 존재 유무로 요청을 구분한다. 
 * => @RequestMapping의 params 속성에 지정한 값과 일치하는 
 *    요청 파라미터가 있을 경우에 호출된다.
 * => 실행 방법
 *    http://localhost:8080/springweb01/control/controller07.do?name=okok
 *    http://localhost:8080/springweb01/control/controller07.do?age=20&tel=1111
 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller07/") 
public class Controller07 {
  
  @RequestMapping(path="ok", params="name") 
  public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("name 있어요!");
  }
  
  @RequestMapping(path="ok", params={"age","tel"})
  public void post(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("age와 tel 있어요!");
  }
  
}


















