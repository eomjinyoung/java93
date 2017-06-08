/* 회원 관리 만들기 : 회원 등록하기 
 * => 포워드 적용
 */


import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
      RequestDispatcher rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    
  }
}









