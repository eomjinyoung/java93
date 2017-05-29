/* JDBC 프로그래밍: 특정 DBMS에 종속되는 것을 막기 I
 * => 기존 코드에서는 java.sql.Driver 구현체(이 규칙에 따라 만든 클래스)의 
 *    인스턴스를 만들기 위해 직접 클래스 명을 언급하였다.
 *    예) com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
 * => 이렇게 하면 코드가 특정 DBMS에 종속되는 문제가 발생한다.
 *    즉 다른 DBMS에 접속하려면 코드를 변경한 후 컴파일 해야 하는 번거로움이 발생한다.
 * => 해결 방법?
 *    java.sql.Driver 구현체의 이름을 변수로 받아서 처리한다. 
 * => 명령창에서 실행하는 법
 *    프롬프트> java -cp bin:xxx.jar -Djdbc.driver=com.mysql.jdbc.Driver step20.Test04_1
 * => 이클립스에서 실행하는 법
 *    1) 일단 그냥 실행한다. 그러면 실행 정보가 이클립스에 기록된다.
 *    2) Run > Run Configurations... > "Java Application / Test04_1" 선택 > arguments > 
 */
package step20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test04_1 {

  public static void main(String[] args) {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      //com.mysql.jdbc.Driver mysqlDriver = new com.mysql.jdbc.Driver();
      //DriverManager.registerDriver(mysqlDriver);
      
      // JVM 아규먼트로 java.sql.Driver 구현체의 이름을 받는다.
      String driverClassName = System.getProperty("jdbc.driver");
      
      // java.sql.Driver 클래스를 메모리에 로딩한다.
      // => 객체를 만들어서 DriverManager에 등록하지 않아도 자동으로 인식한다.
      Class.forName(driverClassName);
      
      
      con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/webappdb", 
        "webapp",
        "1111");
    
      stmt = con.createStatement();
      rs = stmt.executeQuery("select mno, name, tel, email from memb");
    
      while (rs.next()) { 
        System.out.printf("%d, %s, %s, %s\n", 
            rs.getInt("mno"), 
            rs.getString("name"), 
            rs.getString("tel"), 
            rs.getString("email"));
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }

}





