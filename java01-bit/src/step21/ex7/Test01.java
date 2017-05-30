package step21.ex7;

public class Test01 {

  public static void main(String[] args) {
    // 1) 추상 클래스는 인스턴스를 생성할 수 없다.
    A obj; // 레퍼런스 변수는 상관없다.
    //obj = new A(); // 컴파일 오류!
    
    // 2) 추상 클래스의 스태틱 멤버를 사용할 수 있다.
    A.sm1();

  }

}
