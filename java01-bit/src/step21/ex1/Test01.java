/* 상속을 적용하기 전
 * => 필요한 데로 만들어 사용하라!
 * => 처음부터 상속을 고민하면서 만들지 말라!
 */
package step21.ex1;

public class Test01 {

  public static void main(String[] args) {
    Sedan car1 = new Sedan("에쿠스", "현대자동차", 1997, true);
    car1.load(20);

  }

}
