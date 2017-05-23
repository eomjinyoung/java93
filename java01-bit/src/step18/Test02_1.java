/* 소켓 프로그래밍: 서버 소켓 대기열(서버)
 * => 서버 소켓을 생성할 때 대기열의 최대 개수를 지정할 수 있다.
 *    그 개수 만큼만 클라이언트의 연결 요청을 허락한다.
 */
package step18;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test02_1 {
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");
    
    // ServerSocket(port, backlog)
    // => port: 포트번호
    // => backlog: 대기열의 크기
    ServerSocket serverSocket = new ServerSocket(8888, 3);
    
    Socket socket = serverSocket.accept();
    InputStream in0 = socket.getInputStream();
    OutputStream out0 = socket.getOutputStream();
    
    Scanner in = new Scanner(in0);
    PrintStream out = new PrintStream(out0);
    
    String str = in.nextLine(); // 클라이언트로부터 문자열을 한 줄 읽는다.
    out.println(str); // 클라이언트가 보낸 문자열을 그대로 돌려준다.
    
    in.close();
    in0.close();
    out.close();
    out0.close();
    socket.close();
    serverSocket.close();
  }
}








