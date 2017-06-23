package step28.ex5;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDaoImpl implements MemberDao {
  @Autowired SqlSessionFactory sqlSessionFactory;

  public List<Member> selectList(int pageNo, int pageSize, String search, String value) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,Object> valueMap = new HashMap<>();
      valueMap.put("startIndex", (pageNo - 1) * pageSize);
      valueMap.put("pageSize", pageSize);
      valueMap.put("search", search);
      valueMap.put("value", value);
      
      return sqlSession.selectList("step28.ex5.MemberDao.selectList", valueMap);
      
    } finally {
      sqlSession.close();
    }
  }
  
  public List<Member> selectListByNames(int pageNo, int pageSize, String[] names) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,Object> valueMap = new HashMap<>();
      valueMap.put("startIndex", (pageNo - 1) * pageSize);
      valueMap.put("pageSize", pageSize);
      valueMap.put("names", names);
      
      return sqlSession.selectList("step28.ex5.MemberDao.selectListByNames", valueMap);
      
    } finally {
      sqlSession.close();
    }
  }
  
  public Member selectOne(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      return sqlSession.selectOne("step28.ex5.MemberDao.selectOne", no);
      
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
      
      return sqlSession.selectOne("step28.ex5.MemberDao.selectOneByEmailPassword", valueMap);
      
    } finally {
      sqlSession.close();
    }
  }
  
  public int insert(Member member) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.insert("step28.ex5.MemberDao.insert", member);
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
  }
  
  public int delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.delete("step28.ex5.MemberDao.delete", no);
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
  }
  
  public int update(Member member) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.update("step28.ex5.MemberDao.update", member);
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
  }
  
}
