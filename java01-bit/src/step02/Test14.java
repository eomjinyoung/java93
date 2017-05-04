/* 사용자 정의 데이터 타입: 값 초기화시키기
 * => 객체를 생성한 후 값을 초기화시키는 메서드를 정의한다.  
 */
package step02;

public class Test14 {
  // 클래스를 특정 메서드 안에서 사용하고 싶다면, 그 메서드에 선언하라!
  // 그러나 다음과 같이 클래스 안에서 사용하고 싶다면, 그 클래스에 선언하라!
  static class Student {
    String name;
    byte[] scores;
    short total;
    float aver;
  }
  
  public static Student createStudent(String name, byte kor, byte eng, byte math) {
    Student s = new Student();
    s.name = name;
    s.scores = new byte[]{kor, eng, math};
    s.total = (short)(kor + eng + math);
    s.aver = s.total / 3f;
    return s;
  }
  
  public static void main(String[] args) {
    Student[] arr1 = new Student[3]; 
    
    arr1[0] = createStudent("홍길동", (byte)100, (byte)100, (byte)100);
    arr1[1] = createStudent("임꺽정", (byte)90, (byte)90, (byte)90);
    arr1[2] = createStudent("유관순", (byte)80, (byte)80, (byte)80);
    
    for (int i = 0; i < arr1.length; i++) {
      System.out.printf("%s, %d, %d, %d, %d, %f\n", 
        arr1[i].name, 
        arr1[i].scores[0], arr1[i].scores[1], arr1[i].scores[2], 
        arr1[i].total, arr1[i].aver);
    }
    
  }

}



