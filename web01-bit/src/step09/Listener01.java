/* 웹 애플리케이션 구성 요소 - ServletContextListener
 * 1) 서블릿
 *    - 클라이언트 요청 처리
 * 2) 필터
 *    - 요청 처리 전/후에 작업 수행
 * 3) 리스너 (= event handler)
 *    - 특정 상태(event)에 놓일 때 작업 수행
 *    
 * ServletContextListener?
 * - 웹 애플리케이션이 시작되거나 종료되는 상태에 대해 작업을 수행   
 *    
 * 리스너 배치하기
 * 1) web.xml에 등록하기
 * 
<listener>
  <listener-class>step09.Listener01</listener-class>
</listener>  
 *
 * 2) 애노테이션으로 등록하기
 *
@WebListener
 *
 */
package step09;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class Listener01 implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // ServletContext 객체가 생성되었을 때 호출된다.
    // 즉 웹 애플리케이션이 시작되었을 때 호출된다.
    System.out.println("====> Listener01.contextInitialized()");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    // ServletContext 객체가 소멸되기 직전에 호출된다.
    // 즉 웹 애플리케이션이 종료되기 직전에 호출된다.
    System.out.println("====> Listener01.contextDestroyed()");
  }

}









