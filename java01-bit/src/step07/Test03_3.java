/* 초기화 블록: 생성자
 * => 인스턴스를 생성한 후 자동으로 호출되는 특별한 메서드.
 * => 인스턴스 블록과 생성자 호출의 순서
 *    => 인스턴스 생성 --> 인스턴스 블록 실행 --> 생성자 호출  
 * => 인스턴스 블록과의 차이점
 *    파라미터를 받아서 인스턴스 변수를 특정 값으로 초기화시킬 수 있다.
 * => 여러 개의 생성자를 가질 수 있다.
 *    다만, 그 중에서 한 개만 호출된다. 
 *    new 명령어 작성 시에 호출되는 생성자를 개발자가 지정해야 한다.
 * => 문법
 *    클래스명(파라미터선언) {...}
 *    => 리턴 타입은 없다.
 */
package step07;

public class Test03_3 {
  static class Student {
    static String name = "홍길동"; // 변수를 선언할 때 값을 초기화시키는 문장을 포함할 수 있다.
    int age = 20;
    static {
      System.out.println("static {...}");
    }
    { // 인스턴스 블록
      System.out.println("{인스턴스 블록 실행}");
    }
    // 이렇게 파라미터가 없는 생성자를 "기본 생성자(default constructor)"라 부른다.
    Student() {
      System.out.println("Student()...호출");
    }
  }
  
  public static void main(String[] args) {
    new Student();
    System.out.println("-------------------------");
    new Student();
    
  }

}
