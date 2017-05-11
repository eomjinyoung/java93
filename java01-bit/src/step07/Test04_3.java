/* 인스턴스 메서드와 this 변수 II
 * => 인스턴스 변수를 가리키는 풀 세트 문법
 *    클래스명.this.변수명  
 * => 다른 클래스와 헷갈릴 일이 없다면, 클래스 이름을 생략해도 된다.
 * => 다른 로컬 변수와 헷갈릴 일이 없다면, this를 생략해도 된다.
 */
package step07;

public class Test04_3 {
  
  static class Calculator {
    int result;
    
    Calculator(int value) {
      Calculator.this.result = value;
    }
    
    public void plus(int value) {
      Calculator.this.result += value;
    }
    
    public void minus(int value) {
      Calculator.this.result -= value;
    }
  }
  
  public static void main(String[] args) {
    Calculator c1 = new Calculator(10);
    c1.plus(10);
    System.out.println(c1.result);
  }

}
