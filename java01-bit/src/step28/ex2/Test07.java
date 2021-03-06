/* Mybatis 퍼시스턴스 프레임워크: 사용
 * 1) mybatis 라이브러리 준비
 *    - mvnrepository.com 에서 "mybatis" 검색
 *    - build.gradle 파일에 의존 라이브러리 설정 추가 
 *    - "gradle eclipse" 실행하여 이클립스 설정파일 갱신
 *    - 프로젝트 "refresh"
 * 2) mybatis 사용자 안내 문서 확인
 *    - www.mybatis.org 방문
 * 3) SqlSessionFactory 객체를 준비한다.
 * 4) MemberDao에 SqlSessionFactory를 주입한다.
 *    - MemberDao 변경
 * 5) mybatis 설정 파일 준비
 *    - mybatis-config.xml
 * 6) MemberDao에 저장된 SQL문을 분리
 *    - MemberDao.xml     
 */ 
package step28.ex2;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test07 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream("step28/ex2/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    MemberDaoImpl memberDao = new MemberDaoImpl();
    memberDao.setSqlSessionFactory(sqlSessionFactory);
    
    List<Member> list = memberDao.selectListByEmail(1, 100, "kang111@test.com");
    for (Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(), m.getTel());
    }
    System.out.println("------------------------------------------------------");
    
    list = memberDao.selectListByName(1, 100, "강사");
    for (Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(), m.getTel());
    }
    System.out.println("------------------------------------------------------");
    
    list = memberDao.selectListByTel(1, 100, "1112");
    for (Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(), m.getTel());
    }
    System.out.println("------------------------------------------------------");

  }

}






