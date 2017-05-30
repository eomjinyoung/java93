package step21.ex5;

public class CarTester {
  public static void test(Car car) {
    System.out.println("자동차 테스트 시작!");
    /* 다음 코드의 run() 메서드는 
     * 추상 클래스 Car의 추상 메서드인 run()을 호출하는 것이 아니다.
     * 파라미터에 넘어온 객체의 실제 클래스에 대해서 run()을 호출하는 것이다.
     * 만약 car 변수에 Sedan 객체(인스턴스 주소)가 저장되어 있다면,
     * Sedan 클래스의 run()을 호출한다.
     * 만약 car 변수에 Truck 객체가 저장되어 있다면,
     * Truck 클래스의 run()을 호출한다.
     */ 
    car.run();
    System.out.println("자동차 테스트 끝!");
  }
}
