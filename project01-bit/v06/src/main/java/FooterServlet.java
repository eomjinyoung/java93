/* 꼬리말을 출력하는 서블릿
 * => 다른 서블릿과 협력하여 꼬리말을 출력하는 일을 한다. 
 */


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/footer") 
public class FooterServlet  extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter out = res.getWriter();
    
    out.println("<div class='footer'>");
    out.println("  <span>비트캠프 자바93기</span> | ");
    out.println("  <address>서울시 서초구 서초동 1327-15번지 비트아카데미 빌딩 3층</address> ");
    out.println("</div>");
  }
}









