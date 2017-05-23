/* 소켓 프로그래밍: 클라이언트 프로그램 만들기
 * => 특별한 IP 주소
 *    - 127.0.0.1 : 현재 프로그램을 실행하는 컴퓨터를 가리킨다. 
 * => 특별한 도메인 이름
 *    - localhost : 현재 프로그램을 실행하는 컴퓨터를 가리킨다.
 *    - 즉, 127.0.0.1 == localhost    
 */
package step18;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test01_2 {
  public static void main(String[] args) throws Exception {
    // 1) 클라이언트 소켓 만들기
    // => 첫 번째 파라미터: 접속하려는 상대편 프로그램의 컴퓨터 주소
    // => 두 번째 파라미터: 접속하려는 상대편 프로그램의 포트 번호
    // => 자신의 포트번호? 
    //    OS가 자동으로 부여한다. 
    //    개발자가 신경쓸 필요가 없다.
    //    즉 쌍방 모두 포트 번호가 반드시 있어야 한다는 의미!
    //
    Socket socket = new Socket("localhost", 8888);
    
    // 2) 소켓을 통해 입출력을 할 수 있도록 스트림 객체를 만든다.
    InputStream in = socket.getInputStream();
    OutputStream out = socket.getOutputStream();
    
    // 3) 서버에서 먼저 데이터를 읽는다면, 클라이언트는 먼저 데이터를 보내야 한다.
    //    꺼꾸로 서버에서 데이터를 먼저 보낸다면, 클라이언트는 먼저 데이터를 읽어야 한다.
    out.write(0x77); // 클라이언트가 보낸 데이터를 서버가 모두 읽을 때까지 리턴하지 않는다(blocking).
    int b = in.read(); // 서버가 보낸 데이터를 1바이트 읽을 때까지 리턴하지 않는다.
    System.out.printf("%x\n", b);
    
    // 4) 서버와의 데이터 입출력이 끝났으면 연결을 끊는다.
    in.close();
    out.close();
    socket.close();
  }
}








