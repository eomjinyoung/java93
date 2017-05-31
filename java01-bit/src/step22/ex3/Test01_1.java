/* JDBC 프로그래밍 II: DAO + Connection Pooling 
 * => Pooling 기법?
 *    - 객체를 효율적으로 생성하고 관리하기 위해,
 *      한 번 생성된 객체는 내부 컬렉션에 담아 두었다가
 *      필요할 때 마다 빌려주고,
 *      다 쓴 다음에는 다시 돌려 받아서 보관해두는 방식.
 *      이런 방식으로 객체를 관리하면,
 *      같은 객체를 여러 개 생성할 필요가 없어 메모리가 절약된다.
 *      생성된 객체를 보관해 두었다가 다시 꺼내 쓰기 때문에
 *      객체 생성시간도 줄어드는 이점이 있다.
 *    - 이점?
 *      1) 생성된 객체 재사용으로 "메모리가 절약된다." 
 *      2) 생성된 객체 재상용으로 "객체를 준비하는 시간이 줄어든다."
 * 
 * => Pooling 기법을 DB 커넥션 관리하는데 적용한 것을 
 *    "DB Connection Pool"이라 부른다.
 *    
 * => 작업
 *    1) DBConnectionPool 클래스 작성
 *    2) MemberDao에 DBConnectionPool 적용
 *    3) 테스트
 */
package step22.ex3;

import java.util.List;

public class Test01_1 {

  public static void main(String[] args) throws Exception {
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    // DB 커넥션을 관리할 객체를 만든다.
    DBConnectionPool conPool = new DBConnectionPool(
        jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
    
    // DAO에 DB 커넥션 풀을 전달한다.
    MemberDao memberDao = new MemberDao(conPool);
    
    List<Member> list = memberDao.selectList();
    for (Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getTel(), m.getEmail());
    }
    System.out.println("-----------------------------------------");
    
    /*
    System.out.println(memberDao.delete(60));
    System.out.println("-----------------------------------------");
    
    Member member = new Member();
    member.setName("홍길동104");
    member.setTel("1111-1111");
    member.setEmail("hong104@test.com");
    member.setPassword("1111");
 
    System.out.println(memberDao.insert(member));
    System.out.println("-----------------------------------------");
    */
    /*
    Member member = new Member();
    member.setNo(60); // 변경하려는 데이터의 mno이어야 한다.
    member.setName("홍길동 변경");
    member.setTel("1111-2221");
    member.setEmail("hong105@test.com");
    member.setPassword("1111");
    
    memberDao.update(member);
    System.out.println("-----------------------------------------");
    */
    list = memberDao.selectList();
    for (Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getTel(), m.getEmail());
    }
    System.out.println("-----------------------------------------");
  }
}

/* 현재 이 MemberDao의 문제점
 * => DAO 객체가 커넥션 객체 한 개를 완전히 독점한다.
 * => 만약 DAO 객체가 여러 개일 경우,
 *    각각의 DAO 객체가 커넥션을 한 개 독점하는 문제가 발생한다.
 *    즉 자원 낭비이다.
 * => 해결책?
 *    커넥션 객체가 필요할 때 마다 빌려서 쓴다.
 *    다 쓴 다음에는 반납한다.
 */




