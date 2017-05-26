/* JDBC 프로그래밍: Statement 객체 
 * => Connection 객체로부터 얻는다.
 * => SQL문을 DBMS에 전달하는 일을 한다.
 * => SELECT 문을 실행한 경우, 그 결과를 다루는 객체를 리턴한다.
 */
package step20;

import java.sql.DriverManager;

public class Test02_1 {

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
    
    //4) SQL을 실행할 Statement 객체 얻기
    //   => java.sql.Statement 규격에 따라 만든 객체를 리턴한다.
    java.sql.Statement stmt = con.createStatement();
    
    //5) SELECT SQL문을 DBMS에 보낸다.
    //   => Statement 객체가 SQL 문을 DBMS에 보내는 일을 한다.
    //   => SQL을 문자열 그대로 보내는 것이 아니라,
    //      DBMS가 처리하기 쉬운 형태로 변환(컴파일)하여 
    //      그 변환된 SQL을 DBMS에 보낸다.
    //   => 물론 DBMS 마다 그 변환 형식이 다를 것이다.
    //      변환하는 일은 각 DBMS의 JDBC 드라이버 클래스들 중에서
    //      Statement 객체를 할 것이다.
    //   => 주요함수
    //      executeQuery() : select 문을 보낼 때
    //      executeUpdate() : insert, update, delete 등 기타 SQL을 보낼 때
    //   => executeQuery()의 리턴 값
    //      서버가 SELECT를 실행한 후 준비한 결과 값을 가져오는 도구를 리턴한다.
    //   => 그 도구는 java.sql.ResultSet 규격에 따라 만든 객체이다.
    //
    java.sql.ResultSet rs = stmt.executeQuery("select mno, name, tel, email from memb");
    
    //5) ResultSet 객체를 통해 서버에 결과를 한 개씩 가져온다.
    //   => 한꺼번에 다 가져오는 것이 아니라, 한 개씩 가져온다.
    //   => next() : 서버에서 결과를 한 개 가져온다.
    //
    while (rs.next()) { 
      // 서버에서 가져온 한 개의 레코드 값은 ResultSet 객체에 보관되어 있다.
      // 꺼내보자!
      System.out.printf("%d, %s, %s, %s\n", 
          rs.getInt("mno"), 
          rs.getString("name"), 
          rs.getString("tel"), 
          rs.getString("email"));
    }
    
    //6) 지금까지 사용한 JDBC 관련 객체의 자원을 해제한다.
    // => 생성된 역순으로 자원을 해제해야 한다.
    // => ResultSet을 더이상 사용하지 않으면 자원을 해제하라!
    rs.close();
    // => Statement를 더이상 사용하지 않으면 자원을 해제하라!
    stmt.close();
    // => DBMS와 연결을 끊고 싶다면 Connection의 close()를 호출하라!
    con.close();
    
    // => DriverManager는 close() 메서드가 없다.
  }

}





