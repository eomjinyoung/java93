/* 상속 문법을 사용하기 전 III
 * => 요구사항
 *    - 우리는 AdvancedCalculator에 나누기 기능을 추가시키고 싶다.
 * => 해결 방법
 *    1) 새 클래스를 만들어 나누기 기능을 추가한다.
 *    2) AdvancedCalculator의 기능을 사용하겠다고 선언한다. 
 */ 
package step09.ex2;

public class Test03 {
  public static void main(String[] args) {
    MasterCalculator calc = new MasterCalculator();
    calc.plus(100);
    calc.plus(20);
    calc.minus(30);
    calc.multiple(2);
    calc.divide(3);
    System.out.println(calc.result);
  }
}
