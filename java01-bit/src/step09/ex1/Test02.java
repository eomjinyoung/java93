/* 상속 문법을 사용하기 전 II
 * => 요구사항
 *    - 우리는 BasicCalculator에 곱하기 기능을 추가시키고 싶다.
 * => 해결 방법
 *    1) 원본 BasicCalculator.java 소스 파일에
 *       곱하기를 처리하는 메서드를 추가시키는 방법 
 *    2) 원본 복사하여 AdvancedCalculator.java를 만든다.
 *       그리고 그 소스 파일에 곱하기 기능을 추가한다.
 *       왜? 가능한 원본을 손대지 않기 위해.
 *       다른 프로젝트에서 기존의 BasicCalculator.java 를 쓰고 있다면,
 *       원본 파일을 손대는 것은 위험하다.
 * => 여기에서는 복사/붙여넣기를 사용하여 새 클래스를 만들겠다. 
 */ 
package step09.ex1;

public class Test02 {
  public static void main(String[] args) {
    AdvancedCalculator calc = new AdvancedCalculator();
    calc.plus(100);
    calc.plus(20);
    calc.minus(30);
    calc.multiple(2);
    System.out.println(calc.result);
  }
}
