package step21.ex6;

// 모든 자동차는 Vehicle 규칙에 따라 작성한다.
// 앞으로 Car를 상속 받는 모든 서브 클래스는 
// Vehicle 규칙에 따라 메서드를 작성해야 한다.
// 즉 Vehicle 규칙에 선언된 메서드 run()을 구현해야 한다.
public abstract class Car implements Vehicle {

  protected String model;
  protected String maker;
  protected int cc;

  public Car() {
    super();
  }
  
  public Car(String model, String maker, int cc) {
    this.model = model;
    this.maker = maker;
    this.cc = cc;
  }

  // 인터페이스에 run() 메서드가 선언되어 있기 때문에 여기서 선언할 필요가 없다.
  //public abstract void run();

}