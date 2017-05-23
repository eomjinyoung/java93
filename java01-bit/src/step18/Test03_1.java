/* 소켓 프로그래밍: 여러 클라이언트의 요청을 처리하기(서버)
 * => 반복문을 사용하여 여러 클라이언트 요청을 순차적으로 처리한다.
 */
package step18;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test03_1 {
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");
    
    ServerSocket serverSocket = new ServerSocket(8888);
    System.out.println("=> 서버 소켓 생성 완료!");

    while (true) {
      try (
        Socket socket = serverSocket.accept();
        InputStream in0 = socket.getInputStream();
        OutputStream out0 = socket.getOutputStream();
        Scanner in = new Scanner(in0);
        PrintStream out = new PrintStream(out0);) {
        
        System.out.println("=> 클라이언트 연결 승인!");
        String str = in.nextLine(); // 클라이언트로부터 문자열을 한 줄 읽는다.
        out.println(str); // 클라이언트가 보낸 문자열을 그대로 돌려준다.
      } catch (Exception e) {} 
    }
  }
}








