/* 스프링 사용법: 셋터 호출하기 VI
 */
package step27.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test09 {
  public static void main(String[] args) {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex2/application-context-09.xml");

    System.out.println(ctx.getBean("c1"));
    System.out.println(ctx.getBean("c2"));
  }
}






