/* 웹 애플리케이션 실행하기
 * 1) 클라이언트가 요구하는 자원의 경로를 알아내기
 * 2) 클라이언트가 요청한 자원을 처리
 * 3) HttpProcessor 클래스를 패키지 멤버 클래스로 분리
 * 4) Command 패턴 적용 
 * 5) properties 파일을 이용하여 서블릿 객체 생성 자동화
 *    - 서블릿 클래스를 추가할 때 마다 HttpServer 클래스를 변경해야 한다.
 *    - 이 문제를 해결하기 위한 방안?
 *      URL과 그 URL을 처리할 객체를 별도의 외부 파일에 둔다.
 *      서버를 시작할 때 이 파일을 읽어 객체를 준비한다.
 *    - 작업
 *      1. URL과 그 URL 요청을 처리할 클래스 이름을 외부 파일에 저장한다.
 *         web.properties
 *      2. HttpServer를 시작하면 web.properties 파일을 로딩한다.  
 *      3. web.properties에 지정된 클래스를 로딩하고 그 객체를 만들어 맵에 보관한다.
 *    - 문제점
 *      서블릿 클래스를 추가 할 때 마다 web.properties 파일을 변경해야 한다.
 *         
 *      
 */
package step23.ex11;

import java.io.FileReader;
import java.net.ServerSocket;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class HttpServer {
  int port;
  
  //클라이언트 요청을 처리할 객체를 담는다.
  HashMap<String,Command> servletMap = new HashMap<>();
 
  public HttpServer(int port) throws Exception {
    this.port = port;
    
    Properties props = new Properties();
    // 이클립스에서 프로그램을 실행하면, 항상 현재 폴더는 프로젝트 폴더이다.
    props.load(new FileReader("src/step23/ex11/web.properties"));
    
    Set<String> urlSet = props.stringPropertyNames();
    for (String url : urlSet) {
      String classFullName = props.getProperty(url);
      Class clazz = Class.forName(classFullName); // 클래스를 로딩한 후 그 클래스를 다루는 도구를 리턴한다.
      servletMap.put(url, (Command)clazz.newInstance());
    }
  }
  
  public void listen() throws Exception {
    ServerSocket serverSocket = new ServerSocket(this.port);
    System.out.println("서버 실행 중...");
    
    while (true) {
      new HttpProcessor(serverSocket.accept(), servletMap).start();
    }
  }
  
  public static void main(String[] args) throws Exception {
    HttpServer server = new HttpServer(8888);
    server.listen();
  }
}










