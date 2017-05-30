/* 추상 클래스 1
 * => 추상 클래스는 일반 클래스와 같이 모든 멤버를 가질 수 있다.
 * => 단 인스턴스를 생성할 수 없다.
 * => 서브 클래스에게 공통 필드나 기능을 상속해 주는 용도이다.
 */
package step21.ex7;

public abstract class A {
  static int v1 = 100;
  int v2 = 200;
  
  public static void sm1() {
    System.out.println("A.sm1()...");
  }
  
  public void m1() {
    System.out.println("A.m1()...");
  }
}
