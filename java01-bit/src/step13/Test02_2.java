/* nested class: static nested class II 
 */
package step13;

public class Test02_2 {
  // static nested class를 주로 사용하는 경우
  // => 계층구조로 상수 값을 관리하고 싶을 때
  //    특히 안드로이드 프로그래밍에서 ID 값을 관리하기 위해 이 문법을 사용한다.
  static class Member {
    String name;
    String tel;
    int schoolLevel;
    int userType;
    int working;
    int language;
  }
  
  public static void main(String[] args) {
    // static nested 클래스 대신 일반 클래스로 만든 상수 값을 사용해 보자!
    Member m = new Member();
    m.name = "홍길동";
    m.tel = "111-1111";
    m.schoolLevel = CSchool.BACHELOR;
    m.userType = CUserType.TEACHER;
    m.working = CWork.NOT_WORKING;
    m.language = CLanguage.JAVA;
  }
  

}
