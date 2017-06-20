/* Class 도구 사용법: 메서드의 리턴타입 알아내기*/
package step26;

import java.lang.reflect.Method;

public class Test05 {

  public static void main(String[] args) throws Exception {
    Class<?> clazz = Math.class;
    
    Method m = clazz.getMethod("sin", double.class);
    System.out.println(m);
    
    // 리턴 타입이 뭔지 알아내기
    Class<?> returnType = m.getReturnType();
    System.out.println(returnType.getName());
    
  }
}






