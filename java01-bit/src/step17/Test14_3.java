/* 예외처리 : 자원을 자동 해제시키는 try ~ catch ~ 문장 사용법
 * => try (객체 선언) ~ 
 *    try 괄호 안에 선언할 수 있는 객체는 
 *    java.lang.AutoCloseable 규격에 따라 만든 객체만 가능하다.
 *    
 * => java.lang.AutoCloseable 규격?
 *    자원을 자동으로 해제시킬 때 close() 메서드를 호출한다는 규칙이다.
 *    따라서 이 규칙을 준수하는 클래스는 반드시 이 규칙에 선언된
 *    close() 메서드를 만들어야 한다. 
 *    
 */
package step17;

import java.io.FileInputStream;

public class Test14_3 {

  static class A {
    public void close() throws Exception {
      System.out.println("A.close()");
    }
  }
  
  static class B implements AutoCloseable {
    public void close() throws Exception {
      System.out.println("B.close()");
    }
  }
  
  public static void main(String[] args) {
    int age = 15;
    
    try (
        /* A 클래스가 close() 메서드를 갖고 있다 하더라도,
         * 공식적으로 java.lang.AutoCloseable 규칙을 따른다고 선언하지 않았기 때문에
         * 이 괄호안에 선언할 수 없다.
         */
        //A obj1 = new A();
        
        /* B 클래스는 java.lang.AutoCloseable 규칙을 따르기 때문에 
         * 이 괄호 안에 선언할 수 있다.
         * 그리고 try 문장을 벗어나기 전에 자동으로 close()를 호출할 것이다.
         */
        B obj2 = new B();
    ) {
      if (age < 19) 
        throw new Exception("미성년입니다.");
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}




