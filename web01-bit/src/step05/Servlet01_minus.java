/* 작업을 나눠서 처리하기 : 포워딩
 * 1) 포워딩(forwarding)
 *    - 실행을 완전히 위임한다.
 * 2) 인클루딩(including)
 *    - 잠시 실행을 위임한 후 작업이 끝나면 다시 돌아온다. 
 */
package step05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/step05/Servlet01/minus")
public class Servlet01_minus extends HttpServlet {
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
    out.println("<h1>빼기 결과</h1>");
    
    int a = Integer.parseInt(req.getParameter("a"));
    int b = Integer.parseInt(req.getParameter("b"));
    String op = req.getParameter("op");
    
    if (op.equals("-")) {
      out.printf("%d - %d = %d\n", a, b, (a - b));
    } else {
      // 다른 서블릿에게 실행을 위임한다.
      // 1) 다른 서블릿에게 요청 및 응답 도구를 전달할 객체를 준비한다.
      RequestDispatcher rd = req.getRequestDispatcher("/step05/Servlet01/multiple");
      
      // 2) 요청 배달자를 이용하여 해당 서블릿에게 실행을 위임한다.
      // - 위임할 때 서블릿 컨테이너로부터 받은 
      //   ServletRequest와 ServletResponse 객체를 전달한다.
      rd.forward(req, res); 
      
      // 중요!
      // => sendRedirect()와 마찬가지로 포워딩 할 때 그 전에 출력한 내용은 취소된다.
      return; // 다음을 실행해봐야 소용없다. 따라서 현재 메서드를 종료하라!
    }
    
    out.println("</body>");
    out.println("</html>");
  }
}









