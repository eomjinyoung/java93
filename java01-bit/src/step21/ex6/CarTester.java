package step21.ex6;

public class CarTester {
  // CarTester는 Vehicle 규칙에 따라서 만든 객체라면,
  // 어떤 객체든지 테스트 할 것이다.
  public static void test(Vehicle car) {
    System.out.println("자동차 테스트 시작!");
    car.run();
    System.out.println("자동차 테스트 끝!");
  }
}
