/* Spring WebMVC: 페이지 컨트롤러 만들기
 * => Spring에서 제공하는 프론트 컨트롤러와 협업할 페이지 컨트롤러 만들기
 * => Spring WebMVC 프로젝트 설정
 *    1) web.xml에 Spring webmvc의 프론트 컨트롤러를 설정한다.
 *       /WEB-INF/web.xml
 *    2) Spring 설정 파일을 준비한다.
 *       /src/main/src/step01/application-context.xml
 *    3) Gradle 설정 파일 준비
 *       build.gradle
 *    4) "gradle eclipse" 실행
 *    
 * => 페이지 컨트롤러 만들기
 *    1) 클래스를 페이지 컨트롤러로 표시하기
 *       - @Controller 애노테이션을 붙인다.
 *    2) 요청을 처리할 메서드를 표시하기
 *       - @RequestMapping(URL) 애노테이션을 붙인다.
 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  // 페이지 컨트롤러 클래스임을 표시
public class Controller01 {
  
  @RequestMapping("/control/controller01") // 어떤 요청을 처리할 지 표시
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("Hello, world!");
  }

}


















