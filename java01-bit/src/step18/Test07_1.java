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
 *      
 * => 대표적인 프로토콜: Telnet, FTP, 채팅 등
 *      
 */
package step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class Test07_1 {
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
        // 연결되어 있는 동안 계속 클라이언트와 통신하기 - connectionful
        while (true) {
          String json = in.readLine();
          if (json == null)
            break;
          
          // Gson 객체를 이용해 JSON 문자열을 Value 객체로 만든다.
          // => Gson 라이브러리 추가
          //    1) build.gradle 에 repositories {}, dependencies {} 블록 추가
          //    2) 명령창에서 "gradle eclipse"를 실행하여 이클립스 설정 파일 갱신
          //    3) 이클립스에서 프로젝트 "refresh" 할 것.
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
          
          /* connectionful
           * => 커넥션풀 방식에서는 클라이언트와 연결된 후 
           *    count 변수처럼 그 클라이언트의 상태를 관리할 수 있다.
           * => 단점: 
           *    1) 클라이언트가 연결을 끊을 때까지 그 상태 값을 유지해야 하기 때문에
           *       메모리 낭비가 발생
           *    2) 보다 많은 클라이언트의 요청을 처리할 수 없다.
           *    3) 클라이언트가 서버를 사용하지 않더라도,
           *       연결을 끊지 않는 한 계속 클라이언트의 정보를 유지해야 한다.
           */
          if (++count > 5) { // 무료 사용 횟수를 넘으면 계산을 안해준다. 
            out.println("무료 사용 끝!");
          } else { 
            out.println(result);
          }
          out.flush();
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








