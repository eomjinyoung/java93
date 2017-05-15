/* 캡슐화(encapsulation): modifier 종류 I
 * => 캡슐화란?
 *    - 추상화를 무너뜨리지 않게 만드는 문법이다.
 *    - 추상화란? 
 *      어떤 목적에 맞게 동작하도록 클래스 안에 변수나 메서드를 정의한 것을 말한다.
 *    - 즉 클래스에 정의된 원래 목적에 맞게 동작할 수 있도록 
 *      클래스 멤버(변수, 메서드, 이너 클래스)의 접근 제한하는 것이다.
 *    - 만약 인스턴스 변수에 무효한 값이 들어가거나
 *      사용하지 말아야할 메서드를 호출하게 되면,
 *      시스템이 목적한대로 동작하지 않을 수 있다.
 *      그래서 변수나 메서드, 이너 클래스의 접근을 제한하는 것이다.
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
package step11;

import step11.ex1.A;

public class Test03 {

  public static void main(String[] args) {
    A obj = new A();
    //obj.v1 = 1;  // private
    //obj.v2 = 2; // (default)
    //obj.v3 = 3; // protected
    obj.v4 = 4; // public
  }

}
