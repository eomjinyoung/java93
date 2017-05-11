/* 초기화 블록: 생성자 III
 * => 클래스는 여러 개의 생성자를 가질 수 있다.
 * => 파라미터의 개수나 파라미터 타입, 파라미터 순서로 구분된다.
 * => 그러나 변수 이름하고는 상관없다.
 * => 인스턴스를 생성할 떄 반드시 여러 개의 생성자 중에서 호출될 생성자를 지정해야 한다.
 * => 문법
 *    new 클래스명(아규먼트, ...) 
 *    => 인스턴스를 생성시키는 명령문에서 어떤 값을 넘기느냐에 따라 
 *       호출될 생성자가 결정된다.
 */
package step07;

public class Test03_5 {
  static class Student {
    int age = 20;
    
    Student() { 
      System.out.println("Student()...호출");
    }
    
    Student(int a) {
      System.out.println("Student(int)...호출");
      this.age = a;
    }
    
    // 데이터 타입은 같은 데 변수명이 다르다? 
    // 호출할 때 어떤 생성자를 호출할 지 구분할 수 없기 때문에 
    // 이런 문법은 허용하지 않는다.
    /*
    Student(int b) {
      System.out.println("Student(int)...호출");
      this.age = a;
    }
    */
    
    Student(int a, String n) {
      System.out.println("Student(int, String)...호출");
      this.age = a;
    }
    
    Student(String n, int a) {
      System.out.println("Student(String, int)...호출");
      this.age = a;
    }
    
    /* 오버로딩(overloading)
     * => 이렇게 파라미터 타입이 다르거나 개수가 다른, 생성자 또는 메서드를
     *    여러 개 중복해서 만드는 문법을 말한다.
     */
  }
  
  public static void main(String[] args) {
    new Student(); // 호출될 생성자는 넘겨주는 값의 개수와 타입으로 결정된다.
    new Student(20);
    //new Student(20L); // long 값을 받는 생성자가 없다. 컴파일 오류!
    //new Student(true); // 마찬가지로 boolean 값을 받는 생성자가 없다. 컴파일 오류!
    new Student("홍길동", 20);
    new Student(20, "홍길동");
  }

}
