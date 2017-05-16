/* nested class: local class
 * => 특정 메서드 안에서만 사용되는 클래스를 만들 때 사용한다. 
 */
package step13;

public class Test04_1 {
  public static void main(String[] args) {
    // local class
    class A {
      int a;
    }
    
    A obj = new A();
    obj.a = 200;
  }
  
  public static void test() {
    // main() 메서드에 선언된 로컬 클래스는 오직 main() 안에서만 사용할 수 있다.
    A obj = new A(); // 컴파일 오류!
  }
}
