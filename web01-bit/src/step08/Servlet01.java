/* 웹 애플리케이션에서 사용할 자원을 준비하는 방법: 서블릿을 이용하기 I
 * => 다른 서블릿을 실행하기 전에 자원을 준비시키는 서블릿을 먼저 실행하여 
 *    자원을 준비시키는 방법 
 * => 이 서블릿의 문제점?
 *    - init() 메서드에서 자원을 준비한다.
 *    - init() 메서드는 서블릿 객체가 생성할 때 호출된다.
 *    - 서블릿 객체는 클라이언트로부터 최소의 요청을 들어왔을 때 생성된다.
 *    - 클라이언트에서 요청하지 않으면 생성되지 않는다.
 *    - 생성되지 않으면, init() 호출되지 않는다.
 *    - 따라서 서버 운영자는 서버를 껐다가 켤 때 마다 이런 작업을 수행하는 서블릿을
 *      반드시 실행해야 하는 번거로움이 발생한다.
 * => 해결책?
 *    - Sevlet02를 보라!
 */
package step08;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/step08/Servlet01")
public class Servlet01 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void init() throws ServletException {
    // Servlet 인터페이스의 init(ServletConfig) 메서드 대신에
    // 이 메서드를 오버라이딩 하라고 GenericServlet 클래스에서 제공해준다.
    // 개발자는 서블릿이 생성될 때 뭔가를 준비시키고 싶다면,
    // 오리지널 init(ServletConfig) 대신 이 메서드를 오버라이딩 하여 코드를 작성하라!
    System.out.println("=============> step08.Servlet01.init()");
    ServletContext sc = this.getServletContext();
    sc.setAttribute("v1", "hello");
  }
  
  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    // 클라이언트가 요청할 때 마다 자원을 준비하는 것이 아니기 때문에
    // 이 메서드가 호출될 때 작업할 필요가 없다.
    System.out.println("=============> step08.Servlet01.service()");
  }
}









