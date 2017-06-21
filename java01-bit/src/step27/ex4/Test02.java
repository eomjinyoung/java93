/* 스프링 사용법: 커스텀 프로퍼티 에디터 만들고 사용하기 II
 * => Spring IoC 컨테이너는 프로퍼티 값을 설정할 때,
 *    기본으로 String을 자바 원시 타입의 값으로 변환해준다.
 *    그러나 그 외의 타입에 대해서는 변환을 제공하지 않는다.
 * => 해결책?
 *    - Spring에서 정한 규칙에 따라 
 *      String을 다른 타입의 값으로 변환시키는 
 *      "프로퍼티 값 변환기(custom property editor)"를 만들어 장착하면 된다.
 * => 방법
 *    1) 변환기를 작성한다.
 *       - java.beans.PropertyEditor 인터페이스를 구현해야 한다.
 *         그러나 인터페이스에 12개 되는 메서드가 있다.
 *         이 메서드 모두를 직접 구현하는 것은 너무나 번거롭다.
 *       - 그래서 Java에서는 개발자가 편하게 구현하도록
 *         이 인터페이스를 미리 구현한 도우미 클래스를 제공하고 있다.
 *         "PropertyEditorSupport" 이다.
 *       - 즉 PropertyEditorSupport를 상속 받아서 만들라!
 *       - CustomDateEditor 클래스 추가 
 *    2) 설정 파일에 프로퍼티 변환기를 등록한다.
 *       - 
 */
package step27.ex4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
  public static void main(String[] args) {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex4/application-context-02.xml");
    
    // 현재 Spring IoC 컨테이너에 보관된 객체를 알아내기
    String[] names = ctx.getBeanDefinitionNames();
    for (String name : names) {
      System.out.println(ctx.getBean(name));
    }
  }
}






