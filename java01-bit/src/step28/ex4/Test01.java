/* Mybatis 퍼시스턴스 프레임워크: 조인 결과 가져오기
 */ 
package step28.ex4;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream("step28/ex4/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    TeacherDaoImpl teacherDao = new TeacherDaoImpl();
    teacherDao.setSqlSessionFactory(sqlSessionFactory);
    
    List<Teacher> list = teacherDao.selectList(1, 100);
    for (Teacher t : list) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          t.getNo(), t.getName(), t.getEmail(), t.getTel(), t.getHomepage());
    }
    

  }

}






