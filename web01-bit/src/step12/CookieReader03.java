package step12;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 쿠키 읽기 III
 * => 쿠키 값이 URL 인코딩 되어 있을 때,
 *    개발자가 직접 URL 디코딩을 수행해야 한다.
 *  
 */

@WebServlet("/step12/CookieReader03")
public class CookieReader03 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    Cookie[] cookies = req.getCookies();
    
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        out.printf("%s=%s\n", 
            cookie.getName(),  // 쿠키 이름
            URLDecoder.decode(cookie.getValue(), "UTF-8"));  
        // 영어는 URL 디코딩해도 값이 같다. 그러니 영어를 디코딩하는 것에 대해 걱정말라!
      }
    } else {
      out.println("쿠키가 한 개도 없습니다.");
    }
  }
}





