/* 소켓 프로그래밍 : connectionless 서버 만들기
 * => 서비스를 요청할 때 마다 연결한 하고, 요청 처리가 끝나면 연결을 끊는다.
 * => 장점
 *    계속 연결된 상태가 아니기 때문에, 
 *      - 요청할 때만 일시적으로 연결되어 작업을 수행한다.
 *      - 보다 많은 클라이언트의 요청을 처리할 수 있다. 
 * => 단점
 *    계속 연결된 상태가 아니기 때문에, 
 *      - 요청할 때 마다 연결하기 때문에 네트워크 오버헤드가 발생한다.
 *      - 클라이언트와의 작업 상태를 지속해서 관리할 수 없다.
 * 
 * => 대표적인 프로토콜: HTTP, 메신저 등 
 */
package step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class Test07_2 {
  class Value {
    int v1;
    int v2;
    String op;
  }

  class CalculatorJob implements Runnable {
    Socket socket ;
    
    public CalculatorJob(Socket socket) {
      this.socket = socket;
      System.out.println("=> 클라이언트와 연결되었음!");
    }
    
    public void run() {
      int count = 0;
      try (
        Socket socket = this.socket;
        BufferedReader in = new BufferedReader(
                              new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
      ) {
        String json = in.readLine();
        if (json == null)
          return;
        
        Gson gson = new Gson();
        Value value = gson.fromJson(json, Value.class);
        
        float result = 0f;
        
        switch (value.op) {
        case "+": result = (float)value.v1 + value.v2; break;
        case "-": result = (float)value.v1 - value.v2; break;
        case "*": result = (float)value.v1 * value.v2; break;
        case "/": result = (float)value.v1 / value.v2; break;
        case "%": result = (float)value.v1 % value.v2; break;
        }
        
        // 클라이언트가 요청할 때 마다 이 객체가 만들어지기 때문에
        // count 변수는 영원히 0이다. 
        // 그래서 같은 클라이언트가 몇 번 요청했는지 알 수 없다.
        if (++count > 5) { // 이 조건은 부질없는 짓! 
          out.println("무료 사용 끝!");
        } else { 
          out.println(result);
        }
        out.flush();
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
    Test07_2 server = new Test07_2();
    server.listen(8888);
  }
}








