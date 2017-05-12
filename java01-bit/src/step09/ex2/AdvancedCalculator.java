package step09.ex2;

/* 해설
 * => BasicCalculator의 코드를 재사용할 것이고,
 *    거기에다가 곱하기를 수행하는 multiple() 메서드를 추가한다.
 * => BasicCalculator의 코드를 복사/붙여넣기 할 필요가 없다.
 * => 기존의 BasicCalculator 코드를 그대로 공유한다.
 * => 즉 AdvancedCalculator는 BasicCalculator 클래스에 의존한다.
 *    BasicCalculator 클래스가 없으면 AdvancedCalculator를 사용할 수 없다.
 */ 
public class AdvancedCalculator extends BasicCalculator {
  // 새 곱하기 기능 추가 
  void multiple(int value) {
    this.result *= value;
  }
}
