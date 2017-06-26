/* Spring WebMVC: 요청 프로토콜의 Content-Type 헤더 값에 따라 호출될 메서드 결정 
 * => Content-Type 요청 헤더?
 *    - 웹 브라우저가 웹 서버에게 보내는 데이터의 형식을 의미한다.
 * => 실행 방법
 *    http://localhost:8080/springweb01/controller10.html
 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller10/") 
public class Controller10 {
  
  // consumes 의 의미?
  // => 클라이언트가 보낸 데이터의 형식 중에서 이 메서드가 처리할 수 있는 형식을 지정. 
  @RequestMapping(path="ok", consumes="text/plain") 
  public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("text/plain 데이터를 받아서 처리했음!");
  }
  
  @RequestMapping(path="ok", consumes="application/json")
  public void post(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("application/json 데이터를 맏아서 처리했음!");
  }
  
}


















