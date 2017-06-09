/* 웹 애플리케이션 구성 요소 - Filter
 * 1) 서블릿
 *    - 클라이언트 요청 처리
 * 2) 필터
 *    - 요청 처리 전/후에 작업 수행
 * 3) 리스너 (= event handler)
 *    - 특정 상태(event)에 놓일 때 작업 수행
 *    
 * Filter?
 * - 요청이 들어왔을 때 서블릿에 전달하기 전에 작업을 수행
 * - 서블릿이 요청을 처리한 후에 작업을 수행 
 * - 응용 분야
 *   => 클라이언트가 보낸 데이터를 서블릿이 처리하기 전에 
 *   예1) 압축 해제시키기    
 *   예2) 암호해제 시키기
 *   예3) 로그인 여부 검사하기
 *   예4) 서블릿 요청 기록(로그) 남기기
 *   예5) 서블릿이 원하는 형식으로 요청 데이터를 가공하기
 *   예6) 서블릿을 실행하기 전에 반드시 수행해야 하는 공통 작업
 *   등등...
 *   
 *   => 서블릿이 작업을 수행한 후 응답하기 전에
 *   예1) 압축하기
 *   예2) 암호화시키기
 *   예3) 로그 남기기
 *   예4) 클라이언트가 원하는 특정 형식(XML, PDF, Excel, GIF 등)으로 변환시키기 
 *   등등...
 *   
 * 리스너 배치하기
 * 1) web.xml에 등록하기
 * 
<!-- 1) 필터 클래스 등록 -->
  <filter>
    <filter-name>step10.Filter01</filter-name>
    <filter-class>step10.Filter01</filter-class>
  </filter>
<!-- 2) 필터 클래스에 URL 적용 -->  
  <filter-mapping>
    <filter-name>step10.Filter01</filter-name>
    <url-pattern>/step10/*</url-pattern>
  </filter-mapping>  
 *
 * 2) 애노테이션으로 등록하기
 *
@WebFilter(urlPatterns="/step10/*")
 *
 */
package step10;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns="/step10/*")
public class Filter01 implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // 필터 객체가 생성될 때 호출된다.
    // 웹 애플리케이션이 시작된 후 딱 한 번만 호출된다. 
    // 필터가 작업을 하는데 필요한 자원을 준비시키는 코드를 여기에 둔다.
    System.out.println("######### Filter01.init() ##########");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // 필터가 적용될 때 마다 호출된다.
    System.out.println("Filter01.doFilter() 시작 -------------");
    
    // 이 메서드에서 다음 필터를 실행해야 한다. 그래야 서블릿까지 실행될 수 있다.
    // chain 객체에 대해 doFilter()를 호출하면,
    // => 다음 필터가 있다면 그 필터를 실행하고,
    // => 다음 필터가 없다면 최종 목적지인 서블릿으로 보낸다.
    chain.doFilter(request, response);
    
    // 서블릿까지 실행을 완료한 후 리턴된다.
    System.out.println("------------ Filter01.doFilter() 끝!");
    
  }

  @Override
  public void destroy() {
    // 필터 객체가 소멸될 때 호출된다.
    // 웹 애플리케이션이 종료되기 전에 딱 한 번만 호출된다.
    // init()에서 준비한 자원을 해제시키는 코드를 여기에 둔다.
    System.out.println("######### Filter01.destroy() ##########");
  }

}











