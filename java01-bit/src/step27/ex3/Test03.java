/* 스프링 사용법: 팩토리 메서드 호출하기 III
 * => 팩토리 메서드(Factory Method)? 
 *    - 객체를 만들어 주는 메서드를 말한다.
 * => new 연산자를 사용해서 만들면 되지 않는가?
 *    - 객체를 생성하는 과정이 복잡할 경우에 매번 new를 사용하여 복잡한 객체를 생성하기 보다는,
 *      복잡한 객체를 생성하는 메서드를 만들어 놓고 호출하는 것이 편하기 때문이다.
 *    - 즉 객체 생성 과정이 복잡한 경우 사용하는 설계 비법이 "팩토리 메서드" 패턴이다.
 *    
 */
package step27.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) {
    // 3) Spring IoC 컨테이너를 이용하여 팩토리 메서드를 사용하기
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex3/application-context-03.xml");

    
    System.out.println(ctx.getBean("c1"));
    System.out.println(ctx.getBean("c2"));
    System.out.println(ctx.getBean("c3"));
  }
}






