/* 상속 문법을 사용하기 전 III
 * => 요구사항
 *    - 우리는 AdvancedCalculator에 나누기 기능을 추가시키고 싶다.
 * => 해결 방법
 *    이전처럼 원본은 그대로 두고 복사/붙여넣기를 통해 새 클래스를 만든 다음에,
 *    나누기 기능을 추가한다. 
 */ 
package step09.ex1;

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
