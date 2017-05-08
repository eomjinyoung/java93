/* 메서드 : 여러 개의 값을 리턴하고 싶을 때 IV*/
package step05;

public class Test06 {
  static class Student {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }
  
  //4) 사용자(개발자)가 정의한 클래스의 객체에 값을 담은 다음 그 객체의 주소를 리턴할 수 있다.
  public static Student getStudent(int studentNo) {
    // 지정된 번호의 학생 정보를 찾았다고 가정하자!
    Student s = new Student();
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 90;
    s.math = 80;
    s.sum = 100 + 90 + 80;
    s.aver = (100 + 90 + 80) / 3f;
    return s;
  }
  
  public static void main(String[] args) {
    Student s2 = getStudent(100); 

    // 사용자 정의 객체의 변수 값을 꺼내 출력할 수 있다.
    System.out.println(s2.name);
    System.out.println(s2.kor);
    System.out.println(s2.eng);
    System.out.println(s2.math);
    System.out.println(s2.sum);
    System.out.println(s2.aver);
  }
}








