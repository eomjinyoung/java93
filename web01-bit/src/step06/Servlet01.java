/* 서블릿끼리 값을 공유하는 방법: ServletRequest 보관소 사용하기 
 * => 저장소를 이용하여 값을 공유할 수 있다.  
 * 1) ServletContext
 *    - 웹 애플리케이션 당 1개 존재
 *    - 웹 애플리케이션이 시작될 때 ServletContext 객체가 생성되고,
 *      웹 애플리케이션이 종료될 때 ServletContext 객체가 소멸된다.
 * 2) HttpSession
 *    - 클라이언트 당 1개 존재
 *    - 서버에 방문하면 서버로부터 세션ID를 발급받는다.
 *      세션 ID당 한 개의 HttpSession 객체가 존재한다.
 * 3) ServletRequest
 *    - 요청 때마다 생성되고 응답 후 제거됨
 *    - 포워드, 인클루드인 경우 ServletRequest를 공유하기 때문에
 *      포워드, 인클루드 하는 서블릿마다 ServletRequest를 만들지 않는다.
 * 4) PageContext 
 *    - JSP를 실행할 때마다 생성되고 실행된 후 제거됨.
 */
package step06;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/step06/Servlet01")
public class Servlet01 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    // ServletRequest 보관소에 값 저장하기
    req.setAttribute("v1", "hello");
    
    RequestDispatcher rd = req.getRequestDispatcher("/step06/Servlet02");
    rd.forward(req, res); 
  }
}









