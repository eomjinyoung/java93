/* 스프링 사용법: scope 속성으로 객체 생성 정책을 설정한다.
 * => singleton : 객체를 한 개만 생성
 * => prototype : getBean()을 호출할 때 마다 생성한다. 
 * => request : 웹에서 사용. 요청이 들어올 때 마다 생성한다.
 * => session : 웹에서 사용. 세션 당 한 개만 생성한다.
 */
package step27.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {
  public static void main(String[] args) throws Exception {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex1/application-context-03.xml");
    
    // singleton 객체는 Spring IoC 컨테이너를 준비할 때 미리 생성된다.
    // 즉 c1, c2 객체는 미리 생성된다. 
    
    // singleton 객체는 한 개만 생성된다.
    Object obj1 = ctx.getBean("c1"); // 기존에 미리 생성된 객체 리턴.
    Object obj2 = ctx.getBean("c1"); // 기존에 미리 생성된 객체 리턴.
    if (obj1 == obj2) System.out.println("obj1 == obj2");
    
    Object obj3 = ctx.getBean("c2"); // 기존에 미리 생성된 객체 리턴.
    Object obj4 = ctx.getBean("c2"); // 기존에 미리 생성된 객체 리턴.
    if (obj3 == obj4) System.out.println("obj3 == obj4");
    
    Object obj5 = ctx.getBean("c3"); // 객체를 생성하여 리턴한다.
    Object obj6 = ctx.getBean("c3"); // 객체를 생성하여 리턴한다.
    if (obj5 == obj6) System.out.println("obj5 == obj6");
  }
}






