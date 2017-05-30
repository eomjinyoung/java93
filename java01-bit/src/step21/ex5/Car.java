package step21.ex5;

public abstract class Car {

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

  // 이 메서드는 어차피 서브 클래스에서 무조건 재정의할 것이다.
  // 또는 재정의하도록 강제하고 싶다!
  // 그렇다면 여기서 코딩하지 말라!
  // 단지 어떤 메서드인지 선언만 하라!
  // 추상 메서드는 구현할 수 없다.
  public abstract void run();

}