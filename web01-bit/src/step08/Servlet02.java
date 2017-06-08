/* 웹 애플리케이션에서 사용할 자원을 준비하는 방법: 서블릿을 이용하기 I
 * => 클라이언트가 요청하지 않아도 웹 애플리케이션이 시작될 때 
 *    서블릿 객체를 자동 생성하는 방법
 *    1) web.xml DD 파일에 설정하는 방법
 *       <servlet>
 *         <servlet-name>...</servlet-name>
 *         <servlet-class>...</servlet-class>
 *         <load-on-startup>1</load-on-startup>
 *       </servlet>
 *    2) @WebServlet 애노테이션에 설정하는 방법
 *       @WebServlet(
 *          urlPatterns="...",
 *          loadOnStartup=1)
 * => <load-on-startup> 또는 loadOnStartup?
 *    - 웹 애플케이션이 시작될 때 자동으로 생성될 서블릿을 지정하는 방법이다.
 *    - 숫자는 생성되는 순서이다. 작은 값의 서블릿부터 먼저 생성한다.
 *    - 같은 값이 여러 개면 먼저 나온 순서대로 서블릿을 생성한다.
 *    - 이 태그나 속성이 붙지 않은 서블릿은 자동으로 생성되지 않는다.
 *      반드시 클라이언트의 요청이 있어야만 생성된다. 
 *    
 * => 자동 생성되는 서블릿의 경우 
 *    보통 직접 클라이언트에게 뭔가를 서비스하기 위해 만든 서블릿이 아니다.
 *    그래서 가능한 클라이언트가 직접 요청하지 못하도록 막아야 한다.
 *    방법은?
 *    URL을 지정하지 않는 것이다.
 */
package step08;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns="/step08/Servlet02", loadOnStartup=1)
public class Servlet02 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void init() throws ServletException {
    // Servlet 인터페이스의 init(ServletConfig) 메서드 대신에
    // 이 메서드를 오버라이딩 하라고 GenericServlet 클래스에서 제공해준다.
    // 개발자는 서블릿이 생성될 때 뭔가를 준비시키고 싶다면,
    // 오리지널 init(ServletConfig) 대신 이 메서드를 오버라이딩 하여 코드를 작성하라!
    System.out.println("=============> step08.Servlet02.init()");
    ServletContext sc = this.getServletContext();
    sc.setAttribute("v2", "hi");
  }
}









