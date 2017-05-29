package step21.ex2;

public class Car {

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

  public void run() {
    System.out.println("간다.");
  }

}