package step09.ex3;

public class A {
  int a;
  
  public A() {
    //int a = 20; // 만약 수퍼 클래스의 생성자를 호출하는 코드 앞에 다른 명령이 있다면,
                // 컴파일 오류이다.
    // 첫 명령어로 이 클래스의 수퍼 클래스 생성자를 호출하는 코드를 작성해야 한다.
    super();
    
    System.out.println("A()");
  }
}
