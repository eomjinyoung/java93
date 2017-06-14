/* 파일 업로드 : POST 요청 데이터 형식 - application/x-www-form-urlencoded
 * => multipart/form-data
 *    - 웹 브라우저에서 웹 서버에게 바이너리를 포함한 데이터를 보낼 때 사용하는 인코딩 방식이다.
 *    - 보내는 요청 방식은 POST이다.
 *    - 그러나 일반적인 형식인 "변수=값&변수=값&..." 이 아닌,
 *      바이너리 데이터를 보내기 적합한 형식으로 보낸다. 
 * => application/x-www-form-urlencoded
 *    - POST 요청 방식으로 웹 서버에게 데이터를 보낼 때 사용하는 기본 인코딩 방식이다.
 *    - 예) name=ABC%EB%B0%80%EB%B0%81%EB%BO%84&age=20&tel=1111-1111
 *    - file 타입의 입력 값을 서버에 보내면, 단지 파일의 이름만 서버에 전달된다.
 *    - 즉 서버에 바이너리 데이터를 보내지 않는다.
 */
package step14;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step14/Servlet01")
@SuppressWarnings("serial")
public class Servlet01 extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    
    String name = req.getParameter("name");
    String file1 = req.getParameter("file1");
    String file2 = req.getParameter("file2");
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.printf("name=%s\n", name);
    out.printf("file1=%s\n", file1);
    out.printf("file2=%s\n", file2);
  }
  
}

/* HTTP POST 요청 프로토콜
POST /web01-bit/step14/Servlet01 HTTP/1.1
Host: localhost:8080
Content-Length: 67
Pragma: no-cache
Cache-Control: no-cache
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.86 Safari/537.36
Content-Type: application/x-www-form-urlencoded
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,...
Referer: http://localhost:8080/web01-bit/step14/form1.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

name=%ED%99%8D%EA%B8%B8%EB%8F%99&file1=images.jpeg&file2=img01.jpeg
 */










