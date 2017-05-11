/* 초기화 블록: 생성자 IV
 * => 생성자가 한 개라도 있으면 컴파일러는 기본 생성자를 자동으로 만들 지 않는다. 
 */
package step07;

public class Test03_6 {
  static class Student {
    int age = 20;
    
    Student(int a) {
      System.out.println("Student(int)...호출");
      this.age = a;
    }
    
    Student(int a, String n) {
      System.out.println("Student(int, String)...호출");
      this.age = a;
    }
    
    Student(String n, int a) {
      System.out.println("Student(String, int)...호출");
      this.age = a;
    }
  }
  
  public static void main(String[] args) {
    //new Student(); // 기본 생성자가 없기 때문에 호출될 수 없다. 컴파일 오류!
    new Student(20);
    new Student("홍길동", 20);
    new Student(20, "홍길동");
  }

}
