/* Spring WebMVC: 클라이언트로부터 JSP를 감추기
 * => MVC 아키텍처에서는 요청을 처리할 때,
 *    페이지 컨트롤러가 Service, DAO와 협업하여 JSP가 출력할 데이터를 준비한다. 
 *    그런 후에 JSP로 포워딩시켜 출력을 완료한다.
 *    그러므로 MVC 아키텍처에서는 JSP를 그냥 실행시키는 것은 아무런 의미도 없다.
 * => 그래서 웹 브라우저가 JSP를 찾지 못하도록 WEB-INF 밑에 숨겨 둔다.   
 */
package control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller18/") 
public class Controller18 {
  
  @RequestMapping("ok1")
  public String ok1(Model model) throws Exception {
    Member member = new Member();
    member.setName("홍길동");
    member.setAge(20);
    member.setWorking(true);
    
    model.addAttribute("member", member);
    
    return "controller18_ok1";
  }

}









































