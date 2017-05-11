/* 인스턴스 변수와 클래스 메서드 
 * => 클래스 메서드에서 인스턴스 변수를 사용할 수 없다!
 * => 이유?
 *    인스턴스를 생성하지 않고 클래스 메서드를 호출할 수 있기 때문이다. 
 */
package step07;

public class Test04_8 {
  
  static class Calculator {
    int result;
    
    public static void plus(int value) {
      // 인스턴스 변수는 인스턴스 주소가 있어야만 사용할 수 있다.
      // 클래스 메서드(=스태틱 메서드)는 this라는 변수가 없다.
      // 그래서 다음 코드는 오류이다.
      //result += value;
    }
    
    public static void minus(int value) {
      //result -= value; // 컴파일 오류!
    }
  }
  
  public static void main(String[] args) {
    Calculator.plus(10);
    //System.out.println(Calculator.result); // 오류!
  }

}
