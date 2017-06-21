/* 스프링 사용법: @Qualifier
 * => 프로퍼티에 넣을 값이 여러 개일 경우 
 *    특정 객체를 지정하는 애노테이션이다.
 * => @Qualifier(객체명)를 사용하여 프로퍼티로 사용할 의존 객체를 특정할 수 있다.
 */
package step27.ex10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex10/application-context-01.xml");
    
    System.out.println("-----------------------------------------");
    
    // 현재 Spring IoC 컨테이너에 보관된 객체를 알아내기
    String[] names = ctx.getBeanDefinitionNames();
    for (String name : names) {
      System.out.println(ctx.getBean(name));
    }
    
  }
}






