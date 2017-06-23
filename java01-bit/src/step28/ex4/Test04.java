/* Mybatis 퍼시스턴스 프레임워크: insert 한 후 자동 생성된 PK 값 받기
 */ 
package step28.ex4;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test04 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream("step28/ex4/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    MemberDaoImpl memberDao = new MemberDaoImpl();
    memberDao.setSqlSessionFactory(sqlSessionFactory);
    
    TeacherDaoImpl teacherDao = new TeacherDaoImpl();
    teacherDao.setSqlSessionFactory(sqlSessionFactory);
    
    Teacher teacher = new Teacher();
    teacher.setName("강사103");
    teacher.setEmail("t103@test.com");
    teacher.setTel("1111-2222");
    teacher.setPassword("1111");
    teacher.setHomepage("home");
    teacher.setFacebook("face");
    teacher.setTwitter("twit");
    
    int count = memberDao.insert(teacher);
    System.out.println(count);
    
    count = teacherDao.insert(teacher);
    System.out.println(count);
  }

}






