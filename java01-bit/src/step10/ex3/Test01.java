/* 다형성 - 오버로딩(overloading)
 * => 같은 기능을 수행하는 메서드에 대해 같은 이름을 부여함으로써
 *    프로그래밍의 일관성을 확보하는 문법!
 */
package step10.ex3;

public class Test01 {

  public static void main(String[] args) {
    Calculator c1 = new Calculator();
    // 파라미터의 개수나 타입에 따라 호출될 메서드를 결정한다.
    c1.plus(1);
    c1.plus(2);
    c1.plus(10, 7);
    
    c1.minus(5);
    
    System.out.println(c1.result);

  }

}
