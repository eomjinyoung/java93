package step21.ex6;

// 규칙 정의
// => 호출자: CarTester
// => 구현체: CarTester가 테스트하는 대상. 예) Sedan, Truck, Bulldozer, Tesla 
public interface Vehicle {
  public abstract void run();
}
