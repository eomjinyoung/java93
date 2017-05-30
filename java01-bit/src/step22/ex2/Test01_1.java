/* JDBC 프로그래밍 II: DAO에서 출력 기능 제거, 데이터 처리만 하도록 변경
 * => memb 테이블의 값을 저장할 새로운 데이터 타입을 정의한다.
 * => 작업
 *    1) Member 클래스 정의
 *    2) MemberDao 클래스를 변경
 *    3) MemberDao 사용
 */
package step22.ex2;

import java.util.List;

public class Test01_1 {

  public static void main(String[] args) throws Exception {
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    MemberDao memberDao = new MemberDao(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
    List<Member> list = memberDao.selectList();
    for (Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getTel(), m.getEmail());
    }
    System.out.println("-----------------------------------------");
    
    /*
    System.out.println(memberDao.delete(59));
    System.out.println("-----------------------------------------");
    
    Member member = new Member();
    member.setName("홍길동104");
    member.setTel("1111-1111");
    member.setEmail("hong104@test.com");
    member.setPassword("1111");
 
    System.out.println(memberDao.insert(member));
    System.out.println("-----------------------------------------");
    */
   
    Member member = new Member();
    member.setNo(60); // 변경하려는 데이터의 mno이어야 한다.
    member.setName("홍길동 변경");
    member.setTel("1111-2221");
    member.setEmail("hong105@test.com");
    member.setPassword("1111");
    
    memberDao.update(member);
    System.out.println("-----------------------------------------");
    
    list = memberDao.selectList();
    for (Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getTel(), m.getEmail());
    }
    System.out.println("-----------------------------------------");
  }
}





