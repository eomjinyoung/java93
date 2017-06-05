/* service() 파라미터 : ServletResponse II - 한글 출력이 깨지는 현상 
 * => "서블릿 컨테이너"는 출력할 때 "2바이트 유니코드"를 
 *    "ISO-8859-1" 문자집합으로 인코딩하여 내보낸다.
 *    예) 
 *    => 서블릿에서 다루는 문자열,
 *       예)"ABC가각간" : 0041 0042 0043 AC00 AC01 AC04
 *    => 서블릿에서 문자열을 내 보낼 때, ISO-8859-1에 없는 글자는 '?'를 대신 내보낸다.
 *       예) ISO-8859-1 : 41 42 43 3F 3F 3F
 *           위의 코드를 출력해 보면: ABC???
 * => 해결책?
 *    - 서블릿 컨테이너에게 어떤 문자집합으로 인코딩해서 내보낼 것인지 알려줘라!
 *    - 예) res.setContentType("text/plain;charset=UTF-8"); 
 *    - 주의! 위의 메서드를 호출한 후에 출력 스트림을 꺼내야 한다.
 *      호출하기 전에 꺼내면 소용없다.
 */
package step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/step02/Servlet05")
public class Servlet05  extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    // 이렇게 출력스트림을 얻기 전에 먼저 호출해야 한다.
    res.setContentType("text/plain;charset=UTF-8");
    
    PrintWriter out = res.getWriter();
    
    // 출력 스트림을 얻은 후에 호출해 봐야 소용없다.
    //res.setContentType("text/plain;charset=UTF-8");
    
    out.println("Hello, world!");
    out.println("안녕하세요!");
  }
}









