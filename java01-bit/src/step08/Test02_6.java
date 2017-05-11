/* 유틸리티 클래스 : String VI - replace() 메서드와 Immutable 객체
 * => immutable(변하지 않는) 객체
 *    String 클래스는 immutable 객체이다.
 *    한 번 값이 결정되면 변하지 않는다.
 *    값을 바꾸려하면 새로운 문자열 인스턴스가 자동 생성된다. 
 */
package step08;

public class Test02_6 {

  public static void main(String[] args) {
    String s1 = "Hello"; 
    String s2 = "Hello"; 
    
    // String 인스턴스는 immutable 객체이다. 
    // 따라서 원본은 그대로 두고 원본을 복사해서 새 문자열 인스턴스를 만든 다음에
    // 작업을 수행한다.
    // 작업 결과 문자열은 어디에? 리턴 값을 확인하라!
    String s3 = s1.replace('l', 'x');
    
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);
  }

}
