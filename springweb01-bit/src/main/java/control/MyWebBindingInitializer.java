// 요청 파라미터를 요청 핸들러의 아규먼트 타입으로 바꿔주는 변환기 등록하기
package control;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

// 방법1) 직접 인터페이스 등록!
public class MyWebBindingInitializer implements WebBindingInitializer{

  @Override
  public void initBinder(WebDataBinder binder, WebRequest request) {
    System.out.println("MyWebBindingInitializer.initBinder()....");
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
