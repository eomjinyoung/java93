/* 소켓 프로그래밍 : 채팅 서버 만들기 - v2
 * => ChatJob들의 연락처를 구축하여 공유한다.
 * => 이렇게 구축된 연락처는 
 *    클라이언트로부터 받은 메시지를 다른 클라이언트에게 보낼 때 사용한다.      
 */
package step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Test08_2 {
  ArrayList<ChatJob> chatJobs = new ArrayList<>();
  
  class ChatJob implements Runnable {
    Socket socket ;
    PrintStream out;
    
    public ChatJob(Socket socket) {
      this.socket = socket;
      chatJobs.add(this);
    }
    
    public void run() {
      try (
        Socket socket = this.socket;
        BufferedReader in = new BufferedReader(
                              new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
      ) {
        this.out = out; // 다른 스레드가 메시지를 보낼 때 사용한다.
        String alias = in.readLine();
        sendAll(String.format("[%s]님이 입장하였습니다.\n", alias));
        
        while (true) {
          String message = in.readLine();
          if (message == null) // 클라이언트에서 종료 신호를 보낸다면 
            break; // 입출력을 끝낸다.
          
          sendAll(message + '\n');
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    public void send(String message) throws Exception {
      out.println(message);
      out.flush();
    }
  }
  
  public void listen(int port) throws Exception {
    ServerSocket serverSocket = new ServerSocket(port);
    System.out.println("서버 실행 중...");
    
    while (true) {
      new Thread(new ChatJob(serverSocket.accept())).start();
    }
  }
  
  public void sendAll(String message) {
    for (int i = chatJobs.size() - 1; i >= 0; i--) {
      try {
        chatJobs.get(i).send(message);
      } catch (Exception e) {
        chatJobs.remove(i);
      }
    }
  }
  
  public static void main(String[] args) throws Exception {
    Test08_2 server = new Test08_2();
    server.listen(8888);
  }
}








