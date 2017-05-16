/* static nested class 문법을 이용하여 상수 값을 계층 구조로 관리한다.
 * => CWork, CUserType, CLanguage, CSchool 클래스처럼 
 *    각 클래스마다 상수를 개별적으로 관리하는 방법보다,
 *    다음과 같이 한 클래스 안에 nested 클래스로 상수를 묶어서 관리하면
 *    상수를 사용하기 편해진다.
 *    특히 계층구조 형식을 취하기 때문에,
 *    OGNL(예: int a = aa.bb.cc.dd; ) 표기법처럼 상수를 사용할 수 있다.
 */
package step13;

public final class Constants {
  public static final class school {
    public static final int HIGH_SCHOOL = 1;
    public static final int BACHELOR = 1;
    public static final int MASTER = 1;
    public static final int DOCTOR = 1;
  }
  
  public static final class userType {
    public static final int STUDENT = 1;
    public static final int TEACHER = 2;
    public static final int MANAGER = 3;
  }
  
  public static final class lang {
    public static final int JAVA = 1;
    public static final int C = 2;
    public static final int CPP = 3;
    public static final int CS = 4;
    public static final int PYTHON = 5;
    public static final int PHP = 6;
    public static final int JAVASCRIPT = 7;
  }
  
  public static final class work {
    public static final int WORKING = 1;
    public static final int NOT_WORKING = 2;
  }
}
