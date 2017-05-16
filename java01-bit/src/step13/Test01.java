/* nested class(=inner class)
 * => 클래스나 메서드 안에 클래스를 정의하는 문법
 * => 특정 클래스 안에서만 사용되는 클래스는 클래스 안에 정의한다.
 * => 특정 메서드 안에서만 사용되는 클래스는 메서드 안에 정의한다.
 * => 종류!
 *    1) static nested class
 *    2) non-static nested class (= inner class)
 *    3) local class
 *    3) anonymous class 
 */
package step13;

// package member class
public class Test01 {
  
  // static nested class 
  static class A {}
  
  // non-static nested class (member inner class)
  class B {}
  
  public static void main(String[] args) {
    // local class
    class C {}

    // anonymous class
    Object obj = new Object() {};
    
    // lamda로 nested 클래스 표현
    Runnable obj2 = () -> {};
  }

}
