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
  
  public List<Member> selectListByEmail(int pageNo, int pageSize, String email) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,Object> valueMap = new HashMap<>();
      valueMap.put("startIndex", (pageNo - 1) * pageSize);
      valueMap.put("pageSize", pageSize);
      valueMap.put("email", email);
      
      return sqlSession.selectList("step28.ex2.MemberDao.selectListByEmail", valueMap);
      
    } finally {
      sqlSession.close();
    }
  }
  
  public List<Member> selectListByName(int pageNo, int pageSize, String name) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,Object> valueMap = new HashMap<>();
      valueMap.put("startIndex", (pageNo - 1) * pageSize);
      valueMap.put("pageSize", pageSize);
      valueMap.put("name", name);
      
      return sqlSession.selectList("step28.ex2.MemberDao.selectListByName", valueMap);
      
    } finally {
      sqlSession.close();
    }
  }
  
  public List<Member> selectListByTel(int pageNo, int pageSize, String tel) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,Object> valueMap = new HashMap<>();
      valueMap.put("startIndex", (pageNo - 1) * pageSize);
      valueMap.put("pageSize", pageSize);
      valueMap.put("tel", tel);
      
      return sqlSession.selectList("step28.ex2.MemberDao.selectListByTel", valueMap);
      
    } finally {
      sqlSession.close();
    }
  }
  
  public Member selectOne(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      // SqlSession.selectOne()을 실행할 때는 반드시 결과를 한 개만 만드는 select문을 지정해야 한다.
      // 여러 개의 결과가 생성되는 select문은 실행할 수 없다.
      return sqlSession.selectOne("step28.ex2.MemberDao.selectOne", no);
      
    } finally {
      sqlSession.close();
    }
  }

  public Member selectOneByEmailPassword(String email, String password) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,Object> valueMap = new HashMap<>();
      valueMap.put("email", email);
      valueMap.put("password", password);
      
      return sqlSession.selectOne("step28.ex2.MemberDao.selectOneByEmailPassword", valueMap);
      
    } finally {
      sqlSession.close();
    }
  }
  
  public int insert(Member member) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      // insert 문을 실행할 때는 insert() 메서드를 호출하라!
      // SqlSession.insert()의 리턴 값은 내부적으론 호출한 executeUpdate()의 리턴 값이다.
      int count = sqlSession.insert("step28.ex2.MemberDao.insert", member);
      
      // insert(), update(), delete()을 호출한 후에는 
      // DBMS에 최종적으로 확정하는 명령을 보내야 실행이 완료된다.
      sqlSession.commit();
      
      /* insert(), update(), delete()을 호출한 후 
       * DBMS에 자동으로 최종적으로 확정하는 명령을 보내고 싶다면,
       * SqlSession을 얻을 때 미리 설정해야 한다. 
       * 코드:
       * SqlSession sqlSession = sqlSessionFactory.openSession(true);
       */
      
      return count;
      
    } finally {
      sqlSession.close();
    }
  }
  
  public int delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.delete("step28.ex2.MemberDao.delete", no);
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
  }
  
  public int update(Member member) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.update("step28.ex2.MemberDao.update", member);
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
  }
  
}
