/* Spring WebMVC: Request Handler의 파라미터들 III - 커스텀 프로퍼티 에디터 
 * => 프론트 컨트롤러는 페이지 컨트롤러의 메서드를 호출할 때,
 *    그 메서드가 어떤 파라미터 값을 요구하는 분석하여
 *    그에 해당하는 값을 자동으로 꼽아준다. 
 * => Request Handler의 파라미터로 선언할 수 있는 것
 *    1) HttpServletRequest, ServletRequest
 *    2) HttpServletResponse, ServletResponse
 *    3) HttpSession
 *    4) Map, Model 
 *    5) 요청 파라미터 
 */
package control;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller13/") 
public class Controller13 {
  
  // 클라이언트가 보낸 파라미터 값은 문자열이다.
  // 프론트 컨트롤러는 페이지 컨트롤러의 메서드를 호출할 때 이 문자열을 메서드 아규먼트 타입에 맞춰 변환해 준다.
  // 단 원시 타입(byte,short,int,long,float,double,boolean,char)으로만 변환해준다.
  // 다른 타입으로 변환하고 싶다면, 별도의 변환기를 설치해야 한다.
  
  // 1) String ---> java.sql.Date 으로 자동 변환 가능! 
  @RequestMapping("ok1")
  public void ok1(java.sql.Date date, boolean working, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ok1()");
    out.printf("date: %s\n", date.toString());
  }
  
  // 2) String ---> java.util.Date 으로 자동 변환 불가능! 
  //    => 실행 오류 발생!
  @RequestMapping("ok2")
  public void ok2(
      String name, // @RequestParam이 붙지 않으면, 기본이 선택 항목이다.
      java.util.Date date, 
      boolean working, HttpServletResponse response) throws Exception {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ok2()");
    out.printf("date: %s\n", date.toString());
  }  
  
  // @InitBinder가 붙은 메서드는 
  //  클라이언트에서 보낸 각각의 요청 파라미터에 대해 요청 핸들러의 아규먼트 값으로 바꿀 때 마다 호출된다.
  // => 기능? 요청 파라미터를 아규먼트 값으로 바꿔주는 변환기를 등록한다.
  //
  @InitBinder
  protected void initBinder(WebDataBinder binder) {
      System.out.println("initBinder()....");
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      dateFormat.setLenient(false);
      
      // 다음 메서드를 호출하여 String ---> java.util.Date 객체로 바꾸는 변환기를 등록한다.
      binder.registerCustomEditor(
          java.util.Date.class, // 첫 번째 파라미터: 문자열을 변환하여 만들 값의 타입 
          new CustomDateEditor( // 이 프로퍼티 변환기는 스프링에서 기본으로 제공. String --> java.util.Date
              dateFormat, // yyyy-MM-dd 형식으로 된 문자열을 분석하여 java.util.Date 객체 생성
              false/*파라미터 값 필수!*/));
  }     
}


















