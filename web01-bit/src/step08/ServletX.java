/* 웹 애플리케이션에서 사용할 자원을 준비하는 방법: 서블릿을 이용하기 I
 * => 서블릿이 준비한 자원을 이용하기
 */
package step08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/step08/ServletX")
public class ServletX extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    ServletContext sc = this.getServletContext();
    String v1 = (String)sc.getAttribute("v1");
    String v2 = (String)sc.getAttribute("v2");
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.printf("v1=%s\n", v1);
    out.printf("v2=%s\n", v2);
  }
}









