/* JDBC 프로그래밍: Statement와 PreparedStatement이 비교
 * => Statement와 PreparedStatement
 * 1) 보안 
 *    Statement
 *      - 사용자가 입력한 값을 가지고 SQL문을 만들기 때문에 보안에 취약하다.
 *      - 즉 악의적으로 값에 SQL의 일부를 포함할 수 있다.
 *    PreparedStatement             
 *      - ?(in-parameter) 자리에 임의의 SQL문을 삽입할 수 없다.
 *      - 삽입해봐야 단순 문자열로 취급한다.
 *      - 그래서 보안 문제를 발생시키지 않는다.   
 * 2) 바이너리 데이터
 *    Statement
 *      - 문자열로 SQL문을 만들기 때문에 바이너리 데이터를 삽입할 수 없다.
 *    PreparedStatement
 *      - ?(in-parameter) 자리에 바이너리 데이터를 삽입할 수 있다.
 * 3) 코드의 가독성
 *    Statement
 *      - + 연산자를 사용하여 컬럼의 값을 연결하는 식으로 문자열을 만들기 때문에,
 *        컬럼의 개수가 많으면 문자열을 붙이는 코드도 산만해지고 복잡해진다.
 *    PreparedStatement
 *      - setXxx()를 사용하여 값을 넣기 때문에 코드가 간결하다.
 * 4) 실행속도
 *    서버에 SQL문을 전달하기 전에 서버에서 원하는 형식으로 변환하여 보낸다.
 *    단순히 SQL을 한 번만 실행한다면 Statement나 PreparedStatement 둘 다 속도가 같다.
 *    그러나 같은 SQL문을 값을 바꿔가면서 여러 번 실행할 경우,
 *    PreparedStatement는 SQL문을 컴파일한 후 값만 넣어서 보내기 때문에 속도가 빠르다.
 *    Statement는 executeXxx()를 실행할 때 마다 SQL문을 매번 컴파일하기 때문에 속도가 느리다.
 */
package step20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test05_3 {

  public static void main(String[] args) throws Exception {
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    // Statement 를 사용했을 때 보안 사고가 발생하는 상황을 시연하는 예제!
    // => 이렇게 사용자가 값을 입력할 때 SQL 코드를 삽입할 수 있다.
    String email = "hong102@test.com' or email like('hong1%') or email='ㅋㅋ";
  
    try {
      Class.forName(jdbcDriver);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    try (
      Connection con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
      Statement stmt = con.createStatement();
    ) {
      // => + 연산자를 이용하여 SQL 문을 만들기 때문에 
      //    값에 교묘하게 포함된 SQL 코드도 함께 포함되어 실행될 수 있다.
      int count = stmt.executeUpdate("delete from memb where email='" + email + "'");
      System.out.println(count);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}








