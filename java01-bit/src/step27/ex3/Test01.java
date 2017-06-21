/* 스프링 사용법: 팩토리 메서드 호출하기 I
 * => 팩토리 메서드(Factory Method)? 
 *    - 객체를 만들어 주는 메서드를 말한다.
 * => new 연산자를 사용해서 만들면 되지 않는가?
 *    - 객체를 생성하는 과정이 복잡할 경우에 매번 new를 사용하여 복잡한 객체를 생성하기 보다는,
 *      복잡한 객체를 생성하는 메서드를 만들어 놓고 호출하는 것이 편하기 때문이다.
 *    - 즉 객체 생성 과정이 복잡한 경우 사용하는 설계 비법이 "팩토리 메서드" 패턴이다.
 *    
 */
package step27.ex3;

public class Test01 {
  public static void main(String[] args) {
    // 1) 일반적인 객체 생성 방법
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
    
    System.out.println(c1);
    System.out.println(c2);
  }
}






