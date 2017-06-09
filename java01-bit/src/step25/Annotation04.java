/* 애노테이션: 애노테이션에 속성 추가하기
 */
package step25;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation04 {
  // 속성 : 인터페이스의 메서드처럼 선언한다.
  String v1(); // 필수 속성. 반드시 값을 지정해야 하는 속성.
  String v2() default "aaa"; // 선택 속성. 값을 지정하지 않아도 되는 속성. 
                             // 값을 지정하지 않으면 default 값이 지정된다.
  int v3();
  int v4() default 100;
}








