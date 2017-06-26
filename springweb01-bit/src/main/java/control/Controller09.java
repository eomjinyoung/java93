/* Spring WebMVC: 요청 프로토콜의 Accept 헤더의 값에 따라 호출될 메서드 결정 
 * => Accept 요청 헤더?
 *    - 웹 브라우저가 웹 서버에게 요구하는 콘텐트의 타입을 가리킨다.
 * => 실행 방법
 *    http://localhost:8080/springweb01/controller09.html
 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller09/") 
public class Controller09 {
  
  // produces 의 의미?
  // => 이 메서드를 생산하는 콘텐트의 타입을 가리킨다.
  @RequestMapping(path="ok", produces="text/plain") 
  public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("text/plain 보냄!");
  }
  
  @RequestMapping(path="ok", produces="application/json")
  public void post(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("application/json 보냄!");
  }
  
}


















