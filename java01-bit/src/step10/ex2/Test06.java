/* 다형성 - 형변환의 희대의 사기꾼! 
 * => 실제 그 타입의 인스턴스가 아님에도 
 *    타입 캐스팅(형변환)을 이용하여 그 인스턴스라고 속이는 방법.
 * => 컴파일은 가능하지만 결국 실행할 때 오류가 발생한다.   
 */
package step10.ex2;

public class Test06 {

  public static void main(String[] args) {
    Member m = new Member();
    m.name = "홍길동";
    m.id = "hong";
    m.password = "1111";
    m.email = "hong@test.com";
    m.tel = "1111";
    
    FreeStudent s = (FreeStudent)m;
    s.schoolName = "비트대학교";
    s.grade = 4;
    s.account = "111-11-1111-111";
    s.bank = "비트은행";
    s.working = true;
    
    System.out.println(s.name);
    System.out.println(s.id);
    System.out.println(s.password);
    System.out.println(s.email);
    System.out.println(s.tel);
    System.out.println(s.schoolName);
    System.out.println(s.grade);
    System.out.println(s.account);
    System.out.println(s.bank);
    System.out.println(s.working);
    
  }

}
