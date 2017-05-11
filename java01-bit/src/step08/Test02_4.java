/* 유틸리티 클래스 : String IV - 상수 문자열 인스턴스
 * => 상수 문자열은 new 연산자 없이 인스턴스를 생성한다.
 * => 상수 문자열은 Constant Pool 이라는 상수만 모아두는 영역에서 따로 관리한다.
 * => 상수 문자열은 중복해서 생성되지 않는다.
 *    즉 같은 문자열이 있으면 기존의 인스턴스 주소를 리턴한다.
 */
package step08;

public class Test02_4 {

  public static void main(String[] args) {
    String s1 = "Hello"; // new String("Hello")와 같지만, 단 Constant Pool 영역에 생성된다.
    String s2 = "Hello"; // 한 번 생성되면 기존의 상수 문자열 인스턴스의 주소를 리턴한다.
    
    if (s1 == s2) { // 상수 문자열을 가리키는 레퍼런스를 비교할 때는 
      // 그냥 == 연산자를 사용해도 된다.
      System.out.println("s1 == s2");
    } else {
      System.out.println("s1 != s2");
    }
    
  }

}
