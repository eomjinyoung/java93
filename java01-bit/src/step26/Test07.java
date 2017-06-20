/* Class 도구 사용법: 메서드 호출하기*/
package step26;

import java.lang.reflect.Method;

public class Test07 {

  public static void main(String[] args) throws Exception {
    // 1) 인스턴스 메서드 호출하기
    String str = new String("Hello");
    Class<?> clazz = String.class;
    
    Method m = clazz.getMethod("replace", char.class, char.class);
    Object returnValue = m.invoke(str, 'l', 'x');
    System.out.println(returnValue);
    
    // 2) 클래스 메서드 호출하기
    clazz = Math.class;
    m = clazz.getMethod("abs", int.class);
    returnValue = m.invoke(null, -100); // 스태틱 메서드를 호출할 때는 인스턴스를 null로 설정하라!
    System.out.println(returnValue);
  }
}






