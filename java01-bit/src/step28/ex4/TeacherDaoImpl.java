package step28.ex4;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TeacherDaoImpl implements TeacherDao {
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  } 
  
  public List<Teacher> selectList(int pageNo, int pageSize) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,Object> valueMap = new HashMap<>();
      valueMap.put("startIndex", (pageNo - 1) * pageSize);
      valueMap.put("pageSize", pageSize);
      
      return sqlSession.selectList("step28.ex4.TeacherDao.selectList", valueMap);
      
    } finally {
      sqlSession.close();
    }
  }
  
  public Teacher selectOne(int no) throws Exception {
    /*
    Connection con = conPool.getConnection();

    try ( 
      PreparedStatement stmt = con.prepareStatement(
          "select m.mno, m.name, m.tel, m.email, t.hmpg, t.fcbk, t.twit " +
          " from tcher t inner join memb m on t.tno=m.mno " +
          " where t.tno=?");) {
      
      stmt.setInt(1, no);
      
      try (ResultSet rs = stmt.executeQuery();) {
        if (!rs.next()) { 
          return null;
        }
        
        Teacher teacher = new Teacher();
        teacher.setNo(rs.getInt("mno"));
        teacher.setName(rs.getString("name"));
        teacher.setTel(rs.getString("tel"));
        teacher.setEmail(rs.getString("email"));
        teacher.setHomepage(rs.getString("hmpg"));
        teacher.setFacebook(rs.getString("fcbk"));
        teacher.setTwitter(rs.getString("twit"));
        return teacher;
      }
      
    } finally { 
      conPool.returnConnection(con);
    }
    */
    return null;
  }

  public int insert(Teacher teacher) throws Exception {
    /*
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "insert into tcher(tno,hmpg,fcbk,twit) values(?,?,?,?)");) {
      
      stmt.setInt(1, teacher.getNo());
      stmt.setString(2, teacher.getHomepage());
      stmt.setString(3, teacher.getFacebook());
      stmt.setString(4, teacher.getTwitter());
      return stmt.executeUpdate();
    
    } finally { 
      conPool.returnConnection(con);
    }
    */
    return 0;
  }
  
  public void insertPhoto(int no, List<String> photoList) throws Exception {
    /*
    Connection con = conPool.getConnection();
    try (
      PreparedStatement stmt = con.prepareStatement(
          "insert into tch_phot(tno,path) values(?,?)");) {
      
      for (String path : photoList) {
        stmt.setInt(1, no);
        stmt.setString(2, path);
        stmt.executeUpdate();
      }
    
    } finally { 
      conPool.returnConnection(con);
    }
    */
  }
  
  public List<String> selectPhotoList(int teacherNo) throws Exception {
    /*
    Connection con = conPool.getConnection();

    try ( 
      PreparedStatement stmt = con.prepareStatement(
          "select path from tch_phot where tno=?");) {
      
      stmt.setInt(1, teacherNo);
      
      ArrayList<String> list = new ArrayList<>();
      
      try (ResultSet rs = stmt.executeQuery();) {
        while (rs.next()) { 
          list.add(rs.getString("path"));
        }
      }
      return list;
      
    } finally { 
      conPool.returnConnection(con);
    }
    */
    return null;
  }
}
