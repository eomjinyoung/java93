/* Spring WebMVC: 필터 다루기
 * => 어떤 작업을 시작하기 전이나 후에 뭔가를 실행하고 싶을 때 사용하는 기술이 필터이다.
 * => 필터의 종류
 * 1) Servlet 기술에서 제공하는 필터 
 *    - javax.servlet.Filter 구현체
 *      => 서블릿 실행 전, 후에 뭔가를 삽입하는 기술. 
 * 2) Spring에서 제공하는 필터
 *    - 인터셉터: 
 *      => 페이지 컨트롤러 실행 전, 후에 뭔가를 삽입하고 싶을 때 사용한다.
 *      => MyInterceptor.java 작성
 *      => application-context.xml 에 인터셉터 관련 태그 추가
  <mvc:interceptors>
<!--  
    <bean class="control.MyInterceptor"/>
-->
<!--  
    <mvc:interceptor>
        <mvc:mapping path="/control/controller22/list.do"/>
        <mvc:mapping path="/control/controller22/insert.do"/>
        <bean class="control.MyInterceptor"/>
    </mvc:interceptor>
-->
    <mvc:interceptor>
        <mvc:mapping path="/control/controller22/**"/>
        <mvc:exclude-mapping path="/control/controller22/delete.do"/>
        <mvc:exclude-mapping path="/control/controller22/detail.do"/>
        <bean class="control.MyInterceptor"/>
    </mvc:interceptor>
  </mvc:interceptors>
  
 *    - AOP(Aspect-Oriented Programming) 객체: 
 *      => 페이지 컨트롤러 뿐만 아니라 모든 객체의 메서드 호출 전, 후에 뭔가를 삽입하는 기술!
 *      => MyAdvice.java 작성
 *      => application-context.xml 에 AOP 관련 태그 추가
<aop:aspectj-autoproxy/>
        => AOP 라이브러리 추가 
           - 'aspectjweaver' 라이브러리 추가
 */
package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller22/") 
public class Controller22 {
  
  @Autowired MyService service;
  
  @RequestMapping("list")
  public String list(Model model) throws Exception {
    System.out.println("  Controller22.list() ===>");
    service.list();
    System.out.println("  <=== Controller22.list()");
    return "controller22_list";
  }
  
  @RequestMapping("detail")
  public String detail(Model model) throws Exception {
    System.out.println("  Controller22.detail() ===>");
    service.detail();
    System.out.println("  <=== Controller22.detail()");
    return "controller22_detail";
  }
  
  @RequestMapping("insert")
  public String insert(Model model) throws Exception {
    System.out.println("  Controller22.insert() ===>");
    service.insert();
    System.out.println("  <=== Controller22.insert()");
    return "controller22_insert";
  }  

  @RequestMapping("update")
  public String update(Model model) throws Exception {
    System.out.println("  Controller22.update() ===>");
    service.update();
    System.out.println("  <=== Controller22.update()");
    return "controller22_update";
  }
  
  @RequestMapping("delete")
  public String delete(Model model) throws Exception {
    System.out.println("  Controller22.delete() ===>");
    service.delete();
    System.out.println("  <=== Controller22.delete()");
    return "controller22_delete";
  }  
}









































