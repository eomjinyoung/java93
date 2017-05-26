/* JDBC 프로그래밍: DriverManager 클래스 
 * => JDBC 드라이버를 관리하는 객체
 * => 이 객체에 JDBC 드라이버 객체를 등록해야만 사용할 수 있다.
 * => DBMS에 연결할 때도 이 객체가 필요하다.
 */
package step20;

import java.sql.DriverManager;

public class Test01_2 {

  public static void main(String[] args) throws Exception {
    //1) MySQL JDBC 드라이버의 정보를 다루는 객체를 생성한다.
    //   => 이 객체가 있어야만 MySQL DBMS에 연결할 수 있다.
    com.mysql.jdbc.Driver mysqlDriver = new com.mysql.jdbc.Driver();
    
    //2) MySQL JDBC 드라이버를 "드라이버 관리자"에 등록한다.
    //   => 반드시 java.sql.Driver 규칙에 따라 만든 클래스여야 한다.
    DriverManager.registerDriver(mysqlDriver);
    
    //3) 드라이버 관리자를 통해 DBMS와 연결한다.
    //   => 직접 MySQL 드라이버를 사용하지 않고,
    //      이렇게 DriverManager 클래스를 통해 우회하여 DBMS와 연결한다.
    //   => 이렇게 우회하는 이유? 특정 DBMS에 종속되지 않기 위해서.
    //      자바 코드를 작성할 때 특정 DBMS에서만 유효한 코드를 작성하게 되면,
    //      그 DBMS에 종속되게 되고 유지보수가 힘들어진다.
    //   => DriverManager의 getConnection()을 호출하여 DBMS와 연결한다.
    //      리턴 값은 DBMS와의 연결 정보를 갖고 있는,
    //      java.sql.Connection 규격에 따라 만든 객체이다.
    java.sql.Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/webappdb", /* 연결할 DBMS와 데이터베이스 정보 */ 
        "webapp", /* 사용자 아이디 */
        "1111"); /* 사용자 암호 */
    
    //4) 연결이 되었으면, 간단한 말을 출력하자!
    System.out.println("DBMS와 연결되었음!");
    
    //5) DBMS와 연결을 끊고 싶다면 Connection의 close()를 호출하라!
    con.close();
  }

}





