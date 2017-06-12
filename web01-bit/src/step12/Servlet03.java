package step12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 쿠키 보내기 III
 * => 사용 기간 지정하기
 * => 사용 기간을 지정하지 않으면, 
 *    - 웹브라우저가 실행되는 동안만 보관된다.
 *    - 웹브라우저를 **모두** 닫으면 사용 기간을 기간을 지정하지 않은 쿠키는 버려진다. 
 * => 사용 기간을 지정하면,
 *    - 컴퓨터를 껐다 켜도 그 기간 동안 유지된다.
 *    - 웹브라우저는 보낼 쿠기를 검사할 때 사용 기간이 지난 쿠키는 제거한다.   
 */

@WebServlet("/step12/Servlet03")
public class Servlet03 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie cookie = new Cookie("c3", "cccc");
    
    // 쿠키의 사용 기간을 명시한다. 
    cookie.setMaxAge(60); // 단위: 초 
    
    resp.addCookie(cookie);
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("Servlet03: 쿠키 보냈음.");
  }
}

/* 쿠키를 보내는 응답 프로토콜
HTTP/1.1 200
Set-Cookie: c3=cccc; Max-Age=60; Expires=Mon, 12-Jun-2017 05:40:44 GMT   <--- 사용 기간 추가
Content-Type: text/plain;charset=UTF-8
Content-Length: 29
Date: Mon, 12 Jun 2017 05:39:44 GMT  
 */










