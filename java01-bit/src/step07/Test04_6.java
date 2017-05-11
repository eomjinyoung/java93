/* 클래스 변수와 인스턴스 메서드 
 * => 인스턴스 메서드에서도 클래스 변수를 사용할 수 있다.
 *    당연하다. 클래스 변수는 공용이기 때문이다. 
 */
package step07;

public class Test04_6 {
  
  static class Calculator {
    static int result;
    
    public void plus(int value) {
      Calculator.result += value;
    }
    
    public void minus(int value) {
      Calculator.result -= value;
    }
  }
  
  public static void main(String[] args) {
    Calculator c = new Calculator();
    c.plus(10);
    System.out.println(Calculator.result);
  }

}
