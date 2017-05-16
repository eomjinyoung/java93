/* nested class: static nested class I 
 */
package step13;

public class Test02_1 {
  // static variable
  static int v1;
  
  // static method
  static void m1() {}
  
  // static nested class 
  static class A {
    int a;
  }
  
  // static method
  public static void main(String[] args) {
    // static context(스태틱 블록) 안에서는 static 멤버를 사용할 수 있다.
    v1 = 10; // OK
    m1(); // OK
    A obj = new A(); // OK
  }
  
  // instance method
  public void test() {
    // 인스턴스 블록에서는 스태틱 멤버를 사용할 수 있다.
    // 왜? 인스턴스가 생성되려면 먼저 클래스가 로딩되어야 하고,
    //     클래스가 로딩될 때 스태틱 멤버가 모두 준비를 완료한다.
    // 그래서 인스턴스를 사용할 때는 이미 스태틱 멤버가 존재하는 상태인 것이다.
    //
    v1 = 20; // OK
    // 로컬 변수에서 찾는다 --> 인스턴스 변수에서 찾는다 --> 클래스 변수에서 찾는다.
    
    m1(); // OK
    
    A obj = new A(); // OK
  }

}
