/* Spring WebMVC: 세션에 보관된 데이터 꺼내기 증명!
 * => 다른 페이지 컨트롤러에서 작업한 결과가 HttpSession 보관소에 저장되어 있다면,
 *    당연히 꺼내 볼 수 있다.
 */
package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/control/controller20/") 
public class Controller20 {
  
  @RequestMapping("ok1")
  public String ok1() throws Exception {
    return "controller20_ok1";
  }
  
  @RequestMapping("reset")
  public String reset(SessionStatus status) throws Exception {
    // setComplete()
    // => 현재 페이지 컨트롤러에서 @SessionAttributes 에 설정된 객체만 세션에서 제거한다.
    status.setComplete(); // 현재 페이지 컨트롤러에 @SessionAttributes가 없기 때문에 제거될 것도 없다.
    
    return "controller20_ok1";
  }
}









































