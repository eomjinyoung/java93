package step09.ex1;

public class MasterCalculator {
  int result;
  
  void plus(int value) {
    this.result += value;
  }
  
  void minus(int value) {
    this.result -= value;
  }
  
  void multiple(int value) {
    this.result *= value;
  }
  
  // 새 나누기 기능 추가
  void divide(int value) {
    this.result /= value;
  }
}
