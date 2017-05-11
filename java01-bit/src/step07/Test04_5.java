/* 클래스 변수와 클래스 메서드 II
 * => 클래스 메서드에서 클래스를 변수를 사용할 때 
 *    다른 로컬 변수와 헷갈리지 않는다면,
 *    클래스 이름을 생략해도 된다. 
 */
package step07;

public class Test04_5 {
  
  static class Calculator {
    static int result;
    
    public static void plus(int value) {
      //this.result += value; // 클래스 메서드나 static 블록에서는 this 변수가 없다. 컴파일 오류!
      // 다음 코드는 this가 생략된 것이 아니라 클래스 이름이 생략된 것이다.
      result += value;
    }
    
    public static void minus(int value) {
      result -= value;
    }
  }
  
  public static void main(String[] args) {
    Calculator.plus(10);
    System.out.println(Calculator.result);
  }

}
