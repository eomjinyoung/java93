/* 웹 애플리케이션 실행하기
 * 1) 클라이언트가 요구하는 자원의 경로를 알아내기
 * 2) 클라이언트가 요청한 자원을 처리
 * 3) HttpProcessor 클래스를 패키지 멤버 클래스로 분리
 * 4) Command 패턴 적용 
 * 5) properties 파일을 이용하여 서블릿 객체 생성 자동화
 * 6) 애노테이션을 적용하여 서블릿 객체 생성 자동화
 *    - 서블릿 클래스에 대해서는 특별한 주석을 붙여 서블릿임을 표시한다.
 *    - HttpServer는 서블릿임을 표시한 클래스를 찾아서 자동으로 생성하여 맵에 저장한다.
 *    - 작업
 *      1. 클래스에 붙일 애노테이션 정의
 *         => WebServlet
 *      2. 각 서블릿 클래스에 WebServlet 애노테이션을 붙인다.
 *         => HelloServlet, OkServlet, ThankServlet, ErrorServlet
 *      3. HttpServer에서는 지정된 경로에서 클래스 파일 정보를 읽어들인다.
 *         클래스를 로딩하여 WebServlet 애노테이션이 붙었는지 확인한다.
 *         해당 애노테이션이 붙었으면 객체를 만들어 맵에 보관한다.
 *      
 */
package step23.ex12;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class HttpServer {
  int port;
  
  //클라이언트 요청을 처리할 객체를 담는다.
  HashMap<String,Command> servletMap = new HashMap<>();
  
  //현재 파일 경로
  String currBinDirPath;
  
  public HttpServer(int port) throws Exception {
    this.port = port;
    
    currBinDirPath = new File("./bin/").getCanonicalPath();
    System.out.println(currBinDirPath);
    
    findClassFile(new File("./bin/"));
  }
  
  public void listen() throws Exception {
    ServerSocket serverSocket = new ServerSocket(this.port);
    System.out.println("서버 실행 중...");
    
    while (true) {
      new HttpProcessor(serverSocket.accept(), servletMap).start();
    }
  }
  
  private void findClassFile(File path) throws Exception {
    File[] files = path.listFiles((File pathname) -> {
        if (pathname.isDirectory())
          return true;
        if (pathname.getName().endsWith(".class") &&
            pathname.getName().indexOf('$') < 0)
          return true;
        return false;
      });
    
    for (File file : files) {
      if (file.isDirectory())
        findClassFile(file);
      else 
        System.out.println(file.getCanonicalPath());
    }
  }
  
  public static void main(String[] args) throws Exception {
    HttpServer server = new HttpServer(8888);
    server.listen();
  }
}










