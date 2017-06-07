/* 작업을 나눠서 처리하기 : 포워딩
 * 1) 포워딩(forwarding)
 *    - 실행을 완전히 위임한다.
 * 2) 인클루딩(including)
 *    - 잠시 실행을 위임한 후 작업이 끝나면 다시 돌아온다. 
 */
package step05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/step05/Servlet01/multiple")
public class Servlet01_multiple extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>포워딩</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>곱하기 결과</h1>");
    
    int a = Integer.parseInt(req.getParameter("a"));
    int b = Integer.parseInt(req.getParameter("b"));
    String op = req.getParameter("op");
    
    if (op.equals("*")) {
      out.printf("%d * %d = %d\n", a, b, (a * b));
    } else {
      out.printf("%s 연산을 지원하지 않습니다.\n", op);
    }
    
    out.println("</body>");
    out.println("</html>");
  }
}









