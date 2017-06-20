/* 스프링 사용법: 셋터 호출하기 IV
 */
package step27.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test07 {
  public static void main(String[] args) {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex2/application-context-07.xml");
    
    Engine e1 = (Engine)ctx.getBean("e1");
    Car c1 = (Car)ctx.getBean("c1");
    Car c2 = (Car)ctx.getBean("c2");
    
    if (e1 == c1.getEngine()) {
      System.out.println("e1 == c1.engine");
    }
    
    if (e1 == c2.getEngine()) {
      System.out.println("e1 == c2.engine");
    }
    
    Car c3 = (Car)ctx.getBean("c3");
    Car c4 = (Car)ctx.getBean("c4");
    
    if (c3.getEngine() == c4.getEngine()) {
      System.out.println("e3.engine == c4.engine");
    } else {
      System.out.println("e3.engine != c4.engine");
    }
  }
}






