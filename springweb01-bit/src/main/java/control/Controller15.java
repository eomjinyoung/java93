/* Spring WebMVC: Request Handler의 리턴 값 다루기 
 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/control/controller15/") 
public class Controller15 {
  
  // 1) void : 요청 핸들러에서 직접 출력하기 
  @RequestMapping("ok1")
  public void ok1(HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ok1(): 안녕하세요!");
  }
  
  // 2) String : 리턴 값을 클라이언트로 출력하기
  @RequestMapping(path="ok2", produces="text/plain;charset=UTF-8")
  @ResponseBody // <=== 리턴 값이 응답 데이터임을 표시하는 애노테이션 
                // 리턴 값을 바로 출력할 때는 @RequestMapping의 produces 속성을 이용하여 
                // 출력 내용의 타입과 인코딩을 지정한다.
  public String ok2() throws Exception {
    return "ok2(): 안녕하세요!";
  }  
  
  // 3) String : 리턴 값을 클라이언트로 출력하기
  @RequestMapping(path="ok3")
  @ResponseBody
  public String ok3(HttpServletResponse response) throws Exception {
    // @ResponseBody를 사용하여 리턴 값을 바로 클라이언트로 출력할 때는
    // 다음과 같이 UTF-8 처리를 지정할 수 없다.
    // 해결책? 위의 ok2() 메서드에서처럼 @RequestMapping의 produces 속성으로 지정해야 한다.
    response.setContentType("text/plain;charset=UTF-8"); // 기능이 먹지 않는다.
    
    return "ok3(): 안녕하세요!";
  }  
  
  // 4) String : JSP로 포워딩하기
  //    => @ResponseBody가 붙지 않으면 리턴 값을 JSP URL로 취급한다.
  @RequestMapping("ok4")
  public String ok4() throws Exception {
    //return "/controller15_ok4.jsp"; // InternalResourceViewResolver를 설정하기 전, OK!
                                    // InternalResourceViewResolver를 설정한 후, 오류 발생
                                    // 왜? 리턴 값 앞뒤에 문자열이 붙기 때문이다.
                                    // "/" + "/controller15_ok4.jsp" + ".jsp"
                                    // 그래서 최종 URL은 "/controller15_ok4.jsp.jsp" 이 된다.
    
    // InternalResourceViewResolver의 설정을 고려하여 리턴 값을 결정!
    return "controller15_ok4";      
  }  
  
  // 5) void : 클라이언트로 출력하지도 않고, JSP URL도 리턴하지 않으면
  //    => 현재 URL을 JSP URL로 사용한다.
  //    => 단 이럴 경우 스프링 설정 파일에 JSP를 어디에서 찾을 것인지 다음과 같이 지정해야 한다.
  /*       <bean id="jspViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
              <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
              <property name="prefix" value="/"/>
              <property name="suffix" value=".jsp"/>
           </bean>
   */
  @RequestMapping("ok5")
  public void ok5() throws Exception {
    System.out.println("ok5()");
  }  
  
  // 6) JSP URL을 ModelAndView 바구니에 담아 리턴하기
  @RequestMapping("ok6")
  public ModelAndView ok6() throws Exception {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("controller15_ok6");
    return mv;
  } 
  
  // 7) JSP URL과 JSP 사용할 데이터도 함께 ModelAndView 바구니에 담아 리턴하기
  @RequestMapping("ok7")
  public ModelAndView ok7() throws Exception {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("controller15_ok7");
    mv.addObject("title", "제목이네요!");
    
    Member member = new Member();
    member.setName("홍길동");
    member.setAge(20);
    member.setWorking(true);
    mv.addObject("member", member);
    
    /* 이렇게 ModelAndView 바구니에 값을 담아 두면,
     * 프론트 컨트롤러는 이 바구니에 담긴 값을 꺼내
     * JSP 가 사용할 수 있도록 ServletRequest 바구니에 옮겨 싣는다.
     */
    return mv;
  } 
}


















