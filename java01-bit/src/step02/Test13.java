/* 변수 선언: 사용자 정의 데이터 타입의 배열 */
package step02;

public class Test13 {
  public static void main(String[] args) {
    //1) 새 데이터 타입을 정의한다.
    class Student {
      String name;
      byte[] scores;
      short total;
      float aver;
    }

    //2) 새 데이터 타입에 따라 만든 메모리의 주소를 담을 변수 선언
    Student s1;
    
    //3) 새 데이터 타입에 따라 메모리를 준비한다.
    // => 리턴 값은 새로 준비한 메모리의 주소이다.
    s1 = new Student();
    
    //4) 그 메모리에 값 넣기
    s1.name = "홍길동";
    s1.scores = new byte[3];
    s1.scores[0] = 100;
    s1.scores[1] = 100;
    s1.scores[2] = 100;
    s1.total = (short)(s1.scores[0] + s1.scores[1] + s1.scores[2]);
    s1.aver = s1.total / 3f;
    
    Student s2 = new Student();
    s2.name = "임꺽정";
    s2.scores = new byte[]{90, 90, 90};
    s2.total = (short)(s2.scores[0] + s2.scores[1] + s2.scores[2]);
    s2.aver = s2.total / 3f;
    
    Student s3 = new Student();
    s3.name = "유관순";
    s3.scores = new byte[]{80, 80, 80};
    s3.total = (short)(s3.scores[0] + s3.scores[1] + s3.scores[2]);
    s3.aver = s3.total / 3f;
    
    System.out.printf("%s, %d, %d, %d, %d, %f\n", 
        s1.name, s1.scores[0], s1.scores[1], s1.scores[2], s1.total, s1.aver);
    
    System.out.printf("%s, %d, %d, %d, %d, %f\n", 
        s2.name, s2.scores[0], s2.scores[1], s2.scores[2], s2.total, s2.aver);
    
    System.out.printf("%s, %d, %d, %d, %d, %f\n", 
        s3.name, s3.scores[0], s3.scores[1], s3.scores[2], s3.total, s3.aver);
  }

}

/*
 * primitive data type
 * => byte, short, int, long, float, double, boolean, char
 * 
 * 사용자 정의 데이터 타입?
 * => 개발자가 자신이 원하는 방식으로 데이터를 묶어서 다루기 위해 
 *    새로 정의하는 데이터 타입
 * => 문법
 *    class 데이터타입명 {
 *      데이터타입 변수명;
 *      ...
 *    }
 */







