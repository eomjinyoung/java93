/* 기타 연산자 : 연선자 우선순위
 */
package step03;

public class Test03_8 {
  public static void main(String[] args) {
    // 연산자 우선 순위에 따라 연산을 수행한다.
    // *,/,% 는 +,- 보다 우선 순위가 높다.
    System.out.println(3 + 4 * 5); // 23
    
    // 우선순위를 임의로 바꾸고 싶다면, 괄호()를 사용하라
    System.out.println((3 + 4) * 5); // 35
  }
}



