/* 소켓 프로그래밍 : connectionful 서버 만들기
 * => 한 번 서버와 연결되면 명시적으로 연결이 끊을 때까지 데이터를 주고 받는 방법
 * => 장점
 *    계속 연결된 상태로 있기 때문에, 
 *      - 바로 데이터를 주고 받을 수 있어 편리하다.
 *      - 작업 상태를 계속 유지할 수 있다.
 * => 단점
 *    계속 연결된 상태로 있기 때문에,
 *      - 사용 중이지 않을 때도 연결을 유지한다. 메모리 낭비!
 *      - 많은 클라이언트의 요청을 처리할 수 없다.  
 */
package step18;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test07_1 {

  class CalculatorJob implements Runnable {
    Socket socket ;
    
    public CalculatorJob(Socket socket) {
      this.socket = socket;
    }
    
    public void run() {
      try (
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
      ) {
        
      } catch (Exception e) {}
    }
  }
  
  public void listen(int port) throws Exception {
    ServerSocket serverSocket = new ServerSocket(port);
    System.out.println("서버 실행 중...");
    
    while (true) {
      new Thread(new CalculatorJob(serverSocket.accept())).start();
    }
  }
  
  public static void main(String[] args) throws Exception {
    Test07_1 server = new Test07_1();
    server.listen(8888);
  }
}








