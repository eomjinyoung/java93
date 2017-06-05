/* service() 파라미터 : ServletResponse I - 출력하기 
 * => ServletResponse?
 *   - 응답에 관련된 작업을 다룰 수 있는 도구
 * => 클라이언트에게 출력하기
 *   1) getOutputStream()
 *      - 바이너리 값을 출력할 때 사용한다.
 *      - 즉 파일 다운로드를 수행하는 서블릿을 만들 때 사용한다.
 *   2) getWriter() : 텍스트 값을 출력할 때 사용한다.
 *      - Text나 HTML/CSS/JavaScript 등 텍스트를 출력할 때 사용한다.            
 */
package step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/step02/Servlet04")
public class Servlet04  extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    PrintWriter out = res.getWriter();
    out.println("Hello, world!");
    out.println("안녕하세요!");
  }
}









