package step09.ex3;

public class C extends B {
  int c;
  
  public C() {
    //super(); // 수퍼 클래스의 기본 생성자를 호출하는 코드를 작성하지 않으면,
               // 컴파일러가 자동으로 붙인다.
    System.out.println("C()");
  }
}
