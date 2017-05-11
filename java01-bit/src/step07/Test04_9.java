/* 클래스 메서드들 끼리 호출하기 
 * => 메서드에서 다른 메서드를 호출하는 것은 당연히 가능하다. 
 */
package step07;

public class Test04_9 {
  
  static class Calculator {
    
    public static void m1() {
      // 메서드 호출할 때 클래스명이 안 붙이면, 자동으로 붙인다.
      /*Calculator.*/m2();
    }
    
    public static void m2() {
      // 물론 우리가 직접 붙여도 된다.
      Calculator.m3();
    }
    
    public static void m3() {
      System.out.println("m3()...");
    }
  }
  
  public static void main(String[] args) {
    Calculator.m1();
  }

}
