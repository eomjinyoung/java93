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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test07_1 {

  class CalculatorJob implements Runnable {
    Socket socket ;
    
    public CalculatorJob(Socket socket) {
      this.socket = socket;
      System.out.println("=> 클라이언트와 연결되었음!");
    }
    
    public void run() {
      try (
        Socket socket = this.socket;
        BufferedReader in = new BufferedReader(
                              new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
      ) {
        // 연결되어 있는 동안 계속 클라이언트와 통신하기 - connectionful
        while (true) {
          String json = in.readLine();
          if (json == null)
            break;
          System.out.println(json);
          
          out.println(json);
        }
        System.out.println("=> 클라이언와 연결 끊김!");
      } catch (Exception e) {
        e.printStackTrace();
      }
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








