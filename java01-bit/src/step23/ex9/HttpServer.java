/* 웹 애플리케이션 실행하기
 * 1) 클라이언트가 요구하는 자원의 경로를 알아내기
 * 2) 클라이언트가 요청한 자원을 처리
 * 3) HttpProcessor 클래스를 패키지 멤버 클래스로 분리
 */
package step23.ex9;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
  int port;
  
  public HttpServer(int port) {
    this.port = port;
  }
  
  public void listen() throws Exception {
    ServerSocket serverSocket = new ServerSocket(this.port);
    System.out.println("서버 실행 중...");
    
    while (true) {
      new HttpProcessor(serverSocket.accept()).start();
    }
  }
  
  public static void main(String[] args) throws Exception {
    HttpServer server = new HttpServer(8888);
    server.listen();
  }
}










