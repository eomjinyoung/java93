/* JDBC 프로그래밍: MySQL JDBC Type 4 드라이버 다운로드
 * => 절차 
 *    1) www.mvnrepository.com 에서 mysql 검색한다.
 *    2) MySQL Connector/J의 Gradle 의존 라이브러리 정보를 복사한다.
 *    3) build.gradle의 dependencies {} 블록에 붙여 넣는다.
 *    4) 명령창을 실행하여 java01 프로젝트 폴더에서 gradle 명령을 실행한다.
 *       > gradle eclipse     <== 이클립스 설정 파일(.classpath, .project 등)을 갱신한다. 
 *    5) 이클립스에서 프로젝트 폴더를 "Refresh" 한다.
 *    6) 드라이버 라이브러리 파일(mysql-connector-java-5.1.42.jar)에 있는 클래스를 로딩해 본다.
 */
package step20;

public class Test01_1 {

  public static void main(String[] args) throws Exception {
    //1) MySQL JDBC 드라이버의 정보를 다루는 객체를 생성한다.
    //   => 이 객체가 있어야만 MySQL DBMS에 연결할 수 있다.
    com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
  }

}





