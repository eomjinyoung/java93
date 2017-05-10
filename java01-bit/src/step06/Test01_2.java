/* class 문법의 용도: 사용자 정의 데이터 타입 만들기 II
 * => 객체를 다루는 코드를 별도의 메서드로 분리하면, 
 *    필요할 때 마다 재 사용할 수 있어 편리하다. 
 */
package step06;

public class Test01_2 {
  //1) 사용자 정의 데이터 타입 만들기
  static class Student {
    String name;
    int[] scores = new int[3];
    int total;
    float aver;
  }
  
  // 인스턴스와 값을 파라미터로 넘기면,
  // 해당 인스턴스의 각 변수에 파라미터로 받은 값을 저장한다.
  public static void init(Student s, String name, int kor, int eng, int math) {
    s.name = name;
    s.scores[0] = kor;
    s.scores[1] = eng;
    s.scores[2] = math;
  }
  
  // 인스턴스(의 주소)를 파라미터로 넘기면
  // 해당 인스턴스의 합계와 평균을 구해서 그 인스턴스의 변수에 저장한다.
  public static void compute(Student s) {
    s.total = s.scores[0] + s.scores[1] + s.scores[2];
    s.aver = s.total / 3f;
  }
  
  // 인스턴스를 파라미터로 넘기면,
  // 해당 인스턴스의 값을 한 줄로 출력한다.
  public static void print(Student s) {
    System.out.printf("%s, %d, %d, %d, %d, %f\n", 
        s.name, s.scores[0], s.scores[1], s.scores[2], s.total, s.aver);
  }
  
  public static void main(String[] args) {
    Student s1 = new Student();
    init(s1, "홍길동", 100, 100, 100);
    compute(s1);
    
    Student s2 = new Student();
    init(s2, "임꺽정", 90, 90, 90);
    compute(s2);
    
    Student s3 = new Student();
    init(s3, "유관순", 80, 80, 80);
    compute(s3);
    
    print(s1);
    print(s2);
    print(s3);

  }

}
