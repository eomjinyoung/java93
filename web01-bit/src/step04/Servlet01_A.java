/* 화면 전환하기 : Refresh 헤더를 이용한 화면 전환 (화면A)
 */
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/step04/Servlet01/a")
public class Servlet01_A  extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>리프래시</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>화면A</h1>");
    out.println("</body>");
    out.println("</html>");
  }
}









