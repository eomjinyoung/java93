/* 상속: 생성자 호출 II
 * => 서브 클래스 생성자 안에 
 *    수퍼 클래스의 기본 생성자를 호출하는 코드를 두지 않으면,
 *    컴파일러가 자동으로 수퍼 클래스의 기본 생성자를 호출하는 코드를 둔다.
 * => 증명!
 *    수퍼 클래스에 기본 생성자를 없애고 파라미터가 있는 생성자를 둔다.
 *
 */
package step09.ex4;

public class Test01 {

  public static void main(String[] args) {
    new C();
  }

}
