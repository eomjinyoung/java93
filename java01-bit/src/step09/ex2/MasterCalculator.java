package step09.ex2;

public class MasterCalculator extends AdvancedCalculator {
  // 새 나누기 기능 추가
  void divide(int value) {
    this.result /= value;
  }
}
