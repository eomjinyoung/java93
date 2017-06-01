package step10.ex5;

public class Test01 {
  public static void main(String[] args) {
    A obj1 = new A();
    obj1.m1();
    
    A obj2 = new B();
    obj2.m1();
    
    A obj3 = new C();
    obj3.m1(); 
    // 비록 obj3는 A의 레퍼런스이지만, 실제로 C의 인스턴스를 가리키고 있다.
    // 그래스 m1() 메서드는 C에서 오버라이딩 한 메서드를 호출하는 것이다.
   
    B obj4 = new C();
    obj4.m1();
    obj4.m2();
    
    
    
  }
}
