package step23.ex10;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Map;

class HttpProcessor extends Thread {
  Socket socket;
  
  // 클라이언트 요청을 처리할 객체를 담아둔 맵이다.
  Map<String,Command> servletMap;
  
  public HttpProcessor(Socket socket, Map<String,Command> servletMap) {
    this.socket = socket;
    this.servletMap = servletMap;
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
      
      // HttpServer가 건네준 서블릿 맵에서 url로 Command 객체를 찾는다. 
      Command servlet = servletMap.get(url);
      
      if (servlet != null) { // 있다면,
        servlet.service(out); // 그 커맨드 객체(서블릿)를 호출한다.
      } else { // 없다면,
        servletMap.get("error").service(out); // 오류를 처리하는 커맨드 객체를 호출한다.
      }
      
      out.flush(); // 마무리로 버퍼에 쌓여있는 출력을 클라이언트로 보낸다.
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  } // run()
  
  private String extractUrl(String requestLine) {
    return requestLine.substring(requestLine.indexOf(" ") + 1, requestLine.lastIndexOf(" "));
  }
  
}
