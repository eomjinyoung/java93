package step28.ex5;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherDaoImpl implements TeacherDao {
  @Autowired SqlSessionFactory sqlSessionFactory;
  
  public List<Teacher> selectList(int pageNo, int pageSize) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,Object> valueMap = new HashMap<>();
      valueMap.put("startIndex", (pageNo - 1) * pageSize);
      valueMap.put("pageSize", pageSize);
      
      return sqlSession.selectList("step28.ex5.TeacherDao.selectList", valueMap);
      
    } finally {
      sqlSession.close();
    }
  }
  
  public Teacher selectOne(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      return sqlSession.selectOne("step28.ex5.TeacherDao.selectOne", no);
      
    } finally {
      sqlSession.close();
    }
  }

  public int insert(Teacher teacher) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.insert("step28.ex5.TeacherDao.insert", teacher);
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
  }
  
}
