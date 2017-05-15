package step09.ex4;

public class A {
  int a;
  
  public A() {
    //super(); // 작성하지 않으면 컴파일러는 
               // 이와 같이 수퍼 클래스의 기본 생성자를 호출하는
               // 코드를 자동으로 붙인다.
    
    System.out.println("A()");
  }
}
