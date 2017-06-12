package bitcamp.java93.filter;

/* 역할: 쿠키로 들어온 세션 ID를 가지고 로그인 여부를 검사한다. */

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.domain.Member;

@WebFilter({"/member/*", "/classroom/*", "/lecture/*"})
public class AuthCheckFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    
    // 클라이언트가 보낸 쿠기를 꺼낸다.
    Member loginMember = null;
    Cookie[] cookies = httpRequest.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("sessionId")) {
          loginMember = (Member)request.getServletContext().getAttribute(cookie.getValue());
          httpRequest.setAttribute("loginMember", loginMember);
          break;
        }
      }
    }
    
    if (loginMember == null) { // 쿠키에 세션ID가 없다면 로그인 화면으로 보낸다.
      httpResponse.sendRedirect("../auth/login");
      return;
    }
    
    // 다음 필터 또는 서블릿을 실행해야 한다.
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {}

}
