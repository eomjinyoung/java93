/* Class 도구 사용법: 클래스의 특정 메서드만 추출하기 */
package step26;

import java.lang.reflect.Method;

public class Test04 {

  public static void main(String[] args) throws Exception {
    Class<?> clazz = MyClass.class;
    
    Method m = clazz.getMethod("m1");
    System.out.println(m);
    
    // 일치하는 메서드를 찾지 못했을 때? null을 리턴하는 것이 아니라 예외가 발생한다.
    //m = clazz.getMethod("m1", String.class);
    //System.out.println(m);
    
    Method m2 = clazz.getMethod("m2", int.class);
    System.out.println(m2);
    
    Method m3 = clazz.getMethod("m3", String.class, int.class);
    System.out.println(m3);
  }
}






