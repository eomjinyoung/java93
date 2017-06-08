/* 역할:
 * => memb 테이블의 데이터를 다루는 메서드를 모아둔 클래스이다.
 * => 출력하는 역할은 호출자에게 맡긴다.
 * => DAO의 역할은 결과를 리턴하면 된다.
 * => 커넥션은 DBConnectionPool로부터 얻어서 사용하고,
 *    사용한 후에는 반납한다.
 * => DAO는 커넥션을 관리하지 않는다.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
  DBConnectionPool conPool;
  
  public MemberDao(DBConnectionPool conPool) {
    this.conPool = conPool;
  }
  
  public List<Member> selectList(int pageNo, int pageSize) throws Exception {
    Connection con = conPool.getConnection();

    try ( 
      PreparedStatement stmt = con.prepareStatement(
          "select mno, name, tel, email from memb order by name asc limit ?, ?");) {
      
      stmt.setInt(1, (pageNo - 1) * pageSize /* 시작 인덱스 */);
      stmt.setInt(2, pageSize /* 꺼낼 레코드 수 */);
      
      ArrayList<Member> list = new ArrayList<>();
      
      try (ResultSet rs = stmt.executeQuery();) {
        Member member = null;
        while (rs.next()) { 
          member = new Member();
          member.setNo(rs.getInt("mno"));
          member.setName(rs.getString("name"));
          member.setTel(rs.getString("tel"));
          member.setEmail(rs.getString("email"));
          
          list.add(member);
        }
      }
      return list;
      
    } finally { 
      conPool.returnConnection(con);
    }
  }
  
  public Member selectOne(int no) throws Exception {
    Connection con = conPool.getConnection();

    try ( 
      PreparedStatement stmt = con.prepareStatement(
          "select mno, name, tel, email from memb where mno=?");) {
      
      stmt.setInt(1, no);
      
      try (ResultSet rs = stmt.executeQuery();) {
        if (!rs.next()) { 
          return null;
        }
        
        Member member = new Member();
        member.setNo(rs.getInt("mno"));
        member.setName(rs.getString("name"));
        member.setTel(rs.getString("tel"));
        member.setEmail(rs.getString("email"));
        return member;
      }
      
    } finally { 
      conPool.returnConnection(con);
    }
  }
  
  public int insert(Member member) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "insert into memb(name,tel,email,pwd) values(?,?,?,password(?))");) {
      
      stmt.setString(1, member.getName());
      stmt.setString(2, member.getTel());
      stmt.setString(3, member.getEmail());
      stmt.setString(4, member.getPassword());
      return stmt.executeUpdate();
    
    } finally { 
      conPool.returnConnection(con);
    }
  }
  
  public int delete(int no) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "delete from memb where mno=?");) {
      
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    
    } finally { 
      conPool.returnConnection(con);
    }
  }
  
  public int update(Member member) throws Exception {
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "update memb set name=?, tel=?, email=?, pwd=password(?) where mno=?");) {
      
      stmt.setString(1, member.getName());
      stmt.setString(2, member.getTel());
      stmt.setString(3, member.getEmail());
      stmt.setString(4, member.getPassword());
      stmt.setInt(5, member.getNo());
      return stmt.executeUpdate();
    
    } finally { 
      conPool.returnConnection(con);
    }
  }
  
  
}
