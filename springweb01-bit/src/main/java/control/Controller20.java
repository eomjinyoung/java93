/* Spring WebMVC: 세션에 보관된 데이터 꺼내기 증명!
 * => 다른 페이지 컨트롤러에서 작업한 결과가 HttpSession 보관소에 저장되어 있다면,
 *    당연히 꺼내 볼 수 있다.
 */
package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller20/") 
public class Controller20 {
  
  @RequestMapping("ok1")
  public String ok1() throws Exception {
    return "controller20_ok1";
  }
}









































