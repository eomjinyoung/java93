import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* 이클립스 웹 프로젝트에서 서블릿 작성 및 배치하기
 * 1) javax.servlet.Servlet 인터페이스의 구현체를 작성한다.
 * 2) web.xml에 서블릿 정보를 등록한다.
 * 3) 웹애플리케이션 실행 환경에 이 프로젝트를 추가한다.
 * 4) 웹애플리케이션을 실행 환경에 배치한다.
 *    => "실행환경" 컨텍스트 메뉴 > publish 클릭
 *    => 또는 실행환경을 가동(start)시키면 자동으로 배치된다.
 * 5) 웹 브라우저에 다음과 같이 URL을 지정해 실행한다.
 *    => http://localhost:8080/web01/hello 
 *    
 * 서블릿 생명주기 메서드들
 * => init() 
 *   - 딱 한 번만 호출된다.
 *   - 서블릿 컨테이너가 서블릿 객체를 생성한 후 호출한다.
 *   - 서블릿이 작업하는데 필요한 자원을 준비시키는 코드를 넣는다.
 * => destroy()
 *   - 딱 한 번만 호출된다.
 *   - 웹 애플리케이션의 실행이 멈출 때,
 *     서블릿을 사용한 자원을 초기화시킬 수 있도록 이 메서드를 호출한다.
 *   - 서블릿이 사용한 자원을 초기화시키는 코드를 넣는다.
 * => service()
 *   - 해당 서블릿에 대해 요청이 들어올 때 마다 호출된다.
 *   - 클라이언트가 요청한 작업을 처리하는 코드를 넣는다. 
 *     
 * 웹 애플리케이션이 사용하는 라이브러리의 배치
 * => 웹 애플리케이션이 참조하는 라이브러리는 
 *    $tmp/wtpwebapps/web01/WEB-INF/lib/ 폴더에 복사된다.
 * => 즉 build.gradle의 dependencies {} 블록에 지정된 라이브러리 파일들이
 *    .../lib/ 폴더에 복사된다는 것이다.
 * => 주의!
 *    - "servlet-api" 라이브러리는 당연히 서블릿 컨테이너에 포함되어 있다.
 *    - 따라서 배치할 필요가 없다.
 *    - 단지 서블릿을 만들 때 컴파일 단계에서만 사용하면 된다.
 *    - 그럼, 배치에서 제외하는 방법이 있는가?
 *      dependencies {} 블록에 라이브러리 정보를 등록할 때,
 *      "compile" 명령 대신 "providedCompile" 명령을 사용하라!  
 *      
 * javax.servlet.Servlet 인터페이스
 * => 서블릿 컨테이너가 클라이언트 요청을 처리하기 위해 
 *    객체에 대해 호출하는 메서드의 규칙!
 * => 클라이언트 요청을 처리하는 클래스를 만들 때는 
 *    반드시 이 규칙에 따라 만들어야 한다.
 * => 이 규칙에 따라 만든 클래스를 "서블릿"이라 부른다.     
 */
public class HelloServlet implements Servlet {
  public HelloServlet() {
    System.out.println("HelloServlet()");
  }
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("init()");
    
  }

  @Override
  public ServletConfig getServletConfig() {
    System.out.println("getServletConfig()");
    return null;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("service()");
    
  }

  @Override
  public String getServletInfo() {
    System.out.println("getServletInfo()");
    return null;
  }

  @Override
  public void destroy() {
    System.out.println("destroy()");
    
  }

}
