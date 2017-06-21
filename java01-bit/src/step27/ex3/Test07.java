/* 스프링 사용법: java.sql.Date.valueOf("2017-06-21") 호출하기
 */
package step27.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test07 {
  public static void main(String[] args) {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex3/application-context-07.xml");
    
    // 제조일이 지정된 Tire 객체를 꺼내 출력한다.
    System.out.println(ctx.getBean("t1"));
  }
}






