package step10.ex4;

public class C extends B {
  int c;

  public void m2() { // B클래스의 m2() 재정의
    System.out.println("C.m2()");
  }
  
  public void m3() { // A클래스의 m3() 재정의
    System.out.println("C.m3()");
  }
  
  public void m5() { // 새로 추가
    System.out.println("C.m5()");
  }
  
  public void test1() {
    m1(); // B.m1()
    m2(); // C.m2()
    m3(); // C.m3()
  }
  
  public void test2() {
    super.m1(); // B.m1() <-- 수퍼 클래스부터 찾았더니 B에 있다.
    super.m2(); // B.m2() <-- 수퍼 클래스부터 찾았더니 B에 있다.
    super.m3(); // A.m3() <-- 수퍼 클래스부터 찾았더니 B에 없고, A에 있다.
    m4();       // B.m4() <-- 현재 클래스부터 찾았더니 B에 있다.
    super.m4(); // B.m4() <-- 수퍼 클래스부터 찾았더니 B에 있다.
    m5();       // C.m5()
    //super.m5(); <-- 수퍼 클래스부터 찾았는데 m5()가 어디에도 없다. 
  }
  
}
