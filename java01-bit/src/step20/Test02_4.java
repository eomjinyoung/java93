/* JDBC 프로그래밍: Statement 객체 - DELETE 실행
 * => Statement.executeUpdate()
 *    - INSERT, UPDATE, DELETE 등 DML, DDL을 실행한다.
 *    - 리턴 값은 명령어 영향을 받은 레코드 개수이다.
 *      예) INSERT -> 등록된 레코드 개수,
 *          UPDATE -> 변경된 레코드 개수,
 *          DELETE -> 삭제된 레코드 개수 
 */
package step20;

import java.sql.DriverManager;

public class Test02_4 {

  public static void main(String[] args) throws Exception {
    com.mysql.jdbc.Driver mysqlDriver = new com.mysql.jdbc.Driver();
    DriverManager.registerDriver(mysqlDriver);
    java.sql.Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/webappdb", 
        "webapp",
        "1111"); 
    java.sql.Statement stmt = con.createStatement();
    int count = stmt.executeUpdate(
        "delete from memb where email='hong100@test.com'");

    System.out.println(count);
    
    stmt.close();
    con.close();
  }

}





