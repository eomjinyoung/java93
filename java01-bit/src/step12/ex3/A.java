/* final : 변수에 final 붙이기
 * => 딱 한 번만 값을 저장할 수 있다.
 * => 주로 상수를 표현할 때 사용한다.
 */
package step12.ex3;

public class A {
  int a;
  final int b;
  
  public A() {
    a = 10;
    b = 20;
  }
  
  public void m() {
    b = 30; // final 변수는 딱 한 번만 값을 저장할 수 있다. 컴파일 오류!
  }
}
