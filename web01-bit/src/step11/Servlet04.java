/* HttpServlet 추상 클래스를 상속받아 서블릿 만들기 IV
 * => POST 요청만 처리하기
 * => HttpServlet 추상 클래스에 추가한 doPost() 메서드만 오버라이딩
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

@WebServlet("/step11/Servlet04")
public class Servlet04 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("POST 요청입니다.");
  }
}








