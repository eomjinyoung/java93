/* JDBC 프로그래밍 II: DAO(Data Access Object) 적용
 * => DAO? 데이터를 저장, 조회, 변경, 삭제를 처리하는 
 *    그런 역할을 수행하는 객체를 부르는 말이다.
 * => 보통 테이블 당 한 개의 DAO를 만든다.
 * => 물론 SELECT 할 때 조인을 수행하는 경우,
 *    여러 테이블의 데이터를 다루기도 한다.
 * => 이렇게 데이터를 다루는 코드를 별도의 클래스로 분류해 놓으면
 *    소스 코드를 유지보수하기 편하다.
 * => 작업
 *    1) memb 테이블의 등록, 조회, 변경, 삭제를 다루는 DAO 클래스를 만든다.
 *       예) MemberDao
 *    2) MemberDao 클래스에 등록, 조회, 변경, 삭제를 수행하는 메서드를 정의한다.
 *    3) Test06_x 에서 MemberDao를 사용하여 멤버 데이터를 다룬다.
 */
package step22.ex2;

public class Test01_1 {

  public static void main(String[] args) throws Exception {
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    MemberDao memberDao = new MemberDao(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
    memberDao.selectList();
    System.out.println("-----------------------------------------");
    
    /*
    memberDao.delete(59);
    memberDao.selectList();
    System.out.println("-----------------------------------------");
    */
    
    /*
    memberDao.insert("홍길동104", "hong104@test.com", "1111-1111", "1111");
    memberDao.selectList();
    System.out.println("-----------------------------------------");
    */
    
    /*
    memberDao.update(59, "홍길동변경", "hong104@test.com", "1111-2222", "1313");
    memberDao.selectList();
    System.out.println("-----------------------------------------");
    */
    
    /* 이 예제의 문제점?
     * => DAO가 데이터를 처리하는 일 뿐만 아니라 화면에 출력하는 일도 담당한다.
     * => 만약 이 DAO를 윈도우 프로그램을 개발할 때 쓰려한다면,
     *    안타깝지만 재사용할 수 없다.
     *    
     * "High Cohesion"
     * => 한 클래스는 한 가지 역할만 해야지 재사용성이 좋아진다.
     * => 여러 가지 역할을 하면 재사용하기 힘들다.
     */
    
  }
}





