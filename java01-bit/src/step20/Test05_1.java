/* JDBC 프로그래밍: PreparedStatement 객체 사용 전
 * => SQL문에 변수의 값을 넣으려면 더하기 연산자를 사용해야 한다.
 */
package step20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test05_1 {

  public static void main(String[] args) throws Exception {
    // 원래는 값을 JVM 아규먼트나 프로그램 아규먼트 등 외부로부터 받아야 하지만,
    // 테스트를 원활하게 하기 위해서 변수에 값을 담아 놓자!
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    String name = "홍길동103";
    String email = "hong103@test.com";
    String tel = "1111-1111";
    String password = "1111";
  
    try {
      Class.forName(jdbcDriver);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    try (
      Connection con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword); 
      Statement stmt = con.createStatement();
    ) {
      // 변수에 들어 있는 값을 가지고 SQL 문을 만드려면 다음과 같이 
      // 더하기 연산자 '+'를 사용해야 한다.
      // 특히 문자열인 경우에는 작은 따옴표 ''를 사용해야 한다.
      // 너무 번거롭고 불편한다.
      int count = stmt.executeUpdate("insert into memb(name,tel,email,pwd) values('" +
        name + "', '"+ 
        tel + "', '" + 
        email + "', password('" + 
        password + "'))");

      System.out.println(count);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}





