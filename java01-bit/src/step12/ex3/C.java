/* final : 변수에 final 붙이기
 * => 딱 한 번만 값을 저장할 수 있다.
 * => 주로 상수를 표현할 때 사용한다.
 */
package step12.ex3;

public class C {
  public void m1() {
    int a;
    a = 10;
    a = 20;
    
    final int b;
    b = 20;
    b = 30; // final 변수는 값을 딱 한 번만 저장할 수 있다.
  }
}
