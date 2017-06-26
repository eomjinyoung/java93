/* Spring WebMVC: 요청 프로토콜의 헤더 이름을 요청 조건으로 지정 
 * => HTTP 요청 프로토콜에 지정한 이름의 헤더가 있을 경우에 호출된다.
 * => 실행 방법
 *    http://localhost:8080/springweb01/controller08.html
 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller08/") 
public class Controller08 {
  
  @RequestMapping(path="ok", headers="aaaa") 
  public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("aaaa 헤더 있어요!");
  }
  
  @RequestMapping(path="ok", headers={"bbbb","cccc"})
  public void post(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("bbbb, cccc 헤더 있어요!");
  }
  
}


















