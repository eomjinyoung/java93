/* HttpServlet 추상 클래스를 상속받아 서블릿 만들기 III
 * => HttpServlet 추상 클래스에 추가한 doXxx() 메서드 오버라이딩
 *    요청
 *      --> Servlet.service(ServletRequest,ServletResponse)
 *          --> Servlet.service(HttpServletRequest,HttpServletResponse)
 *              --> doGet()
 *              --> doPost()
 *              --> doHead()
 *              --> doTrace()
 *              --> doDelete()
 *              ...
 * => /step11/test.html 로 테스트 하라!
 */
package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step11/Servlet03")
public class Servlet03 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("GET 요청입니다.");
  }
  
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("POST 요청입니다.");
  }
}








