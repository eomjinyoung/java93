/* 회원 관리 만들기 : 회원 등록하기 
 * => GenericServlet을 상속 받는 대신 HttpServlet 을 상속 받아 서블릿을 만든다.
 * => 이점?
 *    Servlet 인터페이스에 선언된 service(ServletRequest, ServletResponse)를 
 *    직접 오버라이딩 하지 않고,
 *    HttpServlet 클래스에 추가된 service(HttpServletRequest, HttpServletResponse)를
 *    오버라이딩 한다.
 *    그러면 ServletRequest, ServletResponse를 
 *    HttpServletRequest와 HttpServletResponse로 형변환할 필요가 없다.
 */


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/member/add")
public class MemberAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  // 강조!
  // 다음 메서드는 Servlet 인터페이스에 선언된 메서드가 아니라,
  // HttpServlet 클래스에 추가된 메서드이다.
  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    
    Member m = new Member();
    m.setName(req.getParameter("name"));
    m.setTel(req.getParameter("tel"));
    m.setEmail(req.getParameter("email"));
    m.setPassword(req.getParameter("password"));
    
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    try {
      DBConnectionPool conPool = new DBConnectionPool(
          jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      MemberDao memberDao = new MemberDao(conPool);
      memberDao.insert(m);

      res.sendRedirect("list");
      
    } catch (Exception e) {
      res.setContentType("text/html;charset=UTF-8");
      PrintWriter out = res.getWriter();
      
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("  <meta charset='UTF-8'>");
      out.println("  <title>회원관리</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>회원 등록</h1>");
      out.println("오류 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
      out.println("<a href='list'>목록</a>");
      out.println("</body>");
      out.println("</html>");
    }
    
  }
}









