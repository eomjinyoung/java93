/* 사용자 정의 데이터 타입: 생성자
 * => 인스턴스를 생성한 후 자동으로 호출되는 특별한 메서드.
 * => 그래서 주로 인스턴스를 사용하기 전에 그 메모리를 초기화시키는 용도로 사용한다.
 * => 자바스크립트와 달리 자바의 생성자는 특별한 문법으로 작성한다.
 * => 문법
 *    클래스명(파라미터들) {}
 *    
 */
package step02;

public class Test16 {
  static class Student {
    String name;
    int[] scores;
    int total;
    float aver;
    
    // 사용자 정의 클래스를 만들 때,
    // 다음과 같이 인스턴스를 초기화시키는 특별한 메서드(생성자)를 추가할 수 있다. 
    Student(String name, int kor, int eng, int math) {
      // 생성자에는 this라는 내장 변수가 있다.
      // 생성자를 호출할 때 그 인스턴스의 주소를 담고 있는 변수이다.
      // 인스턴스의 필드를 사용하고 싶다면 이 내장 변수 this를 사용하라!
      this.name = name;
      this.scores = new int[]{kor, eng, math};
      this.total = kor + eng + math;
      this.aver = this.total / 3f;
    }
    
    public static void printStudent(Student s) {
      System.out.printf("%s, %d, %d, %d, %d, %.1f\n", 
          s.name, 
          s.scores[0], s.scores[1], s.scores[2], 
          s.total, s.aver);
    }
  }
  
 
  public static void main(String[] args) {
    Student[] arr1 = new Student[3]; 
    
    // 다음 코드의 의미
    // 1) Student 클래스의 설계에 따라 인스턴스(메모리)를 준비하라.
    // 2) Student 클래스에 정의된 메서드 중에서 다음 네 개의 값을 받을 수 있는 생성자를 호출하라.
    //    생성자를 호출하지 않을 수 있는가? 없다! 무조건 호출해야 한다.
    // 3) 그리고 그 인스턴스 주소를 리턴하라!
    arr1[0] = new Student("홍길동", 100, 100, 100);
    arr1[1] = new Student("임꺽정", 90, 90, 90);
    arr1[2] = new Student("유관순", 80, 80, 80);
    /* createStudent() 메서드를 사용해도 괜찮았는데 왜 생성자를 사용하는가?
     * => 클래스와 관련된 코드는 그 클래스 함께 묶어 두는 것이 유지보수에 좋다.
     * => 나중에 클래스 별로 별개의 파일로 분리할 때 유리하다.
     *    유지보수 입장에서는 코드를 관리하기 쉽다.
     */
    
    // printStudent() 메서드 또한 이 메서드와 관련된 클래스 안에 옮겨 둔다.
    for (int i = 0; i < arr1.length; i++) {
      Student.printStudent(arr1[i]); // 좀 더 어떤 클래스의 메서드인지 다루기가 쉬워진다.
    }
    
  }

}



