package step28.ex5;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectDaoImpl implements ProjectDao {
  @Autowired SqlSessionFactory sqlSessionFactory;
  
  public Project selectOne(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      return sqlSession.selectOne("step28.ex5.ProjectDao.selectOne", no);
      
    } finally {
      sqlSession.close();
    }
  }

  
}
