package step13;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step13/Servlet02")
public class Servlet02 extends HttpServlet {
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
    out.println("<h1>회원상세정보</h1>");
    out.println("<form action='Servlet02' method='POST'>");
    out.println("우편번호:<input type='text' name='postno'><br>");
    out.println("기본주소:<input type='text' name='baseaddr'><br>");
    out.println("상세주소:<input type='text' name='detailaddr'><br>");
    out.println("<button>다음</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Member member = (Member)req.getSession().getAttribute("member");
    member.postNo = req.getParameter("postno");
    member.baseAddr = req.getParameter("baseaddr");
    member.detailAddr = req.getParameter("detailaddr");
    
    resp.sendRedirect("Servlet03");
  }
}







