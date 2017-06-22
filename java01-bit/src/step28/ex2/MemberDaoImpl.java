package step28.ex2;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDaoImpl implements MemberDao {
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Member> selectList(int pageNo, int pageSize) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,Object> valueMap = new HashMap<>();
      valueMap.put("startIndex", (pageNo - 1) * pageSize);
      valueMap.put("pageSize", pageSize);
      
      return sqlSession.selectList("step28.ex2.MemberDao.selectList", valueMap);
      
    } finally {
      sqlSession.close();
    }
  }
  
  public Member selectOne(int no) throws Exception {
    /*
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
    */
    return null;
  }

  public Member selectOneByEmailPassword(String email, String password) throws Exception {
    /*
    Connection con = conPool.getConnection();

    try ( 
      PreparedStatement stmt = con.prepareStatement(
          "select mno, name, tel, email from memb where email=? and pwd=password(?)");) {
      
      stmt.setString(1, email);
      stmt.setString(2, password);
      
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
    */
    return null;
  }
  
  public int insert(Member member) throws Exception {
    /*
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "insert into memb(name,tel,email,pwd) values(?,?,?,password(?))",
          Statement.RETURN_GENERATED_KEYS);) {
      
      stmt.setString(1, member.getName());
      stmt.setString(2, member.getTel());
      stmt.setString(3, member.getEmail());
      stmt.setString(4, member.getPassword());
      int count = stmt.executeUpdate();
      
      // 자동 생성된 PK 값을 꺼내기 
      try (ResultSet rs = stmt.getGeneratedKeys();) {
        rs.next();
        member.setNo(rs.getInt(1));
      }
      
      return count;
    
    } finally { 
      conPool.returnConnection(con);
    }
    */
    return 0;
  }
  
  public int delete(int no) throws Exception {
    /*
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "delete from memb where mno=?");) {
      
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    
    } finally { 
      conPool.returnConnection(con);
    }
    */
    return 0;
    
  }
  
  public int update(Member member) throws Exception {
    /*
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
     */
    return 0;
  }
  
}
