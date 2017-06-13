package step13;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step13/Servlet04")
public class Servlet04 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 입력정보 확인</h1>");
    out.println("<form action='Servlet04' method='POST'>");
    
    Member member = (Member)req.getSession().getAttribute("member");
    if (member != null) {
      out.printf("이름:%s<br>\n", member.name);
      out.printf("이메일:%s<br>\n", member.email);
      out.printf("전화:%s<br>\n", member.tel);
      out.printf("암호:%s<br>\n", member.password);
      out.printf("우편번호:%s<br>\n", member.postNo);
      out.printf("기본주소:%s<br>\n", member.baseAddr);
      out.printf("상세주소:%s<br>\n", member.detailAddr);
      out.printf("최종학력:%s<br>\n", member.school);
      out.printf("총근무기간:%d<br>\n", member.work);
    }
    out.println("<button name='ok'>확인</button>");
    out.println("<button name='cancel'>취소</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Member member = (Member)req.getSession().getAttribute("member");
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    
    if (req.getParameter("ok") != null) {
      out.printf("%s님 정보를 저장하였습니다!", member.name);
    } else {
      out.printf("%s님 정보를 취소하였습니다!", member.name);
    }
  }
}







