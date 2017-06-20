/* Class 도구 사용법: 클래스의 메서드 알아내기 */
package step26;

import java.lang.reflect.Method;

public class Test03 {

  public static void main(String[] args) throws Exception {
    //test1();
    test2();
  }
  
  private static void test1() throws Exception {
    Class<?> clazz = MyClass.class;
    
    // 상속받은 메서드를 포함하여 모든 public 메서드만 추출한다.
    Method[] methodList = clazz.getMethods(); 
    for (Method m : methodList) {
      System.out.println(m.getName());
    }
  }
  
  private static void test2() throws Exception {
    Class<?> clazz = MyClass.class;
    
    // 해당 클래스에 선언된 모든 메서드를 추출한다. 상속 받은 메서드 제외!
    Method[] methodList = clazz.getDeclaredMethods();
    for (Method m : methodList) {
      System.out.println(m.getName());
    }
  }
}






