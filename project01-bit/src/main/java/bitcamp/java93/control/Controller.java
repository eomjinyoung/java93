package bitcamp.java93.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
  String service(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
