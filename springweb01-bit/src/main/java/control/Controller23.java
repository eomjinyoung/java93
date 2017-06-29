/* Spring WebMVC: JSON 콘텐츠로 응답하기
 * => @Controller + @ResponseBody = @RestController
 */
package control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

//@Controller
@RestController
@RequestMapping("/control/controller23/") 
public class Controller23 {
  
  // JSON 데이터 내보내기
  
  // 1) @Controller + @ResponseBody를 사용한 방법
  @RequestMapping(path="ok1", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String ok1() throws Exception {
    Member member = new Member();
    member.setName("홍길동");
    member.setAge(20);
    member.setWorking(true);
    
    return new Gson().toJson(member);
  }

  // 2) @RestController를 사용한 방법
  @RequestMapping("ok2")
  public Member ok2() throws Exception {
    Member member = new Member();
    member.setName("홍길동");
    member.setAge(20);
    member.setWorking(true);
    
    return member;
  }
}









































