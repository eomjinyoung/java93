/* 유틸리티 클래스 : String II - 레퍼런스 비교
 * => == 연산자는 해당 변수에 저장된 값을 비교한다.
 *    따라서 같은 값을 갖고 있는 인스턴스라 하더라도,
 *    == 연산자로 비교하면 주소가 다르기 때문에 
 *    같지 않다고 결과가 나온다.
 */
package step08;

public class Test02_2 {

  public static void main(String[] args) {
    String s1 = new String("Hello");
    String s2 = new String("Hello");
    
    if (s1 == s2) { // 두 변수에 저장된 주소가 같은지 비교해 보자!
      System.out.println("s1 == s2");
    } else {
      System.out.println("s1 != s2");
    }
    
  }

}
