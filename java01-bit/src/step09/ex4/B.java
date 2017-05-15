package step09.ex4;

public class B extends A {
  int b;
  
  // B 클래스는 기본 생성자가 없다.
  public B(int value) {
    //super();
    System.out.println("B()");
    b = value;
  }
}
