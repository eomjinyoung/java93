/* 스프링 사용법: @Autowired 애노테이션 사용하기 III
 * => @Autowired를 셋터 메서드에 붙이지 않고 필드 선언에 붙이는 방법
 * => XML 설정 파일에서 직접 의존 객체를 주입하는 대신에
 *    @Autowired를 이용하여 의존 객체 주입을 자동화시키기.
 * => 방법?
 *    1) 의존 객체를 자동으로 주입시키기 위해서는 
 *       셋터 또는 필드에 @Autowired를 붙여야 한다.
 *       => Car 클래스에 Engine engine; 필드 선언에 붙였다.
 *    2) Spring IoC 컨테이너가 객체를 생성한 후,
 *       @Autowired를 처리하도록 그 역할을 수행할 객체를 장착해야 한다.
 *       => application-context-01.xml에 @Autowired를 처리할 객체를 등록하였다.
 * => @Autowired 애노테이션을 처리할 클래스
 *    - org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
 *    
 * => 스프링 IoC 컨테이너에 장착할 수 있는 부품: BeanPostProcessor
 *    - 스프링 IoC 컨테이너가 빈을 생성한 후 작업을 실행시키는 객체 
 * 
 */
package step27.ex7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex7/application-context-01.xml");
    
    System.out.println("-----------------------------------------");
    
    // 현재 Spring IoC 컨테이너에 보관된 객체를 알아내기
    String[] names = ctx.getBeanDefinitionNames();
    for (String name : names) {
      System.out.println(ctx.getBean(name));
    }
    
  }
}






