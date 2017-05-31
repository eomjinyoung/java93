package step23.ex12;

import java.io.PrintStream;

//@WebServlet(url="/nono")
public class NoServlet implements Command {
  public void service(PrintStream out) throws Exception {
    out.println("HTTP/1.1 200 OK");
    out.println("Server: BIT Server");
    out.println();
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>hello</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("  <h1>nono... 안돼요....</h1>");
    out.println("</body>");
    out.println("</html>");
  }
}
