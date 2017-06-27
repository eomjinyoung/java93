/* Spring WebMVC: Request Handler의 파라미터들 IV - 커스텀 프로퍼티 에디터 II 
 * => 커스텀 프로퍼티 에디터를 등록하는 방법
 * 1) 각각의 페이지 컨트롤러에 @InitBinder 애노테이션이 붙은 메서드를 만들기
 *    => Controller13.java 참고!
 *    @InitBinder
      protected void initBinder(WebDataBinder binder) {
          ...
      } 
      
 * 2) WebBindingInitializer 인터페이스를 구현한 클래스를 만들어 설정 파일에 등록하기
 *    => spring 2.5에서 사용하던 예전 방식
 *    => MyWebBindingInitializer.java 생성
 *    => application-context.xml 에 등록
 *    <bean class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
        <property name="cacheSeconds" value="0"/>
        <property name="webBindingInitializer">
            <bean class="control.MyWebBindingInitializer"/>
        </property>
      </bean>
      그리고 <mvc:annotation-driven/> 을 주석으로 막아라!
 *    
 * 3) 페이지 컨트롤러가 작업하기 전에 충고를 하는 클래스를 만들기 
 *    => spring 3.2 부터는 @ControlAdvice 가 붙은 클래스에 등록한다.
 *    => @ControlAdvice가 붙은 클래스를 만든다.
 *     
 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller14/") 
public class Controller14 {
  
  // 모든 페이지 컨트롤러가 사용할 프로퍼티 변환기 설치하기 
  @RequestMapping("ok1")
  public void ok1(
      String name, // @RequestParam을 붙이지 않으면, 기본이 선택 항목이다.
      java.util.Date date, 
      boolean working, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ok1()");
    out.println(name);
    out.println(date);
  }  
}


















