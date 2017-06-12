package step12;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 쿠키 보내기 IV
 * => 한글 보내기
 * => 한글은 8비트가 넘어가는 코드 값이기 때문에,
 *    URL 인코딩(ASCII 코드화) 해서 보내야 한다.   
 */

@WebServlet("/step12/Servlet04")
public class Servlet04 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 웹서버 중에서 쿠키값을 유니코드로 그대로 내보내는 서버는 다음과 같이 
    // 평상시에 사용하는 방법으로 쿠키 값을 설정하면 된다.
    // Cookie cookie = new Cookie("c4", "ABC가각간");
    
    // 만약 웹서버가 유니코드를 그대로 내보내는 서버가 아니라면, 
    // 다음과 같이 개발자가 URL 인코딩을 수행해야 한다.
    // 주의! 
    // 웹서버가 유니코드 값을 보내더라도 웹브라우저 중에서는 유니코드를 
    // 처리할 수 없는 브라우저도 있기 때문에,
    // 가능한 개발자가 URL 인코딩 해서 보내라!
    Cookie cookie = new Cookie("c4", URLEncoder.encode("ABC가각간", "UTF-8"));
    
    resp.addCookie(cookie);
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("Servlet04: 쿠키 보냈음.");
  }
}

/* 쿠키를 보내는 응답 프로토콜
HTTP/1.1 200
Set-Cookie: c3=cccc; Max-Age=60; Expires=Mon, 12-Jun-2017 05:40:44 GMT   <--- 사용 기간 추가
Content-Type: text/plain;charset=UTF-8
Content-Length: 29
Date: Mon, 12 Jun 2017 05:39:44 GMT  
 */










