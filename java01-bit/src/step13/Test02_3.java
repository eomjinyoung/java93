/* nested class: static nested class III 
 */
package step13;

public class Test02_3 {
  
  static class Member {
    String name;
    String tel;
    int schoolLevel;
    int userType;
    int working;
    int language;
  }
  
  public static void main(String[] args) {
    // static nested class로 정의된 상수 값 사용하기
    Member m = new Member();
    m.name = "홍길동";
    m.tel = "111-1111";
    m.schoolLevel = Constants.school.BACHELOR;
    m.userType = Constants.userType.TEACHER;
    m.working = Constants.work.NOT_WORKING;
    m.language = Constants.lang.JAVA;
  }
  

}
