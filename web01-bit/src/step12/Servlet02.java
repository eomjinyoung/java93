package step12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 쿠키 보내기 II
 * => 사용 범위를 지정하기
 * => 사용 범위를 지정하지 않으면 쿠키를 보낸 서블릿의 경로에 한정된다.
 */

@WebServlet("/step12/Servlet02")
public class Servlet02 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie cookie = new Cookie("c2", "bbbb");
    // 쿠키의 사용 범위를 현재 웹애플리케이션 전체로 지정한다. 
    cookie.setPath(req.getContextPath()); // getContextPath() --> "/web01"
    resp.addCookie(cookie);
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("Servlet02: 쿠키 보냈음.");
  }
}

/* 쿠키를 보내는 응답 프로토콜
HTTP/1.1 200
Set-Cookie: c2=bbbb; Path=/web01-bit       <------ 사용 범위를 지정하면 path가 추가된다.
Content-Type: text/plain;charset=UTF-8
Content-Length: 29
Date: Mon, 12 Jun 2017 05:12:28 GMT   
 */










