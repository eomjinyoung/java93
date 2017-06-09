/* 웹 애플리케이션 구성 요소 - ServletRequestAttributeListener
 * 1) 서블릿
 *    - 클라이언트 요청 처리
 * 2) 필터
 *    - 요청 처리 전/후에 작업 수행
 * 3) 리스너 (= event handler)
 *    - 특정 상태(event)에 놓일 때 작업 수행
 *    
 * ServletRequestAttributeListener?
 * - ServletRequest 보관소에 값을 추가하거나 변경, 삭제할 때 작업 수행    
 *    
 * 리스너 배치하기
 * 1) web.xml에 등록하기
 * 
<listener>
  <listener-class>step09.Listener03</listener-class>
</listener>  
 *
 * 2) 애노테이션으로 등록하기
 *
@WebListener
 *
 */
package step09;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class Listener03 implements ServletRequestAttributeListener {
  
  @Override
  public void attributeAdded(ServletRequestAttributeEvent sce) {
    // ServletRequest 객체에 값을 저장할 때 호출된다.
    // 즉 req.setAttribute(...) 호출할 때
    System.out.printf("====> Listener03.attributeAdded(): %s=%s\n", 
        sce.getName(), sce.getValue());
  }

  @Override
  public void attributeRemoved(ServletRequestAttributeEvent sce) {
    // ServletRequest 객체에서 값을 제거할 때 호출된다.
    System.out.println("====> Listener03.attributeRemoved()");
  }
  
  @Override
  public void attributeReplaced(ServletRequestAttributeEvent sce) {
    // ServletRequest 객체에 저장된 값을 변경할 때 호출된다.
    System.out.println("====> Listener03.attributeReplaced()");
  }

}









