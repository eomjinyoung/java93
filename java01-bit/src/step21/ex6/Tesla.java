package step21.ex6;

// 이제부터 Tesla도 CarTester 자동차 검사소에서 테스트 할 수 있도록
// Vehicle 규칙을 준수해야 한다.
// 그래서 Vehicle에 선언된 run() 메서드를 구현하였다.
public class Tesla extends Motor implements Vehicle {
  int charge; 
  
  public void doCharge() {
    charge = 100;
  }
  
  // Vehicle에 선언된 메서드 run()을 구현하였다.
  public void run() {
    System.out.println("조용히 달린다!");
  }
}
