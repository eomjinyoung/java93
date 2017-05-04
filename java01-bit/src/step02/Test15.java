/* 사용자 정의 데이터 타입: 값 초기화시키기 II
 * => 자바에서 기본 연산 단위는 int이기 때문에
 *    byte 변수를 사용하는 것이 불편하다.
 * => 보통 byte 변수는 여러 개의 값을 담기 위해 배열로 선언해 사용한다.
 *    예를 들면, 이미지 파일과 같은 바이너리 파일을 읽을 때 
 *    그 값을 저장하기 위해 바이트 배열을 사용한다.
 * => 그럼 일반적인 숫자 값을 다룰 때는 그냥 int를 사용하라!  
 */
package step02;

public class Test15 {
  static class Student {
    String name;
    int[] scores;
    int total;
    float aver;
  }
  
  public static Student createStudent(String name, int kor, int eng, int math) {
    Student s = new Student();
    s.name = name;
    s.scores = new int[]{kor, eng, math};
    s.total = kor + eng + math;
    s.aver = s.total / 3f;
    return s;
  }
  
  // 인스턴스의 값을 출력하는 메서드를 만들어 사용하자!
  public static void printStudent(Student s /* Student 인스턴스의 주소를 받을 변수*/) {
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", 
        s.name, 
        s.scores[0], s.scores[1], s.scores[2], 
        s.total, s.aver);
  }
  
  public static void main(String[] args) {
    Student[] arr1 = new Student[3]; 
    
    arr1[0] = createStudent("홍길동", 100, 100, 100);
    arr1[1] = createStudent("임꺽정", 90, 90, 90);
    arr1[2] = createStudent("유관순", 80, 80, 80);
    
    for (int i = 0; i < arr1.length; i++) {
      printStudent(arr1[i]);
    }
    
  }

}



