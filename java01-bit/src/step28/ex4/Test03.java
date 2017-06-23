/* Mybatis 퍼시스턴스 프레임워크: 조인 결과 가져오기 II
 */ 
package step28.ex4;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test03 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream("step28/ex4/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    ProjectDaoImpl projectDao = new ProjectDaoImpl();
    projectDao.setSqlSessionFactory(sqlSessionFactory);
    
    Project project = projectDao.selectOne(11);
    System.out.println(project);
  }

}






