package step27.ex3;

public class CarFactory {
  
  // 객체를 만들어주는 메서드를 "팩토리 메서드"라 부른다.
  public static Car createCar(String name) {
    switch (name) {
    case "tico": return createTico();
    case "sonata": return createSonata();
    default: return null;
    }
  }
  
  private static Car createTico() {
    Engine e1 = new Engine(8, 4);
    
    Tire[] tireList = {
      new Tire("비트타이어", 13),
      new Tire("비트타이어", 13),
      new Tire("비트타이어", 13),
      new Tire("비트타이어", 13)
    };
    
    Car c1 = new Car();
    c1.setModel("티코");
    c1.setCc(800);
    c1.setEngine(e1);
    c1.setTires(tireList);
    
    return c1;
  }
  
  private static Car createSonata() {
    Engine e2 = new Engine(16, 8);
    
    Tire[] tireList2 = {
      new Tire("비트타이어", 15),
      new Tire("비트타이어", 15),
      new Tire("비트타이어", 15),
      new Tire("비트타이어", 15)
    };
    
    Car c2 = new Car();
    c2.setModel("소나타");
    c2.setCc(1998);
    c2.setEngine(e2);
    c2.setTires(tireList2);
    
    return c2;
  }
}
