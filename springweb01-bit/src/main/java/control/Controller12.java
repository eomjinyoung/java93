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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/control/controller12/") 
public class Controller12 {
  
  // 클라이언트가 보낸 파라미터 값을 받는 방법
  
  // 1) 보내는 데이터(요청 파라미터)의 이름과 같은 이름으로 아규먼트 이름을 짓는다.
  @RequestMapping("ok1")
  public void ok1(String name, int age, boolean working, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ok1()");
    out.printf("name: %s\n", name);
    out.printf("age: %d\n", age);
    out.printf("working: %b\n", working);
  }
  
  // 2) 보내는 데이터(요청 파라미터)의 이름과 아규먼트 이름이 다를 경우
  //    @RequestParam 애노테이션을 사용하여 그 이름을 지정할 수 있다.
  //    단, @RequestParam을 붙이는 순간 필수 항목이 된다.
  @RequestMapping("ok2")
  public void ok2(
      @RequestParam(name="name") String n, 
      @RequestParam(name="age") int a, 
      @RequestParam(name="working") boolean w, 
      HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ok2()");
    out.printf("name: %s\n", n);
    out.printf("age: %d\n", a);
    out.printf("working: %b\n", w);
  }
  
  // 3) @RequestParam 애노테이션에서 요청 파라미터 값을 선택 항목으로 만들기
  @RequestMapping("ok3")
  public void ok3(
      @RequestParam(name="name", required=false) String n, 
      @RequestParam(name="age", required=false) int a, 
      @RequestParam(name="working", required=false) boolean w, 
      HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ok3()");
    out.printf("name: %s\n", n);
    out.printf("age: %d\n", a);
    out.printf("working: %b\n", w);
  }  

  // 4) @RequestParam 애노테이션에서 요청 파라미터의 기본 값 지정하기
  @RequestMapping("ok4")
  public void ok4(
      @RequestParam(name="name", required=false) String n, 
      @RequestParam(name="age", required=false, defaultValue="0") int a, 
      @RequestParam(name="working", required=false, defaultValue="false") boolean w, 
      HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ok4()");
    out.printf("name: %s\n", n);
    out.printf("age: %d\n", a);
    out.printf("working: %b\n", w);
  }
  
  // 5) 요청 파라미터 값을 바로 값 객체(Value Object; VO)에 저장하기  
  //    VO 객체의 프로퍼티 이름과 일치하는 요청 파라미터를 찾아서 그 값을 넣어준다.
  //    누가? 프론트 컨트롤러가 Member 객체를 생성한 다음에 값을 넣어준다.
  //    
  @RequestMapping("ok5")
  public void ok5(Member member, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ok5()");
    out.printf("name: %s\n", member.getName());
    out.printf("age: %d\n", member.getAge());
    out.printf("working: %b\n", member.isWorking());
  }  
}


















