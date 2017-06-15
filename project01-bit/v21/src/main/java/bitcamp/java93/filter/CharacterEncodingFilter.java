package bitcamp.java93.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // 모든 서블릿을 위해 POST 요청에 대한 파라미터의 문자 집합을 지정한다.
    request.setCharacterEncoding("UTF-8");
    
    // 다음 필터 또는 서블릿을 실행해야 한다.
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {}

}
