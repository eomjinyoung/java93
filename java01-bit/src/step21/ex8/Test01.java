package step21.ex8;

public class Test01 {

  public static void main(String[] args) {
    //인터페이스의 모든 필드는 public, static, final이다.
    //A.v4 = 20; // 컴파일 오류!
    System.out.println(A.v4);
    
    //인터페이스는 인스턴스를 생성할 수 없다.
    A obj; // obj에는 A 규칙에 따라 만든 클래스라면 어떤 클래스든지 인스턴스를 저장할 수 있다.
    //obj = new A(); // 컴파일 오류!

  }

}
