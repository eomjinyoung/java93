/* 역할:
 * => memb 테이블의 데이터를 다루는 메서드를 모아둔 클래스이다.
 */
package step22.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberDao {
  String driver;
  String url;
  String username;
  String password;
  
  public MemberDao(String driver, String url, String username, String password) 
      throws Exception {
    this.driver = driver;
    this.url = url;
    this.username = username;
    this.password = password;
    
    Class.forName(driver);
  }
  
  public void selectList() {
    try ( 
      Connection con = DriverManager.getConnection(this.url, this.username, this.password); 
    
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select mno, name, tel, email from memb");) {
    
      while (rs.next()) { 
        System.out.printf("%d, %s, %s, %s\n", 
            rs.getInt("mno"), 
            rs.getString("name"), 
            rs.getString("tel"), 
            rs.getString("email"));
      }
        
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void insert(String name, String tel, String email, String password) {
    try (
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(
            "insert into memb(name,tel,email,pwd) values(?,?,?,password(?))");
      ) {
        stmt.setString(1, name);
        stmt.setString(2, tel);
        stmt.setString(3, email);
        stmt.setString(4, password);
        int count = stmt.executeUpdate();

        System.out.println(count);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
  
  
}
