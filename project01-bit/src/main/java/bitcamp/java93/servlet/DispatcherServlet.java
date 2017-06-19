package bitcamp.java93.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="*.do")
public class DispatcherServlet  extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
      String controllerPath = req.getServletPath().replace(".do", ""); 
      
      res.setContentType("text/html;charset=UTF-8");
      RequestDispatcher rd = req.getRequestDispatcher(controllerPath);
      rd.include(req, res);
      
      Exception error = (Exception)req.getAttribute("error");
      if (error != null) {
        throw error;
      }
      
      String viewPath = (String)req.getAttribute("view");
      if (viewPath.startsWith("redirect:")) {
        res.sendRedirect(viewPath.replaceAll("redirect:", ""));
        return;
      } 
      
      rd = req.getRequestDispatcher(viewPath);
      rd.include(req, res);
      
    } catch (Exception e) {
      req.setAttribute("error", e); 
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.forward(req, res);
      return;
    }
    
  }
}









