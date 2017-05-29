/* JDBC 프로그래밍: PreparedStatement 객체 사용 후
 * => 더하기 연산자를 사용하여 SQL문을 만드는 대신,
 *    in-parameter '?'를 사용하여 SQL문을 만든다.
 *    
 *    
 */
package step20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test05_2 {

  public static void main(String[] args) throws Exception {
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    String name = "홍길동102";
    String email = "hong102@test.com";
    String tel = "1111-1111";
    String password = "1111";
  
    try {
      Class.forName(jdbcDriver);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    try (
      Connection con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
      
      // SQL 문을 미리 준비해 둔다. 
      // 숫자, 문자 상관없이 값이 들어갈 자리는 ?를 사용하여 비워둔다.
      // 이때 ?를 in-parameter 라고 부른다.
      // prepareStatement()의 리턴 값은 java.sql.PreparedStatement의 구현체이다.
      PreparedStatement stmt = con.prepareStatement(
          "insert into memb(name,tel,email,pwd) values(?,?,?,password(?))");
    ) {
      // SQL문을 서버에 보내기 전에 in-parameter 자리에 값을 채운다.
      // 컬럼의 타입에 따라 호출하는 메서드가 다르다. 
      // => setXxx(컬럼인덱스, 값)
      // => 컬럼 인덱스는 1부터 시작한다.
      // 빈자리(in-parameter)에 값을 넣을 때 컬럼의 순서를 지킬 필요는 없다.
      // 그렇다고 굳이 임의 순서대로 넣는 것은 코드의 이해도를 떨어뜨린다.
      stmt.setString(1, name);
      stmt.setString(2, tel);
      stmt.setString(3, email);
      stmt.setString(4, password);
      // 이렇게 setXxx()를 호출하여 SQL문을 완성하면, 
      // + 연산자를 사용하여 SQL문을 완성하는 방법보다 편리하고 가독성이 좋다.
      
      // 위에서 SQL문을 준비하고 값을 채웠기 때문에 여기에서는 그냥 실행만 하면 된다.
      int count = stmt.executeUpdate();

      System.out.println(count);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}








