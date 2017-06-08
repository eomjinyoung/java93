package bitcamp.java93.servlet;
/* 웹 페이지의 CSS 스타일 코드를 출력하는 서블릿
 */


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/style/core") 
public class StyleServlet  extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter out = res.getWriter();
    out.println("<style>");
    out.println("address {");
    out.println("  display: inline-block;");
    out.println("}");
    out.println(".footer {");
    out.println("  background-color: gray;");
    out.println("  color: white;");
    out.println("  margin: 10px;");
    out.println("  padding: 10px;");
    out.println("  text-align: center;");
    out.println("}");
    out.println("</style>");
  }
}









