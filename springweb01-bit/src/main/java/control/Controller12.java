/* Spring WebMVC: Request Handler의 파라미터들 II - @RequestParam
 * => 프론트 컨트롤러는 페이지 컨트롤러의 메서드를 호출할 때,
 *    그 메서드가 어떤 파라미터 값을 요구하는 분석하여
 *    그에 해당하는 값을 자동으로 꼽아준다. 
 * => Request Handler의 파라미터로 선언할 수 있는 것
 *    1) HttpServletRequest, ServletRequest
 *    2) HttpServletResponse, ServletResponse
 *    3) HttpSession
 *    4) Map, Model 
 *    5) 요청 파라미터 
 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller12/") 
public class Controller12 {
  
  // 클라이언트가 보낸 파라미터 값을 받는 방법
  
  // 1) 보내는 데이터(요청 파라미터)의 이름과 같은 이름으로 아규먼트 이름을 짓는다.
  @RequestMapping("ok1")
  public void ok1(String name, int age, boolean working, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ok10()");
    out.printf("name: %s\n", name);
    out.printf("age: %d\n", age);
    out.printf("working: %b\n", working);
  }
  
}


















