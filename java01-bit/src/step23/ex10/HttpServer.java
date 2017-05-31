/* 웹 애플리케이션 실행하기
 * 1) 클라이언트가 요구하는 자원의 경로를 알아내기
 * 2) 클라이언트가 요청한 자원을 처리
 * 3) HttpProcessor 클래스를 패키지 멤버 클래스로 분리
 * 4) Command 패턴 적용 
 *    - 메서드를 객체화시키는 설계 기법.
 *    - 한 개의 메서드를 한 개의 클래스로 정의하는 방식을 말한다.
 *    - 이런 방식은 기능을 추가할 때 마다 메서드를 추가해야 하는 경우에 적합하다.
 *      메서드를 추가하는 것 보다 클래스를 추가하는 것이 유지보수를 더 쉽게 해주기 때문이다. 
 *    - 작업
 *      1. 호출자(HttpProcessor)와 호출당하는자(요청처리객체) 사이의 호출 규칙을 정의한다.
 *         => Command 인터페이스 정의 
 *      2. 메서드를 추출하여 Command 규칙에 따라 클래스를 만든다.
 *         => HelloServlet, OkServlet, ErrorServlet 클래스 작성  
 *      3. HttpServer에서 맵에 커맨드 객체를 보관한다.
 *      4. HttpProcessor는 HttpServer에 제공해준 맵 객체에서 
 *         URL을 처리하는 커맨드 객체를 찾아 호출한다.   
 *      
 */
package step23.ex10;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class HttpServer {
  int port;
  
  //클라이언트 요청을 처리할 객체를 담는다.
  HashMap<String,Command> servletMap = new HashMap<>();
 
  public HttpServer(int port) {
    this.port = port;
    
    // url과 url을 처리할 객체를 맵에 보관한다. 
    servletMap.put("/hello", new HelloServlet());
    servletMap.put("/ok", new OkServlet());
    servletMap.put("error", new ErrorServlet());
  }
  
  public void listen() throws Exception {
    ServerSocket serverSocket = new ServerSocket(this.port);
    System.out.println("서버 실행 중...");
    
    while (true) {
      new HttpProcessor(serverSocket.accept(), servletMap).start();
    }
  }
  
  public static void main(String[] args) throws Exception {
    HttpServer server = new HttpServer(8888);
    server.listen();
  }
}










