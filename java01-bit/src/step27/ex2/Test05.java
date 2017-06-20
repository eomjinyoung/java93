/* 스프링 사용법: 셋터 호출하기 II
 */
package step27.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05 {
  public static void main(String[] args) {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex2/application-context-05.xml");
    
    // 객체의 scope이 singleton인 경우, 
    // getBean()은 항상 존재하는 객체를 리턴한다.
    System.out.println(ctx.getBean("c1"));
    System.out.println(ctx.getBean("c2"));
  }
}






