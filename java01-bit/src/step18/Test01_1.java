/* 소켓 프로그래밍: 서버 프로그램 만들기
 * => 소켓(socket)?
 *    - 통신에 필요한 정보를 담고 있는 객체
 *    - 이 객체를 이용하여 통신을 수행한다.
 * => 소켓 생성에 필요한 값?
 *    - 인터넷 주소(IP Address, 도메인주소)
 *    - 포트번호(통신하는 프로그램을 구분하기 위한 식별자)
 * => 용어
 *    1) 클라이언트(client) : 접속을 요청하는 쪽
 *    2) 서버(server) : 접속을 받아들이는 쪽
 *    3) 포트번호 : 
 *       - OS가 구분할 수 있도록 통신프로그램에 부여되는 번호.
 *       - 클라이언트쪽 프로그램은 OS가 포트번호를 자동으로 부여한다.
 *       - 서버쪽은 프로그램은 스스로 지정한다.
 *         단 사용 중인 포트 번호를 중복 사용할 수 없다.
 *         기존에 특정 목적으로 널리 이용되는 포트 번호도 피해야 한다.
 *         예) FTP(20,21), Telnet(23), SSH(22), SMTP(25), HTTP(80), POP3(110), IMAP4(143),
 *             HTTPS(443), 프록시서버(8080), MySQL(3306) 
 *     4) 대기열 :
 *        - 클라이언트가 서버에 접속을 요청했을 때, 그 클라이언트의 연결 정보를 저장한 목록이다.
 *        - 대기열이 꽉차있을 경우, 클라이언트의 연결 요청을 거절한다.
 *    
 * => 종류
 *    1) 서버 소켓
 *       - 서버측 프로그램을 작성할 때 사용한다.
 *       - ServerSocket 클래스를 이용하여 만든다.
 *       - 다른 프로그램과 중복되지 않도록 포트 번호를 지정한다.
 *    2) 클라이언트 소켓
 *       - 클라이언트측 프로그램을 작성할 때 사용한다.
 *       - Socket 클래스를 이용하여 만든다.
 *       - 접속하려는 상대편 인터넷주소(IP 주소, 도메인 주소)를 지정한다.
 *       - 접속하려는 상대편의 포트번호를 지정한다.
 */
package step18;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test01_1 {
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");
    
    // 1) 서버 소켓 만들기
    ServerSocket serverSocket = new ServerSocket(8888);
   
    // 2) 대기열의 첫 번째 클라이언트의 접속을 승인한다.
    // => 만약 대기 중인 클라이언트가 없다면, 리턴하지 않고 접속할 때까지 기다린다.
    // => 여러 클라이언트가 대기 중이라면 그 중 첫 번째 클라이언트와 연결한다.
    // => 리턴 값: 대기열에 등록된 첫 번째 클라이언트의 연결 정보를 가지고 만든 소켓 객체이다.
    Socket socket = serverSocket.accept();
    
    // 3) 소켓을 통해 입출력을 할 수 있도록 스트림 객체를 만든다.
    InputStream in = socket.getInputStream();
    OutputStream out = socket.getOutputStream();
    
    // 4) 소켓으로 클라이언트와 연결되면 데이터를 주고 받는 순서는 상관없다.
    //    그러나 일반적으로 클라이언트에서 먼저 데이터를 전송한다.
    //    그래서 서버는 클라이언트의 데이터를 먼저 읽고 그에 대한 응답을 한다.
    int b = in.read(); // 클라이언트에서 1바이트를 보낼 때까지 계속 기다린다(blocking).
    System.out.printf("%x\n", b);
    
    out.write(0x01); // 서버가 보낸 1바이트 데이터를 클라이언트에서 읽을 때까지 리턴하지 않는다. 
    
    // 5) 클라이언트와 데이터 입출력이 끝났으면 연결을 끊는다.
    in.close();
    out.close();
    socket.close();
    serverSocket.close();
  }
}








