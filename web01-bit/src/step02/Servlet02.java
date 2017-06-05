/* service() 파라미터 : ServletRequest II - 파라미터 값 전달하고 받기 
 * => GET 요청으로 파라미터 값 전달하기
 *    - URL에 붙여 전달한다.
 *    - 예) http://localhost:8080/web01/step02/Servlet02?파라미터명=값&파라미터명=값
 * => POST 요청으로 파라미터 값 전달하기
 *    - message-body 에 붙인다.
 *    - 예)
 *      POST /step02/Servlet02 HTTP/1.1
 *      Host: ...
 *      User-Agent: ...
 *      
 *      파라미터명=값&파라미터명=값 
 *    
 * => 테스트
 *   - http://localhost:8080/web01/step02/Servlet02.html 
 *   
 * => 요청 방식에 상관없이 getParameter() 메서드를 사용하여 
 *    클라이언트가 보낸 값을 알아낼 수 있다. 
 */
package step02;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/step02/Servlet02")
public class Servlet02  extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.printf("parameter(name): %s\n", req.getParameter("name")); // name 파라미터 값
    System.out.printf("parameter(age): %s\n", req.getParameter("age")); // age 파라미터 값
  }
}









