package step09.ex1;

public class AdvancedCalculator {
  int result;
  
  void plus(int value) {
    this.result += value;
  }
  
  void minus(int value) {
    this.result -= value;
  }
  
  // 새 곱하기 기능 추가 
  void multiple(int value) {
    this.result *= value;
  }
}
