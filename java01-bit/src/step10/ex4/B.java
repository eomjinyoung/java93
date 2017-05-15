package step10.ex4;

public class B extends A {
  int b;

  public void m1() { // A클래스의 m1() 재정의 
    System.out.println("B.m1()");
  }
  
  public void m2() { // A클래스의 m2() 재정의
    System.out.println("B.m2()");
  }
  
  public void m4() { // 새로 추가
    System.out.println("B.m4()");
  }
}
