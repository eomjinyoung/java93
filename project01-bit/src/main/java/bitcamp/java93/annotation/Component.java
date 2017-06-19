/* 역할: 
 * => 페이지 컨트롤러나 DAO, Service 와 같이 
 *    자동으로 객체를 생성해야 하는 클래스에 붙이는 애노테이션이다.
 * => 즉 이 애노테이션이 붙은 클래스는 웹 애플리케이션이 시작될 때
 *    객체를 생성하여 ServletContext 보관소에 저장할 것이다.
 */
package bitcamp.java93.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
  String value() default "";
}
