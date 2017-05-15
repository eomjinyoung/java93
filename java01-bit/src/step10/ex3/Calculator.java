package step10.ex3;

public class Calculator {
  int result;
  
  public void plus(int value) {
    result += value;
  }
  
  // 비록 파라미터의 타입이나 개수가 다르더라도 같은 기능을 수행한다면
  // 그 메서드의 이름을 같게 함으로써 프로그래밍의 일관성을 확보할 수 있다.
  // => 이렇게 같은 이름을 가진 메서드가 추가로 적재된다고 해서 "overloading"이라 한다.
  public void plus(int v1, int v2) {
    result += v1 + v2;
  }
  
  public void plus(int[] values) {
    for (int v : values) {
      result += v;
    }
  }
  
  public void minus(int value) {
    result -= value;
  }
}
