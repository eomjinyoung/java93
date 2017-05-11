/* 인스턴스 변수와 인스턴스 메서드 
 * 1) 인스턴스 변수
 *    => new 명령으로 Heap 메모리 영역에 생성된다.
 * 2) 인스턴스 메서드
 *    => 클래스의 코드가 Method Area 메모리 영역에 로딩된다.
 *       따라서 클래스의 코드인 "인스턴스 메서드"도 당연히 Method Area 영역에 로딩된다.
 *    => 인스턴스 주소 없이는 호출할 수 없다.
 *    => 즉 인스턴스 변수를 다루는 메서드이다.
 *    => 만약 인스턴스 변수를 다루지 않는다면, 
 *       그 메서드는 "클래스 메서드"로 선언하는 것이 낫다.
 * => 주의!
 *    클래스의 모든 명령 코드는 Method Area 영역에 있다.
 *    인스턴스 생성할 때 인스턴스 메서드도 생성되는 것이 아니다! 
 */
package step07;

public class Test04_1 {
  
  static class Calculator {
    int result;
    
    public void plus(int value) {
      this.result += value;
    }
    
    public void minus(int value) {
      this.result -= value;
    }
  }
  
  public static void main(String[] args) {
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();
    c1.plus(10);
    c1.plus(20);
    System.out.println(c1.result);
    System.out.println(c2.result);
    
  }

}
