/* 화면 전환하기 : Refresh 헤더를 이용한 화면 전환
 * => 화면을 전환한다는 것은 웹 브라우저가 웹 서버에게 다시 요청한다는 의미다.
 * => 리프래시(refresh)?
 *    특정 시간이 지나면(timeout) 지정된 URL을 웹서버에게 다시 요청하는 기법.
 * => 리프래시 방법?
 *    1) 응답 헤더에 추가하기
 *       예) Refresh: 1;url=Servlet02
 *    2) HTML 문서에 삽입하기 
 *       예) <html>
 *             <head>
 *               <meta http-equiv="Refresh" content="1;url=Servlet02">
 *             ...
 */
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/step04/Servlet01")
public class Servlet01  extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    // 응답할 때 HTTP 프로토콜에 따라 Refresh 헤더를 붙이고 싶다.
    // 그런데, ServletResponse 도구에는 HTTP 응답 헤더를 추가시키는 기능이 없다.
    // 비밀!
    // 만약 서블릿 컨테이너가 웹서버와 연동한다면, (거의 대부분 웹서버와 연동한다)
    // service() 메서드의 파라미터로 ServletRequest의 서브 구현체인 HttpServletRequest,
    // ServletResponse의 서브 구현체인 HttpServletResponse 객체가 넘어온다.
    HttpServletRequest httpReq = (HttpServletRequest) req;
    HttpServletResponse httpRes = (HttpServletResponse) res;

    if (req.getParameter("page") == null) {
      // 웹브라우저에게 명령을 내린다.
      // => Servlet01이 보낸 결과를 화면에 출력한 후,
      //    1초 후에 다시 웹서버에게 "Servlet01/a" URL을 요청하라는 명령이다. 
      httpRes.setHeader("Refresh", "1;url=Servlet01/a");
    
    } else if (req.getParameter("page").equals("b")) {
      httpRes.setHeader("Refresh", "1;url=Servlet01/b");
    }
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>리프래시</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>화면1</h1>");
    out.println("</body>");
    out.println("</html>");
  }
}









