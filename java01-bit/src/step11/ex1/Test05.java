/* 캡슐화(encapsulation): modifier 종류 III
 * => private
 *    - 클래스 멤버만이 접근 가능
 * => (default) : 아무것도 붙이지 않는 것.
 *    - 클래스 멤버 + 같은 패키지의 클래스 
 * => protected
 *    - 상속 받아서 만든 변수인 경우 자식 클래스에서 접근 가능!
 *    - 클래스 멤버 + 같은 패키지의 클래스 + 자식 클래스
 * => public 
 *    - 모든 접근 허용.
 */
package step11.ex1;

import step11.ex1.A;

public class Test05 {

  public static void main(String[] args) {
    A obj = new A();
    //obj.v1 = 1;  // private
    obj.v2 = 2; // (default). A와 같은 패키지에 있는 클래스이다.
    obj.v3 = 3; // protected. A와 같은 패키지에 있는 클래스이다.
    obj.v4 = 4; // public
  }

}
