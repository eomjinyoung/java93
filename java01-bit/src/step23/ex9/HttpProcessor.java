package step23.ex9;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

class HttpProcessor extends Thread {
  Socket socket;
  
  public HttpProcessor(Socket socket) {
    this.socket = socket;
  }
  
  public void run() {
    try (
      Socket socket = this.socket;
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));) {
      
      String line = null;
      boolean requestLine = true;
      String url = null;
      
      while (true) {
        line = in.readLine();
        if (line.isEmpty()) 
          break;
        
        if (requestLine) {
          requestLine = false;
          url = extractUrl(line);
        }
      }
      
      if (url.equals("/hello")) {
        hello(out);
      } else if (url.equals("/ok")) {
        ok(out);
      } else {
        error(out);
      }
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  } // run()
  
  private String extractUrl(String requestLine) {
    return requestLine.substring(requestLine.indexOf(" ") + 1, requestLine.lastIndexOf(" "));
  }
  
  private void hello(PrintStream out) {
    out.println("HTTP/1.1 200 OK");
    out.println("Server: BIT Server");
    out.println();
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>hello</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("  <h1>안녕하세요!</h1>");
    out.println("</body>");
    out.println("</html>");
    out.flush();
  }
  
  private void ok(PrintStream out) {
    out.println("HTTP/1.1 200 OK");
    out.println("Server: BIT Server");
    out.println();
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>hello</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("  <h1>/ok를 요청하셨네요. ㅋㅋ</h1>");
    out.println("</body>");
    out.println("</html>");
    out.flush();
  }
  
  private void error(PrintStream out) {
    out.println("HTTP/1.1 200 OK");
    out.println("Server: BIT Server");
    out.println();
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>hello</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("  <h1>요청한 자원을 찾을 수 없습니다.</h1>");
    out.println("</body>");
    out.println("</html>");
    out.flush();
  }
}
