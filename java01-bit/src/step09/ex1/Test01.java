/* 상속 문법을 사용하기 전 I
 * => BasicCalculator 클래스를 이용하여 더하기, 빼기를 수행한다. 
 */ 
package step09.ex1;

public class Test01 {
  public static void main(String[] args) {
    BasicCalculator calc = new BasicCalculator();
    calc.plus(100);
    calc.plus(20);
    calc.minus(30);
    System.out.println(calc.result);
  }
}
