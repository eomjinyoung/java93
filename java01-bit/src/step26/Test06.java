/* Class 도구 사용법: 메서드의 파라미터 타입 알아내기*/
package step26;

import java.lang.reflect.Method;

public class Test06 {

  public static void main(String[] args) throws Exception {
    Class<?> clazz = String.class;
    
    Method[] methodList = clazz.getMethods();
    for (Method m : methodList) {
      System.out.printf("%s\n", m.getName());
      Class<?>[] paramTypes = m.getParameterTypes();
      for (Class<?> paramType : paramTypes) {
        System.out.printf("--> %s\n", paramType.getName());
      }
      System.out.println();
    }
    
  }
}






