/* 캡슐화(encapsulation): 기본 접근 제어 범위
 * => 기본은 같은 패키지에 있는 클래스의 접근을 허용한다.
 */
package step11;

public class Test01 {

  public static void main(String[] args) {
    Calculator c = new Calculator();
    c.plus(10);
    c.plus(7);
    c.minus(3);
    // 치명적인 문제
    // => 외부에서 직접 result를 접근할 수 있기 때문에 조작이 가능하다.
    //    물론 만든 사람은 조심해서 사용할 것이지만,
    //    다른 사용자가 Calculator를 사용할 때는 사용을 잘 한다는 보장이 없다.
    c.result = 100;
    
    // 위의 코드처럼 직접 result의 값을 변경할 수 있기 때문에
    // 잘못된 결과를 출력할 수 있다.
    // 해결책? result를 외부에서 직접 접근할 수 없게 만들기!
    System.out.println(c.result);

  }

}
