/* class 문법의 용도: 사용자 정의 데이터 타입 만들기 III
 * => 인스턴스(=객체)를 다루는 메서드는 그 인스턴스와 관련된 
 *    클래스 블록 안에 둔다.
 * => 클래스와 관련된 메서드를 하나의 블록으로 묶음으로써
 *    코드 관리가 쉬워진다.
 *    관련된 코드가 모여 있으니 편하다는 얘기다. 
 */
package step06;

public class Test01_3 {
  //1) 사용자 정의 데이터 타입 만들기
  static class Student {
    String name;
    int[] scores = new int[3];
    int total;
    float aver;

    // 이렇게 클래스 블록 안에 묶여서 호출할 때 마다 클래스 이름으로 
    // 호출해야 하는 메서드를 "클래스 메서드(= 스태틱 메서드)"라 부른다.
    public static void init(Student s, String name, int kor, int eng, int math) {
      s.name = name;
      s.scores[0] = kor;
      s.scores[1] = eng;
      s.scores[2] = math;
    }

    public static void compute(Student s) {
      s.total = s.scores[0] + s.scores[1] + s.scores[2];
      s.aver = s.total / 3f;
    }

    public static void print(Student s) {
      System.out.printf("%s, %d, %d, %d, %d, %f\n", 
          s.name, s.scores[0], s.scores[1], s.scores[2], s.total, s.aver);
    }
  }
  
  public static void main(String[] args) {
    Student s1 = new Student();
    // init(), compute(), print() 메서드는 Student 클래스 블록 안에 묶여 있기 때문에
    // 호출할 때 클래스 이름을 언급해야 한다.
    // => How?
    //    클래스명.메서드명();
    Student.init(s1, "홍길동", 100, 100, 100);
    Student.compute(s1);
    
    Student s2 = new Student();
    Student.init(s2, "임꺽정", 90, 90, 90);
    Student.compute(s2);
    
    Student s3 = new Student();
    Student.init(s3, "유관순", 80, 80, 80);
    Student.compute(s3);
    
    Student.print(s1);
    Student.print(s2);
    Student.print(s3);

  }

}
