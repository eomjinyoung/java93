/* 스프링 사용법: @Component 애노테이션 사용하기
 * => @Component 애노테이션이 붙은 클래스인 경우,
 *    Spring IoC 컨테이너가 자동으로 객체를 생성하게 만들 수 있다.
 * => 방법
 *    1) 자동으로 객체를 생성해야 하는 대상 클래스에 @Component 붙여라!
 *       - Car, Engine 클래스에 붙인다.
 *    2) @Component 애노테이션을 처리할 객체를 등록하라!
 *       - @Component 뿐만 아니라 @Autowired 등 여러 애노테이션을 처리해야 하기 때문에
 *         등록할 클래스도 여러 개다.
 *       - Spring에서는 개발자가 이런 각각의 사안을 처리할 객체를 <bean> 태그를 사용하여
 *         매번 등록시키는 일이 번거롭다는 판단에, 
 *         관련 객체를 한꺼번에 등록시킬 수 있는 단축 태그를 제공한다. 
 *         <context:component-scan package="..."/>
 */
package step27.ex9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex9/application-context-01.xml");
    
    System.out.println("-----------------------------------------");
    
    // 현재 Spring IoC 컨테이너에 보관된 객체를 알아내기
    String[] names = ctx.getBeanDefinitionNames();
    for (String name : names) {
      System.out.println(ctx.getBean(name));
    }
    
  }
}






