package bitcamp.java93.filter;

/* 역할: 로그인 여부를 검사하는 필터 */

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
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
    
    // 로그인 여부 검사
    String sessionId = httpRequest.getParameter("sessionId");
    if (sessionId == null) { // 파라미터에 세션 아이디가 없으면 로그인 화면으로 보낸다.
      httpResponse.sendRedirect("../auth/login.html");
      return;
    }
    
    Member loginMember = (Member)request.getServletContext().getAttribute("id_" + sessionId);
    if (loginMember == null) { // 로그인 하지 않았다면 로그인 화면으로 보낸다.
      httpResponse.sendRedirect("../auth/login.html");
      return;
    }
    
    // 다음 필터 또는 서블릿을 실행해야 한다.
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {}

}
