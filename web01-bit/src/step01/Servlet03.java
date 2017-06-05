/* 웹 애플리케이션 컴포넌트 : 서블릿 만들기 III - HttpServlet 추상 클래스 상속 받기
 * => HttpServlet?
 *    - GenericServlet 클래스는 GET, POST, HEAD, PUT, DELETE 등의 요청을 구분하지 않고
 *      무조건 service() 호출한다.
 *    - HttpServlet은 클라이언트의 요청을 구분하여 
 *      내부에서 미리 추가한 메서드를 호출한다.
 *      GET     ---> doGet() 호출
 *      POST    ---> doPost() 호출
 *      HEAD    ---> doHead() 호출
 *      PUT     ---> doPut() 호출
 *      ....
 *      
 * => 개발자들은 HttpServlet을 상속 받을 때 뭘 오버라이딩 해야 하는가?
 *    - 해당 서블릿에 대해 어떤 Method를 처리하느냐에 따라
 *      오버라이딩 할 메서드가 결정된다.
 *    - 예를 들면
 *      클라이언트의 GET 요청만 처리하고 싶다면 doGet()을 오버라이딩 하고,
 *      클라이언트의 POST 요청만 처리하고 싶다면 doPost()를 오버라이딩 한다.
 *      만약 둘 다 처리하고 싶다면 doGet(), doPost() 모두 오버라이딩 하면 된다.
 *       
 * 
 * doGet(), doPost() 호출 테스트
 * => /WebContent/step01/Servlet03.html 로 GET 요청과 POST 요청을 실행한다.
 */
package step01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/step01/Servlet03")
public class Servlet03  extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Servlet03에 대해 GET 요청이 들어온다면,
    // 서블릿 컨테이너 
    //   ---> serivce(ServletRequest, ServletResponse) 호출
    //        ---> serivce(HttpServletRequest, HttpServletResponse) 호출
    //             ---> doGet(HttpServletRequest, HttpServletResponse) 호출
    System.out.println("Servlet03.doGet()");
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Servlet03에 대해 POST 요청이 들어온다면,
    // 서블릿 컨테이너 
    //   ---> serivce(ServletRequest, ServletResponse) 호출
    //        ---> serivce(HttpServletRequest, HttpServletResponse) 호출
    //             ---> doPost(HttpServletRequest, HttpServletResponse) 호출
    System.out.println("Servlet03.doPost()");
  }
}











