/* 추상 클래스 3
 * => 추상 클래스를 상속 받은 서브 클래스는 
 *    추상 메서드가 있으면 구현해야 한다.
 *    구현하지 않으면 일반 클래스가 될 수 없다. 
 *    자신도 추상 클래스가 되어야 한다.
 */
package step21.ex7;

// C는 B의 메서드 중에서 추상 메서드 m2()를 구현하지 않았기 때문에
// 추상 클래스로 선언해야 한다.
public abstract class C extends B {
  
  public void m3() {
    System.out.println("B.m3()...");
  }
}






